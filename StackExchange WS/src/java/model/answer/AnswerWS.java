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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import org.json.*;

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
        ArrayList<Answer> answers = new ArrayList<>();
        try{
            String sql;
            sql = "SELECT * FROM answer WHERE question_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, question_id);
            ResultSet rs = stmt.executeQuery();
            
            /* Get every data returned by SQL query */
            while(rs.next()){
                answers.add(new Answer( rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getInt("vote"),
                rs.getString("create_time")
                ));
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
            String sql;
            sql = "SELECT * FROM answer WHERE answer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, answer_id);
            ResultSet rs = stmt.executeQuery();
            
            /* Get every data returned by SQL query */
            while(rs.next()){
                answers.add(new Answer( rs.getInt("answer_id"),
                rs.getInt("question_id"),
                rs.getInt("user_id"),
                rs.getString("content"),
                rs.getInt("vote"),
                rs.getString("create_time")
                ));
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
            String sql;
            sql = "SELECT COUNT(*) as answercount FROM answer WHERE question_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,question_id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                i=rs.getInt("answercount");
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
    @WebResult (name="Integer")
    public int addAnswer (@WebParam(name = "token") String token, @WebParam(name = "question_id") int qid, @WebParam(name = "content") String content) {
        int aid = -1;
        
        // Send token to IS connector
        
        // Get response in json format
        JSONObject jo = new JSONObject();
        
        // Parse json
        int uid = jo.getInt("id");
        int status = jo.getInt("status");
        
        // if status ok, insert answer into db, select answer_id
        if (status == 1){
            try{
                String sql = "INSERT INTO answer (question_id,user_id,content) VALUES (?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1,qid);
                stmt.setInt(2,uid);
                stmt.setString(3, content);
                stmt.executeUpdate();
                stmt.close();
                
                String sql2 = "SELECT answer_id FROM answer WHERE question_id=? AND content=? AND user_id=?";
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                stmt2.setInt(1, qid);
                stmt2.setString(2, content);
                stmt2.setInt(3, uid);
                ResultSet rs = stmt2.executeQuery();
                
                while (rs.next()) {
                    aid = rs.getInt("answer_id");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AnswerWS.class.getName()).log
                (Level.SEVERE, null, ex);
            }
        } else {
            // alert: fail to add answer
        }
        return aid;
    }
}
