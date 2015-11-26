/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author i-ONe
 */
@WebServlet(urlPatterns = {"/TokenValidator"})
public class TokenValidator extends HttpServlet {

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
        // JDBC driver name and database URL
         String JDBC_DRIVER="com.mysql.jdbc.Driver";  
        String DB_URL="jdbc:mysql://localhost:3306/stackexchange";
    
        //  Database credentials
        String USER = "root";
        String PASS = "";
        
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Authentication</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if( cookies != null ){
                out.println("<h2> Found Cookies Name and Value</h2>");
                cookie = cookies[0];
                out.print("Name : " + cookie.getName( ) + ",  ");
                out.print("Value: " + cookie.getValue( )+" <br/>");
                
                try {
                    // Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    // Open a connection
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    // Execute SQL query
                    Statement stmt = conn.createStatement();
                    String sql = "SELECT COUNT(*) as rowcount from token where AccessToken = '"+cookie.getValue()+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    rs.next();
                    if (rs.getInt("rowcount") != 0){
                        out.println("Access Token is Valid");
                    } else {
                        out.println("Not Valid");
                        response.sendError(response.SC_BAD_REQUEST, "Access Token is not Valid");
                    }
                    
                    // Clean-up environment
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception e){
                    //Handle errors for Class.forName
                    e.printStackTrace();
                }
            }else{
                response.sendError(response.SC_BAD_REQUEST, "expired token");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
