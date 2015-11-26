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
    public Integer register(@WebParam(name = "email") String email, @WebParam(name = "name") String name, @WebParam(name = "password") String password) {
        try {
            String selectQuery = "SELECT * FROM user WHERE email = ?";
            
            try (PreparedStatement select = conn.prepareStatement(selectQuery)){
                select.setString(1, email);
                    
                ResultSet result = select.executeQuery();
                    
                if(result.next()){
                    return 0;
                }
                    
                else {
                    String sql = "INSERT INTO user(email, name, password) VALUE (?, ?, SHA1(?))";
                    try (PreparedStatement statement = conn.prepareStatement(sql)) {
                        statement.setString(1, email);
                        statement.setString(2, name);
                        statement.setString(3, password);
                
                        statement.executeUpdate();
                        return 1;
                
                    }
                }
            
            }
        }
        catch (SQLException e) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return 0;            
        }        
    }
}
