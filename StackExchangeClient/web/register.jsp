<%-- 
    Document   : register
    Created on : Nov 24, 2015, 12:02:31 PM
    Author     : mochamadtry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style> 
            <%@ include file="style.css"%>
        </style>
        <title>Register</title>
    </head>
    <body>
        <div class="container">
                <h1> Stack Exchange </h1>
		<h2> Register Form </h2> 
		<div id="searchbox">
		<form name = "RegisterForm" action = "registers" method="POST"> 
                    <input type="text" name="name" placeholder="Name"> <br>
                    <input type="text" name="email" placeholder="Email"> <br>
                    <input type="password" name="password" placeholder="Password"> <br>
                    <input type="submit" value="Sign Up">

		</form>
		</div>


	</div>
    </body>
</html>