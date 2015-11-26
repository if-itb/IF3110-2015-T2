/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import UserWS.User;
import connector.ISConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author Tifani
 */
public class LoginController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        User user = (User) request.getAttribute("user");
        if (user != null) {
            // User has been already registered
            response.sendRedirect(request.getContextPath());
        } else {
            // Remove user's session
            HttpSession session = request.getSession(false);
            String error = null;
            if (session != null && (error = (String) session.getAttribute("error")) != null) {
                request.setAttribute("error", error);
                session.removeAttribute("error");
            }
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
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
        response.setContentType("text/html;charset=UTF-8");
        User user = (User) request.getAttribute("user");
        if (user != null) {
            // User has been already registered
            response.sendRedirect(request.getContextPath());
        } else {
            // Login in user
            String  email = request.getParameter("email"),
                    password = request.getParameter("pass");
            
            JSONObject object = null;
            object = ISConnector.validateLogin(email, password);
            if (object.containsKey("token")){
                Cookie cookie = new Cookie("token", (String)object.get("token"));
                cookie.setPath("/");
                long expiredDate = -1;
                if (object.containsKey("expire_date")) {                        
                    expiredDate = new Timestamp(new Date().getTime()).getTime()-(long)object.get("expire_date");
                    expiredDate /= 1000;                                                
                }                    
                cookie.setMaxAge((int)expiredDate);
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath());
                return;
            } else if (object.containsKey("error")) {
                request.setAttribute("error", (String)object.get("error"));
            }         
        }
        doGet(request, response);
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
