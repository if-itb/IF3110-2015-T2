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
import org.data.Answer;
import org.data.Question;
import org.json.JSONObject;
import org.wsdl.IdentityImplService;

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
                connectDB();
                st = connection.createStatement();
                sql = ("INSERT INTO users (username, email, password) VALUES ('"+ username +"', '"+ email +"', '"+ password +"')");
                st.execute(sql);
                closeDB();
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public String login(String email, String password){
        String token = null;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT email FROM users WHERE email = '" + email + "' AND password = '" + password + "'");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                IdentityImplService identityService = new IdentityImplService();
                org.wsdl.Identity identity = identityService.getIdentityImplPort();
                token = identity.createToken(rs.getInt("id_user"));
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return token;
    }
    /**
     * Web service operation
     * @param id
     * @return 
     */
    @Override
    public Question getQuestion(int id) {
        Question qu = new Question();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT question.id, question.id_user, question.topic, question.content, question.timestamp, (SELECT COUNT(vote_question.id_user) as votes FROM vote_question WHERE vote_question.id = question.id) as votes, COUNT(answer.id) AS count FROM (question LEFT JOIN answer ON question.id = answer.id) WHERE question.id = '" + id + "'");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                qu.id = rs.getInt("id");
                qu.name = rs.getString("name");
                qu.topic = rs.getString("topic");
                qu.content = rs.getString("content");
                qu.timestamp = rs.getString("timestamp");
                qu.vote = rs.getInt("votes");
                qu.count = rs.getInt("count");
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qu;
    }

    /**
     * Web service operation
     * @return 
     */
    @Override
    public Question[] getAllQuestion() {
        ArrayList<Question> allQuestion = new ArrayList<>();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT DISTINCT question.id, (SELECT username FROM user WHERE user.id = question.id_user) as name, question.topic, question.content, question.timestamp, (SELECT COUNT(vote_question.id_user) as votes FROM vote_question WHERE vote_question.id = question.id) as votes, (SELECT COUNT(answer.id) as count FROM answer WHERE answer.id = question.id) as count FROM question ORDER BY id DESC");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Question qu = new Question();
                qu.id = rs.getInt("id");
                qu.name = rs.getString("name");
                qu.topic = rs.getString("topic");
                qu.content = rs.getString("content");
                qu.timestamp = rs.getString("timestamp");
                qu.vote = rs.getInt("votes");
                qu.count = rs.getInt("count");
                allQuestion.add(qu);
            }
            closeDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Question qu[] = new Question[allQuestion.size()];
        for(int i = 0; i < allQuestion.size(); i++){
            qu[i] = allQuestion.get(i);
        }
        return qu;
    }
    
    @Override
    public Answer getAnswer(int id_answer) {
        Answer an = new Answer();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT *, (SELECT COUNT(vote_answer.id_user) as votes FROM vote_answer WHERE vote_answer.id_answer = answer.id_answer) as votes FROM answer WHERE id_answer ='" + id_answer + "'");
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                an.id = rs.getInt("id");
                an.id_answer = rs.getInt("id_answer");
                an.name = rs.getString("name");
                an.content = rs.getString("content");
                an.timestamp = rs.getString("timestamp");
                an.vote = rs.getInt("votes");
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return an;
    }
    @Override
    public Answer[] getAllAnswer(int id) {
        ArrayList<Answer> allAnswer = new ArrayList<>();
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = ("SELECT *, (SELECT COUNT(vote_answer.id_user) as votes FROM vote_answer WHERE vote_answer.id_answer = answer.id_answer) as votes FROM answer WHERE id ='" + id + "'");
            ResultSet rs = st.executeQuery(sql);
            
            JSONObject j = new JSONObject();
            while(rs.next()){
                Answer an = new Answer();
                an.id = rs.getInt("id");
                an.id_answer = rs.getInt("id_answer");
                an.name = rs.getString("name");
                an.content = rs.getString("content");
                an.timestamp = rs.getString("timestamp");
                an.vote = rs.getInt("votes");
                allAnswer.add(an);
            }
            closeDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        Answer an[] = new Answer[allAnswer.size()];
        for(int i = 0; i < allAnswer.size(); i++){
            an[i] = allAnswer.get(i);
        }
        return an;
    }

    /**
     * Web service operation
     * @param token
     * @param topic
     * @param content
     * @return 
     */
    @Override
    public int addQuestion(String token, String topic, String content){
        int id = 0;
        IdentityImplService identityService = new IdentityImplService();
        org.wsdl.Identity identity = identityService.getIdentityImplPort();
        String status = identity.whoIs(token);
        JSONObject json = new JSONObject(status);
        if(json.get("status").equals("ok")){
            int id_user = json.getInt("id_user");
            try {
                connectDB();
                Statement st = connection.createStatement();
                String sql = "INSERT INTO question (id_user, topic, content) VALUES ('"+ id_user +"', '"+ topic +"', '"+ content +"')";
                st.execute(sql);
                closeDB();
                connectDB();
                st = connection.createStatement();
                sql = "SELECT id FROM question WHERE content LIKE '" + content + "'";
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    id = rs.getInt("id");
                }
                closeDB();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return id;
    }
    @Override
    public boolean addAnswer(int id, String token, String content){
        IdentityImplService identityService = new IdentityImplService();
        org.wsdl.Identity identity = identityService.getIdentityImplPort();
        String status = identity.whoIs(token);
        JSONObject json = new JSONObject(status);
        if(json.get("status").equals("ok")){
            int id_user = json.getInt("id_user");
            try {
                connectDB();
                Statement st = connection.createStatement();
                String sql = "INSERT INTO answer (id, id_user, content) VALUES ('"+ id +"', '"+ id_user +"', '"+ content +"')";
                st.execute(sql);
                closeDB();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return true;
    }
    @Override
    public int editQuestion(int id, String token, String topic, String content){
        IdentityImplService identityService = new IdentityImplService();
        org.wsdl.Identity identity = identityService.getIdentityImplPort();
        String status = identity.whoIs(token);
        JSONObject json = new JSONObject(status);
        if(json.get("status").equals("ok")){
            int id_user = json.getInt("id_user");
            try {
                connectDB();
                Statement st = connection.createStatement();
                String sql = "UPDATE question SET topic = '" + topic + "', content = '" + content + "' WHERE id = '" + id + "' AND id_user = '" + id_user + "'";
                st.execute(sql);
                closeDB();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return id;
    }
    @Override
    public boolean deleteQuestion(int id, String token){
        IdentityImplService identityService = new IdentityImplService();
        org.wsdl.Identity identity = identityService.getIdentityImplPort();
        String status = identity.whoIs(token);
        JSONObject json = new JSONObject(status);
        if(json.get("status").equals("ok")){
            int id_user = json.getInt("id_user");
            try {
                connectDB();
                Statement st = connection.createStatement();
                String sql = "DELETE FROM question WHERE id = '" + id + "' AND id_user = '" + id_user + "'";
                st.execute(sql);
                closeDB();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return true;
    }
    @Override
    public int updateVoteAnswer(int id_answer, int vote){
        int votes = 0;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "SELECT votes FROM answer WHERE id_answer = '" + id_answer + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            votes = rs.getInt("votes");
            if(vote == 1){
                votes++;
            }
            else if(vote == -1 && votes > 0){
                votes--;
            }
            closeDB();
            connectDB();
            st = connection.createStatement();
            sql = "UPDATE answer SET votes = '" + votes + "' WHERE id_answer = '" + id_answer + "'";
            st.execute(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return votes;
    }
    @Override
    public int updateVoteQuestion(int id, int vote){
        int votes = 0;
        try {
            connectDB();
            Statement st = connection.createStatement();
            String sql = "SELECT votes FROM question WHERE id = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            votes = rs.getInt("votes");
            if(vote == 1){
                votes++;
            }
            else if(vote == -1 && votes > 0){
                votes--;
            }
            closeDB();
            connectDB();
            st = connection.createStatement();
            sql = "UPDATE answer SET votes = '" + votes + "' WHERE id = '" + id + "'";
            st.execute(sql);
            closeDB();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return votes;
    }
}
