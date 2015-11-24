/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;

import database.DB;
import java.lang.Object;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 *
 * @author Ahmad Naufal Farhan
 */
public class Login extends HttpServlet {

    // database connection
    Connection conn = DB.getConnection();
    
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
        JSONObject object = new JSONObject();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            try {
                String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2, password);
                
                ResultSet res = pst.executeQuery();
                
                if (res.next()) {
                    /* SET LOGIN CREDENTIALS AND TOKENS HERE */
                    // random string for token
                    Random random = new Random();
                    String token = new BigInteger(130, random).toString(32);
                    
                    int uid = res.getInt("uid");
                    Timestamp tst = new Timestamp(new Date().getTime());
                    tst.setTime(tst.getTime() + ((2 * 3600) + 1000));
                    
                    query = "INSERT INTO tokens (uid, token_str, expired) VALUES (?, ?, ?)";
                    pst = conn.prepareStatement(query);
                    pst.setInt(1, uid);
                    pst.setString(2, token);
                    pst.setString(3, tst.toString());
                    
                    pst.executeUpdate();
                    
                    // send the response containing token contents as JSON
                    object.put("token_str", token);
                    object.put("expire", tst.toString());
                } else
                    object.put("error", "Invalid login credentials!");
                
                // output to response
                out.print(object.toString());
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
     
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
