<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : Nov 15, 2015, 11:53:34 AM
    Author     : zulvafachrina
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <link rel="StyleSheet" href="style.css" type="text/css">
=======
>>>>>>> origin/master
        <title>Simple Stack Exchange</title>
    </head>
    <body>
        <div id="header">
            <h1> <a href ="question-list.jsp" style="color:#000"> Simple Stack Exchange </a> </h1>
        </div>
        
        
        <%
        String redirectURL = "/Stack_Exchange_Client/QuestionServlet";
        response.sendRedirect(redirectURL);
        %>
    </body>
</html>
