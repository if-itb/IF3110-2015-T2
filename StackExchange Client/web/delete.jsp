<%-- 
    Document   : delete
    Created on : Nov 18, 2015, 5:10:32 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    try {
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = "";
	int qid = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	int result = port.deleteQ(accessToken, qid);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    String site = "index.jsp";
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    %>

        
    </body>
</html>
