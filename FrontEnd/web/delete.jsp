<%-- 
    Document   : delete
    Created on : Nov 18, 2015, 8:26:13 AM
    Author     : yoga
--%>



<%@page import="java.io.IOException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String token=request.getParameter("token");
    try {
	questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
	questionmodel.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	int id = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	int result = port.deleteQuestion(id);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    String site = "index1.jsp?token=" + token;
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site); 
%>