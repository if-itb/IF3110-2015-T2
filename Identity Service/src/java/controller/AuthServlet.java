/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.DB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author Acer
 */
@WebServlet(name = "Validation", urlPatterns = {"/validation"})
public class Validation extends HttpServlet {

    Connection conn = DB.connect();
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
        JSONObject obj = new JSONObject();
        
        PreparedStatement statement = null;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String token = request.getParameter("token");
            try {
                String query = new String();
                query = "SELECT * FROM token WHERE access_token = ?";
                
                statement = conn.prepareStatement(query);
                statement.setString(1, token);
                
                ResultSet result = statement.executeQuery();
                
                if(result.next()) {
                    Date expire_date = null;
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try{
                        expire_date = format.parse(result.getString("expire_date"));
                    }
                    catch ( Exception ex ){
                        System.out.println(ex);
                    }

                    Date current_date = new Date();

                    if (current_date.after(expire_date)) {
                        obj.put("message", "expired");
                    } else {
                        obj.put("message", "valid");
                    }

                    out.print(obj);
                } else {
                    obj.put("message", "invalid");
                    out.print(obj);
                }

            } catch(SQLException ex) {
                obj.put("error", ex);  
                out.print(obj);
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
