/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dazzlesquad.user_package;

import com.dazzlesquad.database_console.DBConnect;
import com.dazzlesquad.answer_package.Answer;
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
 * @author ryanyonata
 */
@WebService(serviceName = "UserWS")
public class UserWS {

    Connection conn; 

    public UserWS() throws SQLException {
        DBConnect db = new DBConnect();
        conn = db.connect();
    }

    /**
     * Web service operation
     */
   
    
    @WebMethod(operationName = "getUserById")
    @WebResult(name="User")
    public User getUserById(@WebParam(name = "id") int id) {
        User userResult = null;
        try {
            Statement statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM User WHERE id=?";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,id);
            
            ResultSet result = dbStatement.executeQuery();
            
            if (result.next())
            {
               userResult = new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password")); 
            }
            else {
               userResult = new User();
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userResult;
    }
    
    
    @WebMethod(operationName = "registerUser")
    @WebResult(name="NewUser")
    public int registerUser(@WebParam(name = "user") User user) {
        int insertsuccessful = 1; // nanti diganti fungsi validasi
        
        if (insertsuccessful == 1) {
            try {
                Statement statement = conn.createStatement();
                String sql;
                sql = "INSERT INTO User (name, email, password) VALUES (?,?,?)";

                PreparedStatement dbStatement = conn.prepareStatement(sql);
                dbStatement.setString(1,user.getUserName());
                dbStatement.setString(2,user.getUserEmail());
                dbStatement.setString(3,user.getUserPassword());

                dbStatement.executeUpdate(); 

                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return insertsuccessful;
    }
    
    @WebMethod(operationName = "getUserByToken")
    @WebResult(name = "userResult")
    public User getUserByToken(@WebParam(name = "token") String token) {
        int userIdResult;
        User userResult = null;
        try {
            Statement statement = conn.createStatement();
            String sql;

            sql = "SELECT user_id FROM tokenlist WHERE token = ?";

            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, token);

            ResultSet result = dbStatement.executeQuery();

            if (result.next()) {
                userIdResult = result.getInt("user_id");
            } else {
                userIdResult = 0;
            }

            String sql2 = "SELECT * FROM user WHERE id = ?";
            PreparedStatement dbStatement2 = conn.prepareStatement(sql2);
            dbStatement.setString(1, token);

            ResultSet result2 = dbStatement2.executeQuery();

            if (result.next()) {
                userResult = new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"));
            } else {
                userResult = new User();
            }

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userResult;
    }
    
}