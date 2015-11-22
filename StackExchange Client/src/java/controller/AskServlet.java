/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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
@WebServlet(name = "AskServlet", urlPatterns = {"/ask"})
public class AskServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StackExchange_WS/StackExchange.wsdl")
    private StackExchange_Service service;        

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
        request.getRequestDispatcher("WEB-INF/view/ask.jsp").forward(request, response);
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
        // check request topic and content
        // reload this page if they are empty
        String
                topic = request.getParameter("topic"),
                content = request.getParameter("content");
        if (topic == null || content == null || topic.isEmpty() || content.isEmpty()) {
            response.sendRedirect(request.getRequestURI());
            return;
        }
            
        // check access token
        // redirect to login page if access token is not set
        String loginPage = request.getContextPath() + "/login";
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.sendRedirect(loginPage);
            return;
        }
        String auth = null;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("auth")) {
                auth = cookie.getValue();
                break;
            }
        }
        if (auth == null) {
            response.sendRedirect(loginPage);
            return;
        }

        // check validity of access token and get the user via identity service
        // redirect to login page if access token is invalid/expired
        URLConnection connection = new URL("http://localhost:8080/Identity_Service/auth").openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        try (OutputStream output = connection.getOutputStream()) {
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            String query = String.format(
                    "auth=%s",
                    URLEncoder.encode(auth, charset));
            output.write(query.getBytes(charset));
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader buf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String read;
        while ((read = buf.readLine()) != null)
            builder.append(read);
        try {
            JSONObject jsonResponse = (JSONObject)new JSONParser().parse(builder.toString());
            // auth error, redirect to login page
            if (jsonResponse.containsKey("error")) {
                response.sendRedirect(loginPage);
                return;
            }
            // auth valid, create the question
            else if (jsonResponse.containsKey("id")) {
                StackExchange port = service.getStackExchangePort();
                long id = (long) jsonResponse.get("id");                
                Question question = port.addQuestion((int)id, topic, content);
                // redirect to question page if success
                if (question != null) {
                    response.sendRedirect(request.getContextPath() + "/question?id=" + question.getId());
                    return;
                }
                // if failed let the get method handles it
                else {
                    request.setAttribute("error", "Failed to create question");
                    doGet(request, response);
                    return;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getRequestURI());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Handle ask request";
    }// </editor-fold>

}
