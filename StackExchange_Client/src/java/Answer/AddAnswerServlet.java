/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.answer.AnswerWS_Service;

/**
 *
 * @author ASUS X202E
 */
public class AddAnswerServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/AnswerWS.wsdl")
    private AnswerWS_Service service;

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
        model.answer.Answer newAns = new model.answer.Answer();
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int question_id = Integer.parseInt(request.getParameter("question_id"));
        String content = request.getParameter("content");
        newAns.setUserId(user_id);
        newAns.setQuestionId(question_id);
        newAns.setContent(content);
        addAnswer(newAns);
        response.sendRedirect("view?id="+question_id);
    }

    private void addAnswer(model.answer.Answer a) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        model.answer.AnswerWS port = service.getAnswerWSPort();
        port.addAnswer(a);
    }

}
