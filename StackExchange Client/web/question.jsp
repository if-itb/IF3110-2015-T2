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
                  <%
                  try {
                      questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
                      questionWS.QuestionWebService port = service.getQuestionWebServicePort();
                       // TODO initialize WS operation arguments here
                      int id = Integer.parseInt(request.getParameter("id"));
                      // TODO process result here
                      questionWS.Question result = port.getQuestionById(id);
                      out.println(result.getContent());
                  %>
    
  
			<div class="row">
				<div class= "vote col">
                                    
						<img src="img/upvote.png" width ="30" height="30">



					<span id="question-vote-count-"> </span>
					
						<img src="img/downvote.png" width="30" height="30">
					
				</div>
                            </a>
				<div class = "col-content">
					<p>
						
					</p>
			</div>
	</div>
	<div class = "row-info">
		asked by <span class="name"> <%= result.getAskerName()%></span>
                <%
                                } catch (Exception ex) {
                      // TODO handle custom exceptions here
                  }
                  %>
                  <hr>
                  <hr>
    <%
    try {
	answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
	answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
	 // TODO initialize WS operation arguments here
	int qid = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	java.util.List<answerWebService.Answer> result = port.getAnswerByQid(qid);
	for(int i=0; i<result.size(); i++ ){
          
        
    %>
	<div class="section" id="answers">
              <%out.println(result.get(i).getContent());%>
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
<% } } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>		
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
