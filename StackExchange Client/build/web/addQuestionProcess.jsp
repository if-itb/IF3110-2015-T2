<%-- 
    Document   : addQuestionProcess
    Created on : Nov 23, 2015, 10:20:17 PM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add Question Processing</title>
    </head>
    
    <body>
         <%-- start web service invocation --%><hr/>
    <%
    try {
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String questionTitle = request.getParameter("questionTopic");
	java.lang.String questionContent = request.getParameter("questionContent");
	int userID = 10;
	// TODO process result here
	java.lang.Boolean result = port.addQuestion(questionTitle, questionContent, userID);
	if (result){
            out.println("question added");
        } else{
            out.println("failed to add question");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    
    %>
    <%-- end web service invocation --%><hr/>


    <%--String site = new String("index.jsp"); 
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);--%>

       
        
    </body>
</html>
