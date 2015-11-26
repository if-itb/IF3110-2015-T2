/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import TokenOperation.Token;
import TokenOperation.TokenAdapter;
import UserOperation.UserAdapter;
import UserOperation.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Aidin
 */
public class Handler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
       
        String email, pass;
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        
        User clientUser = new User(email,pass);
        User dbUser = new User();
        Token token = new Token();
       
        UserAdapter uadb = new UserAdapter();
        TokenAdapter tadb = new TokenAdapter();
        
        try {
            dbUser=uadb.getUser(email);
            if((dbUser.getEmail()).isEmpty()){
                response.sendError(404, "email is not found");
            } else {
                if(!clientUser.isEqual(dbUser)){
                    response.sendError(404, "email and password do not match");
                } else {
                    
                    
                    response.setContentType("application/xml");
                    PrintWriter printWriter;
                    try {
                        printWriter = response.getWriter();
                        printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                        printWriter.println("<root>");            
                        printWriter.print("<token>");
                       // printWriter.print(token);
                        printWriter.println("</token>");
                        printWriter.print("<lifetime>");
                        //printWriter.print(lifetime);
                        printWriter.println("</lifetime>");
                        printWriter.println("</root>");                      
                        printWriter.flush();
                    } catch (IOException e) {
                    
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
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
