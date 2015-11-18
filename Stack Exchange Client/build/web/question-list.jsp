
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
	<h1> <a href ="question-list.jsp" style="color:#000"> Simple Stack Exchange </a> </h1>
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
    </body>
</html>
