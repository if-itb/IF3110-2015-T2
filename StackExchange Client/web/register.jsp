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
        <form action="UserServlet" method="post">
        <input name="nama" type="text" placeholder="Nama"><br>
        <input name="email" type="text" placeholder="Email"><br>
        <input name="password" type="password" placeholder="Password"><br>
        <input type="submit" value="Register">
        </form>
    </body>
</html>
