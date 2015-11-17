/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import MD5Hashing.MD5Hashing;

/**
 *
 * @author alberttriadrian
 */
public class ValidateUser extends HttpServlet {

    //Declare Connection
    private Connection conn;
    
    //Declare Database Name
    static final String DB_NAME = "wbd";
    
    //Declare JDBC Driver Name and Database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/" + DB_NAME +"?zeroDateTimeBehavior=convertToNull";
    
    //Declare Database Credentials
    static final String USER = "root";
    static final String PASS = "alberttriadrian";
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidateUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       PrintWriter out = response.getWriter();
       out.println("hello"); 
       try{
            String user_email = request.getParameter("email");
            String user_password = request.getParameter("password");
            //User Token = access token and life time 
            out.println("Hello Wolrd");
            JSONObject userToken = new JSONObject();

            //Register JDBC Driver
            Class.forName(JDBC_DRIVER);
            
            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);   
            
            //Execute SQL Query
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT email,password FROM user";
            
            ResultSet rs = stmt.executeQuery(sql);
             
            ArrayList<String> userEmailList =new ArrayList<String>();//creating arraylist
            ArrayList<String> userPasswordList =new ArrayList<String>();//creating arraylist

             // Extract data from result set
             while(rs.next()){
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                userEmailList.add(email);
                userPasswordList.add(password);
             }
             
             boolean found = false;
             int i = 0;
             
             while  (i < userEmailList.size() - 1){
                 if (user_email == userEmailList.get(i)){
                     found = true;
                 }
                 i++;
             }

             MD5Hashing md5 = new MD5Hashing();
             
             String access_token; 
             int lifetime;
             if (found){
                //Login Successful and send the token response
                access_token = md5.Hash(user_password);
                lifetime = 5;
                
                //Format the response to JSON
                userToken.put("access_token",access_token);
                userToken.put("lifetime", lifetime);             
             }
             else{
                 
             }
                       
            out.println(userToken.toString());
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
