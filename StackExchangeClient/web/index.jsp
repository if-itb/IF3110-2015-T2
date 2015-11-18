<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Stack Exchange</title>
    </head>
    <body>
        <p>Haha</p>
        <c:forEach items="${result}" var="question">
        <c:out value="${question.getContent()}"></c:out>
        </c:forEach>
        <p>Haha</p>
    </body>
</html>
