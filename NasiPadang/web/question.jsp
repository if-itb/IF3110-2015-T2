<%-- 
    Document   : question
    Created on : Nov 19, 2015, 4:11:41 AM
    Author     : user
--%>

<%@page import="org.wsdl.Answer"%>
<%@page import="org.wsdl.AnswerArray"%>
<%@page import="java.util.List"%>
<%@page import="org.wsdl.Question"%>
<%@page import="org.wsdl.QuestionArray"%>
<%@page import="org.wsdl.StackExchangeImplService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange</title>
	<link rel="stylesheet" href="css/style.css" />
	<script src="js/validation.js"></script>
	<script src="js/delete_question.js"></script>
	<script src="js/ajax.js"></script>
        <%String id = request.getParameter("id");
        StackExchangeImplService stackExchangeService = new StackExchangeImplService();
        org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
        int i = Integer.parseInt(id);
        Question question = stackExchange.getQuestion(i);
        AnswerArray allAnswer = stackExchange.getAllAnswer(i);
        List<Answer> items = allAnswer.getItem();
        %>
    </head>
    <body>
        <a href="index.jsp"><h1>Simple StackExchange</h1></a><br>

	<div class="title"><%=question.getTopic()%></div>
	<hr></hr>
	<div class="question">
            <table>
                <tbody>
                    <tr>
                        <td>
                            <a class="vote-up" href="javascript:upvoteQuestion(<%=question.getId()%>)">Up</a>
                            <div class="vote" id="votes"><%=question.getVote()%></div>
                            <a class="vote-down" href="javascript:downvoteQuestion(<%=question.getId()%>)">Down</a>
                        </td>
                        <td>
                            <table>
                                <tbody>
                                    <tr><td><p class="content"><%=question.getContent()%></p></td></tr>
                                    <tr><td><div class="credential">asked by <%=question.getName()%> at <%=question.getTimestamp()%> | <a class="yellow" href="edit.php?id=<%=question.getId()%>">edit</a> | <a class="delete" href="javascript:confirmDelete(<%=question.getId()%>)">delete</a></div></td></tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
	<br>
	<div class="answer">
            <div class="title"><div id="count"><%=question.getCount()%> Answer</div>
            <ul>
                <%for(Answer answer : items){%>
                    <hr></hr>
                    <li>
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        <a class="vote-up" href="javascript:upvoteAnswer(<%=answer.getIdAnswer()%>)">Up</a>
                                        <div class="vote" id="votes<%=answer.getIdAnswer()%>"><%=answer.getVote()%></div>
                                        <a class="vote-down" href="javascript:downvoteAnswer(<%=answer.getIdAnswer()%>)">Down</a>
                                    </td>
                                    <td>
                                        <table>
                                            <tbody>
                                                <tr><td><p class="content"><%=answer.getContent()%></p></td></tr>
                                                <tr><td><div class="credential">answered by <%=answer.getName()%> at <%=answer.getTimestamp()%></div></td></tr>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </li><br>
                <%}%>
            </ul>
            <div id="ajax_answer"></div>
	</div>

	<hr></hr>
	<div class="new-answer">
		<div class="title">Your Answer</div>
		<form name="answer" method="post" action="AddAnswer.php">
			<input type="hidden" name="id" value="<%=question.getId()%>">
			<input class="inputform" type="text" name="name" placeholder="Name"><br>
			<input class="inputform" type="text" name="email" placeholder="Email"><br>
			<textarea class="inputform" type="text" name="content" placeholder="Content"></textarea><br>
			<input class="button" type="submit" value="Post" onclick="return validateFormAnswer()">
		</form>
	</div>
    </body>
</html>
