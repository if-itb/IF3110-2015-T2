<%-- 
    Document   : question
    Created on : Nov 16, 2015, 1:47:03 AM
    Author     : vanyadeasysafrina
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
<jsp:useBean id="question" type="QuestionWS.Question" scope="request"/>
<jsp:useBean id="answers" type="java.util.List<AnswerWS.Answer>" scope="request"/>
	<div class="container">
            <h2><a href="question?q_id=<%= question.getQId() %>" class="question-title-big">
                   <%= question.getTopic() %>
            </a></h2>
            <hr>
            <span id="question-vote"><br>
                <div onclick="location.href='vote?id=<%= question.getQId() %>&type=q&vote=1';" class="arrow-up">
                </div><br>
                <span id="questvote" class="question-number"><%= question.getVote()%></span><br>
                <br>
		<div onclick="location.href='vote?id=<%= question.getQId() %>&type=q&vote=-1';" class="arrow-down">
                </div><br></span>
		<span id="question-content">
                    <%= question.getContent().replace("\n", "<br>") %>
                    <br><br><br>
                    <span class="question-info">asked by <span class="author">
                            <%= question.getEmail() %>
                    </span> at <%= question.getDateCreated()%> |
                    <% if (question.getDateEdited()!=null) { %>
                            <%= " edited at " + question.getDateEdited() + " " %>
                    <% } %>
                    <a href="edit?q_id=<%= question.getQId() %>" class="edit-question"> edit</a> | 
                    <a href="delete?q_id=<%= question.getQId() %>" 
                       class="delete-question" onclick="return deleteConfirmation(<%= question.getQId() %>)">
                        delete
                    </a><br></span>
                </span>
                <br><br><br>
		<h2><%= question.getAnswer() %> Answer(s)</h2><hr>
		<br><br>
                <%
		if (question.getAnswer()==0) { %>
			No answer.
                        <br><br><br><hr><br>
                <%
                }
		for(int i = 0; i < question.getAnswer(); i++) { %>
                    <span id="question-vote"><br>
                        <div onclick="location.href='vote?id=<%= question.getQId() %>&type=a&vote=1';" class="arrow-up">
                        </div><br>
			<span id="ansvote-<%= answers.get(i).getAId() %>" class="question-number">
                            <%= answers.get(i).getVote() %></span><br>
                        <br>
                        <div onclick="location.href='vote?id=<%= question.getQId() %>&type=a&vote=-1';" class="arrow-down"></div>
                        <br>
                    </span>
                    <span id="question-content">
                        <%= answers.get(i).getContent().replace("\n", "<br>") %>
			<br><br><br>
			<span class="question-info">answered by
                            <span class="author">
                                <%= answers.get(i).getEmail() %>
                            </span>
                            at <%= answers.get(i).getDateCreated() %>
                        </span>
                    </span>
                    <br><br><hr>
                <% } %>
                
                
		<div class="center">
			<form class="basic-grey" name= "answer" action="answer" onsubmit="return validateAnswerForm()" method="post">
				<input type="hidden" name="q_id" value="<%= question.getQId() %>">
				<textarea id="content" name="content" placeholder="Content" ></textarea><br>
				<div class="div-right-button">
					<input type="submit" class="right-button" value="Post">
				</div>
			</form>
		</div>
	</div>

<script src="assets/js/confirmation.js"></script>
<script src="assets/js/validation.js"></script>
<script src="assets/js/script.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>