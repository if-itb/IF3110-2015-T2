/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.sql.ResultSet;

/**
 *
 * @author Luqman A. Siswanto
 */
@WebService(serviceName = "UserWS")
public class UserWS {
  DB database;
  
  public UserWS() throws Throwable {
    database = new DB();
  }
  
  /**
   * 
   * @param name
   * @param email
   * @param pass 
   */
  @WebMethod(operationName = "createUser")
  @WebResult(name="addUser")
  public void createUser(@WebParam(name = "name") String name,@WebParam(name = "email") String email,@WebParam(name = "pass") String pass) {
    String query = "INSERT INTO `user` (`name`, `email`, `pass`) VALUES ('"+name+"','"+email+"', '"+pass+"')";
    database.executeQuery(query);
  }
  
  @WebMethod(operationName = "getName")
  @WebResult(name="gettingName")
  public String getName(@WebParam(name = "id") int id) {
    String query = "SELECT * FROM `user` WHERE id=" + id;
    ResultSet rs = database.getResultQuery(query);
    try {
      return rs.getString("name");
    } catch(Throwable e) {
      e.printStackTrace();
    }
    return "";
  }
}
