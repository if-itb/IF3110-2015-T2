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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
            sql = "SELECT * FROM question natural join user";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            /* Get data */
            while (rs.next()) {
                //int qId, int uId, String username, String name, String topic, String content, int vote, int answer, String dateCreated, String dateEdited
                questions.add(new Question (
                    rs.getInt("q_id"),
                    rs.getInt("u_id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("topic"),
                    rs.getString("content"),
                    rs.getInt("vote"),
                    getCountAnswer(rs.getInt("q_id")),
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
            sql = "SELECT * FROM question natural join user WHERE q_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, q_id);
            
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get data */
            while (rs.next()) {
                //int qId, int uId, String username, String name, String topic, String content, int vote, int answer, String dateCreated, String dateEdited
                question = new Question (
                    rs.getInt("q_id"),
                    rs.getInt("u_id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("topic"),
                    rs.getString("content"),
                    rs.getInt("vote"),
                    getCountAnswer(rs.getInt("q_id")),
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
                sql = "SELECT q_id FROM question WHERE u_id="+u_id+" ORDER BY date_created DESC LIMIT 1";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                    return rs.getInt("q_id");
                }
            }
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return -1;
        }
        
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteQuestion")
    @WebResult(name="Vote")
    public String voteQuestion(@WebParam(name = "q_id") int q_id, @WebParam(name = "u_id") int u_id) {
        String vote = "null";
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vote FROM vote_question WHERE q_id="+q_id+" and u_id="+u_id;
            ResultSet rs = stmt.executeQuery(sql);
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                vote = Integer.toString(rs.getInt("vote"));
            }
            if(!empty && (vote.equals("1"))) return "null";
            sql = "UPDATE question SET vote = vote+1 WHERE q_id="+q_id;
            stmt.executeUpdate(sql);
            if(!empty) {
                sql = "UPDATE vote_question SET vote = vote+1 WHERE q_id="+q_id+" and u_id="+u_id;
            }
            else {
                sql = "INSERT INTO vote_question VALUE ("+q_id+","+u_id+",1)";
            }
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM question WHERE q_id="+q_id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vote = Integer.toString(rs.getInt("vote"));
            }
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return "null";
        }
        return vote;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "devoteQuestion")
    public String devoteQuestion(@WebParam(name = "q_id") int q_id, @WebParam(name = "u_id") int u_id) {
        String vote = "null";
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vote FROM vote_question WHERE q_id="+q_id+" and u_id="+u_id;
            ResultSet rs = stmt.executeQuery(sql);
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                vote = Integer.toString(rs.getInt("vote"));
            }
            if(!empty && (vote.equals("-1"))) return "null";
            sql = "UPDATE question SET vote = vote-1 WHERE q_id="+q_id;
            stmt.executeUpdate(sql);
            if(!empty) {
                sql = "UPDATE vote_question SET vote = vote-1 WHERE q_id="+q_id+" and u_id="+u_id;
            }
            else {
                sql = "INSERT INTO vote_question VALUE ("+q_id+","+u_id+",-1)";
            }
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM question WHERE q_id="+q_id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vote = Integer.toString(rs.getInt("vote"));
            }
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return "null";
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCountAnswer")
    public int getCountAnswer(@WebParam(name = "q_id") int q_id) {
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "select count(a_id) as count from answer where q_id="+q_id+" group by q_id";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQuestion")
    public int updateQuestion(@WebParam(name = "q_id") int q_id, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE question SET topic = '"+topic+"', content = '"+content+"', date_edited=now() WHERE q_id="+q_id;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    
}
