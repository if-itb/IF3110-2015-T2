/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.UUID;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        
        out.println("Servlet");
        response.sendRedirect("http://localhost:8081/Front-End/login.jsp");
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
        Statement statement;
        
        DBConnection connection = new DBConnection();
        Connection conn = connection.getConn();
        if (request.getParameter("token") != null) {
            String checkToken = "SELECT * from token WHERE value = '" + request.getParameter("token") + "'";
            
            try {
                statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(checkToken);
                if (rs.next()) {
                    request.setAttribute("tokenStatus", 1);
                }
                
                rs.close();
                statement.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else {
            if (request.getParameter("email") != null && request.getParameter("password") != null) {
                
                String query1 = "SELECT * from user WHERE email = '" + request.getParameter("email") + "' AND password = '" + request.getParameter("password") + "'";
                String query2 = "SELECT * from user WHERE email = '" + request.getParameter("email") + "'";
                
                try {
                    statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery(query1);
                    if (rs.next()) {
                        UUID tokenGenerator = UUID.randomUUID();
                        String token = tokenGenerator.toString();
                        String updateQuery = "INSERT INTO token(value, user_Email) values('" + token + "', '" + request.getParameter("email") + "')";
                        statement.execute(updateQuery);
                        response.sendRedirect("http://localhost:8081/Front-End/index.jsp?token=" + token);
                    }
                    else {
                        rs = statement.executeQuery(query2);
                        if (rs.next()) {
                            response.sendRedirect("http://localhost:8081/Front-End/login.jsp?fail1");
                        }
                        else {
                            response.sendRedirect("http://localhost:8081/Front-End/login.jsp?fail");
                        }
                    }
                    
                    rs.close();
                    statement.close();

                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else {
                response.sendRedirect("http://localhost:8081/Front-End/login.jsp");
            }
        }
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