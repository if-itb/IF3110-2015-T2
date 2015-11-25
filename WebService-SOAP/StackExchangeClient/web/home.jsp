<%-- 
    Document   : displayQuestion
    Created on : Nov 25, 2015, 1:59:01 PM
    Author     : Calvin
--%>

<%@page import="java.util.List"%>
<%@page import="stackexchangews.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            List<Answer> answers = (List<Answer>)request.getAttribute("answers");
            for (Answer answer : answers) {
                out.println("<br>"+answer.getUserId());
                out.println("<br>"+answer.getContent());
                out.println("<br>"+answer.getVote());
                out.println("<br>");
            }
        %>
    </body>
</html>
