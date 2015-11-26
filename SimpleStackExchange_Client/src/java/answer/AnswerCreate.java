/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import question.QuestionCreate;
import tool.ConsumerREST;
import webservice.SimpleStackExchangeWS_Service;

/**
 *
 * @author mfikria
 */
@WebServlet(name = "AnswerCreate", urlPatterns = {"/AnswerCreate"})
public class AnswerCreate extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/SimpleStackExchange_WebService/SimpleStackExchange_WS.wsdl")
    private SimpleStackExchangeWS_Service service;

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
                    HttpSession session = request.getSession();
            webservice.Answer a = new webservice.Answer();
            
            String token = tool.Util.getTokenCookie(request);
            ConsumerREST r = new ConsumerREST(); // Create object for consumming REST Web service
            // Get data from user and data from session
            a.setUid(tool.Util.getUid(request));
            a.setQid(Integer.parseInt(request.getParameter("qid")));
            a.setContent(request.getParameter("answer"));
        
            // Initialize Created time
            XMLGregorianCalendar date = null;
                    try {
                        date = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
                    } catch (DatatypeConfigurationException ex) {
                        Logger.getLogger(QuestionCreate.class.getName()).log(Level.SEVERE, null, ex);
                    }
            a.setCreatedtime(date);
            
            // Pass token and object question to web service
            if(createAnswer(token, a))
                response.sendRedirect("question?qid="+request.getParameter("qid")); // redirect to homepage
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

    private Boolean createAnswer(java.lang.String token, webservice.Answer answer) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.SimpleStackExchangeWS port = service.getSimpleStackExchangeWSPort();
        return port.createAnswer(token, answer);
    }

}
