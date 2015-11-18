<%-- 
    Document   : register
    Created on : Nov 17, 2015, 12:00:08 PM
    Author     : Venny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Simple StackExchange: Register</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Dosis:500' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container">
            <h1><a href="index.jsp">Simple StackExchange</a></h1>
            <div class="login">
                <form method="post" action="" name="register">
                    <input type="text" class="input-group" placeholder="Name" name="Name">
                    <input type="text" class="input-group" placeholder="Email" name="email">
                    <input type="password" class="input-group" placeholder="Password" name="password">
                    <div class="button-bottom">
                        <button type="submit" name="register" value="Submit">Register</button>
                    </div>
                </form>
            </div>

        </div>
        
    </body>
</html>