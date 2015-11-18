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

    //Declare Connection
    //private Connection conn;
    
    //Declare Database Name
    static final String DB_NAME = "wbd";    
    //Declare JDBC Driver Name and Database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/" + DB_NAME +"?zeroDateTimeBehavior=convertToNull";
    
    //Declare Database Credentials
   
    
    /*Luminto
    static final String USER = "root";
    static final String PASS = "";*/
    
   //Albert Tri
    static final String USER = "root";
    static final String PASS = "alberttriadrian";
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public int register(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password){
        //TOD wt.prirlite your implementation code here:
        
        int hasil;
        Connection conn = null;
        PreparedStatement dbStatement = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String sql; 
            sql = "SELECT * FROM user";
            dbStatement = conn.prepareStatement(sql);
            ResultSet rs = dbStatement.executeQuery();
            while (rs.next()){
                if (email == rs.getString("email")){
                    return 0;
                }
            }
            
            sql = "INSERT INTO user(Nama, Email, Password) VALUES (?,?,?)";
            
            dbStatement = conn.prepareStatement(sql);

            dbStatement.setString(1, name);
            dbStatement.setString(2, email);
            dbStatement.setString(3, password);
            
            dbStatement.executeUpdate();
            hasil = 1;
            dbStatement.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
            hasil = 0;
        }
        return hasil;
    }
}
