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
        <%out.write("<div class='link-normalizer'><a class='title' href='index.jsp?token=" + request.getParameter("token") + "'>Simple StackExchange</a></div>");%>
        <br>
        <br>
        <br>
        <br>
        <div class="subtitle">Register Here</div>
        <hr class='line'>
         <%
           /* if (request.getParameter("error").equals("-2")){
                out.println("User Not Found! Please Register First!");
            }*/
            
        %>
        <%out.write("<form name='registerForm' action='registerresult.jsp?token="+ request.getParameter("token") +"' method='POST'>");%>
            <input type="hidden" name="question_id">
            <input type="text" class='form-text' name="name" placeholder="Name" required><br>
            <input type="text" class='form-text' name="email" placeholder="Email" required><br>
            <input type="password" class='form-text' name="password" placeholder="Password" required><br>
            <button class='button-post' type='submit'> Register </button>
        </form>
    </body>
</html>
