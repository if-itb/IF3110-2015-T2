/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackExchangeWS;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Calvin
 */
@WebService(serviceName = "StackExchangeWS")
public class StackExchangeWS {
    
    DBConnection DB = new DBConnection();
    Connection conn = DB.getConn();
    
    @WebMethod(operationName = "register")
    @WebResult(name="result")
    public String register(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {        
        try {
            String sql = "SELECT email FROM user";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            
            while (rs.next()) {
                if (email.equals(rs.getString("email"))) return "Email already used";
            }
            
            sql = "INSERT INTO user(name, email, password) VALUES(?, ?, ?)";
            dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, name);
            dbStatement.setString(2, email);
            dbStatement.setString(3, password);
            
            dbStatement.executeUpdate();
            
            return "Successfully added user";
        }
        catch (SQLException ex) {
            return "Error adding user";
        }
    }
    
    @WebMethod(operationName = "getQuestion")
    @WebResult(name="Question")
    public Question getQuestion(@WebParam(name = "qid") int qid) {        
        Question q = new Question();
        
        try {
            String sql = "SELECT * FROM question WHERE id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            while(rs.next()) {
                q = new Question(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getString("topic"),
                        rs.getString("content"),
                        rs.getInt("vote"));
            }
            
            return q;
        }
        catch (SQLException ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "getAnswer")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswer(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        
        try {
            String sql = "SELECT * FROM answer WHERE questionId = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            while(rs.next()) {
                Answer temp = new Answer(
                        rs.getInt("id"),
                        rs.getInt("questionId"),
                        rs.getInt("userId"),
                        rs.getString("content"),
                        rs.getInt("vote"));
                answers.add(temp);
            }
            
            return answers;
        }
        catch (SQLException ex) {
            return null;
        }
    }

    @WebMethod(operationName = "insertQuestion")
    @Oneway
    public void insertQuestion(@WebParam(name = "userId") int userId, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        try {
            String sql = "INSERT INTO question(userId, topic, content) VALUES(?, ?, ?)";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, userId);
            dbStatement.setString(2, topic);
            dbStatement.setString(3, content);
            
            dbStatement.executeUpdate();
        }
        catch(SQLException ex) {
        }
    }
    
    @WebMethod(operationName = "updateQuestion")
    @Oneway
    public void updateQuestion(@WebParam(name = "qid") int qid, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        try {
            String sql = "UPDATE question SET topic = ?, content = ? WHERE id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, topic);
            dbStatement.setString(2, content);
            dbStatement.setInt(3, qid);
            
            dbStatement.executeUpdate();
        }
        catch(SQLException ex) {
        }
    }
    
    @WebMethod(operationName = "insertAnswer")
    @Oneway
    public void insertAnswer(@WebParam(name = "qid") int qid, @WebParam(name = "userId") int userId, @WebParam(name = "content") String content) {
        try {
            String sql = "INSERT INTO answer(questionId, userId, content) VALUES(?, ?, ?)";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            dbStatement.setInt(2, userId);
            dbStatement.setString(3, content);
            
            dbStatement.executeUpdate();
        }
        catch(SQLException ex) {
        }
    }
}
