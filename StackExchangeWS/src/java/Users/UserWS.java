/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

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
public class UserWS {
    Connection conn = DB.getConnection();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addRegister")
    @WebResult(name = "success")
    public int addRegister(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        int res = 0;
        try {
            // check if the user with the email is already registered
            String sql = "SELECT email FROM users WHERE email = ?"; 
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, email);
            ResultSet rs = pstat.executeQuery(); 
            
            // if email not existed, insert the user
            if (!rs.isBeforeFirst()&& (email != null || email != ""))
            {
                //Statement st = conn.createStatement();
                String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
                Statement st = conn.createStatement();
                // set the prepared statement by the query and enter the value of where clause
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, password);

                res = pst.executeUpdate();

                pst.close();
                st.close();
            }
            
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
