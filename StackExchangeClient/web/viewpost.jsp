<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>Stack Exchange</title>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1><br>
            <c:forEach items="${result}" var="question">
            <h2>${question.topic}</h2><br>    
            <table>
		<tr>
                    <td style="width:15%; text-align:center">
                        <img src="images/up.png"><br>
                        <p id="vote" style="font-size:40px; margin:0; color:lightgrey"> ${question.vote} </p>
                        <img src="images/down.png">
		    </td>
		    <td style="vertical-align:top">
		    	${question.content}<br>
		    </td>
		</tr>
            </table>
            <p style="text-align:right">asked by ${question.username} at date | edit | delete</p>
            <h2>1 Answer</h2><br>
            </c:forEach>
                
            <table>
		<tr style="border-bottom:2px solid #000">
                    <td style="width:15%; text-align:center; padding:20px">
                        <img src="images/up.png"><br>
			<p style="font-size:40px; margin:0; color:lightgrey">1</p>
			<img src="images/down.png">
                    </td>
                    <td style="vertical-align:top; padding:20px">Content<br>
			<p style="text-align:right">answered by username at date</p>
                    </td>
		</tr>
            </table>
            
            <br><p style="font-size:30px; margin:0; color:grey"> Your Answer </p>
            <form name="AnswerForm" method="POST">
		<input type="text" name="name" id="inputtext1" placeholder="Name"><br>
		<input type="text" name="email" id="inputtext1" placeholder="Email"><br>
		<textarea name="content" id="content" placeholder="Content"></textarea><br><br>
		<input type="submit" value="Post">
            </form>
            
	</div>
    </body>
</html>
