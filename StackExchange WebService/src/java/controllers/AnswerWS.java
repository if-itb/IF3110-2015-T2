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
    public ArrayList getAnswerByQId(@WebParam(name = "qId") int qId) {
        //TODO write your implementation code here:
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM answer WHERE q_id=";
            //dbStatement.setInt(1, qId);
            ResultSet rs = stmt.executeQuery(query);
            /* Get data */
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
    public int addNewAnswer(@WebParam(name = "uId") int uId, @WebParam(name = "content") String content, @WebParam(name = "qId") int qId) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO answer(u_Id,content,date_created,q_Id) VALUE ("+uId+",'"+content+"',now(),"+qId+")";
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
    public int voteAnswer(@WebParam(name = "aId") int aId) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT vote FROM answer WHERE a_id="+aId;
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            int vote = dbStatement.executeQuery().getInt("vote");
            vote++;
            sql = "UPDATE answer SET vote = " +vote+ "WHERE a_id="+aId;
            stmt.executeUpdate(sql);
            stmt.close();
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
    @WebMethod(operationName = "devoteAnswer")
    public int devoteAnswer(@WebParam(name = "aId") int aId) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT vote FROM answer WHERE a_id="+aId;
                PreparedStatement dbStatement = conn.prepareStatement(sql);
                int vote = dbStatement.executeQuery().getInt("vote");
                vote--;
                sql = "UPDATE answer SET vote = " +vote+ "WHERE a_id="+aId;
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
