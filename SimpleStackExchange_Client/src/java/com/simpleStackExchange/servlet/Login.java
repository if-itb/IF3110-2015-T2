/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simpleStackExchange.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mfikria
 */
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // get request parameters for userID and password
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        if(email.equals("mfikria@gmail.com") && password.equals("password")){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            //set session's expiration time
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("email", email);
            response.addCookie(userName);
            //Get the encoded URL string
            String encodedURL = response.encodeRedirectURL("index.jsp");
            response.sendRedirect(encodedURL);
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
