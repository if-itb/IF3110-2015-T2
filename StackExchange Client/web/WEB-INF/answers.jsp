<%-- 
    Document   : answers
    Created on : Nov 26, 2015, 1:29:14 PM
    Author     : Scemo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>StackExchange</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css"><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Simple StackExchange</h1>
            <h2>
                <div>
                    <span>${question.title}</span>
                </div>
                <div>
                    <hr>
                </div>
            </h2>
            <div class="answer_question">
                <div class="vote">
                    <div class="number">
			<span>&#x25B2</span>
                    </div>
                    <br>
                    <div class="number">
                        <span>${question.votes}</span>
                    </div>
                    <br>
                    <div class="number">
                        <span>&#x25BC</span>
                    </div>		
		</div>
                <div class="answer_topic">
                    <c:out value="${question.content}"/>
		</div>
			
		<div class="asked_email">
                    asked by <span>${asker}</span>|<!-- <a href="Edit.php?id=".$row["Q_id"]."\" class=\"color_yellow\">edit<a> | <a href=\"Delete.php?id=".$row["Q_id"]."\" class=\"delete\">delete<a> -->
		</div>
            </div>
        <h2 class="align">
            <div>
                <span>${count_answer[question.id]}Answers </span>
            </div>
            <div>
		<hr>
            </div>
	</h2>
    </body>
</html>
