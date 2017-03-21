package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import questionmodel.QuestionWS_Service;

@WebServlet(name = "askquestion", urlPatterns = {"/askquestion"})
public class askquestion extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_15534/StackExchangeService/QuestionWS.wsdl")
    private QuestionWS_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean found = false;
        int i=0;
        boolean token_expired = false;
        
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null) {
            while (!found && i < cookies.length){
                if (cookies[i].getName().equals("tokenCookie")) {
                    String token = cookies[i].getValue();
                    String topic = request.getParameter("topic");
                    String content = request.getParameter("content");
                    if (createQuestion(topic,token,content))
                        token_expired = true;
                    found = true;
                }
                i++;
            }
        }
        
        if (token_expired) {
            int count = 0;
            i = 0;
            while (count<2 && i<cookies.length){
                if (cookies[i].getName().equals("usernameCookie") || cookies[i].getName().equals("tokenCookie")) {
                    cookies[i].setMaxAge(0);
                    cookies[i].setPath("/");
                    response.addCookie(cookies[i]);
                    count++;
                }
                i++;
            }
        }
        response.sendRedirect("index");
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

    private Boolean createQuestion(java.lang.String topic, java.lang.String token, java.lang.String content) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        questionmodel.QuestionWS port = service.getQuestionWSPort();
        return port.createQuestion(topic, token, content);
    }

}
