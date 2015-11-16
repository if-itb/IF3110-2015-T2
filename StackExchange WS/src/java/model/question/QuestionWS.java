/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import com.sun.istack.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
     */
    @WebMethod(operationName = "getQuestionByID")
    @WebResult(name = "Question")
    public Question getQuestionByID(@WebParam(name = "id") final int id) {        
        Question question = null;
        try (Statement statement = conn.createStatement()) {
            String sql ="SELECT * FROM question WHERE id = ?";            
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);            
            dbStatement.setInt(1, id);
                        
            try (ResultSet result = dbStatement.executeQuery(sql)) {
                if (result.next())
                    question = new Question(
                            result.getInt("id"),
                            result.getInt("id_user"),
                            result.getString("topic"),
                            result.getString("content"),
                            result.getInt("votes"),
                            result.getString("date")
                    );
                result.close();
            }
            statement.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        return question;
    }

    /**
     * Get list of all questions
     * @return List of all questions
     */
    @WebMethod(operationName = "getAllQuestions")
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            String sql ="SELECT * FROM question";                        
            PreparedStatement dbStatement = conn.prepareStatement(sql);                                                
            
            try (ResultSet result = dbStatement.executeQuery(sql)) {
                while (result.next())
                    questions.add(new Question(
                            result.getInt("id"),
                            result.getInt("id_user"),
                            result.getString("topic"),
                            result.getString("content"),
                            result.getInt("votes"),
                            result.getString("date")
                    ));
                result.close();
            }
            statement.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
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
    public boolean addQuestion(@WebParam(name = "id_user") final int id_user, @WebParam(name = "topic") final String topic, @WebParam(name = "content") final String content) {
        boolean success = false;
        try (Statement statement = conn.createStatement()) {
            String sql ="INSERT INTO"
                    + "question (id_user, topic, content)"
                    + "VALUES (?, ?, ?)";                        
            PreparedStatement dbStatement = conn.prepareStatement(sql);            
            dbStatement.setInt(1, id_user);
            dbStatement.setString(2, topic);
            dbStatement.setString(3, content);            
                        
            success = dbStatement.execute(sql);            
            statement.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        return success;
    }
       
    
}
