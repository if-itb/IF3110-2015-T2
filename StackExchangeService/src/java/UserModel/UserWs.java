/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import Config.DB;
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
import javax.jws.WebResult;

/**
 *
 * @author FiqieUlya
 */
@WebService(serviceName = "UserWs")
public class UserWs {

    private final DB db = new DB();
    private Connection conn;

    
    @WebMethod(operationName = "getPasswordById")
    @WebResult(name = "Password")
    public String getPasswordUser(@WebParam(name = "username") String uname) {
        String password = null;
        conn = db.connect();
        try {
            Statement stmt;
            stmt = conn.createStatement();
            
            String sql;
            sql = "SELECT password FROM account where username = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, uname);
            
            ResultSet rs;
            rs = dbStatement.executeQuery();
            
            /* Get every data returned by SQLquery */
            while(rs.next()) {
                password= rs.getString("password");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
           Logger.getLogger(UserWs.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        return password;
    }
}
