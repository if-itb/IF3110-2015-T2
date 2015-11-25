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
        <div>
        <form name='login' action='ask.jsp'>            
            <input type='text' name='mail' placeholder='Email' size='80'><br><br>
            <input type='text' name='pass' placeholder='Password' size='80'><br><br>
            New here? <a href='register.jsp'>Sign Up!</a>          
            <input type='submit' value='Login'>
            
            </center>
        </form>
        </div>
    </body>
</html>
