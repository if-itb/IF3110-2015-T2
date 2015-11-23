/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ahmad Naufal Farhan
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    Connection conn = DB.getConnection();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public int addUser(@WebParam(name = "name") String name,
                        @WebParam(name = "email") String email,
                        @WebParam(name = "password") String password) {
        
        int res = 0;
        try {
            // check if the user with the email is already registered
            String sql = "SELECT email FROM users WHERE email = ?"; 
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, email);
            ResultSet rs = pstat.executeQuery(); 
            
            // if email not existed, insert the user
            if (!rs.isBeforeFirst() && (email != null || email.equals(""))) {
                
                // set the prepared statement by the query and enter the value of where clause
                try (Statement st = conn.createStatement()) {
                   
                    String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
                    
                    try (PreparedStatement pst = conn.prepareStatement(query)) {
                        pst.setString(1, name);
                        pst.setString(2, email);
                        pst.setString(3, password);
                        
                        res = pst.executeUpdate();
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }    
}
