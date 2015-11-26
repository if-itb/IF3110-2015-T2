package Question;

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
public class QuestionListServlet extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            List<Question> questions = getAllQuestion();
            for (int i = 0; i < questions.size(); i++) {
                out.println("<table>\n"
                        + "                <tr>\n"
                        + "                    <td class=\"Votes\" rowspan=\"2\">\n"
                        + "                        <b>");
                out.println(questions.get(i).getVotes());
                out.println("<br>\n"
                        + "                            Votes\n"
                        + "                        </b>\n"
                        + "                    </td>\n"
                        + "                    <td class=\"Answers\" rowspan=\"2\">\n"
                        + "                        <b>");
                out.println(questions.get(i).getAnswers());
                out.println("<br>\n"
                        + "                            Answers\n"
                        + "                        </b>\n"
                        + "                    </td>\n"
                        + "                    <td>\n"
                        + "                        <p class=\"topic\">\n"
                        + "                            <a href=\"question.jsp?qid=");
                out.println(questions.get(i).getQID());
                out.println("\">");
                out.println(questions.get(i).getTopic());
                out.println("</a>\n"
                        + "                        </p>\n"
                        + "                        <p class=\"content\">");
                out.println(questions.get(i).getContent());
                out.println("</p>\n"
                        + "                        <br>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                    <td class=\"Asker\">\n"
                        + "                        asked by\n"
                        + "                        <p class=\"blue\">");
                out.println(getUser(questions.get(i).getUserID()).get(0).getEmail());
                out.println("</p> | \n"
                        + "                        <a class=\"gold\" href=\"edit.jsp?qid=");
                out.println(questions.get(i).getQID());
                out.println("\">\n"
                        + "                            edit\n"
                        + "                        </a> | \n"
                        + "                        <a class=\"red\" href=\"delete.jsp?qid=");
                out.println(questions.get(i).getQID());
                out.println("\">\n"
                        + "                            delete\n"
                        + "                        </a>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "            </table>\n"
                        + "            <hr>");
            }
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

    private java.util.List<QuestionWS.Question> getAllQuestion() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        return port.getAllQuestion();
    }

    private java.util.List<UserWS.User> getUser(int userID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        UserWS.UserWS port = service_1.getUserWSPort();
        return port.getUser(userID);
    }
}
