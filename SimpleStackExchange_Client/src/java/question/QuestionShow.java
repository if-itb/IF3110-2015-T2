/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import webservice.Question;
import webservice.Registereduser;
import webservice.SimpleStackExchangeWS_Service;

/**
 *
 * @author mfikria
 */
@WebServlet(name = "QuestionShow", urlPatterns = {"/question"})
public class QuestionShow extends HttpServlet {

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
        int qid = Integer.parseInt(request.getParameter("qid"));
        Pair<webservice.Question, String> que;
        webservice.Registereduser ru = getUserById(qid);
        if(ru == null)
            que = new Pair(getQuestion(qid), "Invalid User");
        else
            que = new Pair(getQuestion(qid), ru.getName());
        request.setAttribute("question", que);
        
        
        List<webservice.Answer> ans = getAnswers(qid);
        ArrayList<Pair<webservice.Question, String> > answers;
        answers = new ArrayList<Pair<webservice.Question, String>>();
        for(webservice.Answer a : ans) {
            webservice.Registereduser aru = getUserById(a.getUid());
            if(aru == null)
                answers.add(new Pair(a, "Deleted User"));
            else
                answers.add(new Pair(a, ru.getName()));
        }
        request.setAttribute("answers", answers);
        
        request.getRequestDispatcher("question.jsp").forward(request, response);
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

    private Question getQuestion(int qid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.SimpleStackExchangeWS port = service.getSimpleStackExchangeWSPort();
        return port.getQuestion(qid);
    }

    private Registereduser getUserById(int uid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.SimpleStackExchangeWS port = service.getSimpleStackExchangeWSPort();
        return port.getUserById(uid);
    }

    private java.util.List<webservice.Answer> getAnswers(int qid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.SimpleStackExchangeWS port = service.getSimpleStackExchangeWSPort();
        return port.getAnswers(qid);
    }


}
