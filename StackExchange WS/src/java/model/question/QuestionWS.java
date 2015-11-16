/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import com.sun.istack.logging.Logger;
import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author visat
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    private Connection conn = DB.connect();
    
    /**
     * Get question by ID
     * @param id
     * @return Question
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "getQuestionByID")
    @WebResult(name = "Question")
    public Question getQuestionByID(@WebParam(name = "id") final int id) throws SQLException {        
        Question question = null;
        PreparedStatement statement = null;            
        try {
            String sql ="SELECT * FROM question WHERE id = ?";            
            statement = conn.prepareStatement(sql);            
            statement.setInt(1, id);
                        
            ResultSet result = statement.executeQuery();
            if (result.next())
                question = new Question(
                    result.getInt("id"),
                    result.getInt("id_user"),
                    result.getString("topic"),
                    result.getString("content"),
                    result.getInt("votes"),
                    result.getString("date")
                );                                        
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        finally {
            if (statement != null)
                statement.close();
        }
        return question;
    }

    /**
     * Get list of all questions from database
     * @return List of all questions
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "getAllQuestions")
    public List<Question> getAllQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        PreparedStatement statement = null;                                                
        try {
            String sql ="SELECT * FROM question";                                    
            statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next())
                questions.add(new Question(
                    result.getInt("id"),
                    result.getInt("id_user"),
                    result.getString("topic"),
                    result.getString("content"),
                    result.getInt("votes"),
                    result.getString("date")
                ));            
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        finally {
            if (statement != null)
                statement.close();
        }
        return questions;
    }

    /**
     * Add question to database
     * @param id_user
     * @param topic
     * @param content
     * @return Boolean true if success, false otherwise
     */
    @WebMethod(operationName = "addQuestion")
    public boolean addQuestion(@WebParam(name = "id_user") final int id_user, @WebParam(name = "topic") final String topic, @WebParam(name = "content") final String content) throws SQLException {
        boolean success = false;
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO"
                    + "question (id_user, topic, content)"
                    + "VALUES (?, ?, ?)";                        
            statement = conn.prepareStatement(sql);                        
            statement.setInt(1, id_user);
            statement.setString(2, topic);
            statement.setString(3, content);            
                        
            success = statement.executeUpdate() > 0;                        
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        finally {
            if (statement != null)
                statement.close();
        }
        return success;
    }

    /**
     * Delete question from database
     * @param id
     * @return Boolean true if success, false otherwise
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "deleteQuestion")
    public boolean deleteQuestion(@WebParam(name = "id") final int id) throws SQLException {
        boolean success = false;
        PreparedStatement statement = null;
        try {
            String sql = "DELETE FROM question WHERE id = ?";                        
            statement = conn.prepareStatement(sql);                        
            statement.setInt(1, id);            
                        
            success = statement.executeUpdate() > 0;                        
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        finally {
            if (statement != null)
                statement.close();
        }
        return success;
    }
       
    
}
