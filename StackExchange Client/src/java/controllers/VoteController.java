/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import AnswerWS.AnswerWS_Service;
import QuestionWS.QuestionWS_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author vanyadeasysafrina
 */
public class VoteController extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WebService/AnswerWS.wsdl")
    private AnswerWS_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/StackExchange_WebService/QuestionWS.wsdl")
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
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        int vote = Integer.parseInt(request.getParameter("vote"));
        String q_id;
        if(type.equals("q")) {
            if(vote==1) {
                q_id = voteQuestion(id,1);
            }
            else { //vote==-1
                q_id = devoteQuestion(id,1);
            }
        }
        else { //type.equals("a")
            if(vote==1) {
                q_id = voteAnswer(id,1);
            }
            else {
                q_id = devoteAnswer(id,1);
            }
        }
        if(!q_id.equals("null")) {
            response.sendRedirect("question?q_id=" + id);
        }
        else {
            // message
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
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        int vote = Integer.parseInt(request.getParameter("vote"));
        String q_id;
        if(type.equals("q")) {
            if(vote==1) {
                q_id = voteQuestion(id,1);
            }
            else { //vote==-1
                q_id = devoteQuestion(id,1);
            }
        }
        else { //type.equals("a")
            if(vote==1) {
                q_id = voteAnswer(id,1);
            }
            else {
                q_id = devoteAnswer(id,1);
            }
        }
        response.sendRedirect("question?q_id=" + q_id);
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

    private String voteQuestion(int qId, int uId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        return port.voteQuestion(qId, uId);
    }

    private String devoteQuestion(int qId, int uId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        return port.devoteQuestion(qId, uId);
    }

    private String voteAnswer(int aId, int uId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        AnswerWS.AnswerWS port = service_1.getAnswerWSPort();
        return port.voteAnswer(aId, uId);
    }

    private String devoteAnswer(int aId, int uId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        AnswerWS.AnswerWS port = service_1.getAnswerWSPort();
        return port.devoteAnswer(aId, uId);
    }

}
