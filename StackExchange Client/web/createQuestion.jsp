<%-- 
    Document   : createQuestion
    Created on : Nov 25, 2015, 9:26:47 AM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
    </head>
    <body>        
    <%
    try {
        out.println("Hello World");
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
        java.lang.String accessToken = request.getParameter("token");
	java.lang.String title = request.getParameter("topic");
	java.lang.String content = request.getParameter("content");
        out.println("Hello World2");
	// TODO process result here
	int result = port.createQ(accessToken, title, content);
        out.println(result);
	if (result == 1){
            String site = "index.jsp";
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        } else {
            String site = "login.jsp";
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    </body>
</html>
