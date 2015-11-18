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
	<title>Simple StackExchange</title>
	
	<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">StackExchange</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="signin.jsp">Sign In</a>
                    </li>
                    <li>
                        <a href="register.jsp">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('http://localhost:8080/WebClient/images/Home2.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Welcome To StackExchange</h2>
                    <h4>Where Ivan is better than Google</h4>
                </div>
            </div>
        </div>
    </header>
    
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
	
		<% for (int i = 0; i < n; i++) { %>
			<div class = 'content'>
				<div class = 'q_or_a'>
					<div class = 'left'>
						<span class = 'vote'><% questionList.get(i).getNumVote(); %><br>Votes</span>
						<span class = 'answer'>0<br>Answers</span>
					</div>
					<div class = 'mid'>
						<a class = 'topic' href='#'><%= questionList.get(i).getTopic() %><br></a>
						<div class = 'q_content'>
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
	    				</div>
					</div>
				</div>
				<div class = 'details'>Asked by <span class = 'b_link'><%= questionList.get(i).getUsername() %> </span>|
                <a href = '#' class = 'y_link'> edit </a>|
                <a href='#' class = 'r_link'>delete</a><br></div>
			</div>
	        <hr>
			<% } %>
		</div>
</body>
</html>