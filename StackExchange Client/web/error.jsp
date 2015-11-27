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
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">    
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>    <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container">
            <% out.write("<a id='logo-container' href='index.jsp?token="+ request.getParameter("token") +"' class='brand-logo'>Home</a>");%>
            <ul class="right hide-on-med-and-down">
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>

            <ul id="nav-mobile" class="side-nav">
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>   
        <script>
            $(document).ready(function(){

              // Initialize collapse button
              $(".button-collapse").sideNav();
            });
        </script>
        <title>Simple StackExchange</title>
    </head>
    <body>
    <%
             if (request.getParameter("id").equals("-1")){
                out.println("<h1 class='header center orange-text'>Oops! You're not logged in yet!<br></h1><h3 class='center orange-text'><a href='register.jsp'>Register here</a><br> or <br><a href='login.jsp'>Login Here</a></h3>");
            } else if (request.getParameter("id").equals("-2")){
                out.println("<h1>Login Expired. Please <a href='login.jsp'>Login</a> Again</h1>");
            } else if (request.getParameter("id").equals("3")){
                out.println("<h1>You are not authorized to access that! <a href='index.jsp?token="+request.getParameter("token")+"'>Home</a></h1>");
            }
       
    %>

    </body>
</html>
