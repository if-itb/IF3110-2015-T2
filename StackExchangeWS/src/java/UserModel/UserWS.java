/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import DatabaseAdapter.database;
import QuestionModel.Question;
import QuestionModel.QuestionWS;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author user
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    database DB = new database();
    
    Connection conn = DB.connect();
    
    @WebMethod(operationName = "getUserByUID")
    @WebResult(name="User")
    public User getUserByUID(@WebParam(name = "uid") int uid) {
        
        User user = new User();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM users where user_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, uid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            rs.next();
            user = new User(rs.getInt("user_id"),                     
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("password")
                            );
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
}
