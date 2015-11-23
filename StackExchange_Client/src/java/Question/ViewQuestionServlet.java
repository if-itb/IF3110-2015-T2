/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.question.Question;
import model.question.QuestionWS_Service;
import model.answer.Answer;
import model.answer.AnswerWS_Service;
import model.user.User;
import model.user.UserWS_Service;

/**
 *
 * @author Venny
 */
@WebServlet(name = "ViewQuestionServlet", urlPatterns = {"/view"})
public class ViewQuestionServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/QuestionWS.wsdl")
    private QuestionWS_Service q_service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/AnswerWS.wsdl")
    private AnswerWS_Service a_service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/UserWS.wsdl")
    private UserWS_Service u_service;

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
        model.question.Question q = getQuestionByID(Integer.parseInt(request.getParameter("id")));
        java.util.List<model.answer.Answer> answerList = getAnswersByQID(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("question",q);
        request.setAttribute("answers",answerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
        dispatcher.forward(request,response);
    }


    private Question getQuestionByID(int questionId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        model.question.QuestionWS port = q_service.getQuestionWSPort();
        return port.getQuestionByID(questionId);
    }
    
    private java.util.List<Answer> getAnswersByQID(int i) {
        model.answer.AnswerWS port = a_service.getAnswerWSPort();
        return port.getAnswersByQID(i);
    }
}
