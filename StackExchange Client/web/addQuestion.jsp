<%--
  Created by IntelliJ IDEA.
  User: Marco Orlando
  Date: 11/17/2015
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css">
  <title>Simple StackExchange</title>
  <script type = "text/javascript" src="validatorInputQuestionAnswer.js"></script>
</head>

<body>
<div id="container">
  <div id="header_addQuestions">
    <span id="Judul">Simple StackExchange</span>
    <span id="what">What's your question?</span>
  </div>


  <div id="body">
    <form name="myForm" action="addQuestionProcess.jsp" method="post">
      <input type="text" name="questionTopic" placeholder="Question Topic"><br>
      <textarea name="questionContent" placeholder="Content"></textarea><br>
      <div id="submitter">
        <input class="submitButton" name= "submitButton" type="submit" value=Submit>
      </div>
    </form>
  </div>

</div>

</body>
</html>
