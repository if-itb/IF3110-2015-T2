/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbd.rgs;

import com.wbd.ans.Answer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sun.security.util.Password;

/**
 *
 * @author User
 */
@WebService(serviceName = "RegisterWS")
public class RegisterWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public int register(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) throws Exception{
        //TODO write your implementation code here:
        int hasil = 0;
        Connection conn = null;
        PreparedStatement dbStatement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wbd","root","");
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO user(Nama, Email, Password) VALUES (?,?,?)";
            
            dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, name);
            dbStatement.setString(2, email);
            dbStatement.setString(3, password);
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
