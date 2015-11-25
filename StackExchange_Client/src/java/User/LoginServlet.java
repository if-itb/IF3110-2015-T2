/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.user.UserWS_Service;
import model.user.User;

/**
 *
 * @author Venny
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/UserWS.wsdl")
    private UserWS_Service service;
    
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id = getIDbyEmail(email);
        if (id == -1){
            //user doen't exist
            response.sendRedirect("login.jsp");
        } else {
            model.user.User user  = getUserByID(id);
            if (user.getPassword().equals(password)){
                //authenticated
                response.sendRedirect("index");
            } else {
                //unauthenticated
                response.sendRedirect("login.jsp");
            }
        }
    }

    private int getIDbyEmail(String email) {
        model.user.UserWS port = service.getUserWSPort();
        return port.getIDbyEmail(email);
    }

    private User getUserByID(int id) {
        model.user.UserWS port = service.getUserWSPort();
        return port.getUserByID(id);
    }

}
