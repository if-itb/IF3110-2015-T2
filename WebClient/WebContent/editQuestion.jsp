<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Question</title>
</head>
<body>
<body>
	<div id="content">
		<span class="error"></span>
	    <form id="editQuestionForm" action="question_edit_post.jsp" METHOD="POST">
	        Topic : <input type="text" name="topic"/><br/>
	        Content: <input type="textarea" name="content" cols="10"/><br/>
	        <button id="submitBtn">Submit</button>
	    </form>
	</div>
</body>
</html>