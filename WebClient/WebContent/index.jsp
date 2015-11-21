<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*, java.io.*"%>
	<%@ page import = "org.tusiri.ws.question.QuestionService" %>
	<%@ page import = "org.tusiri.ws.question.Question" %>
	<%@ page import = "org.tusiri.ws.question.QuestionItem" %>

	<jsp:include page="Header.jsp" flush="true">
		<jsp:param name="pageTitle" value="Simple StackExchange" />
	</jsp:include>
</head>

<body class="index">
	
	<div id="page-wrapper">
	
	<!-- Header -->
	<header id="header" class="alt">
		<h1 id="logo"><a href="index.html">Stack Exchange <span>| by Tusiri</span></a></h1>
		<jsp:include page="navigationbar.jsp" flush ="true"/>
	</header>
	
   <!-- Banner -->
	<section id="banner">
		<div class="inner">
			<header>
				<h2>STACK EXCHANGE</h2>
			</header>
			<p>This is <strong>STACK EXCHANGE</strong>, a place
			<br />
			where Ivan is
			<br />
			better than Google</a>.</p>
			<footer>
				<ul class="buttons vertical">
					<li><a href="question_create.jsp" class="button fit scrolly">Ask a Question</a></li>
				</ul>
			</footer>

		</div>

	</section>
    
    <!-- Page Content -->
    <div class="container">
		<div class="search">
	        <form action = "#" method="get">
	            <input name ='search' class = "searchbar" type = "text"/>
	            <input class = "button" type = "submit" value="Search"/>
	        </form>
	        <p>Cannot find what you are looking for? <a href = "question_create.jsp">Ask here</a></p>
		</div>

		<h2 style="color:darkblue">Recently Asked Questions</h2>
		<hr>
	
		<%
			QuestionService qservice = new QuestionService();
			Question q = qservice.getQuestionPort();
			List<QuestionItem> questionList = q.getQuestionList();
			int n = questionList.size();
		%>
	
		<% for (int i = 0; i < n; i++) { 
			int id = questionList.get(i).getIdUser(); 
		%>
			<div class = 'content'>
				<div class = 'q_or_a'>
					<div class = 'left'>
						<span class = 'vote'>
							<% int tmp = questionList.get(i).getNumVote(); 
								out.println(tmp);	
							%>
							<br>Votes
						</span>
						<span class = 'answer'>
							<% tmp = questionList.get(i).getNumAnswer(); 
								out.println(tmp);
							%>
							<br>Answers
						</span>
					</div>
					<div class = 'mid'>
						<a class = 'topic' href='#'><%= questionList.get(i).getTopic() %><br></a>
						<div class = 'q_content'>
						<%
		  					String str = questionList.get(i).getContent();
				  			if(str.length() < 180) {
				  				out.println (questionList.get(i).getContent());
				  			} else {
				  				out.println (str.substring(0, 180)+"...");
				  			}
	    				%>
	    				</div>
					</div>
				</div>
				<div class = 'details'>Asked by 
					<span class = 'b_link'><%= questionList.get(i).getUsername() %> </span>
					<span hidden class = 'modify_<%=id%>'>
						|
                		<a href = 'question_edit.jsp?id=<%= questionList.get(i).getIdQuestion() %>' class = 'y_link'> edit </a>|
                		<a href='#' class = 'r_link'>delete</a><br>
                	</span>
                </div>
			</div>
	        <hr>
			<% } %>
		</div>
</body>
</html>