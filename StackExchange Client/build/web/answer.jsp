<%-- 
    Document   : answer
    Created on : Nov 24, 2015, 1:20:01 AM
    Author     : Raihan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
    <center>
    
        <h1>Simple Stack Exchange</h1>
        
        <h3>Question Topic</h3>
        <hr width="80%">
        Content<br>
        N Votes | Vote UP | Vote Down<br>
        asked by X | Email<br><br><br>
        
        N Answers<br>
        <hr width="80%">
        <h4>Your Answer</h4>
        <form name='question' action='answer.jsp'>            
            <textarea name='acontent' placeholder="Answer" style="resize:none;width:500px;"></textarea><br><br>
            <input type="submit" value="Submit">
        </form>        
        
        
    </center>
    </body>
</html>
