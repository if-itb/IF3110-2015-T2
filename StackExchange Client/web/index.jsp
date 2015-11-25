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
	<title>Simple StackExchange </title>
	<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
    </head>
    <body>
	<div id="wrapper">
		<h1 class = "center">  Simple StackExchange
</h1>

<div id="main-page" onload="function() {document.getElementById('autofocus').focus();}">


	<div class="questions">
		<h3>Recently Asked Questions</h3>
<%
    try {
	questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
	questionWS.QuestionWebService port = service.getQuestionWebServicePort();
	// TODO process result here
	java.util.List<questionWS.Question> result = port.getAllQuestion();

        for (int i=0 ; i < result.size(); i++){
            
        int id = result.get(i).getQuestionId();
        String s = String.valueOf(id);
    %>
    						<div class="col title">
                                                <a href="question.jsp?id=<%= s %>"><% out.println(result.get(i).getTopic());%></a>
						</div>
		<%out.println(result.get(i).getContent());%>
                       <div class="question">

    
					<div class="row">
						<div class="col vote in-numbers">
							<div class="number"></div>
							<div class="flag">Votes</div>
						</div>
						<div class="col answers in-numbers">
							<div class="number"></div>
							<div class="flag">Answers
                                                           

                                                        </div>
						</div>

					</div>
					<div class="row">
						<div class="controls" align="right">
                                                  asked by <span class="name"> <% out.println(result.get(i).getAskerName()); %>|
							<span class="link edit"> edit </span> |
							<span class="link delete"> delete </span>
						</div>
					</div>
			</div>
	</div>
   

 <% } } catch (Exception ex) {
	// TODO handle custom exceptions here
    }%>
	</div>
</div>

    </body>   
    

</html>
