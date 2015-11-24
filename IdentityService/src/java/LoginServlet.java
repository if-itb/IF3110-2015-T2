/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.*;
import java.security.*;

/**
 *
 * @author vickonovianto
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/wbd";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";    
    
    class User {
        private String email;
        private String password;
        
        public String getEmail() { return email; }
        public String getPassword() { return password; }
    }
    
    class Status {
        private boolean success;
        private String description;
        private String access_token;
        private int lifetime;
        public void setSuccess(boolean newSuccess) { success = newSuccess; };
        public void setDescription(String newDescription) { description = newDescription; };
        public void setAccessToken(String newAccessToken) { access_token = newAccessToken; };
        public void setLifetime(int newLifetime) { lifetime = newLifetime; };
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
            
        try {
            //System.out.println("this is debug message");
            //parsing json
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
            }
            
            User user = (User) gson.fromJson(sb.toString(), User.class);
 
            Connection conn = null;
            Statement stmt = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            String sql = "SELECT userID, password FROM account WHERE email = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            ResultSet rs = preparedStatement.executeQuery();
            
            Status status = new Status();
            
            if (rs.next()) {
                String password = rs.getString("password");
                if (password.equals(user.getPassword())) {
                    System.out.println("password cocok");
                    
                    String seed = "";
                    java.util.Date date = new java.util.Date();
                    long ms = date.getTime();
                    seed = seed.concat(user.getEmail() + user.getPassword() + ms);
                    byte[] bytesOfMessage = seed.getBytes("UTF-8");
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    byte[] thedigest = md.digest(bytesOfMessage);
                    String access_token = new String(thedigest, "UTF-8");
                    
                    ms = ms + 300 * 1000;
                    Object tokenexpired = new java.sql.Timestamp(ms);
                    
                    int userid = rs.getInt("userID");
                    sql = "UPDATE account SET token=?, tokenexpired=? WHERE userID = ?";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, access_token);
                    preparedStatement.setObject(2, tokenexpired);
                    preparedStatement.setInt(3, userid);
                    preparedStatement.executeQuery();
                    
                    status.setSuccess(true);
                    status.setDescription("password cocok");
                    status.setAccessToken(access_token);
                    status.setLifetime(300);
                    response.getOutputStream().print(gson.toJson(status));
                    response.getOutputStream().flush();
                }
                else {
                    System.out.println("password tidak cocok");
                }
                System.out.println(password);
            }
            
            rs.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
           
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
