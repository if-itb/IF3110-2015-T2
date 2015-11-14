/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbd.crt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "CreateQuestionWS")
public class CreateQuestionWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateQ")
    public int CreateQ(@WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
       int hasil  = 0;
        Connection conn = null;
        PreparedStatement dbStatement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO question(QuestionTopic, Content) VALUES (?,?)";
            
            dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, title);
            dbStatement.setString(2, content);
            dbStatement.executeUpdate();
            hasil = 1;
            dbStatement.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
}
