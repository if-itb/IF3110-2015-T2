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
                <div onclick="vote(<%= question.getQId() %>,'question','up')" class="arrow-up">
                </div><br>
                <span id="questvote" class="question-number"><%= question.getVote()%></span>
                <br><br>
		<div onclick="vote(<%= question.getQId() %>,'question','down')" class="arrow-down">
                </div><br></span>
		<span id="question-content">
                    <%= question.getContent().replace("\n", "<br>") %>
                    <br><br><br>
                    <span class="question-info">asked by <span class="author">
                            <%= question.getUsername() %>
                    </span> at <%= question.getDateCreated()%> |
                    <% if (question.getDateEdited()!=null) { %>
                            <%= " edited at " + question.getDateEdited() + " " %>
                    <% } %>
                    <a href="edit?q_id=<%= question.getQId() %>" class="edit-question"> edit</a> | 
                    <!-- TODO --><a href="controllers/delete-question.controller.php/?q_id=<%= question.getQId() %>"
                                    class="delete-question" onclick="return deleteConfirmation(<%= question.getQId() %>)">
                        delete
                    </a><br></span></span>
		</span>
                <br><br><br>
		<h2><%= question.getCountAnswer() %> Answers</h2><hr>
		<br><br>
                <%
		if (question.getCountAnswer()==0) { %>
			No answer.
                        <br><br><br><hr><br>
                <%
                }
		for(int i = 0; i < question.getCountAnswer(); i++) { %>
                    <span id="question-vote"><br>
                        <div onclick="vote(<%= answers.get(i).getaId() %>,'answer','up')" class="arrow-up">
                        </div><br>
			<span id="ansvote-<%= answers.get(i).getaId() %>" class="question-number">
                            <%= answers.get(i).getVote() %>
                        </span>
                        <br><br>
                        <div onclick="vote(<%= answers.get(i).getaId() %>,'answer','down')" class="arrow-down"></div>
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
			<form class="basic-grey" name= "answer" action="controllers/answer.controller.php" onsubmit="return validateAnswerForm()" method="post">
				<input type="hidden" name="q_id" value="<?php echo $id ?>">
				<input type="text" id="name" name="name" placeholder="Name"><br>
				<input type="text" id="email" name="email" placeholder="Email"><br>
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