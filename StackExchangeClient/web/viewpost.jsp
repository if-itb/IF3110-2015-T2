<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@ include file="style.css"%>
        </style>
        <title>Stack Exchange</title>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${username == null}">
                    <div class="login">
                        <h1>Log-in</h1>
                            <form action="/StackExchangeClient/login" method="POST">
                                <input type="text" name="user" placeholder="Username">
                                <input type="password" name="pass" placeholder="Password">
                                <input type="submit" name="login" value="Login">
                            </form>
                            <div class="login-help">
                                <a href="StackExchangeClient/register.jsp">Register</a>
                            </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <p style="text-align:right">You're log in as ${username} <button onclick="window.location.href='logout';">Log out</button></p>
                </c:otherwise>
            </c:choose>

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
            <p style="text-align:right">asked by ${question.username} at ${question.date} | edit | delete</p>
            <h2>${count} Answer</h2><br>
            </c:forEach>

            <table>
                <c:forEach items="${answers}" var="answer">
                    <tr style="border-bottom:2px solid #000">
                        <td style="width:15%; text-align:center; padding:20px">
                            <img src="images/up.png"><br>
                            <p style="font-size:40px; margin:0; color:lightgrey">${answer.vote}</p>
                            <img src="images/down.png">
                        </td>
                        <td style="vertical-align:top; padding:20px">${answer.content}<br>
                            <p style="text-align:right">answered by ${answer.username} at ${answer.date}</p>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
            <br><p style="font-size:30px; margin:0; color:grey"> Your Answer </p>
            <form name="AnswerForm" action="addanswer" method="POST">
		<textarea name="content" id="content" placeholder="Content"></textarea><br><br>
                <input type="hidden" name="idQuestion" value="${result.get(0).idQuestion}" />
		<input type="submit" value="Post">
            </form>
            
	</div>
    </body>
</html>
