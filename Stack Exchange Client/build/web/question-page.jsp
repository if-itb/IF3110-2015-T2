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
        <script src="script.js"></script>
        <title>Simple Stack Exchage</title>
    </head>

    <body>
    <div id="edit-delete" style="text-align:right">
            <c:choose>
                <c:when test="${token.length()==0}">
                    <p>
                        <c:out value="Logged in as"/> 
                        <b><c:out value="guest"/></b> | 
                        <a href="login.jsp" style="color:#FFA500"> Log in </a> | 
                        <a href="register.jsp" style="color:#FF0000"> Register </a> 
                    </p>
                </c:when>
                <c:otherwise>
                    <p>
                        <c:out value="Logged in as"/> 
                        <b><c:out value="${token}"/></b> | 
                        <a href="http://localhost:8082/Stack_Exchange_IS/Logout" style="color:#FFA500"> Log out </a> | 
                        <a href="register.jsp" style="color:#FF0000"> Register </a> 
                    </p>
                </c:otherwise>
            </c:choose>
        </div>
        <div id="header">
	<h1> <a href ="/Stack_Exchange_Client/QuestionServlet" style="color:#000"> Simple Stack Exchange </a> </h1>
    </div>
    
    <div class = "container">
	<div class="boxarea">
		<h2><c:out value="${question.topic}"/><hr></h2>
	
		<div class="vote">
                    <a href="/Stack_Exchange_Client/VoteQuestion?qid=${question.id}&flag=1">
                        <div class="arrow-up"></div>
                    </a>
                    <h3> <div id="question-vote"><c:out value="${question.vote}"/></div></h3>
                     <a href="/Stack_Exchange_Client/VoteQuestion?qid=${question.id}&flag=-1">
                        <div class="arrow-down"></div>
                    </a>
		</div>

		<div class="question-page-content">
			<p><c:out value="${question.content}"/></p>
		</div>

		<div class="edit-delete">
			<p> asked by <b><c:out value="${question.username}"/></b><br>
				email at <c:out value="${question.date}"/> | <a href="/Stack_Exchange_Client/GetQuestion?qid=${question.id}" style="color:#FFA500"> edit </a> | <a href="#" onclick="validateDelete(${question.id})" style="color:#FF0000"> delete </a> </p>
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
			<a href="/Stack_Exchange_Client/VoteAnswer?qid=${question.id}&flag=1&aid=${answer.id}">
                            <div class="arrow-up"></div>
                        </a>
			<h3> <div id="answer-vote-${answer.id}"><c:out value="${answer.vote}"/></div> </h3>
			<a href="/Stack_Exchange_Client/VoteAnswer?qid=${question.id}&flag=-1&aid=${answer.id}">
                            <div class="arrow-down"></div>
                        </a>
                    </div>

                    <div class="question-page-content">
                        <p><c:out value="${answer.content}"/></p>
                    </div>

                    <div class="edit-delete">
                        <p><c:out value="answer by"/>
                            <b><c:out value="${answer.username}"/></b>
                            <c:out value="at ${answer.date} "/>
                        </p>
                    </div>
		</div>
		<br><hr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
	
        <c:if test="${token.length() != 0}">
            <h3> Your Answer </h3>
            <form method="POST" name="Form" action="/Stack_Exchange_Client/AddAnswer?qid=${question.id}">
                    <textarea name="answer_content" id="answer_content" rows="15" placeholder="Content"></textarea>
                    <br>
                    <input type="submit" id="submit_answer" name="submit_answer" value="Post">
            </form>
        </c:if>
        

</div>
    </body>
</html>
