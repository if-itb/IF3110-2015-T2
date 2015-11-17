/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import model.Answer;
import model.Question;
import model.User;

/**
 *
 * @author visat
 */
@WebService(serviceName = "StackExchange")
public class StackExchange {
    private final Connection connection = DB.connect();
    
    /**
     * Get question by ID
     * @param id
     * @return Question
     */
    @WebMethod(operationName = "getQuestion")
    @WebResult(name = "Question")
    public Question getQuestion(@WebParam(name = "id") final int id) {        
        Question question = null;        
        try {
            String sql ="SELECT * FROM question WHERE id = ?";            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);                
                try (ResultSet result = statement.executeQuery()) {
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
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return question;
    }

    /**
     * Get list of all questions from database
     * @return List of all questions     
     */
    @WebMethod(operationName = "getQuestions")
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();        
        try {
            String sql ="SELECT * FROM question";                                    
            try (
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet result = statement.executeQuery()) {
                while (result.next())
                    questions.add(new Question(
                            result.getInt("id"),
                            result.getInt("id_user"),
                            result.getString("topic"),
                            result.getString("content"),
                            result.getInt("votes"),
                            result.getString("timestamp")
                    ));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return questions;
    }

    /**
     * Add question to database
     * @param idUser
     * @param topic
     * @param content
     * @return Boolean true if success, false otherwise     
     */
    @WebMethod(operationName = "addQuestion")
    public boolean addQuestion(
            @WebParam(name = "idUser") final int idUser,
            @WebParam(name = "topic") final String topic,
            @WebParam(name = "content") final String content) {
        boolean success = false;        
        try {
            String sql = "INSERT INTO"
                    + "question (id_user, topic, content)"
                    + "VALUES (?, ?, ?)";                        
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idUser);
                statement.setString(2, topic);
                statement.setString(3, content);
                
                success = statement.executeUpdate() > 0;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return success;
    }

    /**
     * Delete question from database
     * @param id
     * @return Boolean true if success, false otherwise     
     */
    @WebMethod(operationName = "deleteQuestion")
    public boolean deleteQuestion(@WebParam(name = "id") final int id) {
        boolean success = false;        
        try {
            String sql = "DELETE FROM question WHERE id = ?";                        
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);                
                success = statement.executeUpdate() > 0;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return success;
    }

    /**
     * Update question
     * @param id
     * @param topic
     * @param content
     * @return boolean     
     */
    @WebMethod(operationName = "updateQuestion")
    public boolean updateQuestion(
            @WebParam(name = "id") final int id,
            @WebParam(name = "topic") final String topic,
            @WebParam(name = "content") final String content) {
        boolean success = false;        
        try {
            String sql = "UPDATE question SET topic = ?, content = ? WHERE id = ?";                        
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, topic);
                statement.setString(2, content);
                statement.setInt(3, id);
                
                success = statement.executeUpdate() > 0;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return success;        
    }
    
    /**
     * Web service operation
     * @param idQuestion
     * @param idUser
     * @return 
     */
    @WebMethod(operationName = "isVoteQuestionAvailable")    
    public boolean isVoteQuestionAvailable (
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idQuestion") int idQuestion) {
        boolean available = false;                        
        try {
            String sql = "SELECT * FROM vote_question WHERE id_user = ? AND id_question = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idUser);
                statement.setInt(2, idQuestion);                
                try (ResultSet result = statement.executeQuery()) {
                    available = result.next();
                }
            }
        }
        catch(SQLException ex){
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }                        
        return available;
    }
        
    private boolean voteQuestion(int idUser, int idQuestion, boolean voteUp) {
        boolean success = false;                
        try {
            if (getQuestion(idQuestion) != null && !isVoteQuestionAvailable(idUser, idQuestion)) {                
                String updateQuery = "UPDATE question SET votes = votes " + (voteUp? "+" : "-")  + " 1 WHERE id = ?";
                String insertQuery = "INSERT INTO vote_question (id_user, id_question) VALUES (?, ?)";                    
                connection.setAutoCommit(false);
                try (
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    updateStatement.setInt(1, idQuestion);
                    insertStatement.setInt(1, idUser);
                    insertStatement.setInt(2, idQuestion);                        
                    success = updateStatement.executeUpdate() > 0 && insertStatement.executeUpdate() > 0;
                    connection.commit();
                }
                finally {
                    connection.setAutoCommit(true);
                }                                    
            }                
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return success;        
    }
    
    /**
     *
     * @param idUser
     * @param idQuestion
     * @return
     */
    @WebMethod(operationName = "voteQuestionUp")
    public boolean voteQuestionUp(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idQuestion") int idQuestion) {
        return voteQuestion(idUser, idQuestion, true);
    }
    
    @WebMethod(operationName = "voteQuestionDown")
    public boolean voteQuestionDown(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idQuestion") int idQuestion) {
        return voteQuestion(idUser, idQuestion, false);
    }
    
    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "getAnswer")
    @WebResult(name = "Answer")
    public Answer getAnswer(@WebParam(name = "id") int id) {
        Answer answer = null;
        try{
            String sql = "SELECT * FROM answer WHERE id = ?";            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()){
                    answer = new Answer(result.getInt("id"),
                        result.getInt("id_question"),
                        result.getInt("id_user"),
                        result.getString("content"),
                        result.getString("timestamp"));
                }
            }
        }
        catch(SQLException ex){
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }                                
        return answer;
    }
    
    /**
     * Web service operation
     * @param idQuestion
     * @return 
     */
    @WebMethod(operationName = "getAnswers")
    @WebResult(name = "Answer")
    public List<Answer> getAnswers(@WebParam(name = "idQuestion") int idQuestion) {
        List<Answer> answeresult = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM answer WHERE id_question = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idQuestion);
            
            try (ResultSet result = statement.executeQuery()) {
                while(result.next()){
                    answeresult.add(new Answer(result.getInt("id"),
                            result.getInt("id_question"),
                            result.getInt("id_user"),
                            result.getString("content"),
                            result.getString("timestamp")
                    ));
                }
            }
        }
        catch(SQLException ex){
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }                        
        return answeresult;
    }

    /**
     * Web service operation
     * @param idQuestion
     * @param content
     * @param idUser
     * @return 
     */
    @WebMethod(operationName = "addAnswer")
    @WebResult(name = "Answer")
    public boolean addAnswer(@WebParam(name = "idQuestion") int idQuestion,
                            @WebParam(name = "idUser") int idUser, 
                            @WebParam(name = "content") String content) {
        boolean success = false;                
        try{
            String sql = "INSERT INTO answer(id_question, id_user, content) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idQuestion);
                statement.setInt(2, idUser);
                statement.setString(3, content);
                
                success = statement.executeUpdate() > 0;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return success;
    }

    private boolean voteAnswer(int idUser, int idAnswer, boolean voteUp) {
        boolean success = false;                
        try {
            if (getAnswer(idAnswer) != null && !isVoteAnswerAvailable(idUser, idAnswer)) {                                            
                String updateQuery = "UPDATE answer SET votes = votes " + (voteUp? "+" : "-")  + " 1 WHERE id = ?";
                String insertQuery = "INSERT INTO vote_answer (id_user, id_answer) VALUES (?, ?)";                    
                connection.setAutoCommit(false);
                try (
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    updateStatement.setInt(1, idAnswer);
                    insertStatement.setInt(1, idUser);
                    insertStatement.setInt(2, idAnswer);                        
                    success = updateStatement.executeUpdate() > 0 && insertStatement.executeUpdate() > 0;
                    connection.commit();
                }
                finally {
                    connection.setAutoCommit(true);
                }                                    
            }                
        }
        catch (SQLException ex) {
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return success;        
    }
    
    /**
     * Web service operation
     * @param idUser
     * @param idAnswer     
     * @return      
     */
    @WebMethod(operationName = "voteAnswerUp")
    @WebResult(name = "Answer")
    public boolean voteAnswerUp(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idAnswer") int idAnswer) {
        return voteAnswer(idUser, idAnswer, true);        
    }
    
    /**
     * Web service operation
     * @param idUser
     * @param idAnswer     
     * @return      
     */
    @WebMethod(operationName = "voteAnswerDown")
    @WebResult(name = "Answer")
    public boolean voteAnswerDown(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idAnswer") int idAnswer) {
        return voteAnswer(idUser, idAnswer, false);        
    }
    
    /**
     * Web service operation
     * @param idUser
     * @param idAnswer
     * @return 
     */
    @WebMethod(operationName = "isVoteAnswerAvailable")
    @WebResult(name = "Answer")
    public boolean isVoteAnswerAvailable(
            @WebParam(name = "idUser") int idUser,
            @WebParam(name = "idAnswer") int idAnswer) {
        boolean available = false;                        
        try{
            String sql = "SELECT * FROM vote_answer WHERE id_user = ? AND id_answer = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idUser);
                statement.setInt(2, idAnswer);
                
                available = statement.execute();
            }
        }
        catch(SQLException ex){
            Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);
        }                        
        return available;
    }
    
    /**
     * Web service operation
     * @param name
     * @param email
     * @param password
     * @return 
     */
    @WebMethod(operationName = "addUser")
    public boolean addUser(
            @WebParam(name = "name") String name,
            @WebParam(name = "email") String email,
            @WebParam(name = "password") String password) {        
        boolean success = false;
        try {         
          String sql = "SELECT email FROM users WHERE email = ?";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, email);
          
          ResultSet temp = statement.executeQuery();
          if(!temp.next()){
              sql = "INSERT INTO users (name, email, password) VALUES (MD5(?), ?, ?)";
              statement = connection.prepareStatement(sql);                            
              statement.setString(1, name);
              statement.setString(2, email);
              statement.setString(3, password);

              success = statement.executeUpdate() > 0;              
          }
          statement.close();
        } catch (SQLException ex) {
          Logger.getLogger(StackExchange.class.getName()).log(Level.SEVERE, null, ex);          
        }
        
        return success;
    }
}
