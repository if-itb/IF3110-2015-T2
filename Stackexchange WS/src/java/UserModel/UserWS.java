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
  public boolean addUser(@WebParam(name = "id_user") int idUser, @WebParam(name = "name") String name, @WebParam(name = "email") String email) {
    //TODO write your implementation code here:
    boolean userAdded;
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "INSERT INTO user (id_user, name, email) VALUES (?, ?, ?)";
      PreparedStatement databaseStatement = connection.prepareStatement(query);
      databaseStatement.setInt(1, idUser);
      databaseStatement.setString(2, name);
      databaseStatement.setString(3, email);
      databaseStatement.executeUpdate();
      
      statement.close();
      userAdded = true;
    } catch (SQLException ex) {
      Logger.getLogger(UserWS.class.getName()).log(Level.SEVERE, null, ex);
      userAdded = false;
    }
    
    return userAdded;
  }
}
