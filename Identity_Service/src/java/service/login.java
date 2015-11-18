/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DB;
import java.sql.Connection;
import org.json.*;
import java.io.*;
import java.util.UUID;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fitra Rahmamuliani
 */

@WebServlet(urlPatterns = "/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1;
    /* Connect to database */
    Connection conn = DB.connect();
    
    /* Make JSON object */
    JSONObject jo = new JSONObject();
    
    public login(){
        super();
        /* to do autogenerated contructor stub*/
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   { 
        // TODO Auto-generated constructor stub 
       String id = request.getParameter("email"); 
       String pass = request.getParameter("password"); 
       response.setContentType("text/html"); 
       PrintWriter out = response.getWriter(); 
       RequestDispatcher rd = null; 
       request.setAttribute(id, "name"); 
       if(id.equals("email") && pass.equals("password"))
       { 
           UUID generateToken = UUID.randomUUID();
           String token = generateToken.toString();
           String query = "UPDATE user SET token="+ token +" WHERE name=" + id +";";
           rd = request.getRequestDispatcher("/WelcomeServlet"); 
           rd.forward(request, response);
       } 
       else{ 
            out.println("<b>Invalid Login Info.</b><br>"); 
            rd = request.getRequestDispatcher("/login.jsp"); 
            rd.include(request, response); } out.close(); 
   }
}
