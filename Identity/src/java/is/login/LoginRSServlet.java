/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class LoginRSServlet extends HttpServlet {

    @Override
    protected void doPost( HttpServletRequest request,
                         HttpServletResponse response ) throws ServletException, IOException
    {
        try {
            response.setContentType("text/html");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull", "root", "");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE Email = ? AND Password = ?"; // Login query validation
            final PrintWriter out = response.getWriter();
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, request.getParameter("email"));
            dbStatement.setString(2, request.getParameter("password"));
            ResultSet rs = dbStatement.executeQuery();
            if (rs.next()) { // If the query returns a row (login succeeded)
                String token = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (int i=0;i<cookies.length;i++) {
                        if (cookies[i].getName().equals("access_token")) {
                            token = cookies[i].getValue();
                            break;
                        }
                    }
                }
                if (token == null) {
                    token = UUID.randomUUID().toString(); //generate token
                    //Cookie c = new Cookie("access_token", token);
                    //c.setPath("/FrontEnd/");
                    //response.addCookie(c);
                    //response.setHeader("access_token", token);
                }
                //response.addHeader("token", token);
                response.sendRedirect("http://localhost:8000/FrontEnd/login.jsp?token="+token+"&valid=1");
            }
            else
            {
                response.sendRedirect("http://localhost:8000/FrontEnd/login.jsp?valid=0");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginRSServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginRSServlet.class.getName()).log(Level.SEVERE, null, ex);
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
