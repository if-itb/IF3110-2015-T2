/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Token {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/stack";
    
    static final String USER = "root";
    static final String PASS = "" ;
    
    public int id ;
    public String ac_Token ;
    public String expire ;
    public String username ;
    public  Token() {}
    
    public void generateToken(String name) {
        SecureRandom random = new SecureRandom();
        ac_Token= new BigInteger(100,random).toString(32);
        long times = (long) (System.currentTimeMillis() / 1000);
        times = times+3600;
        this.expire = String.valueOf(times);        
        System.out.println(ac_Token+"|"+expire);
    }
    
    public void saveToken() {
        int id = this.id ;
        String name = this.username;
        Connection conn =null;
        String exp ="";
        String sql ="";
        Statement stmt = null;
        ResultSet rs = null; 
        try {    
                conn = DriverManager.getConnection(DB_URL, USER,PASS);
                sql = "INSERT INTO token (`token`,`expire`,`id_user`,`username`) VALUES ('"+this.ac_Token+"','"+this.expire+"','"+this.id+"','"+name+"')";
                System.out.println(sql);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
        
    }
    
}
