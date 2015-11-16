<%-- 
    Document   : ask
    Created on : Nov 16, 2015, 11:23:02 PM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <title>Simple StackExchange</title>
    </head>
    <body>
	<div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
	<br>
	<br>
	<br>
	<br>
	<div class="subtitle">What's your question?</div>
	<hr class='line'>
        <form name="askForm" action="askpost.php" onsubmit="return validateQuestion()" method="post">
	    <input value="question_id lama" type="hidden" name="question_id">
            <input value="name lama" type="text" class='form-text' name="name" placeholder="Name"><br>
            <input value="email lama" type="text" class='form-text' name="email" placeholder="Email"><br>
            <input value="topic lama" type="text" class='form-text' name="topic" placeholder="Question Topic"><br>
            <textarea name="content lama" class='form-textarea' placeholder="Content"> content lama </textarea><br>
            <button class='button-post' type='submit'> Post </button>
	</form>
    </body>
</html>



