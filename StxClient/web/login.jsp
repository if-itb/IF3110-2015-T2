<%-- 
    Document   : login
    Created on : Nov 26, 2015, Nov 26, 2015 12:45:49 AM
    Author     : Fikri-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="include/header.jsp"  %>
<h1>Sign in</h1>
<form class="block" action="" name="LoginForm" method="POST">
    <ul>
        <input type='text' name = 'Email' placeholder='email'></input>
        <input type='password' name = 'Password' placeholder='password'></input><br><br>
        <input type='submit' value='sign in'></input>
    </ul>
</form>
<%@include file="include/footer.jsp" %>
