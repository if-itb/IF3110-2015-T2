<%-- 
    Document   : index
    Created on : Nov 17, 2015, 11:36:58 AM
    Author     : Venny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Simple StackExchange</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Dosis:500' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1>
            <div class="login">
                <h5>Do not have an account? <a href="register.jsp">Register here</a></h5>
                <script>
                    
                </script>
                <form method="POST" action="LoginIS" name="login">
                    <input type="text" class="input-group" placeholder="Email" name="email">
                    <input type="password" class="input-group" placeholder="Password" name="password">
                    <div class="button-bottom">
                        <button type="submit" name="login" value="Submit">Log in</button>
                    </div>
                </form>
            </div>

        </div>
        
    </body>
</html>
