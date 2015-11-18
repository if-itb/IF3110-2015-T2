<%-- 
    Document   : index
    Created on : Nov 18, 2015, 1:51:38 PM
    Author     : Asanilta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="questions" type="java.util.List<QuestionWS.Question>" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Dosis:500' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1>
            <form action="Search.jsp"><!--ini filenya belum ada-->
		<input class="searchBox" type="text" name="questions">
		<input type="submit" class="submitButton" value="Search">
            </form>
            <p>
		Cannot find what you are looking for? <a href="ask.jsp">Ask here</a>
		<br>
		<br>
            </p>
            <div class="raqtitle left"><h3>Recently Asked Question</h3></div>
        
        <hr>
        
        <% for (QuestionWS.Question question : questions) { %>
                <div class="question-block">
                    <div class="q-votes"><%= question.getVote() %><br>Votes</div>
                    <div class="q-answers">0<br>Answers</div>
                    <div class="q-topic-content">
                        <div class="q-topic"><a href="view.jsp?id=<%= question.getQuestionId() %>"><%= question.getTopic() %></a></div>
                        <div class="q-content"><%= question.getContent() %></div>
                    </div>
                    <div class="details">asked by <span class="name">name (email)</span> | <a class="edit" href="edit.jsp?id=<%= question.getQuestionId() %>">edit</a> | <a class="delete" href="delete.php?id=<%= question.getQuestionId() %>" onclick="return confirm('Are you sure you want delete this question?')">delete</a></span></div>    
                </div>
                <hr>
        <% } %>
    </div>
</body>
</html>
