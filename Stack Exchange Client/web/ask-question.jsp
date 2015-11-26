<%-- 
    Document   : ask-question
    Created on : Nov 15, 2015, 10:18:19 PM
    Author     : zulvafachrina
--%>

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
    
    <body>
       <div class = "container">
		<h2> What's Your Question? <hr> </h2>
		<form method="POST" name="Form" action="question-page.jsp" onsubmit="return validateFormQuestion()">
			<input type="text" name="question_name" id="question_name" placeholder="Name">
			<br>
			<input type="text" name="question_email" id="question_email" placeholder="Email">
			<br> 
			<input type="text" name="question_topic" id="question_topic" placeholder="Question Topic">
			<br>
			<textarea name="question_content" id="question_content" rows="15" placeholder="Content"></textarea>
			<br>
			<input type="submit" id="submit_question" name="submit_question" value="Post">
		</form>
	</div>
    </body>
</html>
