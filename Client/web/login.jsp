<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login Page</title>
<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container login">
		<a class="homelink" href="index.jsp"><h1 id="title">My StackExchange</h1></a>
		<div class="content">
			<h2>Login</h2>
			<hr>
			<form action="http://localhost:8083/v1/login", method="post" onsubmit="">
			<input class="textbox" type="text", name="email", id="email" placeholder="Email">
			<br>
			<input class="textbox" type="password", name="password", id="password" placeholder="Password">
			<br>
			<input type="submit" id="post"  value="Login">
			</form>
			Have not yet registered? <a href="register.jsp">Register now</a>
		</div>	
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>