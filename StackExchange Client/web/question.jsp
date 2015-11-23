<%-- 
    Document   : question
    Created on : 23-Nov-2015, 13:20:51
    Author     : KEVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head> 
	<meta charset="UTF-8">
	<title>Simple StackExchange </title>
	<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
</head>

<body>
	<div id="wrapper">
		<h1 class = "center">Simple StackExchange
</h1>


<div id= "question_page">
	<div class="section">
		<h2 class="underlined">  </h2>
		<div class="question" id="question-">
			<div class="row">
				<div class= "vote col">
                                    <a href=     "<%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int arg0 = 0;
	// TODO process result here
	java.lang.String result = port.incrVote(arg0);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>" >
						<img src="img/upvote.png" width ="30" height="30">
					    <%-- start web service invocation --%><hr/>
                                    </a>

    <%-- end web service invocation --%><hr/>

					<span id="question-vote-count-"> </span>
					<a href= "    <%-- start web service invocation --%><hr/>
    <%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int arg0 = 0;
	// TODO process result here
	java.lang.String result = port.decrVote(arg0);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
 " >
						<img src="img/downvote.png" width="30" height="30">
					
				</div>
                            </a>
				<div class = "col-content">
					<p>
						
					</p>
			</div>
	</div>
	<div class = "row-info">
		asked by <span class="name"></span> &lt; <span class="email">  
                </span>
	<div class="section" id="answers">
		<h2 class="underline"></h2>
		
			<div class="answer underline" id="answer-">
				<div class="row">
					<div class="col vote">
						
							<img src="img/upvote.png" width="35" height="35">
					
						<span id="answer-vote-count-"></span>
						
							<img src="img/downvote.png" width="35" height="35">
						
					</div>
					<div class="col content">
						<p>
							
						</p>
					</div>
				</div>
				<div class="row info">
					answered by <span class="name"></span> &lt;<span class="email">&gt;</span>
					at <span class="create-date"></span>
				</div>
			</div>
		
	</div>

	<div class="section" id="form-answer">
		<h2>Your Answer</h2>
		<form class="block" action="question.php?id=" method="POST" onsubmit="return validateAnswerForm(this);">
			<input type="text" placeholder="Name" name="name" />
			<input type="text" placeholder="Email" name="email" />
			<textarea name="content" placeholder="Content"></textarea>
			<input type="submit" value="Post" />
			<input type="hidden" name="type" value="answer" />
			<input type="hidden" name="question_id" value="" />
		</form>
	</div>	
</div>	

	</div>
 </body>
 </html>
