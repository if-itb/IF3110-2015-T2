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
	<div id="main-search" class="center">
		<form action="index.php" method="GET">
			<input autofocus="autofocus" type="text" name="q" id="search-bar" placeholder="Search question topic or content here..." value="<?php echo $q ?>">
			<input type="submit" value="Search">
		</form>
		<p>Cannot find what you are looking for? <a href="ask.jsp">Ask here</a></p>
	</div>

	<div class="questions">
		<h3>Recently Asked Questions</h3>
<%
    try {
	questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
	questionWS.QuestionWebService port = service.getQuestionWebServicePort();
	// TODO process result here
	java.util.List<questionWS.Question> result = port.getAllQuestion();

        for (int i=0 ; i < result.size(); i++){
            out.println(result.get(i).getContent());
        
    
    %>
			<div class="question">
                                <%-- start web service invocation --%><hr/>
    
    <%-- end web service invocation --%><hr/>
    
					<div class="row">
						<div class="col vote in-numbers">
							<div class="number"></div>
							<div class="flag">Votes</div>
						</div>
						<div class="col answers in-numbers">
							<div class="number"></div>
							<div class="flag">Answers
                                                            <%-- start web service invocation --%><hr/>
    <%
	answerWebService.AnswerWebService_Service service2 = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port2 = service2.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int qid = result.get(i).getQuestionId();
	// TODO process result here
	java.util.List<answerWebService.Answer> result2 = port2.getAnswerByQid(qid);
	for( int j=0; j < result2.size(); j++){
            out.println(result2.get(j).getContent());
        }
    %>
    <%-- end web service invocation --%><hr/>

                                                        </div>
						</div>
						<div class="col title">
                                                <% out.println(result.get(i).getTopic());%>

						</div>
					</div>
					<div class="row">
						<div class="controls" align="right">
							asked by <span class="name">span> |
							<span class="link edit"></span> |
							<span class="link delete"></span>
						</div>
					</div>
			</div>
	</div>
</div>
	</div>
   

 <% } } catch (Exception ex) {
	// TODO handle custom exceptions here
    }%>
    </body>   
    

</html>
