<%-- 
    Document   : insertquestion
    Created on : Nov 18, 2015, 2:01:07 PM
    Author     : yoga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     
   
    try {
	questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
	questionmodel.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = request.getParameter("name");
	java.lang.String email = request.getParameter("email");
	java.lang.String topic = request.getParameter("topic");
	java.lang.String content = request.getParameter("content");
	// TODO process result here
	int result = port.insertQuestion(name, email, topic, content);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }

    String site = "index1.jsp" ;
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
