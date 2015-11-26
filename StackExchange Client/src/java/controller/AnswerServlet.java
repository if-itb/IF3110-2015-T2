/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import AnswerWS.AnswerWS_Service;
import QuestionWS.Question;
import QuestionWS.QuestionWS_Service;
import UserWS.UserWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Scemo
 */
@WebServlet(name = "AnswerServlet", urlPatterns = {"/Answer"})
public class AnswerServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/UserWS.wsdl")
    private UserWS_Service service_2;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/AnswerWS.wsdl")
    private AnswerWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8088/StackExchange_WS/QuestionWS.wsdl")
    private QuestionWS_Service service;

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
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        AnswerWS.AnswerWS port2 = service_1.getAnswerWSPort();
        UserWS.UserWS port3 = service_2.getUserWSPort();
        String Id = request.getParameter("id");
        Question question = null;
        if (Id != null) {
            try {                
                question = port.getQuestionByID(Integer.parseInt(Id));
            }
            catch (NumberFormatException ex) {                
            }
        }                
        if (question != null) {
            //User user = (User) request.getAttribute("user");
            request.setAttribute("question", question);
            //request.setAttribute("asker", port.getUser(question.getIdUser()));
            java.util.List<AnswerWS.Answer> answers = port2.getAnswerByQID(question.getId());
            Map<Integer, String> answerers = new HashMap<>();
            Map<Integer, Integer> count_answer = new HashMap();
            count_answer.put(question.getId(), port2.getAnswerByQID(question.getId()).size());
            //Map<Integer, Integer> answerStates = new HashMap<>();
            for (AnswerWS.Answer answer: answers) {
                answerers.put(answer.getId(), port3.getUserbyID(answer.getIdUser()));                
                //answerStates.put(answer.getId(), user == null? 0: port.getAnswerVoteState(user.getId(), answer.getId()));
            }
            request.setAttribute("asker", port3.getUserbyID(question.getIdUser()));
            request.setAttribute("count_answer", count_answer);
            request.setAttribute("answers", answers);
            request.setAttribute("answerers", answerers);
            //request.setAttribute("question_state", user == null? 0: port.getQuestionVoteState(user.getId(), question.getId()));
            //request.setAttribute("answer_states", answerStates);
            request.getRequestDispatcher("WEB-INF/answers.jsp").forward(request, response);
        }
        else
            response.sendRedirect(request.getContextPath());
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
        AnswerWS.AnswerWS port = service_1.getAnswerWSPort();
        return port.getAnswerByQID(qid);
    }

    private Question getQuestionByID(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        return port.getQuestionByID(id);
    }

    private String getUserbyID(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        UserWS.UserWS port = service_2.getUserWSPort();
        return port.getUserbyID(id);
    }

}
