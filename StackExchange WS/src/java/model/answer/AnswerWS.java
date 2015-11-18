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
    @WebMethod(operationName = "getAnswersByQid")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswersByQid (@WebParam(name = "question_id") int question_id) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try{
            Statement stmt = conn.createStatement();
            String sql;
            // INI BELOM SELESAI
            sql = "SELECT * FROM answers WHERE id_question = ?";
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
                rs.getString("timestamp")
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
}
