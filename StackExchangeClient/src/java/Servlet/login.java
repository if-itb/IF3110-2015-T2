package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uname = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Form form = new Form();
        form.param("uname", uname);
        form.param("pass", pass);
       
        Client client = ClientBuilder.newClient();
        String url = "http://localhost:21568/StackExchangeAuth/getToken";
        
        try {
            String result = client.target(url).request(MediaType.APPLICATION_XML).post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED), String.class);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(result)));
            Element rootElement = document.getDocumentElement();
            String token = rootElement.getAttribute("token");
            
            Cookie tokenCookie = new Cookie("tokenCookie", token);
            tokenCookie.setMaxAge(60*60*6);
            response.addCookie(tokenCookie);
            Cookie usernameCookie = new Cookie("usernameCookie", token);
            usernameCookie.setMaxAge(60*60*6);
            response.addCookie(usernameCookie);
            response.sendRedirect("index");
            
           
            
            //request.setAttribute("token", result);
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index");
            //dispatcher.forward(request, response);
        }
        catch (Exception e) {}
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
