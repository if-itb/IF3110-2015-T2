<%-- 
    Document   : deleteQuestionProcess
    Created on : Nov 24, 2015, 5:56:48 AM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Question Process</title>
    </head>
    <body>
        
            <%-- start web service invocation --%><hr/>
    <%
  
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	int questionId = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	java.lang.Boolean result = port.deleteQuestion(questionId);
	if (result){
            out.println("question deleted");
        } else{
            out.println("failed to delete question");
        }
        
    String site = new String("index.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
  

    %>
    <%-- end web service invocation --%><hr/>

        
        
        
        
        
    </body>
</html>
