/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auth;

import DatabaseWS.DB;
import QuestionModel.QuestionWS;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Vanji
 */
public class Auth {
  
 private String ReST = "http://localhost:8082/WBD_IS/testrestservlet";
  
  public int check ( String token ) throws org.json.simple.parser.ParseException, IOException {
    int ret = -1;
    JSONParser parser = new JSONParser();
    try{
        String charset = "UTF-8";
        URL url = new URL(ReST);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept-Charset", charset);
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
    Object obj = parser.parse(new FileReader("C:\\xampp\\htdocs\\validation.json"));
    
    JSONObject jsonObject = (JSONObject) obj;
    String message = (String) jsonObject.get("message");
    if(message.equals("valid")){
    ret = 1;
    }
    else if(message.equals("expired")){
    ret = -1;
    }
    else {
    ret= 0;
    }
    } catch(FileNotFoundException e){
        e.printStackTrace();
    }

    return ret;
  }
  
  public int getUserID ( String token ) {
    int ret = -1;
    DB db = new DB();
    Connection conn = db.connect();  
      try {
          Statement stmt = conn.createStatement();
          String sql;

          sql = "SELECT * FROM token WHERE t_token = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1, token);

          ResultSet rs = dbStatement.executeQuery();

          // Extract data from result set
          while(rs.next()){        
            ret = rs.getInt("u_id");
          }

          rs.close();
          stmt.close();
      } catch(SQLException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      }
    return ret;
  }
  
   public String getUName ( String token ) {
    String ret = null;
    int temp = -1;
    DB db = new DB();
    Connection conn = db.connect();  
      try {
          Statement stmt = conn.createStatement();
          String sql;

          sql = "SELECT * FROM token WHERE t_token = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1, token);

          ResultSet rs = dbStatement.executeQuery();

          // Extract data from result set
          while(rs.next()){        
            temp = rs.getInt("u_id");
          }

          sql = "SELECT u_name FROM user WHERE u_id = ?";
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, temp);

          rs = dbStatement.executeQuery();
          
          while(rs.next()){        
            ret = rs.getString("u_name");
          }
          
          
          rs.close();
          stmt.close();
      } catch(SQLException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      }
    return ret;
  }
  
   public String getUEmail ( String token ) {
    String ret = null;
    int temp = -1;
    DB db = new DB();
    Connection conn = db.connect();  
      try {
          Statement stmt = conn.createStatement();
          String sql;

          sql = "SELECT * FROM token WHERE t_token = ?";
          PreparedStatement dbStatement = conn.prepareStatement(sql);
          dbStatement.setString(1, token);

          ResultSet rs = dbStatement.executeQuery();

          // Extract data from result set
          while(rs.next()){        
            temp = rs.getInt("u_id");
          }

          sql = "SELECT u_email FROM user WHERE u_id = ?";
          dbStatement = conn.prepareStatement(sql);
          dbStatement.setInt(1, temp);

          rs = dbStatement.executeQuery();
          
          while(rs.next()){        
            ret = rs.getString("u_email");
          }
          
          
          rs.close();
          stmt.close();
      } catch(SQLException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      }
    return ret;
  }
   
}