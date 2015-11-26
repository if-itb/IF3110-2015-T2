<%-- 
    Document   : search
    Created on : Nov 16, 2015, 11:26:12 AM
    Author     : vanyadeasysafrina
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/views/header.jsp" flush="true"/>
<jsp:useBean id="questions" type="java.util.List<QuestionWS.Question>" scope="request"/>
	<div class="container">
            <br>
            <h2>Search: <%=request.getParameter("keyword") %></h2>
            <% for (QuestionWS.Question q : questions) { %>
            <hr>
            <span id="vote"><br>
                <span class="number"><%= q.getVote() %></span><br>
                Votes
            </span>
            <span id="answer"><br>
                <span class="number"><%= q.getAnswer() %></span><br>
                Answers
            </span>
            <span id="question">
                <a href="question?q_id=<%= q.getQId() %>" class="question-title">
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
                    <a href="edit?q_id=<%= q.getQId() %>" class="edit-question">edit</a> | 
                    <a href="delete?q_id=<%= q.getQId() %>" class="delete-question"
                    onclick="return deleteConfirmation(<%= q.getQId() %>)">delete</a>
                   <br>
                </span>
            </span> 
            <% } %>
	</div>
<script src="assets/js/confirmation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>