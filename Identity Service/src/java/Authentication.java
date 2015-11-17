

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import java.sql.*;
/**
 *
 * @author Edwin
 */
public class Authentication extends HttpServlet {
   
   //attr
    private String user_id;
    private String name; 
    private String email;
    private String create_time;
    
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/stack_x";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public void getUser(String token){
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
           sql = "SELECT user.user_id, name, email, create_time FROM user_token INNER JOIN user ON user.user_id=user_token.user_id WHERE access_token ='" + token + "'";
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
            out.println("{\"user\":[");
            out.println("{\"user_id\":\"" + user_id + "\", \"name\":\"" + name + "\", \"email\":\"" + email + "\", \"create_time\":\"" + create_time + "\"}");
            out.println("]}");
            
        }
        
    }
    
}
