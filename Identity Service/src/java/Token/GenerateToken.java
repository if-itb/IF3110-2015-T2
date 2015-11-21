/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Token;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
            //Variable
            //path and port for the database
            String path = "jdbc:mysql://localhost:3306/stack_exchange";
            
            //soon implemented with HTTP Headers or something else
            String username = "";
            String password = "";
            
            String jsonString = "{\"username\":\"william\", \"password\":\"william\"}";
            JSONParser parser = new JSONParser();
            try {
                Object obj = parser.parse(jsonString);
                JSONObject obj2=(JSONObject) obj;
                username = obj2.get("username").toString();
                password = obj2.get("password").toString();
                out.println(username + " " + password);
            } catch (ParseException ex) {
                Logger.getLogger(GenerateToken.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //query for database
            String query = "SELECT COUNT(*) FROM user WHERE nama = '" + username + "' AND password = '" + password + "'";
            
            
            //Lifetime
            int lifetime = 30; //minutes
            
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
            
            //Check username and password in database
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
            
            //Output token and lifetime
            if(result == 1){
                //generating token
                
                String encoded = Base64.getEncoder().encodeToString(username.getBytes("utf-8"));
                out.println("Token :" + encoded + "\n");
                byte[] byteDecoded = Base64.getDecoder().decode(encoded);
                String decoded = new String(byteDecoded, StandardCharsets.UTF_8);
                out.println("Decoded : " + decoded);
                out.println(generateLifetime(lifetime));
            } else {
                //not generating token
                out.println(result + " Username does not exist or password does not match!");
            }
        }
    }
    
    public String generateLifetime(int lifetime){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, lifetime);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        return (df.format(now.getTime()));
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
