/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dazzlesquad.answer_package;

import com.dazzesquad.database_console.DBConnect;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
/**
 *
 * @author zulvafachrina
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    Connection conn; 

    public AnswerWS() throws SQLException {
        DBConnect db = new DBConnect();
        conn = db.connect();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerById")
    @WebResult(name="Answer")
    public java.util.ArrayList<Answer> getAnswerById(@WebParam(name = "id") int id) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        
        try {
            Statement statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Answer WHERE question_id=?";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,id);
            
            ResultSet result = dbStatement.executeQuery();
            
           
            while(result.next()) {
               answers.add(new Answer(result.getInt("id"), result.getInt("question_id"), result.getInt("user_id"),
               result.getString("content"), result.getInt("vote"), result.getString("date"))); 
               
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
        }
        return answers;
        
    }

    @WebMethod(operationName = "insertAnswer")
    @WebResult(name="NewAnswer")
    public int insertAnswer(@WebParam(name = "answer") Answer answer) {
        int insertsuccessful = 1; // nanti diganti fungsi validasi
        
        if (insertsuccessful == 1) {
            try {
                Statement statement = conn.createStatement();
                String sql;
                sql = "INSERT INTO Answer (id_user, question_id, content, vote, date) VALUES (?,?,?,?,?)";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setInt(1,answer.getId());
                dbStatement.setInt(2,answer.getQid());
                dbStatement.setString(3,answer.getContent());
                dbStatement.setInt(4,answer.getVote());
                dbStatement.setString(5,answer.getDate());

                dbStatement.executeUpdate(); 

                
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertsuccessful;
    }
    
    @WebMethod(operationName = "deleteAnswer")
    @WebResult(name="Success")
    public int deleteAnswer(@WebParam(name = "qid") int qid) {
        int deletesuccessful = 1; // nanti diganti fungsi validasi
        if (deletesuccessful == 1) {
            try {
                String sql;
                Statement statement = conn.createStatement();

                sql = "DELETE FROM Answer WHERE question_id=?";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setInt(1,qid);

                dbStatement.executeUpdate(); 

               
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return deletesuccessful;
    }
    
    @WebMethod(operationName = "countAnswer")
    @WebResult(name="count")
    public int countAnswer(@WebParam(name = "qid") int qid) {
        java.util.ArrayList<Answer> answers = getAnswerById(qid);
        int size = answers.size();
        return size;
    }
    
    
}
