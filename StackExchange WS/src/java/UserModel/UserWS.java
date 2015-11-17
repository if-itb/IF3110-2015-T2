/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author M. Fauzan Naufan
 */
@WebService(serviceName = "UserWS")
public class UserWS {
    /**
     * Web service operation
     * @param nama
     * @param email
     * @param password
     * @return 
     */
    @WebMethod(operationName = "register")
    public void register(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        String url = "jdbc:mysql://localhost:3306/stackexchange";
        String username = "root";
        String pswd = "";
        
        try {
            Connection conn = DriverManager.getConnection(url, username, pswd);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO user VALUES (0,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            int a = pstmt.executeUpdate();
            stmt.close();
	} catch (SQLException ex) {
        }
    }
}
