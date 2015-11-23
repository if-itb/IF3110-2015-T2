<%-- 
    Document   : voteDownAns
    Created on : Nov 23, 2015, 8:38:37 AM
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
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.wbd.ans.AnswerWS_Service service = new com.wbd.ans.AnswerWS_Service();
	com.wbd.ans.AnswerWS port = service.getAnswerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = "";
	java.lang.String ansid = request.getParameter("ansid");
	// TODO process result here
	int result = port.voteDown(accessToken, ansid);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    String site = "question.jsp?id=" + request.getParameter("id") + "&token=" + request.getParameter("token");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
