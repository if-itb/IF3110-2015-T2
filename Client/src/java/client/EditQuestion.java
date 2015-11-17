/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import service.Exception_Exception;
import service.StackExchangeService_Service;


@WebServlet(name = "editQuestion", urlPatterns = {"/editQuestion"})
public class EditQuestion extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/StackExchangeService/StackExchangeService.wsdl")
    private StackExchangeService_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception_Exception {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookies[] = request.getCookies();
        String token = null;
	String username = null;
        Long expirationDate = null;
        for (Cookie cookie : cookies) {
            if ("expirationDate".equals(cookie.getName())) {
                expirationDate = Long.parseLong(cookie.getValue());
            }
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
	    if("username".equals(cookie.getName())){
		username = cookie.getValue();
	    }
        }
        if (token != null && expirationDate != null) {
        
            String status = editQuestion(
                                Integer.parseInt(request.getParameter("idEdited")),
                                username,
				request.getParameter("qtopic"),
                                request.getParameter("qcontent"),
                                token,
                                expirationDate
                            );

            if("1".equals(request.getParameter("fromDetail"))){
                response.sendRedirect("detail?idDetail="+ request.getParameter("idEdited"));
            }
            else {
                response.sendRedirect("Home");
            }
        }
        else {
            response.sendRedirect("Home");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception_Exception ex) {
            Logger.getLogger(EditQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception_Exception ex) {
            Logger.getLogger(EditQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String editQuestion(int qid, java.lang.String name, java.lang.String qtopic, java.lang.String qcontent, java.lang.String token, long expirationDate) throws Exception_Exception {
	// Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
	// If the calling of port operations may lead to race condition some synchronization is required.
	service.StackExchangeService port = service.getStackExchangeServicePort();
	return port.editQuestion(qid, name, qtopic, qcontent, token, expirationDate);
    }

}
