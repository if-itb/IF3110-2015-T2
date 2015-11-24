/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Token;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author acel
 */
@WebServlet(name = "Token", urlPatterns = {"/Token"})
public class Token extends HttpServlet {
    private final int lifetime = 30; //seconds
    private String token = "";
    
    public long generateLifetime(){
        long currentTime = System.currentTimeMillis()/1000;
        currentTime += lifetime;
        return currentTime;
    }
    
    public boolean isInDB(String username, String password){
        //path and port for the database
        final String path = "jdbc:mysql://localhost:3306/stack_exchange";
        //query for database
        final String query = "SELECT COUNT(*) FROM user WHERE nama = '" + username + "' AND password = '" + password + "'";
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
            return true;
        } else {
            return false;
        }
    }
    
    public void generateToken(String username){
        try {
            token = username + ";" + generateLifetime();
            token = Base64.getEncoder().encodeToString(token.getBytes("utf-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String decodeToken(){
        byte[] byteDecoded = Base64.getDecoder().decode(token);
        String decoded = new String(byteDecoded, StandardCharsets.UTF_8);
        return decoded;        
    }
    
    public String toJSON(){
        JSONObject obj = new JSONObject();

        obj.put("token", token);
        
        return obj.toString();
    }
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
            //Variable
            response.setContentType("application/json");
            String username = request.getParameter("uname");
            String password = request.getParameter("pword");
            
            if(isInDB(username,password)){
                generateToken(username);
                out.write(toJSON());
            } else {
                token = "";
                out.write(toJSON());
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
