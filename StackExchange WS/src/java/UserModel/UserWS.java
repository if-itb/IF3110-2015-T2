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
    public int register(@WebParam(name = "nama") String nama, @WebParam(name = "email") String email, @WebParam(name = "password") String password) {
        int i = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/stackexchange";
            String username = "root";
            String pswd = "";
            Connection conn = DriverManager.getConnection(url, username, pswd);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO user VALUES (0,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nama);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (SQLException ex) {
            
        }
        return i;
    }
}
