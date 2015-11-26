/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import AnswerWS.Answer;
import AnswerWS.AnswerWS_Service;
import QuestionWS.Question;
import QuestionWS.QuestionWS_Service;
import UserWS.UserWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author M. Fauzan Naufan
 */
public class QuestionByQIDServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/AnswerWS.wsdl")
    private AnswerWS_Service service_2;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/UserWS.wsdl")
    private UserWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WS/QuestionWS.wsdl")
    private QuestionWS_Service service;

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
        int qid = Integer.valueOf((String) request.getAttribute("qid"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Question> question = getQuestionByQID(qid);
            for (int i = 0; i < question.size(); i++) {
                out.println("            <br>\n"
                        + "            <h2>");
                out.println(question.get(i).getTopic());
                out.println("</h2>\n"
                        + "            <hr>\n"
                        + "            <table>\n"
                        + "                <tr>\n"
                        + "                    <td class=\"VotesQA\">\n"
                        + "                        <a onclick=\"\">\n"
                        + "                            <img src=\"img/vote-up.png\">\n"
                        + "                        </a>\n"
                        + "                        <div id=\"VotesQ\">");
                out.println(question.get(i).getVotes());
                out.println("</div>\n"
                        + "                        <a onclick=\"\">\n"
                        + "                            <img src=\"img/vote-down.png\">\n"
                        + "                        </a>\n"
                        + "                    </td>\n"
                        + "                    <td>");
                out.println(question.get(i).getContent());
                out.println("</td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td></td>\n"
                        + "                    <td class=\"Asker\">\n"
                        + "                        asked by ");
                out.println(getUser(question.get(i).getUserID()).get(0).getEmail());
                out.println(" at ");
                out.println(question.get(i).getDateTime().substring(0, 19));
                out.println(" | \n"
                        + "                        <a class=\"gold\" href=\"");
                out.println("edit.jsp?qid=" + qid);
                out.println("\">\n"
                        + "                            edit\n"
                        + "                        </a> | \n"
                        + "                        <a class=\"red\" href=\"");
                out.println("delete.jsp?qid=" + qid);
                out.println("\" onclick=\"\" >\n"
                        + "                            delete\n"
                        + "                        </a>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "            </table>\n"
                        + "\n"
                        + "            <br>\n"
                        + "            <h2>");
                out.print(question.get(i).getAnswers() + " Answer");
                if (question.get(i).getAnswers() != 1) {
                    out.println("s");
                }
                out.println("</h2>\n"
                        + "            <hr>");
            }
            List<Answer> answers = getAnswerByQID(Integer.valueOf((String) request.getAttribute("qid")));
            for (int i = 0; i < answers.size(); i++) {
                out.println("<table>\n"
                        + "                <tr>\n"
                        + "                    <td class=\"VotesQA\">\n"
                        + "                        <a onclick=\"\">\n"
                        + "                            <img src=\"img/vote-up.png\">\n"
                        + "                        </a>\n"
                        + "                        <br>\n"
                        + "                        <div class=\"VotesA\" id=\"\">");
                out.println(answers.get(i).getVotes());
                out.println("</div>\n"
                        + "                        <a onclick=\"\">\n"
                        + "                            <img src=\"img/vote-down.png\">\n"
                        + "                        </a>\n"
                        + "                    </td>\n"
                        + "                    <td>");
                out.println(answers.get(i).getContent());
                out.println("</td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td></td>\n"
                        + "                    <td class=\"Answerer\">\n"
                        + "                        answered by ");
                out.println(getUser(answers.get(i).getUserID()).get(0).getEmail());
                out.println(" at ");
                out.println(answers.get(i).getDateTime().substring(0, 19));
                out.println("</td>\n"
                        + "                </tr>\n"
                        + "            </table>\n"
                        + "            <hr>");
            }
            out.println("<h2>\n"
                    + "                Your Answer\n"
                    + "            </h2>\n"
                    + "\n"
                    + "            <form name=\"answerForm\" action=\"CreateAnswerServlet\" method=\"post\" onsubmit=\"\">\n"
                    + "                <input name=\"qid\" type=\"hidden\" value=");
            out.println(qid);
            out.println(">\n"
                    + "                <textarea name=\"content\" id=\"question\" placeholder=\"Content\"></textarea>\n"
                    + "                <input class=\"button\" type=\"submit\" value=\"Post\"><br>\n"
                    + "            </form>");
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

    private java.util.List<QuestionWS.Question> getQuestionByQID(int qid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        return port.getQuestionByQID(qid);
    }

    private java.util.List<UserWS.User> getUser(int userID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        UserWS.UserWS port = service_1.getUserWSPort();
        return port.getUser(userID);
    }

    private java.util.List<AnswerWS.Answer> getAnswerByQID(int qid) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        AnswerWS.AnswerWS port = service_2.getAnswerWSPort();
        return port.getAnswerByQID(qid);
    }

}
