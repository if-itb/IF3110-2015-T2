<%-- 
    Document   : ask-question
    Created on : Nov 15, 2015, 10:18:19 PM
    Author     : zulvafachrina
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
		<p> Logged in as <b><c:out value="guest"/></b> | <a href="login.jsp" style="color:#FFA500"> Log in </a> | <a href="register.jsp" style="color:#FF0000"> Register </a> </p>
        </div>
        <div id="header">
            <h1> <a href ="/Stack_Exchange_Client/QuestionServlet" style="color:#000"> Simple Stack Exchange </a> </h1>
        </div>
       <div class = "container">
		<h2> What's Your Question? <hr> </h2>
		<form method="POST" name="Form" action="/Stack_Exchange_Client/AddQuestion" onsubmit="return validateFormQuestion()">
			<input type="text" name="question_topic" id="question_topic" placeholder="Question Topic">
			<br>
			<textarea name="question_content" id="question_content" rows="15" placeholder="Content"></textarea>
			<br>
			<input type="submit" id="submit_question" name="submit_question" value="Post">
		</form>
	</div>
    </body>
</html>
