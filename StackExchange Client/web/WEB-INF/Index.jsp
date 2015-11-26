<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>StackExchange</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>Simple StackExchange</h1>
        <form action="search.jsp" name="search" method="post">
		<input type="text" name="search" placeholder="Type here" class="medium">
		<input type="submit" value="search" id="button">
        </form> 
        <p> Cannot find what you are looking for? Ask here <p>
        <h2> Recently Asked Questions </h2>
            <c:forEach items="${questions}" var="question">
            <hr>
		<div class=vote>
                    <div class=number>
			<span>${question.votes}</span>
                    </div>	
                    <div>
                        Votes
                    </div>
                </div>
				
		<div class=answer>
                    <div class=number>
                        <span>${answers[question.id]}</span>
                    </div>
                    <div>
                        Answers
                    </div>		
		</div>
					
		<div class=topic>
                    <a href="Answer?id=${question.id}"><c:out value="${question.title}"/></a>
                    <c:out value="${question.content}"/>
                    <br>
		</div>
					
		<div class=asked>
                    <!--asked by <span class=name>ini namanya</span> | <a href=\"Edit.php?id=".$row["Q_id"]."\"class=\"color_yellow\">edit<a> | <a onclick="return confirm_delete()\" href=\"Delete.php?id=".$row["Q_id"]."\"class=\"delete\">delete<a> -->
		</div>
            </c:forEach>
    </body>
</html>