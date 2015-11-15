<%-- 
    Document   : question-page
    Created on : Nov 16, 2015, 12:04:50 AM
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
	<h1> <a href ="question-list.jsp" style="color:#000"> Simple Stack Exchange </a> </h1>
    </div>
    
    <div class = "container">
	<div class="boxarea">
		<h2> Question Topic <hr> </h2>
	
		<div class="vote">
			<div class="arrow-up"></div>
			<h3> <div id="question-vote"> 5 </div></h3>
			<div class="arrow-down" ></div>
		</div>

		<div class="question-page-content">
			<p> Lorem Ipsum Bla Bla Bla </p>
		</div>

		<div class="edit-delete">
			<p> asked by <b> someone </b><br>
				email at date | <a href="#" style="color:#FFA500"> edit </a> | <a href="#" style="color:#FF0000"> delete </a> </p>
		</div>
	</div>

	<br>

	<h3> Your Answer </h3>
	<form method="POST" name="Form" action="question-page.jsp">
		<input type="text" name="answer_name" id="answer_name" placeholder="Name">
		<br>
		<input type="text" name="answer_email" id="answer_email" placeholder="Email">
		<br> 
		<textarea name="answer_content" id="answer_content" rows="15" placeholder="Content"></textarea>
		<br>
		<input type="submit" id="submit_answer" name="submit_answer" value="Post">
	</form>

</div>
</html>
