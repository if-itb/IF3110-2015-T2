<%-- 
    Document   : register
    Created on : Nov 16, 2015, 11:35:54 PM
    Author     : chairuniaulianusapati
--%>

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
        <div class="subtitle">Please Register</div>
        <hr class='line'>
        <form name="registerForm" action="registerCallWS" onsubmit="" method="POST">
            <input type="hidden" name="question_id">
            <input type="text" class='form-text' name="name" placeholder="Name"><br>
            <input type="text" class='form-text' name="email" placeholder="Email"><br>
            <input type="text" class='form-text' name="password" placeholder="Password"><br>
            <button class='button-post' type='submit'> Register </button>
        </form>
    </body>
</html>
