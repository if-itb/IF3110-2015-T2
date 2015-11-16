/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author gazandic
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    Connection conn;

    public QuestionWS() throws Throwable {
        DB a = new DB();
        this.conn = a.connect();
    }
    /**
     * Web service operation
     * @param 
     * @return 
     */
    @WebMethod(operationName = "getQuestion")
    @WebResult(name="Questions")
    public ArrayList<Question> getQuestion() {
        ArrayList<Question> questions = new ArrayList<>();  
        String query = "SELECT * FROM question JOIN user WHERE user.id=uid";
        try {
          Statement stmt = conn.createStatement(); 
          PreparedStatement dbStatement =  conn.prepareStatement(query); 
          //dbStatement.setInt(1, qid);
          ResultSet rs = dbStatement.executeQuery(query);
          int i=0;
          while(rs.next()){    
                 int ans = 0;
                 try {
                    String query2 = "SELECT COUNT(*) FROM answer WHERE qid = " + rs.getInt("question.id");
                    Statement stmt2 = conn.createStatement(); 
                    PreparedStatement dbStatement2 =  conn.prepareStatement(query2); 
                    //dbStatement.setInt(1, qid);
                    ResultSet tmp = dbStatement2.executeQuery(query2);
                    tmp.next();
                    ans = tmp.getInt("COUNT(*)");
                    tmp.close();
                 } 
                 catch (Exception e) {
                 
                 }
                 questions.add(new Question( rs.getInt("question.id"),                                                                    
                         rs.getInt("uid"), 
                         rs.getString("user.username"), 
                         rs.getString("topic"),
                         rs.getString("content"),
                         rs.getString("datetime"),
                         rs.getInt("vote"),ans                                 
                 ));               
             i++;
          }       
          rs.close();
          stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        return questions;
    }
    
    /**
     * Web service operation
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name="Question")
    public ArrayList<Question> getQuestionByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Question> questions = new ArrayList<>();  
        String query = "SELECT * FROM question WHERE id = "+qid;
        try {
            Statement stmt = conn.createStatement(); 
            PreparedStatement dbStatement =  conn.prepareStatement(query); 
            //dbStatement.setInt(1, qid);
            ResultSet rs = dbStatement.executeQuery(query);
            int i=0;
            while(rs.next()){        
                int ans = 0;
                 try {
                    String query2 = "SELECT COUNT(*) FROM answer WHERE qid = " + rs.getInt("id");
                    Statement stmt2 = conn.createStatement(); 
                    PreparedStatement dbStatement2 =  conn.prepareStatement(query2); 
                    //dbStatement.setInt(1, qid);
                    ResultSet tmp = dbStatement2.executeQuery(query2);
                    tmp.next();
                    ans = tmp.getInt("COUNT(*)");
                    tmp.close();
                 } 
                 catch (Exception e) {
                 
                 }
                questions.add(new Question( rs.getInt("question.id"),                                                                    
                         rs.getInt("uid"), 
                         rs.getString("user.username"), 
                         rs.getString("topic"),
                         rs.getString("content"),
                         rs.getString("datetime"),
                         rs.getInt("vote"),ans                                
                ));               
                i++;
            }       
            rs.close();
            stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        return questions;
    }
    /**
     * Web service operation
     * @param uid
     * @param topic
     * @param content
     * @return 
     */
    @WebMethod(operationName = "insertQuestion")
    @WebResult(name="saveQuestion")
    public void insertQuestion(@WebParam(name = "uid") int uid,@WebParam(name = "topic") int topic,@WebParam(name = "content") String content) {
        int ans = 0;
        try {
          String query2 = "SELECT id FROM question ";
          Statement stmt2 = conn.createStatement(); 
          PreparedStatement dbStatement2 =  conn.prepareStatement(query2); 
          //dbStatement.setInt(1, qid);
          ResultSet tmp = dbStatement2.executeQuery(query2);
          while(tmp.next()){
            ans = tmp.getInt("id");
          }     
          stmt2.close();
          tmp.close();
        }   
        
        catch (Exception e) {
                 
        }
        ans++;
        String query = "INSERT INTO `question` (`id`, `uid`, `topic`, `content`, `datetime`, `vote`) VALUES ('"+ans+"','"+uid+"','"+topic+"', '"+content+"', CURRENT_TIMESTAMP, '0')";
    
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
     * @param id
     * @param topic
     * @param content
     * @return 
     */
    @WebMethod(operationName = "UpdateQuestion")
    @WebResult(name="updQuestion")
    public void UpdateQuestion(@WebParam(name = "id") int id,@WebParam(name = "topic") String topic,@WebParam(name = "content") String content) {
        String query = "UPDATE question SET topic='" + topic + "', content='" + content + "' WHERE id = " + id + "";
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
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "deleteQuestion")
    @WebResult(name="delQuestion")
    public void deleteQuestion(@WebParam(name = "qid") int qid) {
        String query = "DELETE FROM question WHERE id = "+qid;
    
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
        String query2 = "DELETE FROM answer WHERE qid = "+qid;
    
        try {
          Statement stmt2 = conn.createStatement(); 
          PreparedStatement dbStatement2 =  conn.prepareStatement(query); 
          //dbStatement.setInt(1, qid);
          dbStatement2.executeUpdate(query);
          stmt2.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
    }
    /**
     * Web service operation
     * @param qid
   * @param uid
   * @param type
     * @return 
     */
    @WebMethod(operationName = "voteQuestion")
    @WebResult(name="vtQuestion")
    public int voteQuestion(@WebParam(name = "qid") int qid,@WebParam(name = "uid") int uid,@WebParam(name = "type") int type) {
        int ans = 0;
        try {
          String query2 = "SELECT vote FROM question WHERE id ="+qid;
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
        String queryvt = "INSERT INTO `vote_question` (`qid`, `uid`, `type`) VALUES ('"+qid+"','"+uid+"','"+type+"')";
    
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
        String query = "UPDATE question SET vote = " + ans + " WHERE Id = " + qid + "";
        
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
