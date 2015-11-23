<%--
  Created by IntelliJ IDEA.
  User: Marco Orlando
  Date: 11/17/2015
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css">
  <title>Simple StackExchange</title>
  <script type = "text/javascript"></script>
</head>

<body>
<div id="container">
  <div id="header_addQuestions">
    <span id="Judul">Simple StackExchange</span>
    <span id="what">Registration Form</span>
  </div>


  <div id="body">
    <form name="registForm" action="" method="post">
      <input type="text" name="name" placeholder="Name" required><br>
      <input type="text" name="email" placeholder="Email" required><br>
      <input type="text" name="password" placeholder="Password" required><br>
      <div id="submitter">
        <input class="submitButton" name= "submitButton" type="submit" value="Register">
      </div>
    </form>
  </div>

</div>

</body>
</html>
