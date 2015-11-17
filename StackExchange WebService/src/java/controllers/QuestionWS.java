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
            sql = "SELECT * FROM question";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get data */
            int i = 0;
            while (rs.next()) {
                questions.add(new Question (
                        rs.getInt("q_id"),
                        rs.getInt("u_id"),
                        rs.getString("topic"),
                        rs.getString("content"),
                        rs.getInt("vote"),
                        rs.getString("date_created"),
                        rs.getString("date_edited")));
                i++;
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
            sql = "SELECT * FROM question WHERE q_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, q_id);
            
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get data */
            int i = 0;
            while (rs.next()) {
                question = new Question (
                        rs.getInt("q_id"),
                        rs.getInt("u_id"),
                        rs.getString("topic"),
                        rs.getString("content"),
                        rs.getInt("vote"),
                        rs.getString("date_created"),
                        rs.getString("date_edited"));
                i++;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
        }
        return question;
    }
}
