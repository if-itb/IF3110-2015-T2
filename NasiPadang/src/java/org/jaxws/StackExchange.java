/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.data.Question;

/**
 *
 * @author user
 */
@WebService(serviceName = "StackExchange")
public class StackExchange {
    private Connection connection;
    private void connectDB() throws SQLException{
        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
        String url = "jdbc:mysql://localhost:3306/post";
        String username = "root";
        String password = "";
        connection = null;
        System.out.println("Connecting database...");
        connection = (Connection) DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestion")
    public Question getQuestion(@WebParam(name = "id") int id) {
        Question question = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT * FROM `question` WHERE `id` = " + id);
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                question = new Question();
                question.setID(rs.getInt("id"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setDate(rs.getString("date"));
            }
        
        } catch (SQLException e) {
            System.err.println("Gagal melakukan koneksi.");
        }
        return question;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllQuestion")
    public ArrayList getAllQuestion() {
        ArrayList<Question> allQuestion = new ArrayList<>();
        Question question = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT * FROM `question`");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                question = new Question();
                question.setID(rs.getInt("id"));
                question.setTopic(rs.getString("topic"));
                question.setContent(rs.getString("content"));
                question.setDate(rs.getString("date"));
                allQuestion.add(question);
            }
        } catch (SQLException ex) {
            System.err.println("Gagal melakukan koneksi."); 
        }
        return allQuestion;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addQuestion")
    public Boolean addQuestion(@WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        //TODO write your implementation code here:
        return null;
    }
}
