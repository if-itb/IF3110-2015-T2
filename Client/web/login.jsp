<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="styles/main.css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab:400,700italic,300' rel='stylesheet' type='text/css'>
</head>
<body>
<div class='header'><a href='Home'><h1>Simple StackExhange</h1></a></div>
    <div class="container clearfix">
        <form class="registerForm" action='Login' method='POST'>
            <h2>Login</h2>
	    <p class="err"><c:out value="${errorMessage}" /></p>
            <input type="text" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <button type="submit" class="submitBtn">Login</button>
        </form>
    </div>
</body>
</html>
