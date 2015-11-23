<%-- 
    Document   : editQuestionProcess
    Created on : Nov 24, 2015, 5:11:16 AM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Question Process</title>
    </head>
   
    
    
    <body>
        
        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	int questionId = Integer.parseInt(request.getParameter("questionId"));
	java.lang.String questionTitle = request.getParameter("questionTopic");
	java.lang.String questionContent = request.getParameter("questionContent");
	// TODO process result here
	java.lang.Boolean result = port.updateQuestion(questionId, questionTitle, questionContent);
	if (result){
            out.println("question added");
        } else{
            out.println("failed to add question");
        }
        
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    String site = new String("index.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    %>
    <%-- end web service invocation --%><hr/>

        
        
        
    </body>
    
    
    
    
</html>
