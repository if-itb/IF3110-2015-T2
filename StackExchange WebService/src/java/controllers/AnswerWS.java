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
import javax.jws.WebResult;
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
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQId(@WebParam(name = "q_id") int q_id) {
        Answer a = null;
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {    
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM answer natural join user WHERE q_id="+q_id;
                PreparedStatement dbStatement = conn.prepareStatement(sql);
                /* Get data */
                //int a_id, int u_id, String content, int vote, String date_created, int q_id
                try (ResultSet rs = dbStatement.executeQuery()) {
                    /* Get data */
                    //int a_id, int u_id, String content, int vote, String date_created, int q_id
                    while (rs.next()) {
                        a = new Answer (
                            rs.getInt("a_id"),
                            rs.getInt("u_id"),
                            rs.getString("email"),
                            rs.getString("content"),
                            rs.getInt("vote"),
                            rs.getString("date_created"),
                            rs.getInt("q_id"));
                        answers.add(a);
                    }
                }
            }
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
                String sql = "INSERT INTO answer(u_id,content,date_created,q_id) VALUE ("+u_id+",'?',now(),"+q_id+")";
                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setString(1,content);
                dbStatement.executeUpdate();
            }
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return -1;
        }
        return q_id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteAnswer")
    public String voteAnswer(@WebParam(name = "a_id") int a_id, @WebParam(name = "u_id") int u_id) {
        String vote = "null";
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vote FROM vote_answer WHERE q_id="+a_id+" and u_id="+u_id;
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                vote = Integer.toString(rs.getInt("vote"));
            }
            if(!empty && (vote.equals("1"))) return "null";
            sql = "UPDATE answer SET vote = vote+1 WHERE q_id="+a_id;
            dbStatement = conn.prepareStatement(sql);
            dbStatement.executeUpdate();
            if(!empty) {
                sql = "UPDATE vote_answer SET vote = vote+1 WHERE q_id="+a_id+" and u_id="+u_id;
            }
            else {
                sql = "INSERT INTO vote_answer VALUE ("+a_id+","+u_id+",1)";
            }
            dbStatement = conn.prepareStatement(sql);
            dbStatement.executeUpdate();
            sql = "SELECT vote FROM answer WHERE q_id="+a_id;
            dbStatement = conn.prepareStatement(sql);
            rs = dbStatement.executeQuery();
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
    @WebMethod(operationName = "devoteAnswer")
    public String devoteAnswer(@WebParam(name = "a_id") int a_id, @WebParam(name = "u_id") int u_id) {
        String vote = "null";
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vote FROM vote_answer WHERE q_id="+a_id+" and u_id="+u_id;
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            boolean empty = true;
            while (rs.next()) {
                empty = false;
                vote = Integer.toString(rs.getInt("vote"));
            }
            if(!empty && (vote.equals("-1"))) return "null";
            sql = "UPDATE answer SET vote = vote-1 WHERE q_id="+a_id;
            dbStatement = conn.prepareStatement(sql);
            dbStatement.executeUpdate();
            if(!empty) {
                sql = "UPDATE vote_answer SET vote = vote-1 WHERE q_id="+a_id+" and u_id="+u_id;
            }
            else {
                sql = "INSERT INTO vote_answer VALUE ("+a_id+","+u_id+",-1)";
            }
            dbStatement = conn.prepareStatement(sql);
            dbStatement.executeUpdate();
            sql = "SELECT vote FROM answer WHERE q_id="+a_id;
            dbStatement = conn.prepareStatement(sql);
            rs = dbStatement.executeQuery();
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
}
