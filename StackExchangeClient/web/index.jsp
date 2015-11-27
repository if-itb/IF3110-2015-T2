<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
<head> 
    <title> Register</title>
    <style>
    <%@include file="style.css"%>
    </style>
</head>


<body> 
    <div class="container">
        <c:choose>
            <c:when test="${name == null}">
                <h1> StackExchange Login </h1> 
                <form action="/StackExchangeClient/Login" method="post"> 
                    <table> 
                        <tr> 
                            <td class = "container"> Email  : </td> <td> <input name="email" type="text" required /> </td> 
                        </tr>

                        <tr> 
                            <td class = "container"> Password  : </td> <td> <input name="password" type="password" required /> </td> 
                        </tr>
                    </table>
                    <button class ="answer1" type="submit" name="answer" value="Login"> Submit </button>
                </form>
                <div>
                    <a href="/StackExchangeClient/register.jsp">Register</a>
                </div>
            </c:when>
            <c:otherwise>
                You are log in as ${name} <button onclick="window.location.href = 'Logout';">Logout</button>
            </c:otherwise>
        </c:choose>
    
	<a href="/StackExchangeClient/home"><h1 class="col-3">Simple StackExchange</h1></a>
	<div>
                <div>
			<form role="form" action="/StackExchangeClient/home" method="POST">
                            <input class="col-md-6 col-md-offset-3" type="text" id="searchbox" name="keyword" required>
                            <input class="btn" type="submit" id="searchbutton" value="Search" name="search">
			</form>

                    <div class="col-md"><p>Cannot find what you are looking for? <a href="/StackExchangeClient/askquestion.jsp" style="color:pink">Ask here</a></p></div>
		</div>
                <div class="col-md-2" id="main3"><h3>Recently Asked Questions</h3></div>
                   
                <div class="col-md-8">
                <c:forEach items="${result}" var="question">
                   <ul class="list-inline">
                       <li>
                           VOTE 
                       </li>
                       <li>
                           ANSWERS 
                       </li>
                       <li><a href="<c:url value="/viewpost?qid=${question.getQuestionId()}"></c:url>"><h4>${question.getQuestionTopic()}</h4></a></li>
                   </ul>
                   ${question.getQuestionContent()}<br>
                </c:forEach> 
                   </div>

        </div> 
        
</div>
</body>
</html>