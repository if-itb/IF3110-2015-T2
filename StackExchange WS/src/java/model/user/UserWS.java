/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Venny
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    
    /* Connect to database */
    Connection conn = DB.connect();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    @WebResult(name="User")
    public void addUser(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO user (name, email, password, token) "
                    + "VALUES(" + name + "," + email + "," + password + "," + "'abcd');";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserByID")
    @WebResult(name="User")
    public User getUserByID (@WebParam(name = "user_id") int user_id) {
        ArrayList<User> user = new ArrayList<User>();
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,user_id);
            ResultSet rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQL query */
            int i = 0;
            while(rs.next()){
                user.add(new User( rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("token")
                ));
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
        return user.get(0);
    }
}
