/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import connection.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
            sql = "INSERT INTO user (name, email, password)"
                    + "VALUES(" + name + "," + email + "," + password + ");";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
    }
}
