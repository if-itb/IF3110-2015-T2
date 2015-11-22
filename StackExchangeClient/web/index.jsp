<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <style>
            <%@ include file="style.css"%>
        </style>
        <title>Stack Exchange</title>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1><br>
            
            <div class="login">
                <form class="login-form" action="home" method="post" action="">
                    <input type="text" name="login" value="" placeholder="Username or Email"><br>
                    <input type="password" name="password" value="" placeholder="Password"><br>
                    <div>
                        <label><input type="checkbox" name="remember_me" id="remember_me"/>Remember me</label>
                    </div>
                    <br><input type="submit" name="commit" value="Login">
                </form>
                <button onclick="window.location.href='register.jsp';">Register</button>
            </div>
            
        </div>
    </body>
</html>
