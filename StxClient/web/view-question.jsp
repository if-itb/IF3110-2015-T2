<%-- 
    Document   : view-question
    Created on : Nov 17, 2015, Nov 17, 2015 8:06:32 AM
    Author     : Fikri-PC
--%>

<%@page import="Question.QuestionWS"%>
<%@page import="Question.QuestionWS_Service"%>
<%@page import="Question.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="include/header.jsp" %>
<%
    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
%>
<div id="view-qeustion-page">
<!-- pertanyaan-->
    <%
	QuestionWS_Service service = new QuestionWS_Service();
	QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	
	// TODO process result here
	Question Q = port.getQuestionById(id);
    %>
	<div class="section">	
		<h2><% out.print(Q.getTopic());%></h2>
		<div class="row">
			<div class="col vote">
				<div class = "vote-btn">
				<button type="button" onclick=""><i class="fa fa-chevron-up"></i></button>
				<p class = "number-vote" id=""><% out.print(Q.getVote());%></p>
				<button type="button" onclick=""><i class="fa fa-chevron-down"></i></button>
				</div>
			</div>
			<div class="col content">
				<p><% out.print(Q.getContent());%></p>
				<br>
			</div>
		</div>
		<div class = "row info" align = "right">
			Ditanyakan oleh <span class="name"><% out.print(Q.getName());%></span> |
			<span class="link edit"> <a href= "question.jsp?id=<%out.print(id);%>">Edit</a> </span> | 
			<span class="link delete"> <a href= "javascript:delete_question(<% out.print(id);%>)" >Delete</a></span>
		</div>
		<br>
	</div>
<!-- Jawaban --> 
	<div class="section" id="answers">
		<%
                try {
                    QuestionWS_Service service1 = new QuestionWS_Service();
                    QuestionWS port1 = service1.getQuestionWSPort();
                     // TODO initialize WS operation arguments here
                    
                    // TODO process result here
                    int result1 = port1.getNumAnswer(id);
                    out.println("<h2>"+result1+ " Jawaban </h2>");
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
                %>
                    <%-- start web service invocation --%><hr/>
                <%
                    Answer.AnswerWS_Service service2 = new Answer.AnswerWS_Service();
                    Answer.AnswerWS port2 = service2.getAnswerWSPort();
                     // TODO initialize WS operation arguments here
                    int qId = id;
                    // TODO process result here
                    java.util.List<Answer.Answer> result2 = port2.getAnswers(qId);
                   
                %>
                <%-- end web service invocation --%><hr/>
                <%
                    for(Answer.Answer Ans : result2) {
                %>
                    <div class = "row">
				<div class = "col vote">
					<button type="button" id = "vote-btn" onclick=""><i class="fa fa-chevron-up"></i></button>
					<p class = "number-vote" id=""><% out.print(Ans.getAnsVote());%></p>
					<button type="button" id = "vote-btn" onclick=""><i class="fa fa-chevron-down"></i></button>
				</div>
				<div class = "col content">
					<p> <% out.print(Ans.getAnsContent());%></p>
					<br>
				</div>
				<div class = "row info" align = "right">

					<p>Dijawab oleh <span class = "name"><% out.print(Ans.getAnsEmail());%></span> </p>

				</div>
				<hr>
			</div>
		<% } %>
	</div>

<!-- Form untuk menjawab-->
	<div class="section" id="form-answer">
		<h2>Beri jawaban :</h2>
		<form class = "block" action = 'actions/post-answer.jsp?id=<% out.print(id);%>' name = "myForm" method = 'POST' onsubmit = "return(validateAnswer());">
			<ul>
				<input type = 'text' name = 'Nama' placeholder="Nama" maxlength = '60'></input>
				<input type = 'text' name = 'Email' placeholder="Email"  maxlength = '60'></input>
				<textarea rows = '100' cols = '100' placeholder="Jawaban" name = 'Jawaban'></textarea>
				<input type = 'submit' value = "Kirim"></input>
			</ul>
		</form>
	</div>
                        <%
	//<?php mysql_close($link); ?>
                %>
	</div>
</div>

<%@include file="include/footer.jsp" %>
