/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.question.QuestionWS_Service;

/**
 *
 * @author ASUS X202E
 */
public class AddQuestionServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/QuestionWS.wsdl")
    private QuestionWS_Service service;

   
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
        model.question.Question newQuestion = new model.question.Question();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
        newQuestion.setUserId(user_id);
        newQuestion.setTopic(topic);
        newQuestion.setContent(content);
        addQuestion(newQuestion);
        response.sendRedirect("index");
    }

    private void addQuestion(model.question.Question q) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        model.question.QuestionWS port = service.getQuestionWSPort();
        port.addQuestion(q);
    }


}
