<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <style>
            <%@ include file="style.css"%>
        </style>
        <title>Stack Exchange</title>
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1><br>
            <form class="search-box" method="POST">
		<input type="text" name="keyword">
		<input type="submit" value="Search"><br>
            </form>
            <br><p style="text-align:center">Cannot find what you are looking for? <a href=askquestion.jsp style="color:orange">Ask here</a></p>
            <h3>Recently Asked Questions</h3>
            <table style="table-layout: fixed">
                <c:forEach items="${result}" var="question">                   
                    <tr style="border-top: 2px solid #000; height: 80px;">
                        <td style="width:10%; text-align:center">
                            ${question.answer}<br>Answers
                        </td>
                        <td style="width:10%; text-align:center">
                            ${question.vote}<br>Votes
                        </td>
                        <td style="width:2%;">
                        </td>
                        <td style="vertical-align:top; padding-top:5px">
                            <a href="<c:url value="/viewpost" >
                                <c:param name="id" value="${question.idQuestion}"/>
                                </c:url>">${question.topic}
                            </a>
                            <br><br>${question.content}<br>
                            <p style="text-align:right">asked by ${question.username} | edit | delete</p>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
