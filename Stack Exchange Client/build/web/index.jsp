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
        <title>Simple Stack Exchange</title>
    </head>
    <%
    String redirectURL = "question-list.jsp";
    response.sendRedirect(redirectURL);
    %>
</html>
