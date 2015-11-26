<%-- 
    Document   : createanswer
    Created on : Nov 26, 2015, 2:00:40 PM
    Author     : acel
--%>

<%@page import="userWebService.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	userWebService.UserWebService_Service userService = new userWebService.UserWebService_Service();
        userWebService.UserWebService userPort = userService.getUserWebServicePort();
        java.lang.String token = request.getParameter("token");
        int qid = Integer.parseInt(request.getParameter("qid"));
	java.lang.String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userPort.getUser(id);
	java.lang.String result = port.addAnswer(token, qid, user.getName(), user.getEmail(), content, id);
        out.println(result);
    } catch (Exception ex) {
        out.println("gagal");
    }
    response.sendRedirect("question.jsp?token=" + request.getParameter("token")
                                        + "&id=" + request.getParameter("id") + "&qid=" + request.getParameter("qid"));
    %>
