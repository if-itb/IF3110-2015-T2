
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : question-list
    Created on : Nov 16, 2015, 12:04:39 AM
    Author     : zulvafachrina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" href="style.css" type="text/css">
        <title>Simple Stack Exchage</title>
    </head>
    
<body>
        <div id="header">
	<h1> <a href ="/Stack_Exchange_Client/QuestionServlet" style="color:#000"> Simple Stack Exchange </a> </h1>
</div>

<div class = "container">

	<form method="GET" action="question-list.jsp">
		<div>
			<input type="submit" id="search_button" id="search_button" value="Search">
			<input type="text" name="searchkey" id="searchkey">
			<p style="text-align:center"> Cannot find what you are looking for? <a href="ask-question.jsp" style="color:#FFA500"> Ask Here </a> </p>
		</div>
	</form>
        <h2> Recently Asked Question <hr> </h2>
<<<<<<< HEAD
        
        <c:forEach var="question" items="${questions}">
            <div class="boxarea">
		<div class="vote">
                    <h3><c:out value="${question.vote}"/></h3>
                    <c:out value="Votes"/>
		</div>

                <div class="vote" style="margin-left:5%">
		<h3><c:out value="${question.countAnswer}"/></h3>
                <c:out value="Answers"/>
		</div>

		<div class="question-content">
                    <h4><a href="/Stack_Exchange_Client/QuestionPage?id=${question.id}"> <c:out value="${question.topic}"/></a></h4>
                    <p> <c:out value="${question.content}"/> </p>
		</div>
					
		<div class = "edit-delete">
                    <p> <c:out value="${question.userId}"/> | <a href="#" style="color:#FFA500"> edit </a> | <a href="#" style="color:#FF0000"> delete </a></p>
		</div>

            </div>
        </c:forEach>
=======
        <sql:query var="result" dataSource="jdbc/stackexchange">
                SELECT * FROM Question
        </sql:query>
    
            <table border="1">
                <!-- column headers -->
                <tr>
                    <c:forEach var="columnName" items="${result.columnNames}">
                        <th><c:out value="${columnName}"/></th>
                    </c:forEach>
                </tr>
                <!-- column data -->
                <c:forEach var="row" items="${result.rowsByIndex}">
                    <tr>
                        <c:forEach var="column" items="${row}">
                            <td><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
>>>>>>> origin/master
    </body>
</html>
