/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.User;

/**
 *
 * @author jessica
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    // Open connection to database
    Connection conn = DatabaseController.connect();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public Integer register(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        try {
            try (Statement stmt = conn.createStatement()) {
                String sql = "INSERT INTO user(username, password, name, email) VALUE ('"+username+"',SHA1('"+password+"'),'"+name+"','"+email+"')";
                stmt.executeUpdate(sql);
                
            }
        } catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
