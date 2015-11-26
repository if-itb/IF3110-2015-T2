<%-- 
    Document   : viewpost
    Created on : Nov 25, 2015, 3:03:06 PM
    Author     : Bimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Post</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>stackexchange?</h1>
        <h2>Question Topic</h2>
        <h2><c:out value=""/></h2>
        <p>Question Content</p>
        <div class="col-md-8">  
            <c: items="${answers}" var="answer">
                ${question.getAnswerContent()}<br>
                
            </c:> 
         </div>
    </body>
</html>
