<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@ include file="style.css"%>
        </style>
        <title>Stack Exchange</title>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1><br>
            <h2>What's your question? </h2><br>
            <form class="QuestionForm" method="POST">
		<input type="text" name="name" id="inputtext1" placeholder="Name"><br>
		<input type="text" name="email" id="inputtext1" placeholder="Email"><br>
		<input type="text" name="topic" id="inputtext1" placeholder="Question Topic"><br>
		<textarea name="content" placeholder="Content"></textarea><br><br>
		<input type="submit" value="Post">
            </form>
	</div>
    </body>
</html>
