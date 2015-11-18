<%-- 
    Document   : index
    Created on : Nov 15, 2015, 8:43:46 PM
    Author     : Tifani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
<jsp:useBean id="questions" type="java.util.List<controllers.Question>" scope="request"/>
	<div class="container">
		<div class="center">
			<div id="search">
				<form action="search.jsp" method="GET"> <!-- TODO: search.jsp -->
					<fieldset class="clearfix">
						<input type="search" name="search" value="Type your search-keywords here..." 
                                                       placeholder="Type your search-keywords here...">
						<input type="submit" value="Search" class="button">
					</fieldset>
				</form>
			</div>
			<br>
			Cannot find what you are looking for? <a href="ask.jsp">Ask here</a>
		</div>

		<br>
		<h2>Recently Asked Questions</h2>
                    <% for (controllers.Question q : questions) { %>
                        <hr>
			<span id="vote"><br>
                            <span class="number"><%= q.getVote() %></span><br>
                            Votes
                        </span>
			<span id="answer"><br>
                            <span class="number"> 5 <!-- TODO: num answer--></span><br>
                            Answers
                        </span>
			<span id="question">
                            <a href="question.php?q_id= <%= q.getQId() %>" class="question-title">
                                <%= q.getTopic() %>
                            </a><br>
                            <% if (q.getContent().length()>700) { %>
                                <%= (q.getContent().substring(700) + " ...") %>                            
                            <% } else { %>
                                <%= q.getContent() %>
                            <% } %>
                            <br><br>
                            <span class="question-info">
                                asked by <span class="author"><%= q.getName() %></span> | 
                                <a href="edit.php?q_id=<%= q.getName() %>" class="edit-question">edit</a> | 
                                <a href="controllers/delete-question.controller.php/?q_id=<%= q.getQId() %>" class="delete-question"
                                onclick="return deleteConfirmation(<%= q.getQId() %>)">delete</a>
                               <br>
                            </span>
                        </span> 
                        <% } %>
                    
                        
		
			<!-- TODO: <?php showQuestionList()?> -->
                        
                        
		
	</div>
<script src="assets/js/confirmation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>
