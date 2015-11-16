/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author alberttriadrian
 */
// Loading required libraries
/*import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;*/
 
public class DatabaseAccess extends HttpServlet{
    //Declare Connection
    private Connection conn;
    
    //Declare Database Name
    static final String DB_NAME = "wbdtb2";
    
    //Declare JDBC Driver Name and Database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/" + DB_NAME +"?zeroDateTimeBehavior=convertToNull";
    
    //Declare Database Credentials
    static final String USER = "root";
    static final String PASS = "alberttriadrian";
    
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,IOException
    {
        System.out.println("HAHAHAHA");
        try{
            System.out.println("HAHAHAHA");
    
            //Set response content type 
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = "Database Result";
      
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
                "transitional//en\">\n";
         
            String header = docType + "<html>\n" +
             "<head><title>" + title + "</title></head>\n" +
             "<body bgcolor=\"#f0f0f0\">\n" +
             "<h1 align=\"center\">" + title + "</h1>\n";

            out.println(header);
                  
            //Register JDBC Driver
            Class.forName(JDBC_DRIVER);
            
            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);   
            
            //Execute SQL Query
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM answer";
            
            ResultSet rs = stmt.executeQuery(sql);
             // Extract data from result set
             while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("IDQ");
                String name = rs.getString("Nama");
                String email = rs.getString("Email");
                String answer = rs.getString("Answer");

                //Display values
                out.println("ID_Question: " + id + "<br>");
                out.println(", Name: " + name + "<br>");
                out.println(", Email: " + email + "<br>");
                out.println(", Answer: " + answer + "<br>");
             }
             out.println("</body></html>");            
            
            //PreparedStatement dbStatement = conn.prepareStatement(sql);
            
            //dbStatement.executeUpdate();
            
            //Clean-up environment
            stmt.close();
            conn.close();
            
        }catch(ClassNotFoundException e1){
            //JDBC driver class not found
            System.out.println(e1.toString());
        }catch(SQLException se){
            //Exception when executing java.sql related commands
            se.printStackTrace();
            //System.out.println(e2.toString());
        }catch(Exception e3){
            //Other exceptions
            System.out.println(e3.toString());
        }
        
        
    }
    
}
