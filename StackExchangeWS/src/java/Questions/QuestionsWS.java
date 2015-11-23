/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import database.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;

/**
 *
 * @author Ahmad Naufal Farhan
 */
@WebService(serviceName = "QuestionsWS")
public class QuestionsWS {
    
    Connection conn = DB.getConnection();
    /**
     * Get question row by its id, to show as a post
     * @param id the question id
     * @return the question
     */
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name="Question")
    public Question getQuestionById(@WebParam(name = "id") int id) {
        Question question = null;
        
        try {
            try (Statement st = conn.createStatement()) {
                String query;
                query = "SELECT * FROM questions WHERE id = ?";
                
                // set the prepared statement by the query and enter the value of where clause
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, id);
                
                // create a new question object with the result
                try (ResultSet res = pst.executeQuery()) {
                    
                    if (res.next())
                        question = new Question(res.getInt("id"),
                                res.getInt("uid"),
                                res.getString("topic"),
                                res.getString("content"),
                                res.getString("timestamp"));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }
    
    /**
     * Get all questions for index page
     * @return list containing all questions
     */
    @WebMethod(operationName = "getAllQuestions")
    @WebResult(name = "Questions")
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        
        try (Statement st = conn.createStatement()) {
            
            String query = "SELECT * FROM `questions`";
                
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
               
            try (ResultSet res = pst.executeQuery()) {
                // get the questions
                while (res.next()) {
                    questions.add(new Question(res.getInt("id"),
                            res.getInt("uid"),
                            res.getString("topic"),
                            res.getString("content"),
                            res.getString("timestamp")));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questions;
    }
    
    /** FROM HERE, ALL QUESTION OPERATION MUST HAVE AN AUTHORIZATION TOKEN **/

    /**
     * Create a new question from question form with user
     * @param token the token to be validated
     * @param topic the question topic
     * @param content the question content
     * @param uid user id that posted the question
     * @return succession
     */
    @WebMethod(operationName = "createQuestion")
    @WebResult(name="Success")
    public int createQuestion(@WebParam(name = "token") String token,
                                @WebParam(name = "topic") String topic,
                                @WebParam(name = "content") String content) {
        
        /* INCOMPLETE: Validate token */
        
        int uid = 1; /* STUB: Get ID by token */
        
        try (Statement st = conn.createStatement()) {
            String query = "INSERT INTO questions(uid, topic, content) VALUES (?, ?, ?)";
                
            // set the prepared statement by the query and enter the value of where clause
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, uid);
                pst.setString(2, topic);
                pst.setString(3, content);
                  
                pst.executeUpdate();
            }
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    /**
     * Update the topic and question of a specific question, only can be 
     * edited by the user
     * @param token
     * @param id
     * @param topic
     * @param content
     * @return 
     */
    @WebMethod(operationName = "updateQuestion")
    @WebResult(name = "Success")
    public int updateQuestion(@WebParam(name = "token") String token,
                                @WebParam(name = "id") int id,
                                @WebParam(name = "topic") String topic,
                                @WebParam(name = "content") String content) {
        
        /* INCOMPLETE: Validate token */
        
        try (Statement st = conn.createStatement()) {
            String query = "UPDATE questions SET topic = ?, content = ? WHERE id = ?";
            
            // set the prepared statement by the query and enter the value of where clause
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, topic);
                pst.setString(2, content);
                pst.setInt(3, id);
                
                pst.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    /**
     * Web service operation
     * @param token
     * @param id
     * @return 
     */
    @WebMethod(operationName = "deleteQuestion")
    @WebResult(name = "Success")
    public int deleteQuestion(@WebParam(name = "token") String token, 
                                @WebParam(name = "id") int id) {
        
        /* INCOMPLETE: Validate token */
        
        try (Statement st = conn.createStatement()) {
            String query = "DELETE FROM questions WHERE id = ?";
            
            // set the prepared statement by the query and enter the value of where clause
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

}
