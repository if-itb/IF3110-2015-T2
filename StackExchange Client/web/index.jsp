<%-- 
    Document   : index
    Created on : Nov 20, 2015, 10:57:36 PM
    Author     : William Sentosa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="answerWebService.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>     <%-- start web service invocation --%><hr/>
    
        <%-- start web service invocation --%><hr/>
    <%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int qid = 9;
	// TODO process result here
	java.util.List<answerWebService.Answer> result = port.getAnswerByQid(qid);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
    <%-- start web service invocation --%><hr/>
    <%
    try {
	questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
	questionWS.QuestionWebService port = service.getQuestionWebServicePort();
	// TODO process result here
	java.util.List<questionWS.Question> result = port.getAllQuestion();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	userWebService.UserWebService_Service service = new userWebService.UserWebService_Service();
	userWebService.UserWebService port = service.getUserWebServicePort();
	// TODO process result here
	java.util.List<userWebService.User> result = port.getAllUser();
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>


    </body>   
    

</html>
