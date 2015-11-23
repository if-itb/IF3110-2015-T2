<%--
  Created by IntelliJ IDEA.
  User: Marco Orlando
  Date: 11/17/2015
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--/**
* Created by PhpStorm.
* User: Marco Orlando
* Date: 10/9/2015
* Time: 4:09 PM
*/

-->


<?php
require "connectDatabase.php";
// SQL query
if (isset( $_GET['questionId'])) {
$questionId = $_GET['questionId'];
$strSQL = "SELECT * FROM Questions WHERE questionId=$questionId";
// Execute the query (the recordset $rs contains the result)
$rs = mysql_query($strSQL);
while($row = mysql_fetch_array($rs)) {
// Write the value of the column FirstName (which is now in the array $row)
$name = $row['name'];
$title = $row['title'];
$email = $row['email'];
$content=$row['content'];
$update=true;
}
mysql_close();
}

else{
$name = "";
$title = "";
$email = "";
$content="";
$update=false;
}
?>
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
    <span id="what">Login</span>
  </div>


  <div id="body">
    <form name="myForm" action="addQuestionToDB.php" method="post" onsubmit="return validateFormQuestion()">
      <input type="text" name="email" placeholder="Email" required><br>
      <input type="text" name="password" placeholder="Password" required><br>
      <div id="submitter">
        <input class="submitButton" name= "submitButton" type="submit" value="Login" >
      </div>
    </form>
  </div>

</div>

</body>
</html>
