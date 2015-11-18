/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbd.qst;

import com.wbd.ans.Answer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "retrieveQ")
    public ArrayList<Question> retrieveQ() {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM question";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            
            int i = 0;
            while (rs.next()){
                questions.add(new Question(rs.getInt("IDQ"),rs.getString("access_token"),rs.getString("QuestionTopic"),rs.getString("Content"),rs.getInt("Vote")));
                ++i;
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionbyID")
    public ArrayList<Question> getQuestionbyID(@WebParam(name = "qid") int qid) {
        ArrayList<Question> questions = new ArrayList<Question>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM question WHERE IDQ = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,qid);
            ResultSet rs = dbStatement.executeQuery();
            
            int i = 0;
            while (rs.next()){
                questions.add(new Question(rs.getInt("IDQ"),rs.getString("access_token"),rs.getString("QuestionTopic"),rs.getString("Content"),rs.getInt("Vote")));
                ++i;
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createQ")
    public int createQ(@WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        int hasil = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            String sql = "INSERT INTO question(QuestionTopic, Content) VALUES (?,?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
            hasil = 1;
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            hasil = 2;
        }
        return hasil;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQ")
    public int updateQ(@WebParam(name = "access_token") String access_token, @WebParam(name = "qid") int qid, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
       Connection conn = null;
        try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");

        // Turn on transactions
        conn.setAutoCommit(false);

        Statement stmt = conn.createStatement();
        String sql = "UPDATE question SET QuestionTopic = ?, Content = ? WHERE IDQ = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, content);
        pstmt.setInt(3, qid);
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
}
