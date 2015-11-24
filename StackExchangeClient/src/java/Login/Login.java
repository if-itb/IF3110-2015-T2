/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Ahmad Naufal Farhan
 */
public class Login extends HttpServlet {
    
    private static final String URL_LOGIN = "http://localhost:8082/IdentityService/Login";
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
        response.setContentType("application/json");
        
        // set the parameters and build JSON
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // establish a connection with the identity service that handles login
        URL url = new URL(URL_LOGIN);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // set the request property
        conn.setDoOutput(true);
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
        conn.setRequestProperty( "charset", "utf-8");
        
        // send the object
        String params = String.format("email=%s&password=%s",
                URLEncoder.encode(email, StandardCharsets.UTF_8.name()),
                URLEncoder.encode(password, StandardCharsets.UTF_8.name()));
        
        try (OutputStream out = conn.getOutputStream()) {
            out.write(params.getBytes("UTF-8"));
        }
        
        System.out.println(conn.getResponseCode());
        System.out.println(conn.getErrorStream());
        InputStream is = conn.getInputStream();
        
        // read response json from the identity service servlet
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        
        String temp;
        while ((temp = in.readLine()) != null)
            sb.append(temp);
        
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(sb.toString());
            
            // get the attributes and add the cookie
            String strToken = (String) object.get("token_str");
            Cookie cookie;
            if (strToken != null) {
                cookie = new Cookie("token_cookie", strToken);
                response.addCookie(cookie);
            }
            
            response.sendRedirect("/register.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
