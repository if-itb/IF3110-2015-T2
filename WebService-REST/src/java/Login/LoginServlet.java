package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        UserService user = new UserService();
        out.println(email);
        out.println(user.getUserIDFromEmail(email));
        try {
            if(!(user.emailExist(email)) || !(user.passwordValid(email, password))){
                request.setAttribute("notif","Incorrect email or password");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                
            }else{
                String token = user.getTokenFromUserID(user.getUserIDFromEmail(email));
                if (token == null){
                    UUID tokenGenerator = UUID.randomUUID();
                    token = tokenGenerator.toString();
                    java.util.Date dt = new java.util.Date();
                    java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dt);
                    cal.add(Calendar.MINUTE, 2);
                    String lifetime = sdf.format(cal.getTime());
                    String query = "INSERT INTO token (value,user_id,lifetime) "
                            + "VALUES ('"+token+"','"+user.getUserIDFromEmail(email)+"','"+lifetime+"')";
                    user.executeQuery(query);
                }
                request.setAttribute("token",token);
                /*RequestDispatcher requestDispatcher ; 
                requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);*/
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
    } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
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
}
