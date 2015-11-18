/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import DatabaseAdapter.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author user
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    database DB = new database();
    
    Connection conn = DB.connect();
    
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name="Question")
    public Question getQuestionByQID(@WebParam(name = "qid") int qid) {
        
        Question question = new Question();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions where question_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            rs.next();
            question = new Question(rs.getInt("question_id"), 
                                    rs.getInt("user_id"),                     
                                    rs.getString("topic"),
                                    rs.getString("content"),
                                    rs.getInt("vote"),
                                    rs.getString("time"),
                                    rs.getInt("answer_count")
                                    );                
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }
    
    @WebMethod(operationName = "getAllQuestions")
    @WebResult(name="Questions")
    public ArrayList<Question> getAllQuestions() {
        
        ArrayList<Question> questions = new ArrayList<>();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);            
            ResultSet rs = dbStatement.executeQuery();
            
           int i = 0;
            while (rs.next()) {
            questions.add(new Question(rs.getInt("question_id"), 
                                    rs.getInt("user_id"),                     
                                    rs.getString("topic"),
                                    rs.getString("content"),
                                    rs.getInt("vote"),
                                    rs.getString("time"),
                                    rs.getInt("answer_count")
                                    ));                
                ++i;
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questions;
    }
    
    @WebMethod(operationName = "createQuestion")    
    @WebResult(name="QuestionID")
    public int createQuestion(@WebParam(name = "uid") int uid, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        int qid = 0;
        // Call Identity Service
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO questions(user_id,topic,content,vote,answer_count) VALUES (?,?,?,0,0)";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            dbStatement.setInt(1, uid);
            dbStatement.setString(2, topic);
            dbStatement.setString(3, content);
            
            dbStatement.executeUpdate();
            ResultSet rs = dbStatement.getGeneratedKeys();
            while (rs.next()) {
		qid = rs.getInt(1);
            }            
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qid;
    }
        
    @WebMethod(operationName = "updateQuestion")    
    @WebResult(name="QuestionID")
    public int updateQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "uid") int uid) {
        try {
            // Call Identity Service
            Statement stmt = conn.createStatement();
            
            String isSameUser;
            isSameUser = "SELECT user_id FROM questions WHERE question_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(isSameUser);
            dbStatement.setInt(1, qid);
            
            ResultSet rsSameUser = dbStatement.executeQuery();
            rsSameUser.next();
            
            int questionUID = rsSameUser.getInt("user_id");
            
            if (questionUID == uid) {
                try {                            
                    String sql;
                    sql = "UPDATE questions SET topic = ?, content = ? WHERE question_id = ?";
                    
                    dbStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    dbStatement.setString(1, topic);
                    dbStatement.setString(2, content);
                    dbStatement.setInt(3, qid);
                    
                    dbStatement.executeUpdate();
                    ResultSet rs = dbStatement.getGeneratedKeys();
                    while (rs.next()) {
                        qid = rs.getInt(1);
                    }    
                    
                    rs.close();
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                qid = 0;
            }                
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qid;
    }
    
    @WebMethod(operationName = "voteQuestion")    
    @WebResult(name="QuestionID")
    public int voteQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "vote") int vote) {            
        try {
            Statement stmt = conn.createStatement();
                                    
            String sql;
            sql = "UPDATE questions SET vote = vote + ? WHERE question_id = ?";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            dbStatement.setInt(1, vote);
            dbStatement.setInt(2, qid);
                    
            dbStatement.executeUpdate();
            ResultSet rs = dbStatement.getGeneratedKeys();
            while (rs.next()) {
                qid = rs.getInt(1);
            }    
                    
            rs.close();
            stmt.close();
                    
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qid;
    }


    @WebMethod(operationName = "deleteQuestion")    
    @WebResult(name="QuestionID")
    public int deleteQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "uid") int uid) {
        try {
            // Call Identity Service
            Statement stmt = conn.createStatement();
            
            String isSameUser;
            isSameUser = "SELECT user_id FROM questions WHERE question_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(isSameUser);
            dbStatement.setInt(1, qid);
            
            ResultSet rsSameUser = dbStatement.executeQuery();
            rsSameUser.next();
            
            int questionUID = rsSameUser.getInt("user_id");
            
            if (questionUID == uid) {
                try {                            
                    String sql;
                    sql = "DELETE FROM questions WHERE question_id = ?";
                    
                    dbStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    dbStatement.setInt(1, qid);
                    
                    dbStatement.executeUpdate();
                    ResultSet rs = dbStatement.getGeneratedKeys();
                    while (rs.next()) {
                        qid = rs.getInt(1);
                    }
                    
                    sql = "DELETE FROM answers WHERE question_id = ?";
                    dbStatement = conn.prepareStatement(sql);
                    dbStatement.setInt(1, qid);                    
                    dbStatement.executeUpdate();
                    
                    rs.close();
                    stmt.close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                qid = 0;
            }                
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qid;
    }

}