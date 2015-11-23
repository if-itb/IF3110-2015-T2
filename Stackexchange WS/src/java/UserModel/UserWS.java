/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;

/**
 *
 * @author Devina
 */
@WebService(serviceName = "UserWS")
public class UserWS {
  Database database = new Database();
  
  /**
   * Web service operation
   */
  @WebMethod(operationName = "addUser")
  @WebResult(name="User")
  public boolean addUser(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
    //TODO write your implementation code here:
    boolean userAdded = false;
    int count = 0;
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "select count(*) from user where email = ?";
      PreparedStatement databaseStatement1 = connection.prepareStatement(query);
      databaseStatement1.setString(1, email);
      ResultSet rs = databaseStatement1.executeQuery();
      if (rs.next()) {
        count = rs.getInt("count(*)");
      }
      // Jika email tidak ada, tambahkan user baru
      if (count == 0) {
        query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement databaseStatement2 = connection.prepareStatement(query);
        databaseStatement2.setString(1, name);
        databaseStatement2.setString(2, email);
        databaseStatement2.setString(3, password);
        databaseStatement2.executeUpdate();

        statement.close();
        userAdded = true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return userAdded;
  }
}
