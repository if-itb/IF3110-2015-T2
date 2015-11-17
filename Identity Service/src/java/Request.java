

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
   static final String DB_URL = "jdbc:mysql://localhost:3306/stack_x";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public void getNewToken(String email, String password){
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
           sql = "";
           ResultSet rs = stmt.executeQuery(sql);
           
           if(!rs.next()){
               name = "";
               email = "";
               user_id = "";
               create_time= "";
           }
           else{
               name = rs.getString("name");
               email = rs.getString("email");
               user_id = rs.getInt("user_id") + "";
               
               Timestamp temp = rs.getTimestamp("create_time"); 
               create_time = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(temp);
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
        String token = request.getParameter("token");
        getUser(token);
        
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //JSON format
            out.println("{\"new_token\":[");
            out.println("{\"token\":\"" + token +  "\", \"create_time\":\"" + create_time + "\"}");
            out.println("]}");
            
        }
        
    }
    
    // return a token
    public String getToken(String email, String password){
        String token;
        // randomize a new token
        SecureRandom random = new SecureRandom();
        token = new BigInteger(130,random).toString(32);
        
        return token;
    }

}
