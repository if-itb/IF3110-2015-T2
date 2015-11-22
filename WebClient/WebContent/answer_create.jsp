<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<div id="content">
		<span class="error"></span>
	    <form id="createAnswerForm" action="answer_create_post.jsp" METHOD="POST">
	        Content: <input type="textarea" name="content" cols="10"/><br/>
	        <div class="12u">
				<ul class="buttons">
					<li><input type="submit" class="special" value="Submit Answer" /></li>
				</ul>
			</div>
	    </form>
	</div>
</body>
</html>