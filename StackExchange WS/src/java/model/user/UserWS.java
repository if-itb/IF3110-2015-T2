/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import connection.DB;
import java.sql.Connection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Venny
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    
    /* Connect to database */
    Connection conn = DB.connect();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    @WebResult(name="User")
    public void addUser(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
    }
}
