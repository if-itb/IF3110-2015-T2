<%-- 
    Document   : index
    Created on : Nov 18, 2015, 1:51:38 PM
    Author     : Asanilta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="questions" type="java.util.List<model.question.Question>" scope="request"/>
<jsp:useBean id="users" type="java.util.Map<Integer,model.user.User>" scope="request"/>
<jsp:useBean id="answers" type="java.util.Map<Integer,Integer>" scope="request"/>
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
        
        <% for (model.question.Question question : questions) { %>
                <div class="raq question-block">
                    <div class="votepart">
                        <div class="votenumber"><%= question.getVote() %></div>
                        <div class="votetext">Votes</div>
                    </div>
                    <% int answerCount = answers.get(question.getUserId()); %>
                    <div class="answerpart">
                        <div class="answernumber"><%= answerCount %></div>
                        <div class="answertext">Answers</div>
                    </div>
                    <div class="questionpart">
                        <% String topic = question.getTopic(); if (topic.length() > 153) topic = topic.substring(0,150)+ "..."; %>
                        <div class="qtopic"><a href="view?id=<%= question.getQuestionId() %>"><%= topic %></a></div>
                        <% String content = question.getContent();if (content.length() > 503) content = content.substring(0,500)+"..."; %>
                        <div class="qcontent"><%= content %></div>
                    </div>
                    <% model.user.User user = users.get(question.getUserId()); %>
                    <div class="details">
                        asked by
                        <span class="name"><%= user.getName() %> (<%= user.getEmail() %>)</span><a class="edit" href="edit?id=<%= question.getQuestionId() %>">edit</a><a class="delete" href="delete?id=<%= question.getQuestionId() %>" onclick="return confirm('Are you sure you want delete this question?')">delete</a></div>    
                </div>
        <% } %>
    </div>
</body>
</html>
