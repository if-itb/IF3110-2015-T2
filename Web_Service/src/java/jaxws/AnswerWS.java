/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.*;

/**
 *
 * @author gazandic
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    Connection conn;

    public AnswerWS() throws Throwable {
        DB a = new DB();
        this.conn = a.connect();
    }
    /**
     * Web service operation
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<>();  
        String query = "SELECT * FROM answer JOIN user WHERE qid = "+qid+" AND uid = user.id";
        try {
          Statement stmt = conn.createStatement(); 
          PreparedStatement dbStatement =  conn.prepareStatement(query); 
          //dbStatement.setInt(1, qid);
          ResultSet rs = dbStatement.executeQuery(query);
          int i=0;
          while(rs.next()){                 
                 answers.add(new Answer( rs.getInt("answer.id"),                                  
                         rs.getInt("qid"),                                  
                         rs.getInt("uid"), 
                         rs.getString("user.username"), 
                         rs.getString("content"),                                  
                         rs.getString("datetime"),
                         rs.getInt("vote")
                 ));               
             i++;
          }       
          rs.close();
          stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        return answers;
    }
    /**
     * Web service operation
     * @param uid
     * @param qid
     * @param content
     * @return 
     */
    @WebMethod(operationName = "insertAnswer")
    @WebResult(name="saveAnswer")
    public void insertAnswer(@WebParam(name = "uid") int uid,@WebParam(name = "qid") int qid,@WebParam(name = "content") String content) {
        int ans = 0;
        try {
            String query2 = "SELECT answer.id FROM answer ";
            Statement stmt2 = conn.createStatement(); 
            PreparedStatement dbStatement2 =  conn.prepareStatement(query2); 
            //dbStatement.setInt(1, qid);
            ResultSet tmp = dbStatement2.executeQuery(query2);
            while(tmp.next()){
                    ans = tmp.getInt("answer.id");
            }     
            stmt2.close();
            tmp.close();
        }   
        
       catch (Exception e) {
                 
        }
        ans++;
        String query = "INSERT INTO `answer` (`id`, `qid`, `uid`, `content`, `datetime`, `vote`) VALUES ('"+ans+"','"+qid+"','"+uid+"', '"+content+"', CURRENT_TIMESTAMP, '0')";
    
        try {
          Statement stmt = conn.createStatement(); 
          PreparedStatement dbStatement =  conn.prepareStatement(query); 
          //dbStatement.setInt(1, qid);
          dbStatement.executeUpdate(query);
          stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
    }
    /**
     * Web service operation
     * @param aid
     * @param uid
     * @param type
     * @return 
     */
    @WebMethod(operationName = "voteAnswer")
    @WebResult(name="vtAnswer")
    public int voteAnswer(@WebParam(name = "aid") int aid,@WebParam(name = "uid") int uid,@WebParam(name = "type") int type) {
        int ans = 0;
        try {
          String query2 = "SELECT vote FROM answer WHERE id ="+aid;
          Statement stmt2 = conn.createStatement(); 
          PreparedStatement dbStatement2 =  conn.prepareStatement(query2); 
          //dbStatement.setInt(1, qid);
          ResultSet tmp = dbStatement2.executeQuery(query2);
          tmp.next();
          ans = tmp.getInt("id");
          stmt2.close();
          tmp.close();
        }   
        
        catch (Exception e) {
                 
        }
        ans+= type;
        String queryvt = "INSERT INTO `vote_answer` (`aid`, `uid`, `type`) VALUES ('"+aid+"','"+uid+"','"+type+"')";
    
        try {
          Statement stmtvt = conn.createStatement(); 
          PreparedStatement dbStatementvt =  conn.prepareStatement(queryvt); 
          //dbStatement.setInt(1, qid);
          dbStatementvt.executeUpdate(queryvt);
          stmtvt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        String query = "UPDATE answer SET vote = " + ans + " WHERE id = " + aid + "";
        
        try {
          Statement stmt = conn.createStatement(); 
          PreparedStatement dbStatement =  conn.prepareStatement(query); 
          //dbStatement.setInt(1, qid);
          dbStatement.executeUpdate(query);
          stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        
        return ans;
    }
    
    
}
