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
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.*;

/**
 *
 * @author vanyadeasysafrina
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    // Open connection to database
    Connection conn = DatabaseController.connect();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByQId")
    public ArrayList getAnswerByQId(@WebParam(name = "q_id") int q_id) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answer WHERE q_id="+q_id;
            ResultSet rs = stmt.executeQuery(sql);
            /* Get data */
            //int a_id, int u_id, String content, int vote, String date_created, int q_id
            while (rs.next()) {
                answers.add(new Answer (
                    rs.getInt("a_id"),
                    rs.getInt("u_id"),
                    rs.getString("content"),
                    rs.getInt("vote"),
                    rs.getString("date_created"),
                    rs.getInt("q_id")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return answers;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addNewAnswer")
    public int addNewAnswer(@WebParam(name = "u_id") int u_id, @WebParam(name = "content") String content, @WebParam(name = "q_id") int q_id) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO answer(u_id,content,date_created,q_id) VALUE ("+u_id+",'"+content+"',now(),"+q_id+")";
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
    @WebMethod(operationName = "voteAnswer")
    public int voteAnswer(@WebParam(name = "a_id") int a_id) {
        int vote = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE answer SET vote = vote+1 WHERE a_id="+a_id;
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM answer WHERE a_id="+a_id;
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
    @WebMethod(operationName = "devoteAnswer")
    public int devoteAnswer(@WebParam(name = "a_id") int a_id) {
        int vote = 0;
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE answer SET vote = vote-1 WHERE a_id="+a_id;
            stmt.executeUpdate(sql);
            sql = "SELECT vote FROM answer WHERE a_id="+a_id;
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
}
