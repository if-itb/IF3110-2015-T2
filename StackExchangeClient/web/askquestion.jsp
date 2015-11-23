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
            <p style="text-align:right">You're log in as ica <button onclick="window.location.href='index.jsp';">Log out</button></p>
            <h1>Simple StackExchange</h1><br>
            <h2>What's your question? </h2><br>
            <form class="QuestionForm" action="askquestion" method="POST">
		<input type="text" name="topic" id="inputtext1" placeholder="Question Topic"><br>
		<textarea name="content" placeholder="Content"></textarea><br><br>
		<input type="submit" value="Post">
            </form>
	</div>
    </body>
</html>
