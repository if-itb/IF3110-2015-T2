<%-- 
    Document   : view
    Created on : Nov 22, 2015, 6:18:46 AM
    Author     : Venny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="question" type="model.question.Question" scope="request"/>

<!DOCTYPE html>
<html lang="en">
    <head>
	<title>Simple StackExchange: Question</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div class="container">
            <a href="index"><h1>Simple StackExchange</h1></a>
            <div class="content">
                <h2><%= question.getTopic() %></h2>
                <div class="voting">
                    <div class="arrow-up"></div>
                    <div id="vote-q"><p><%= question.getVote() %></p></div>
                    <div class="arrow-down"></div>
		</div>
		<div class="answer-content">
                    <p><%= question.getContent() %></p>
		</div>
		<div class="question-sign">
                    <p>asked by <font color="#008080">Name</font> at <%= question.getCreateTime() %> <a class="edit">edit</a> |
			<a class="delete">delete</a></p>
		</div>
            </div>
			
            <div class="content">
                <h2>Answers</h2>
		<div class="answer-list">
                    <div class="voting">
			<div class="arrow-up"></div>
			<div id="voteid"><p>?</p></div>
			<div class="arrow-down"></div>
                    </div>
                    <div class="answer-content">
			<p>Answer Content</p>
                    </div>
                    <div class="question-sign">
			<p>answered by <font color="#008080">Name</font> at datetime</p>
                    </div>
		</div>
            </div>

            <div class="content" style="margin-top:30px;">
		<div class="grey-title">Your Answer</div>
                <form method="post" name="saveanswer" action="addAnswer">
                    <input type="hidden" name="question_id" value="<%= question.getQuestionId() %>">
                    <input type="hidden" name="user_id" value="1">
                    <textarea placeholder="Content" rows="5" name="content"></textarea>
                    <div class="button-bottom">
                        <button type="submit" name="saveanswer" value="Submit">Post</button>
                    </div>
                </form>
            </div>
	</div>
    </body>
</html>
