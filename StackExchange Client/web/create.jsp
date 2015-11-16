<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <h1>
            <a href="index.jsp">Simple StackExchange</a>
        </h1>
        <br>
        <h2>What's your question?</h2>
        <hr>
        <form name="askForm" action="" method="post" onsubmit="">
            <input name="name" class="text" type="text" placeholder="Name"><br>
            <input name="email" class="text" type="text" placeholder="Email"><br>
            <input name="topic" class="text" type="text" placeholder="Question Topic"><br>
            <textarea name="content" placeholder="Content"></textarea>
            <input class="button" type="submit" value="Post"><br>
        </form>
    </body>
</html>
