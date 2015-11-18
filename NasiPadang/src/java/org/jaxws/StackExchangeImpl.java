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
import javax.jws.WebService;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private void closeDB() throws SQLException{
        connection.close();
    }
    @Override
    public boolean register(String username, String email, String password){
        boolean success = false;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT email FROM users WHERE email = '" + email + "'");
            ResultSet rs = st.executeQuery(sql);
            closeDB();
            if(!rs.next()){
                sql = ("INSERT INTO users (username, email, password) VALUES ('"+ username +"', '"+ email +"', '"+ password +"')");
                rs = st.executeQuery(sql);
                closeDB();
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public boolean login(String email, String password){
        boolean success = false;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT email FROM users WHERE email = '" + email + "' AND password = '" + password + "'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                success = true;
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    /**
     * Web service operation
     * @param id
     * @return 
     */
    @Override
    public String getQuestion(int id) {
        JSONObject j = new JSONObject();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT question.id, question.name, question.topic, question.content, question.timestamp, question.votes, COUNT(answer.id) AS count FROM (question LEFT JOIN answer ON question.id = answer.id) WHERE question.id = '" + id + "'");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                j.put("id", rs.getInt("id"));
                j.put("name", rs.getString("name"));
                j.put("topic", rs.getString("topic"));
                j.put("content", rs.getString("content"));
                j.put("timestamp", rs.getString("timestamp"));
                j.put("vote", rs.getInt("votes"));
                j.put("count", rs.getInt("count"));
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(j.toString());
        return j.toString();
    }

    /**
     * Web service operation
     * @return 
     */
    @Override
    public String getAllQuestion() {
        JSONArray allQuestion = new JSONArray();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT DISTINCT question.id, question.name, question.topic, question.content, question.timestamp, question.votes, (SELECT COUNT(answer.id) as count FROM answer WHERE answer.id = question.id) as count FROM question ORDER BY id DESC");
            ResultSet rs = st.executeQuery(sql);
            
            JSONObject j = new JSONObject();
            while(rs.next()){
                j = new JSONObject();
                j.put("id", rs.getInt("id"));
                j.put("name", rs.getString("name"));
                j.put("topic", rs.getString("topic"));
                j.put("content", rs.getString("content"));
                j.put("timestamp", rs.getString("timestamp"));
                j.put("vote", rs.getInt("votes"));
                j.put("count", rs.getInt("count"));
                allQuestion.put(j);
            }
            closeDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("THISSSS " + allQuestion.toString());
        return allQuestion.toString();
    }
    
    @Override
    public String getAllAnswer(int id) {
        JSONArray allAnswer = new JSONArray();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT * FROM answer WHERE id ='" + id + "'");
            ResultSet rs = st.executeQuery(sql);
            
            JSONObject j = new JSONObject();
            while(rs.next()){
                j = new JSONObject();
                j.put("id", rs.getInt("id"));
                j.put("name", rs.getString("name"));
                j.put("topic", rs.getString("topic"));
                j.put("content", rs.getString("content"));
                j.put("timestamp", rs.getString("timestamp"));
                j.put("vote", rs.getInt("votes"));
                j.put("count", rs.getInt("count"));
                allAnswer.put(j);
            }
            closeDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allAnswer.toString();
    }

    /**
     * Web service operation
     * @param qu
     * @return 
     */
    @Override
    public boolean addQuestion(String token, String topic, String content){
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "INSERT INTO question (name, topic, content) VALUES ('"+ token +"', '"+ topic +"', '"+ content +"')";
            ResultSet rs = st.executeQuery(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean addAnswer(int id, String token, String content){
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "INSERT INTO answer (id, name, content) VALUES ('"+ id +"', '"+ token +"', '"+ content +"')";
            ResultSet rs = st.executeQuery(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean editQuestion(int id, String token, String topic, String content){
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "UPDATE question SET topic = '" + topic + "', content = '" + content + "' WHERE id = '" + id + "' AND name = '" + token + "'";
            ResultSet rs = st.executeQuery(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean updateVoteAnswer(int id_answer, int vote){
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "SELECT votes FROM answer WHERE id_answer = '" + id_answer + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int votes = rs.getInt("votes");
            if(vote == 1){
                votes++;
            }
            else if(vote == -1 && votes > 0){
                votes--;
            }
            closeDB();
            st = connection.createStatement();
            sql = "UPDATE answer SET votes = '" + votes + "' WHERE id_answer = '" + id_answer + "'";
            rs = st.executeQuery(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    @Override
    public boolean updateVoteQuestion(int id, int vote){
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "SELECT votes FROM question WHERE id = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int votes = rs.getInt("votes");
            if(vote == 1){
                votes++;
            }
            else if(vote == -1 && votes > 0){
                votes--;
            }
            closeDB();
            st = connection.createStatement();
            sql = "UPDATE answer SET votes = '" + votes + "' WHERE id = '" + id + "'";
            rs = st.executeQuery(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
}
