<%-- 
    Document   : editQuestion
    Created on : Nov 26, 2015, 8:21:20 AM
    Author     : X450
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Stack Exchange</title>
  <link rel="stylesheet" type="text/css" href="assets/css/question.css">
<script type = "text/javascript" src="/assets/js/validatequestion.js"> </script>
</head>
<body>
<div class="container">
  <h1 class="align-center margin-bot"><a class="text-link" href="index.jsp"><black>Simple StackExchange</black></a></h1>
  <h2>What's Your Question?</h2>
  <hr>
  <form name="editQuestion" action="http://localhost:8080/stack_exchange_netbeans/UpdateQuestionServlet?question_id=<c:out value="${Question.id}"/>&token=sssc" onsubmit="return validateForm()" method = "Post">
    <input type="text" class="form" value="${Question.topic}" name="Topic">
    <textarea class="form"  rows="5" name="Content">${Question.content}</textarea>
    <div class="align-right">
      <button class="button">Post</Button>
    </div>
  </form>
</div>
</body>
</html>
