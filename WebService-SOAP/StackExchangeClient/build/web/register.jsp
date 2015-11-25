<%-- 
    Document   : index
    Created on : Nov 25, 2015, 1:24:02 PM
    Author     : Calvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form name="Test" method="post" action="RegisterServlet">
           <br>Full Name<br><input type="text" name="fullname">
           <br>Email<br><input type="text" name="email">
           <br>Password<br><input type="text" name="password">
           <br><input type="submit" value="Register">
        </form>
    </body>
</html>
