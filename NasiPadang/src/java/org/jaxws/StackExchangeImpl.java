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
import javax.jws.WebService;
import javax.jws.WebParam;
import org.data.Question;

/**
 *
 * @author user
 */
@WebService(endpointInterface = "org.jaxws.StackExchange")
public class StackExchangeImpl implements StackExchange {
    private Connection connection;
    private void connectDB() throws SQLException{
        try {
            System.out.println("Loading driver...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath!", e);
        }
        String url = "jdbc:mysql://localhost:3306/db_stackexchange";
        String username = "root";
        String password = "";
        connection = null;
        System.out.println("Connecting database...");
        connection = (Connection) DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @Override
    public Question getQuestion(@WebParam(name = "id") int id) {
        Question question = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT * FROM `question` WHERE `id` = " + id);
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                question = new Question();
                question.id = rs.getInt("id");
                question.name = rs.getString("name");
                question.topic = rs.getString("topic");
                question.content = rs.getString("content");
                question.timestamp = rs.getString("timestamp");
                question.vote = rs.getInt("votes");
                question.count = rs.getInt("count");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    /**
     * Web service operation
     * @return 
     */
    @Override
    public ArrayList getAllQuestion() {
        ArrayList<Question> allQuestion = new ArrayList<>();
        Question question = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT DISTINCT question.id, question.name, question.topic, question.content, question.timestamp, question.votes, (SELECT COUNT(answer.id) as count FROM answer WHERE answer.id = question.id) as count FROM question ORDER BY id DESC");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                question = new Question();
                question.id = rs.getInt("id");
                question.name = rs.getString("name");
                question.topic = rs.getString("topic");
                question.content = rs.getString("content");
                question.timestamp = rs.getString("timestamp");
                question.vote = rs.getInt("votes");
                question.count = rs.getInt("count");
                allQuestion.add(question);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allQuestion;
    }

    /**
     * Web service operation
     * @param topic
     * @param content
     * @return 
     */
    @Override
    public Boolean addQuestion(@WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        //TODO write your implementation code here:
        return null;
    }
}
