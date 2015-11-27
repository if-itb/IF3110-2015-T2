<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head><title>Simple StackExchange</title>
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>

<body>
	<div class ='container'>
		<h1 class='center'>Simple StackExchange</h1>

		<div class='center'>
			<form action='/tools/question/search.php' method='GET'>
				<input type='text' name="search" class='searchbar'><button type="submit">Search</button>
			</form>
		</div>

		<p class='center'>
			Cannot find what you are looking for? <a href='askQuestion.jsp' class='yellow'>Ask here</a>
		</p>

		<h2>Recently Asked Questions</h2>

		<c:forEach items="${questions}" var="question">
			<div class='question'>
			<div class='row'>
				<div class='col-1'>
					<p class='center'><b>${question.votes}</b></p>
					<p class='center'><b>Votes</b></p>
				</div>
				<div class='col-2'>
					<p class='center'><b>${question.countAnswers}</b></p>
					<p class='center'><b>Answers</b></p>
				</div>
				<div class='col-8'>
					<p>	
						<a href='ViewQuestion?id=${question.questionId}'> 
							${question.topic}
						</a>
					</p>
					<p>
                                            ${question.content}
					</p>
					<p class='right'>
					asked by <span class="name">${question.askerEmail}</span> | 
					<a href='#' class='yellow' onclick = "editQuestion(${question.questionId})">edit</a> | 
					<a href='#' class='red' onclick = "deleteQuestion(${question.questionId}?>)" >delete</a>
					</p>
				</div>
			</div>
			</div>
		</c:forEach>
	</div>
	<script type='text/javascript' src='/assets/js/question.js'></script>
</body>
</html>