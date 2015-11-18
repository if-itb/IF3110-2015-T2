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
                answers.add(new Answer(rs.getInt("IDAns"),rs.getInt("IDQ"),rs.getString("Nama"),rs.getString("Email"),rs.getString("Answer"),rs.getInt("Vote")));
                ++i;
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex){
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }
}
