/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stackexchangews.services.Question;
import stackexchangews.services.SQLException_Exception;

/**
 *
 * @author davidkwan
 */
@WebServlet(name = "ViewQuestion", urlPatterns = {"/ViewQuestion"})
public class ViewQuestion extends HttpServlet {
    
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
        Question question = new Question();
        int questionId = Integer.parseInt(request.getParameter("id"));
        try {
            question = getQuestion(questionId);
        } catch (SQLException_Exception ex) {
            Logger.getLogger(ViewQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("question", question);
        request.getRequestDispatcher("view/question.jsp").forward(request, response);    
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
    
    private static Question getQuestion(int questionId) throws SQLException_Exception {
        stackexchangews.services.QuestionHandler_Service service = new stackexchangews.services.QuestionHandler_Service();
        stackexchangews.services.QuestionHandler port = service.getQuestionHandlerPort();
        return port.getQuestion(questionId);
    }
}
