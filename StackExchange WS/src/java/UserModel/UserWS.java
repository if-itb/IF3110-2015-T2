/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import Database.DB;
import QuestionModel.QuestionWS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "UserWS")
public class UserWS {
  
  /* Connecting to Database */
  /* MANDATORY */
  DB db = new DB();
  Connection conn = db.connect();   

    /**
     * Web service operation
     * @param user
     */
    @WebMethod(operationName = "registerUser")
    public int registerUser(@WebParam(name = "user") User user) {
        
        try {      
          Statement stmt = conn.createStatement();
          String sql;
          
          sql = "SELECT email FROM users WHERE email = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1, user.getEmail());
          
          ResultSet rs = dbStatement.executeQuery();
          if(rs.next()){
              return -1;
          }
          else{
              sql = "INSERT INTO users (id, email, password, name) VALUES (?, ?, ?, ?)";
              dbStatement = conn.prepareStatement(sql);
              dbStatement.setInt(1, user.getId());
              dbStatement.setString(2, user.getEmail());
              dbStatement.setString(3, user.getPassword());
              dbStatement.setString(4, user.getName());

              dbStatement.executeUpdate();

              stmt.close();
              //conn.close();
          }
        } catch (SQLException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
          return -1;
        }
        return 0;
    }
}
