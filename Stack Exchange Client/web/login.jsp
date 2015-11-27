<%-- 
    Document   : login
    Created on : Nov 26, 2015, 6:06:56 AM
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
        <title>Stack Exchange</title>
    </head>
    <body>
        <div id="edit-delete" style="text-align:right">
		<p> Logged in as <b><c:out value="guest"/></b> | <a href="login.jsp" style="color:#FFA500"> Log in </a> | <a href="register.jsp" style="color:#FF0000"> Register </a> </p>
        </div>
        <div id="header">
            <h1> <a href ="/Stack_Exchange_Client/QuestionServlet" style="color:#000"> Simple Stack Exchange </a> </h1>
        </div>
    
        <div class = "container">
            <div class="loginbox">
                <h3> Login <hr> </h3>
                    <form method="POST" name="Form" action="http://localhost:8082/Stack_Exchange_IS/Login" onsubmit="return validateFormQuestion()">
                            <input type="text" name="email" id="username" placeholder="Email"/>
                            <br>
                            <input type="password" name="password" id="password" placeholder="Password"/>
                            <br> 
                            <input type="submit" id="submit_login" name="submit_login" value="Login"/>
                            <br><br>
                            <p style="float:right"> Don't have an account? <a href="register.jsp" style="color:#FFA500"> Register </a> </p>
                    </form>
            </div>
            </div>
        </div>
    </body>
</html>
