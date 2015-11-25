package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AnswerWS.AnswerWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import QuestionWS.Question;
import QuestionWS.QuestionWS_Service;
import UserWS.UserWS_Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Scemo
 */
@WebServlet(name="ShowQuestionServlet", urlPatterns = {""})
public class ShowQuestionServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/UserWS.wsdl")
    private UserWS_Service service_2;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/QuestionWS.wsdl")
    private QuestionWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/AnswerWS.wsdl")
    private AnswerWS_Service service;
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
            List<Question> Questions = getAllQuestion();
            Map<Integer, Integer> count_answer = new HashMap();
            Map<Integer, String> asker = new HashMap();
            for(Question q : Questions){
                count_answer.put(q.getId(), getAnswerByQID(q.getId()).size());
                asker.put(q.getId(), getUserbyID(q.getIdUser()));
            }
            request.setAttribute("questions", Questions);
            request.setAttribute("answers", count_answer);
            request.setAttribute("askers", asker);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Index.jsp");
            dispatcher.forward( request, response ); 
            
            //request.getRequestDispatcher("WEB-INF/Index.jsp").forward(request, response);
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

    private java.util.List<AnswerWS.Answer> getAnswerByQID(int qid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        AnswerWS.AnswerWS port = service.getAnswerWSPort();
        return port.getAnswerByQID(qid);
    }

    private java.util.List<QuestionWS.Question> getAllQuestion() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service_1.getQuestionWSPort();
        return port.getAllQuestion();
    }

    private String getUserbyID(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        UserWS.UserWS port = service_2.getUserWSPort();
        return port.getUserbyID(id);
    }

}
