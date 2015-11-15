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
@WebService(serviceName = "StackExchangeWebService")
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
        String query = "SELECT * FROM answer WHERE qid= ?";
        try {
          Statement stmt = conn.createStatement(); 
          PreparedStatement dbStatement =  conn.prepareStatement(query); 
          dbStatement.setInt(1, qid);
          ResultSet rs = dbStatement.executeQuery(query);
          int i=0;
          while(rs.next()){                 
                 answers.add(new Answer( rs.getInt("id"),                                  
                         rs.getInt("qid"),                                  
                         rs.getString("username"),                                  
                         rs.getString("isi"),                                  
                         rs.getString("datetime")                                 
                 ));               
             i++;
          }       
          rs.close();
          stmt.close();
        } 
        catch (Throwable ex) {
          ex.printStackTrace();
        }
        System.out.println(answers);
        return answers;
    }
    
}
