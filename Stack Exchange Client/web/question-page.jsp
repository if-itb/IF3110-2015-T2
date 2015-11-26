<%-- 
    Document   : question-page
    Created on : Nov 16, 2015, 12:04:50 AM
    Author     : zulvafachrina
--%>

<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" href="style.css" type="text/css">
        <title>Simple Stack Exchage</title>
    </head>
    <div id="header">
	<h1> <a href ="/Stack_Exchange_Client/QuestionServlet" style="color:#000"> Simple Stack Exchange </a> </h1>
    </div>
    
    <div class = "container">
	<div class="boxarea">
		<h2><c:out value="${question.topic}"/><hr></h2>
	
		<div class="vote">
			<div class="arrow-up"></div>
			<h3> <div id="question-vote"><c:out value="${question.vote}"/></div></h3>
			<div class="arrow-down" ></div>
		</div>

		<div class="question-page-content">
			<p><c:out value="${question.content}"/></p>
		</div>

		<div class="edit-delete">
			<p> asked by <b><c:out value="${question.userId}"/></b><br>
				email at <c:out value="${question.date}"/> | <a href="#" style="color:#FFA500"> edit </a> | <a href="#" style="color:#FF0000"> delete </a> </p>
		</div>
	</div>

	<br>
        
        <c:set var="count" value="${countAnswer}"/>
        <c:choose>
            <c:when test="${count == 0}">
                <h2><c:out value="0 Answer"/><hr></h2>
            </c:when>
            <c:otherwise>
                <h2><c:out value="${count} Answers"/><hr></h2>
                <c:forEach var="answer" items="${answers}">
                <div class="boxarea">
                    <div class="vote">
			<div class="arrow-up"></div>
			<h3> <div id="answer-vote-${answer.id}"><c:out value="${answer.vote}"/></div> </h3>
			<div class="arrow-down"></div>
                    </div>

                    <div class="question-page-content">
                        <p><c:out value="${answer.content}"/></p>
                    </div>

                    <div class="edit-delete">
                        <p><c:out value="answer by"/>
                            <b><c:out value="${answer.userId}"/></b><br>
                            <c:out value="${answer.userId} at ${answer.date} "/>
                        </p>
                    </div>
		</div>
		<br><hr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
	
        <h3> Your Answer </h3>
	<form method="POST" name="Form" action="/Stack_Exchange_Client/AddAnswer?qid=${question.id}">
		<textarea name="answer_content" id="answer_content" rows="15" placeholder="Content"></textarea>
		<br>
		<input type="submit" id="submit_answer" name="submit_answer" value="Post">
	</form>

</div>
</html>
