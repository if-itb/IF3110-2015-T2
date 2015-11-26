<%-- 
    Document   : error
    Created on : Nov 25, 2015, 4:41:23 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
             if (request.getParameter("id").equals("-1")){
                out.println("<h1>You have not registered yet! <a href='register.jsp'>Register here</a> or <a href='login.jsp'>Login Here</a></h1>");
            } else if (request.getParameter("id").equals("-2")){
                out.println("<h1>Login Expired. Please <a href='login.jsp'>Login</a> Again</h1>");
            } else if (request.getParameter("id").equals("3")){
                out.println("<h1>You are not authorized to access that! <a href='index.jsp?token="+request.getParameter("token")+"'>Home</a></h1>");
            }
       
    %>

    </body>
</html>
