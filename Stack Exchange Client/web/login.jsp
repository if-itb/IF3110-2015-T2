<%-- 
    Document   : login
    Created on : Nov 26, 2015, 6:06:56 AM
    Author     : zulvafachrina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" href="style.css" type="text/css">
        <title>Stack Exchange</title>
    </head>
    <body>
        <div id="header">
            <h1> <a href ="question-list.jsp" style="color:#000"> Simple Stack Exchange </a> </h1>
        </div>
    
        <div class = "container">
            <h2> Login <hr> </h2>
                <form method="POST" name="Form" action="question-list.jsp" onsubmit="return validateFormQuestion()">
			<input type="text" name="username" id="username" placeholder="Name">
			<br>
			<input type="password" name="password" id="password" placeholder="Password">
			<br> 
			<input type="submit" id="submit_login" name="submit_login" value="Post">
                </form>
            </div>
        </div>
    </body>
</html>
