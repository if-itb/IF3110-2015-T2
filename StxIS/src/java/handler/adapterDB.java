/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Aidin
 */
public class adapterDB {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/stackexchange";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    public int RES;
    
    public adapterDB(){
        RES=100;
    }
   
    public void getUser(String email, ArrayList users)throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{;
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.prepareStatement("SELECT * FROM user WHERE email=?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String _email = rs.getString("email");
                String _pass = rs.getString("password");
                users.add(new user(_email, _pass));
            }
            //test=rs.toString();            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        } finally {
          if(rs!= null) rs.close();
          if(stmt!= null) stmt.close();
        }
    }
}
