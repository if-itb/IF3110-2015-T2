/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import java.util.ArrayList;
import java.sql.Connection;
import DatabaseAdapter.database;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author user
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    database DB = new database();
    
    Connection conn = DB.connect();
    
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        
        ArrayList<Answer> answers = new ArrayList<>();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answers where question_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            int i = 0;
            while (rs.next()) {
                answers.add(new Answer(rs.getInt("answer_id"), 
                                        rs.getInt("question_id"), 
                                        rs.getInt("user_id"), 
                                        rs.getString("content"),
                                        rs.getInt("vote"),
                                        rs.getString("time")
                                        ));
                ++i;
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;
    }

}
