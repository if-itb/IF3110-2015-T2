<%-- 
    Document   : new
    Created on : Nov 19, 2015, 4:10:35 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
	<link rel="stylesheet" href="css/style.css" />
	<script src="js/validation.js"></script>
    </head>
    <body>
        <a href="index.php"><h1>Simple StackExchange</h1></a><br>

	<div class="list">
	<div class="title">What's your question?</div>
	<hr></hr>
	<form name="new" method="post" action="backend/add_question.php">
		<input class="inputform" type="text" name="name" placeholder="Name"><br>
		<input class="inputform" type="text" name="email" placeholder="Email"><br>
		<input class="inputform" type="text" name="topic" placeholder="Question Topic"><br>
		<textarea class="inputform" name="content" placeholder="Content" rows="5"></textarea><br>
		<input type="submit" class="button" value="Post" onclick="return validateFormNew()">
	</form>
	</div>
    </body>
</html>
