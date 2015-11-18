/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registers;

import database.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mochamadtry
 */
@WebService(serviceName = "Register")
public class Register {
    Connection conn = DB.getConnection();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addRegister")
    public int addRegister(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        try {
            Statement st = conn.createStatement();
            String query = "INSERT INTO register(r_name, r_email, r_password) VALUES (?, ?, ?)";
            
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
           
            pst.executeUpdate();
     
            pst.close();
            st.close();
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
