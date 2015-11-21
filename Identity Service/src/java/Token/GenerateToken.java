/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Token;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acel
 */
@WebServlet(name = "GenerateToken", urlPatterns = {"/GenerateToken"})
public class GenerateToken extends HttpServlet {

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
            out.println("<title>Servlet GenerateToken</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GenerateToken at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //path and port for the database
            String path = "jdbc:mysql://localhost:3306/stack_exchange";
            
            //soon implemented with HTTP Headers or something else
            String usernameDummy = "william";
            String passwordDummy = "william";
            String query = "SELECT COUNT(*) FROM user WHERE nama = '" + usernameDummy + "' AND password = '" + passwordDummy + "'";
            
            Database database = new Database();
            database.connect(path);
            
            int result = 0;
            ResultSet rs = database.fetchData(query);
            try {
                rs.next();
                result = rs.getInt("COUNT(*)");
                rs.close();
            } catch (SQLException ex) {
            }
            
            database.closeDatabase();
            
            if(result == 1){
                //generating token
                String base64encodedString = Base64.getEncoder().encodeToString(usernameDummy.getBytes("utf-8"));
                out.println("Token :" + base64encodedString);
            } else {
                //not generating token
                out.println("Username does not exist or password does not match!");
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
