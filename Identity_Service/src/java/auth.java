/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.crypto.spec.DESedeKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 * auth class
 * 
 * @author ical
 */
public class auth extends HttpServlet 
{
  protected final int timeLimit = 5400;         // token expires in second
  protected static final String DB_URL = "jdbc:mysql://localhost/WBD2";
  protected static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  protected static final String USER = "root";
  protected static final String PASS = "";
  private Connection conn;
  private Statement stmt;

  /**
   * Initialize
   * @throws ServletException 
   */
  @Override
  public void init() throws ServletException 
  {
    super.init(); 
    
    try {
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }

    // Open a connection
    conn = null;
    stmt = null;
    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Handles all request (by POST)
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs 
   */
  @Override
  @SuppressWarnings("CallToPrintStackTrace")
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException 
  {
    PrintWriter out = response.getWriter();
    JSONObject json = new JSONObject();
    ResultSet rs = null;
    Long time = System.currentTimeMillis() / 1000;

    if (request.getParameter("token") != null)        // token verification
    {
      String token = request.getParameter("token");
      Long expires = 0L;
      try {
        rs = queryExecutor("SELECT expires FROM token WHERE val=" + token);
        expires = rs.getLong("expires");
      } catch (SQLException ex) {
        ex.printStackTrace();
      }

      if (null == expires)          // token invalid
        json = generateError("token expired", 3040);
      else if (expires < time)      // token expired
        json = generateError("token invalid", 4040);
      else {
        json.put("num", 1200);
        json.put("detail", "OK");
      }
    } 
    else {        // handle login authentication
      String user = request.getParameter("user");
      String pass = request.getParameter("pass");
      int id = -1;
      
      try {   
        rs = queryExecutor("SELECT id FROM user WHERE email=" + user + " AND pass=" + pass);
        id = rs.getInt("id");
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
      
      if (id != -1)     // user & pass match
      {
        byte[] bytes = null;
        try {
          SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
          random.setSeed(System.currentTimeMillis());
          bytes = new byte[DESedeKeySpec.DES_EDE_KEY_LEN];
          random.nextBytes(bytes);
        } catch (NoSuchAlgorithmException ex) {
          ex.printStackTrace();
        }

        try {   
          updateExecutor("INSERT INTO token uid, val, expires VALUES (" + id +", " + new String(bytes) +", " + (time+timeLimit) +")");
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        json.put("token", bytes);
        json.put("user", user);
      }
      else
        json = generateError("authentication failed", 1403);
    }
    
    out.print(json);
    out.flush();
    
    // Clean-up environment
    try {
      rs.close();
      conn.close();
      stmt.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * [queryExecutor description]
   * 
   * @param  sql          [description]
   * @return              [description]
   * @throws SQLException [description]
   */
  public ResultSet queryExecutor(String sql) throws SQLException {
    ResultSet rs;    
    rs = stmt.executeQuery(sql);
    rs.next();    
    return rs;
  }

  /**
   * [updateExecutor description]
   * 
   * @param  sql          [description]
   * @return              [description]
   * @throws SQLException [description]
   */
  public int updateExecutor(String sql) throws SQLException {
    return stmt.executeUpdate(sql);
  }
  
  /**
   * Generate error flag JSON object
   * 
   * @param detail
   * @param errorNum
   * @return 
   */
  private JSONObject generateError(String detail, int errorNum) {
    JSONObject error = new JSONObject();
    error.put("num", errorNum);
    error.put("detail", detail);
    
    JSONObject res = new JSONObject();
    res.put("error", error);
    return res;
  }
  
}
