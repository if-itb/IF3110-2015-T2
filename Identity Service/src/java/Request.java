

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin
 */
public class Request extends HttpServlet {
    
     //attr
    private String token;
    private String create_time; 
    
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/stackx";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public void createNewToken(String email, String password){
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           stmt = conn.createStatement();
           
           String sql;
           sql = "SELECT user_id FROM user WHERE email ='" + email + "' AND password='" + password + "'";
           ResultSet rs = stmt.executeQuery(sql);
           if(rs.next()){
                int user_id = rs.getInt("user_id");
                String new_token = getRandomToken();
                
                sql = "SELECT access_token FROM user_token WHERE access_token ='" + new_token + "'";
                rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                    new_token = getRandomToken();
                    sql = "SELECT access_token FROM user_token WHERE access_token ='" + new_token + "'";
                    rs = stmt.executeQuery(sql);
                }
                token = new_token;
                
                Date temp = new Date(); 
                create_time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(temp);
                
                //check if current user_id has invalid token
                sql = "SELECT user_id FROM user_token WHERE user_id=" + user_id;
                rs = stmt.executeQuery(sql);
                 
                if(!rs.next()){ //current user_id have no token
                    
                    sql = "INSERT INTO user_token VALUES(" + user_id +",'" + new_token + "','" + create_time + "' )";
                    int res = stmt.executeUpdate(sql);
                    System.out.println(res);
                }
                else{ // current user_id have invalid token
                
                    sql = "UPDATE user_token SET access_token='" + new_token + "', create_time='" + create_time + "' WHERE user_id=" + user_id;
                    int res = stmt.executeUpdate(sql);
                    System.out.println(res);
                }
                
           }
           else{ //INVALID email or password
               token = "";
               create_time ="";
           }
           
           //closing database
           rs.close();
           stmt.close();
           conn.close();
        }
         catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
    }
    
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        createNewToken(email, password);
        
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //JSON format
            out.println("{\"new_token\":[");
            out.println("{\"token\":\"" + token +  "\", \"create_time\":\"" + create_time + "\"}");
            out.println("]}");
            
        }
        
    }
    
    // randomize a token
    public String getRandomToken(){
        
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
        return randomUUIDString;
    }
}
