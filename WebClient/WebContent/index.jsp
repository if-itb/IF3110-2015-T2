<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, java.io.*"%>
<%@ page import = "org.tusiri.ws.question.QuestionService" %>
<%@ page import = "org.tusiri.ws.question.Question" %>
<%@ page import = "org.tusiri.ws.question.QuestionItem" %>
<html>
<title>Simple StackExchange</title>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="style.css">
	<base href="http://localhost:8080/WebClient/index.jsp"/>
</head>
<body>
	<div class="header">
		<span class="subheader">
			log in
		</span> | 
		<span class="subheader">
			register
		</span>
		<div style="width:94%">
		</div>
		<hr>
	</div>
	<a href="index.jsp" style="text-decoration:none; color:black">
		<h1>Simple StackExchange</h1>
	</a>
	<div>
		<form action="#" method="POST">
			<span>
				<input type="text" name="key" class="search"></input>
			</span>
			<span>
				<input type="submit" class="buttonsearch" value="Search">
			</span>
		</form>
	</div>
	<h3>
		Cannot find what you are looking for? 
		<a href="question_create.jsp" class="ask">Ask here</a>
	</h3>
	<h2 style="color:darkblue">Recently Asked Questions</h2>
	<hr>
	
	<%
		QuestionService qservice = new QuestionService();
		Question q = qservice.getQuestionPort();
		List<QuestionItem> questionList = q.getQuestionList();
		int n = questionList.size();
	%>
	
	<% for (int i = 0; i < n; i++) { %>
			<table>
    		<tr>
    			<td class="vote" rowspan="2">
    				<% questionList.get(i).getNumVote(); %> 
    			</td>
    			<td class="vote" rowspan="2">
    				0
    			</td>
				<td class="topic">
					<a href="#" class="topic">
						<%= questionList.get(i).getTopic() %>
					</a>
				</td>
				<td class="askedby">
				</td>
				</tr>
				<tr>
  				<%
  					String str = questionList.get(i).getContent();
		  			if(str.length() < 90) {
		  				out.println ("<td style=\"padding-left:2.6%\" class=\"discontent\">"+questionList.get(i).getContent()+"</td><td></td>");
		  			} else {
		  				out.println ("<td style=\"padding-left:2.6%\" class=\"discontent\">");
		  				out.println (str.substring(0, 90));
		  				out.println ("...</td><td></td>");
		  			}
    			%>
			</tr>
			<tr>
				<td class="vote1">
					Votes
				</td>
				<td class="vote1">
					Answers
				</td>
				<td class="topic">
				</td>
				<td class="askedby">
					asked by  
					<span class="user">
						<%= questionList.get(i).getUsername() %>
					</span>
						|
					<span class="edit">
						<a href="#" class="edit">
						 edit 
						</a>
					</span>
						|
					<span class="delete"onclick="#"> <a href="index.jsp" class="delete">
						 delete 
						</a>
					</span>
				</td>
				</tr>
        </table>
        <hr>
		
		<% } %>
	
	
</body>
</html>