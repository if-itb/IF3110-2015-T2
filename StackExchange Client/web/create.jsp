<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="navbar-up">
            <a href="index.jsp">
                <h1 class="white">Simple StackExchange</h1>
            </a>
        </div>
        <div class="navbar-down">
            <b class="navbar-down">
                <a class="white" href="register.jsp">Register</a> |
                <a class="white" href="login.jsp">Login</a>
            </b>
        </div>
        <div class="main">
            <br>
            <h2>What's your question?</h2>
            <hr>
            <form name="askForm" action="CreateQuestionServlet" method="post" onsubmit="">
                <input name="topic" class="text" type="text" placeholder="Question Topic"><br>
                <textarea name="content" placeholder="Content"></textarea>
                <input class="button" type="submit" value="Post"><br>
            </form>
        </div>
    </body>
</html>
