<%--
  Created by IntelliJ IDEA.
  User: Marco Orlando
  Date: 11/17/2015
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css">
  <title>Simple StackExchange</title>
</head>

<body>
  <div id = "container">
    <div id = "header">
      <p>${flash}</p>
      <span id="Judul">Simple StackExchange</span>
      <form id="search" action ="index.php" method="get">
        <input name = 'search' id="bar" type="text"/>
        <input id="submitButton" type="submit" value="Search"/>
    </div>
    <%--<p align="center">Cannot find what you are looking for? <a style="color:red" href="addQuestion.php">Ask here</a> --%>
    <div id ="body">
      <h3>Recently Asked Questions</h3>
               <%-- start web service invocation --%><hr/>
    <%
    try {
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	// TODO process result here
	java.util.List<wsmodel.QuestionClass> result = port.getAllQuestion();
	out.println(result.get(1).getQuestionTitle());
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>





    </div>

  </div>



</body>
</html>
