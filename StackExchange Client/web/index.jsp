<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
        <link rel="stylesheet" type="text/css" href="style.css">
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
                <c:forEach var="question" items="${questions}">
                    <div class="question-block">
                        <div class="q-votes">${question.vote}<br>Votes</div>
                        <div class="q-answers">0<br>Answers</div>
                        <div class="q-topic-content">
                            <div class="q-topic"><a href="view.jsp?id=1">${question.topic}</a></div>
                            <div class="q-content">${question.content}</div>
                        </div>
                        <div class="details">asked by <span class="name">name (email)</span> | <a class="edit" href="edit.jsp?id=1">edit</a> | <a class="delete" href="delete.php?id=1" onclick="return confirm('Are you sure you want delete this question?')">delete</a></span></div>    
                    </div>
                    <hr>
                </c:forEach>
        </div>
    </body>
</html>
