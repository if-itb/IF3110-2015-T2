<%@page import="java.util.*" %>
<%@page import="java.lang.Exception" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <title>Simple StackExchange</title>
    </head>

    <body>
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
        <br>
        <br>
        <br>
        <br>
        <div class="subtitle">Login</div>
        <hr class='line'>
        <form name="loginForm" action="http://localhost:8082/StackExchange_IS/ValidateUser" onsubmit="" method="POST">
            <input type="hidden" name="question_id">
            <input type="text" class='form-text' name="email" placeholder="Email" required><br>
            <input type="password" class='form-text' name="password" placeholder="Password" required><br>
            <button class='button-post' type='submit'> Register </button>
        </form>

        <c:if test="${not empty message}">
            <h1>${token}</h1>
        </c:if>
    </body>
</html>
