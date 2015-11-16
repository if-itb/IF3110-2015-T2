/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
/**
 *
 * @author Asus
 */
public class DBOPerator {
    private Connection conn = null;
    private Statement stmt = null;
    
    public DBOPerator() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //new com.mysql.jdbc.Driver();
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?user=username&password=password");
        String connectionUrl = "jdbc:mysql://localhost:3306/coppeng";
        String connectionUser = "root";
        String connectionPassword = "";
        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        stmt = conn.createStatement();
    }
    
    public ResultSet exec(String Query) throws SQLException {
        return stmt.executeQuery(Query);
    }
  
    public void close() {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}
