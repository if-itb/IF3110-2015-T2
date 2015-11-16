/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import model.question.QuestionWS;
import connection.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    private Connection conn = DB.connect();


    /**
     * Web service operation
     */
    @WebMethod(operationName = "register")
    public int register(@WebParam(name = "user") User user) {
        //TODO write your implementation code here:
        try {         
          Statement statement = conn.createStatement();
          String sql; 
          sql = "SELECT email FROM users WHERE email = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, user.getEmail());
          
          ResultSet temp = stmt.executeQuery();
          if(temp.next()){
              return -1;
          }
          else{
              sql = "INSERT INTO users (id, password, name, email) VALUES (?, ?, ?, ?)";
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, user.getId());
              stmt.setString(2, user.getPassword());
              stmt.setString(3, user.getName());
              stmt.setString(4, user.getEmail());

              stmt.executeUpdate();
              statement.close();
          }
        } catch (SQLException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
          return -1;
        }
        
        return 0;
    }
}
