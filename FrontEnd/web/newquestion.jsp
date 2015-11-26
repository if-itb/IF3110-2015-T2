<%-- 
    Document   : newquestion
    Created on : Nov 18, 2015, 1:56:10 PM
    Author     : yoga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='style2.css'/>
    </head>
    <body>
        <div class="header">
            <div class="container">
                <%
                    String token = request.getParameter("token");
                    if (token != null) {
                        out.println("<p><a href='index1.jsp?token=" + token + "'>Simple StackExchange</a></p> ");
                    } else {
                        out.println("<p><a href='index1.jsp'>Simple StackExchange</a></p> ");
                    }

                %>
            </div>
        </div>

        <div class="main">
            <div class="container">

                <%                    out.println("<form  name='question' action='insertquestion.jsp?token=" + token + "' method='post' class='form' >");
                    out.println(" <input type='text' name='topic' placeholder='Question Topic' maxlength='30'><br>");
                    out.println("<textarea name='content' placeholder='Content' maxlength='1500'></textarea>");
                    out.println(" <input type='submit' value='Post' >");
                    out.println("</form>");
                %>

            </div>
        </div>
    </body>
</html>
