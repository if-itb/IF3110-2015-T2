<%-- 
    Document   : login
    Created on : Nov 24, 2015, 1:19:29 AM
    Author     : Raihan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center><h1>Simple Stack Exchange</h1>
        <h2>Login</h2>
        <div>
        <form action="http://localhost:8082/StackExchange_IS/Login" method="POST">         
            <input type='text' name='email' placeholder='Email' size='80'><br><br>
            <input type='text' name='password' placeholder='Password' size='80'><br><br>
            New here? <a href='register.jsp'>Sign Up!</a>          
            <input type='submit' value='Login'>
            
            </center>
        </form>
        </div>
    </body>
</html>
