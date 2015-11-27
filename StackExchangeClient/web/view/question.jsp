<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head><title>${question.topic}</title>
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>


<body>
<div class ='container'>
		<h1 class='center'>Simple StackExchange</h1>

		<div class='center'>
			<input type='text' class='searchbar'> <button>Search</button>
		</div>

		<div>&nbsp;</div>

		<h2>${question.topic}</h2>

			<div class='question'>
			<div class='row'>
				<div class='col-1'>
                                    <a href="UpVoteQuestion?id=${question.questionId}&token=${token}"><div class='arrow-up'"></div></a>
                                    <b><p class='center' id='question${question.questionId}'>${question.votes}</p></b>
                                    <a href="DownVoteQuestion?id=${question.questionId}&token=${token}"><div class='arrow-down'></div></a>
				</div>
				
				<div class='col-8'>
					<p>${question.content}</p>
					<p class='right'>
						asked by <span class='name'>${question.askerEmail}</span> at ${question.time} | 
						<a href='EditQuestion?id=${question.questionId}&token=${token}' class='yellow' onclick="editQuestion( ${question.questionId} )">edit</a> | 
						<a href='#' class='red' onclick="deleteQuestion( ${question.questionId} )">delete</a>
					</p>
				</div>
			</div>
			</div>
		
		<h2>${answers.size()} Answers</h2>
		<c:forEach items="${answers}" var="answer">
			<div class='answer'>
				<div class='row'>
					<div class='col-1'>
                                            <a href="UpVoteAnswer?id=${answer.answerId}&token=${token}"><div class='arrow-up'></div></a>
                                            <b><p class='center' id='answer${answer.answerId}'>${answer.votes}</p></b>
                                            <a href="DownVoteAnswer?id=${answer.answerId}&token=${token}"><div class='arrow-down'></div></a>
					</div>
					<div class='col-8'>
					<p>${answer.content}</p>
						<p class='right'>
						answered by <span class='name'>${answer.answererEmail}</span> at ${answer.time}
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
		
		<hr>

		<h1>Your Answer</h1>
		<form name='answerForm' action="AddAnswer" method="post">
			<input type="hidden" name="questionId" value="${question.questionId}">
                        <input type="hidden" name="token" value="${token}">
			<textarea name='content' class='formInput' placeholder='Content' rows='10'></textarea>
			<div class='right'><button type='submit'>Post</button></div>
		</form>
	</div>
</body>
</html>
