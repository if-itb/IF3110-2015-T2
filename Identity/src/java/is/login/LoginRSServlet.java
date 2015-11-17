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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
            String sql = "SELECT * FROM users WHERE Email = ? AND Password = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, request.getParameter("email"));
            dbStatement.setString(2, request.getParameter("password"));
            ResultSet rs = dbStatement.executeQuery();
            if (!rs.next()) {
                
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
