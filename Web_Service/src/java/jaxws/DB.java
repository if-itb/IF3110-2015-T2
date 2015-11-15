/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author gazandic
 */
public class DB {
  final private String SRV = "jdbc:mysql://localhost/";
  final private String USR = "root";
  final private String PWD = "";
  final private String DB = "wbd2";
  private Connection conn;
  private Statement stmt;
  public DB() throws Throwable {
    Class.forName("com.mysql.jdbc.Driver");   // register JDBC driver
    conn = DriverManager.getConnection(SRV+DB, USR, PWD);  // open connection
    stmt = conn.createStatement();    // initialize statement for query
  }
  public Connection connect(){
      return conn;
  } 
}
