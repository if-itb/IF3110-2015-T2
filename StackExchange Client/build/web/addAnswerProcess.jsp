<%-- 
    Document   : addAnswerProcess
    Created on : Nov 24, 2015, 8:37:45 PM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Answer to Particular Question </title>
    </head>
    <body>

        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	int questionId = Integer.parseInt(request.getParameter("questionId"));
	java.lang.String questionContent = request.getParameter("answerContent");
	int userID = 1;
	// TODO process result here
	java.lang.Boolean result = port.addAnswer(questionId, questionContent, userID);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

        
        
    
    
    
        
        
        
        
        
        
        
    </body>
</html>
