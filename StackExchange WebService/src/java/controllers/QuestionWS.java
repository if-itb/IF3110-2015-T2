/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import model.Question;
//import sun.util.logging.PlatformLogger;

/**
 *
 * @author Tifani
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    // Open connection to database
    Connection conn = DatabaseController.connect();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllQuestions")
    @WebResult(name="Question")
    public ArrayList<Question> getAllQuestions() {
        //TODO write your implementation code here:
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT question.q_id as q_id, question.u_id as u_id, "
                    + "username, name, "
                    + "topic, question.content as content, "
                    + "question.vote as vote, count(a_id) as answer, "
                    + "question.date_created as date_created, date_edited "
                    + "FROM (question NATURAL JOIN user) JOIN answer "
                    + "ON (question.q_id = answer.q_id)";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            /* Get data */
            while (rs.next()) {
                questions.add(new Question (
                    rs.getInt("q_id"),
                    rs.getInt("u_id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("topic"),
                    rs.getString("content"),
                    rs.getInt("vote"),
                    rs.getInt("answer"),
                    rs.getString("date_created"),
                    rs.getString("date_edited")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return questions;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name="Question")
    public Question getQuestionById(@WebParam(name = "q_id") int q_id) {
        Question question = new Question();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT question.q_id as q_id, question.u_id as u_id, "
                    + "username, name, "
                    + "topic, question.content as content, "
                    + "question.vote as vote, count(a_id) as answer, "
                    + "question.date_created as date_created, date_edited "
                    + "FROM (question NATURAL JOIN user) JOIN answer "
                    + "ON (question.q_id = answer.q_id) WHERE question.q_id = ? ";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, q_id);
            
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get data */
            while (rs.next()) {
                question = new Question (
                    rs.getInt("q_id"),
                    rs.getInt("u_id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("topic"),
                    rs.getString("content"),
                    rs.getInt("vote"),
                    rs.getInt("answer"),
                    rs.getString("date_created"),
                    rs.getString("date_edited"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
        }
        return question;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addNewQuestion")
    public int addNewQuestion(@WebParam(name = "u_id") int u_id, @WebParam(name = "topic") String topic,  @WebParam(name = "content") String content) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO question(u_id,topic,content,date_created) VALUE ("+u_id+",'"+topic+"','"+content+"',now())";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion")
    public int voteQuestion(@WebParam(name = "q_id") int q_id) {
        int vote = -999;
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE question SET vote = vote+1 WHERE q_id="+q_id;
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM question WHERE q_id="+q_id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vote = rs.getInt("vote");
            }
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return vote;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "devoteQuestion")
    public int devoteQuestion(@WebParam(name = "q_id") int q_id) {
        int vote = -999;
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE question SET vote = vote-1 WHERE q_id="+q_id;
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM question WHERE q_id="+q_id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vote = rs.getInt("vote");
            }
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return vote;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    public int deleteQuestion(@WebParam(name = "q_id") int q_id) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "DELETE FROM question WHERE q_id="+q_id;
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
