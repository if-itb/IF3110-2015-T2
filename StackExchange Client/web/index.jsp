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
        <h1>Hello World!</h1>    
       
        
        <%-- start web service invocation --%><hr/>
    <%
    java.util.List<Answer> result = new ArrayList<Answer>();
    int i = 10;
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int qid = 9;
	// TODO process result here
	result = port.getAnswerByQid(9);
        out.println("Halo");
        out.println(result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    
    <% for(Answer answer : result) { %>
        <p><%= answer.getContent() %></p>
    <% } %>
    
    <%= i %>
    <%-- end web service invocation --%><hr/>

    </body>   
    

</html>
