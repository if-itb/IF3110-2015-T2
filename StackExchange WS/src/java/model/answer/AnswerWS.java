/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import connection.DB;
import java.sql.Connection;
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
/**
 *
 * @author Venny
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    Connection conn = DB.connect();
   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswersByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswersByQID (@WebParam(name = "question_id") int question_id) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answer WHERE question_id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, question_id);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQL query */
            int i = 0;
            while(rs.next()){
                answers.add(new Answer( rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getInt("vote"),
                rs.getString("create_time")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
        return answers;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByID")
    @WebResult(name="Answer")
    public Answer getAnswerByID (@WebParam(name = "answer_id") int answer_id) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answer WHERE answer_id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, answer_id);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQL query */
            int i = 0;
            while(rs.next()){
                answers.add(new Answer( rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getInt("vote"),
                rs.getString("create_time")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
        return answers.get(0);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerCount")
    @WebResult(name="Answer")
    public int getAnswerCount (@WebParam(name = "question_id") int question_id) {
        int i = 0;
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answer WHERE question_id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, question_id);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQL query */
            while(rs.next()){
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
        return i;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAnswer")
    @WebResult(name="Answer")
    public void addAnswer (@WebParam(name = "question_id") int question_id) {
    
    }
}
