/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.webservice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import stackexchange.webservice.model.Answer;
import stackexchange.webservice.model.User;
import stackexchange.webservice.util.Database;

/**
 *
 * @author fauzanrifqy
 */
@WebService(serviceName = "UserWS")
public class UserWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    @Oneway
    public void addUser(@WebParam(name = "user") User user) {
    Database db = new Database();
        try{
            String values="(";
            values+= user.getId() +",";
            values+= "'"+ user.getName() +"',";
            values+= "'"+ user.getEmail() +"',";
            values+= "'"+ user.getToken() +"',";
            values+= user.isValid() +")";
            String sql="insert into users values " + values;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    @Oneway
    public void deleteUser(@WebParam(name = "id") int id) {
        Database db = new Database();
        try{
            String sql="delete from users where id=" + id;
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        }catch(Exception e){
            
        }finally{
            db.closeConnection();
            //db = null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsers")
    @WebResult(name="User")
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        Database db = new Database();
        try{
            String sql="select * from users";
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("token"), rs.getBoolean("valid"));
                users.add(user);
            }
            return users;
        }catch(Exception e){
            User user = new User();
            users.add(user);
            return users;
        }finally{
            db.closeConnection();
            db = null;
        }
    }
}
