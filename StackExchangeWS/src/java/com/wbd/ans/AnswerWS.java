/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbd.ans;

import java.util.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebResult;

/**
 *
 * @author User
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    /**
     * Web service operation
     */    
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name = "Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        //TODO write your implementation code here:
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answer WHERE IDQ = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            ResultSet rs = dbStatement.executeQuery();
            
            int i = 0;
            while (rs.next()){
                answers.add(new Answer(rs.getInt("IDAns"),rs.getInt("IDQ"),rs.getInt("IDUser"),rs.getString("Answer"),rs.getInt("Vote")));
                ++i;
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteUp")
    public int voteUp(@WebParam(name = "access_token") String access_token, @WebParam(name = "ansid") String ansid) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            // Turn on transactions
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            String sql = "UPDATE answer SET Vote = Vote + 1 WHERE IDAns = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ansid);
            pstmt.executeUpdate();
            conn.commit();


            System.out.println("Order successful!  Thanks for your business!");
            return 1;
        }
       catch (Exception e) {
            // Any error is grounds for rollback
            try {
                conn.rollback();
            }
            catch (SQLException ignored) { }
                System.out.println("Order failed. Please contact technical support.");
                  return 0;
       }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteDown")
    public int voteDown(@WebParam(name = "access_token") String access_token, @WebParam(name = "ansid") String ansid) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");

            // Turn on transactions
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            String sql = "UPDATE answer SET Vote = Vote - 1 WHERE IDAns = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ansid);
            pstmt.executeUpdate();
            conn.commit();


            System.out.println("Order successful!  Thanks for your business!");
            return 1;
        }
       catch (Exception e) {
            // Any error is grounds for rollback
            try {
                conn.rollback();
            }
            catch (SQLException ignored) { }
                System.out.println("Order failed. Please contact technical support.");
                  return 0;
       }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createAns")
    public int createAns(@WebParam(name = "access_token") String access_token, @WebParam(name = "qid") String qid, @WebParam(name = "content") String content) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO answer(IDQ, IDUser, Answer, Vote) VALUES (?,?,?,?)";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, qid);
            dbStatement.setInt(2, 0);  //belum
            dbStatement.setString(3, content);
            dbStatement.setInt(4, 0);
            dbStatement.executeUpdate();
            stmt.close();
            return 1;
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNamaAns")
    public String getNamaAns(@WebParam(name = "idans") int idans) {
        String result = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT user.Nama FROM user NATURAL JOIN answer WHERE IDAns = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,idans);
            
            ResultSet rs = dbStatement.executeQuery();
            if (rs.next()){
                result = rs.getString("Nama");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            
        }
        return result;
    }

}
