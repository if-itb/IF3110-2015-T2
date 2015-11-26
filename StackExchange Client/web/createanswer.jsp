<%-- 
    Document   : createanswer
    Created on : Nov 26, 2015, 2:00:40 PM
    Author     : acel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	java.lang.String arg0 = request.getParameter("token");
        int arg1 = Integer.parseInt(request.getParameter("qid"));
	java.lang.String arg2 = request.getParameter("name");
	java.lang.String arg3 = request.getParameter("email");
	java.lang.String arg4 = request.getParameter("content");
        int arg5 = Integer.parseInt(request.getParameter("id"));
	java.lang.String result = port.addAnswer(arg0, arg1, arg2, arg3, arg4, arg5);
        out.println(result);
    } catch (Exception ex) {
        
    }
    response.sendRedirect("http://localhost:8080/StackExchange_Client/question.jsp?token=" + request.getParameter("token")
                                        + "&id=" + request.getParameter("id") + "&qid=" + request.getParameter("qid"));
    %>
