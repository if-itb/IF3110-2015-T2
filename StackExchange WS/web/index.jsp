<%-- 
    Document   : index
    Created on : Nov 17, 2015, 5:22:56 PM
    Author     : zainelwati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stack Exchange</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="container">
            <h1>Simple StackExchange</h1>
            <form action="Search.jsp"><!--ini filenya belum ada-->
		<input class="searchBox" type="text" name="questions">
		<input type="submit" class="submitButton" value="Search">
            </form>
            <p>
		Cannot find what you are looking for? <a href="ask.jsp">Ask here</a>
		<br>
		<br>
            </p>
            <div class="raqtitle left"><h3>Recently Asked Question</h3></div>
            <!-- codingan tampilan list pertanyaan oleh nilta-->
        </div>
    </body>
</html>
