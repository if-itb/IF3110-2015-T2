/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import database.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mochamadtry
 */
@WebService(serviceName = "AnswersWS")
public class AnswersWS {
    // database connection
    Connection conn = DB.getConnection();
    
    /**
     * Web service operation
     * @param qid
     * @return 
     */
    @WebMethod(operationName = "getAnswersByQid")
    @WebResult(name = "Answers")
    public List<Answers> getAnswersByQid(@WebParam(name = "qid") int qid) {
        //TODO write your implementation code here:
        List<Answers> answers = new ArrayList<>();
        
        try (Statement st = conn.createStatement()) {
            
            String query = "SELECT * FROM `answers` WHERE qid = ?";
                
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, qid);
               
            try (ResultSet res = pst.executeQuery()) {
                // get the questions
                while (res.next()) {
                    answers.add(new Answers(res.getInt("id"),
                                            res.getInt("uid"),
                                            res.getInt("qid"),
                                            res.getString("content"),
                                            res.getString("timestamp")));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnswersWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;
    }
    
    /**
     * Create a new answer to the question id
     * @param token
     * @param qid
     * @param content
     * @return 
     */
    @WebMethod(operationName = "createAnswer")
    //@WebResult
    public int createAnswer(@WebParam(name = "token") String token,
                            @WebParam(name = "qid") int qid,
                            @WebParam(name = "content") String content) {
        
        /* INCOMPLETE: Validate token */
        
        int uid = 1; /* STUB: Get ID by token */
        
         try (Statement st = conn.createStatement()) {
            String query = "INSERT INTO answers(uid, qid, content) VALUES (?, ?, ?)";
            
             // set the prepared statement by the query and enter the value of where clause
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, uid);
                pst.setInt(2, qid);
                pst.setString(3, content);

                pst.executeUpdate();
            }
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AnswersWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}