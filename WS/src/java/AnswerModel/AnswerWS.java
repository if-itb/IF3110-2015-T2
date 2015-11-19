/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import ws.register.RegisterWS;

/**
 *
 * @author yoga
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    Connection conn = null;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerbyQID")
    @WebResult(name = "Answer")
    public ArrayList<Answer> getAnswerbyQID(@WebParam(name = "qid") int qid) {

        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            //Take the question
            sql = "SELECT * FROM answers WHERE QuestionID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            ResultSet rs = dbStatement.executeQuery();
            /* Get every answer for question returned by SQL query */
           
            while (rs.next()) {
                answers.add(new Answer(rs.getInt("AnswerID"),
                        rs.getInt("QuestionID"),
                        rs.getInt("Votes"),
                        rs.getString("Answer"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Datetime")
                ));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }
    
    /**
     * Web service operation up vote an answer
     */
    @WebMethod(operationName = "upAnswer")
    @WebResult(name = "Answer")
    public int upAnswer(@WebParam(name = "AnsId") int AnsId) {

        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            //Take the question
            sql = "UPDATE answers SET Votes=Votes+1 WHERE AnswerID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, AnsId);
            int rs = dbStatement.executeUpdate();
           
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    /**
     * Web service operation down vote an answer
     */
    @WebMethod(operationName = "downAnswer")
    @WebResult(name = "Answer")
    public int downAnswer(@WebParam(name = "AnsId") int AnsId) {

        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql;
            //Take the question
            sql = "UPDATE answers SET Votes=Votes-1 WHERE AnswerID = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, AnsId);
            int rs = dbStatement.executeUpdate();
           
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
}
