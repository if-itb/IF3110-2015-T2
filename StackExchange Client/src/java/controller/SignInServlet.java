/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ISConnector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.*;

/**
 *
 * @author visat
 */

@WebServlet(name = "SignInServlet", urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StackExchange_WS/StackExchange.wsdl")
    private StackExchange_Service service;
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
        User user = (User) request.getAttribute("user");
        if (user != null) {
            response.sendRedirect(request.getContextPath());
        } else {
            request.getRequestDispatcher("WEB-INF/view/signin.jsp").forward(request, response);
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
 
        User user = (User) request.getAttribute("user");
        if (user != null) { // user already login
            response.sendRedirect(request.getContextPath());
            return;
        }
        else { // user can login
            String  email = request.getParameter("email"),
                    password = request.getParameter("password");
            
            JSONObject object = ISConnector.requestLogin(email, password);                        
            if (object != null) {
                if (object.containsKey("auth")){
                    Cookie cookie = new Cookie("auth", (String)object.get("auth"));
                    cookie.setPath("/");
                    long age = -1;
                    if (object.containsKey("expire_date")) {                        
                        age = new Timestamp(new Date().getTime()).getTime()-(long)object.get("expire_date");
                        age /= 1000;                                                
                    }                    
                    cookie.setMaxAge((int)age);
                    response.addCookie(cookie);
                    response.sendRedirect(request.getContextPath());
                    return;
                } else if (object.containsKey("error")) {
                    request.setAttribute("error", (String)object.get("error"));
                }
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
