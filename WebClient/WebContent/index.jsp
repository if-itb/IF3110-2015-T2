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
	<title>Simple StackExchange</title>
</head>
<body>
    <jsp:include page="Header.jsp"/>
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
				<div class = 'details'>Asked by <span class = 'b_link'><%= questionList.get(i).getUsername() %> </span>|
                <a href = '#' class = 'y_link'> edit </a>|
                <a href='#' class = 'r_link'>delete</a><br></div>
			</div>
	        <hr>
			<% } %>
		</div>
</body>
</html>