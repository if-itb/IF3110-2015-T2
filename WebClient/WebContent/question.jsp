<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page import="java.util.*, java.io.*"%>
	<%@ page import = "org.tusiri.ws.question.QuestionService" %>
	<%@ page import = "org.tusiri.ws.question.Question" %>
	<%@ page import = "org.tusiri.ws.question.QuestionItem" %>
	<%@ page import = "org.tusiri.ws.question.GetQuestionInfo" %>
	<%@ page import = "org.tusiri.ws.answer.AnswerService" %>
	<%@ page import = "org.tusiri.ws.answer.Answer" %>
	<%@ page import = "org.tusiri.ws.answer.AnswerItem" %>
	<%@ page import = "org.tusiri.ws.answer.GetAnswerList" %>
	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" flush="true">
		<jsp:param name="pageTitle" value="Question" />
	</jsp:include>
	
	<% 
		int q_id = Integer.parseInt(request.getParameter("q_id"));
		QuestionService qservice = new QuestionService();
		Question qs = qservice.getQuestionPort();
		QuestionItem q = qs.getQuestionInfo(q_id);
		
		AnswerService aservice = new AnswerService();
		Answer as = aservice.getAnswerPort();
		List<AnswerItem> a = as.getAnswerList(q_id);
	%>
	
	
</head>
<body class="contact">
	
	
	<div id="page-wrapper">
		<!-- Header -->
		<header id="header" class="alt">
			<h1 id="logo"><a href="index.jsp">Stack Exchange <span>| by Tusiri</span></a></h1>
			<jsp:include page="navigationbar.jsp" flush ="true"/>
		</header>
		
		<article id="main">
			<div class = 'container wrapper style1'>
				<h2><%= q.getTopic() %></h2>
				<div class = 'q_details'>
					<div class = 'only_q'>
						<div class = 'a_left'>
							<div class = 'vote_buttons'>
								<div class='up_button'><img src='assets/img/up.png' width='30' height='30'></div>
									<div class = 'vote' id='q_vote'><%= q.getNumVote() %></div>
								<div class='down_button'><img src='assets/img/down.png' width='30' height='30'></div>
							</div>
						</div>
						<div class = 'a_mid'>
							<div class = 'a_content'><%= q.getContent() %></div></div>
						</div>
						<div class = 'details'>Asked by 
							<span class = 'b_link'><%= q.getUsername() %> </span>
							<span hidden class = 'modify_<%=q.getIdUser()%>'>
				              		<a href = 'question_edit.jsp?id=<%= q.getIdQuestion() %>' class = 'y_link'> edit </a>|
				              		<a href='#' class = 'r_link'>delete</a><br>
			              	</span>
		              	</div>
					</div>
				</div>
			<div class = 'container wrapper style3'>
				<h3><%=a.size()%> Answer</h3>
				<% for (int i = 0; i < a.size(); i++) { %>
					<div class = 'row q_or_a'>
						<div class = 'a_left'>
							<div class = 'vote_buttons'>
								<div class='up_button'><img src='assets/img/up.png' width='30' height='30'></div>
									<div class = 'vote' id='q_vote'><%= a.get(i).getNumVotes() %></div>
								<div class='down_button'><img src='assets/img/down.png' width='30' height='30'></div>
							</div>
						</div>
						<div class = 'a_mid'>
							<div class = 'a_content'><%= a.get(i).getContent() %></div>
						</div>
						<div class = 'details'>Answered by 
							<span class = 'b_link'><%= q.getUsername() %> </span>
						</div>
					</div>
				<%} %>
				<h3>Your Answer</h3>
				<form action="answer_create_post.jsp" METHOD="POST">
					<div class="controls">
						<input type = 'hidden' name = 'q_id' value = '<%=q_id%>'/>
                    	<textarea rows="10" cols="100" class="form-control" name="content" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"> </textarea>
					</div>
					<div class="row">
						<div class="12u">
							<ul class="buttons">
								<li><input type="submit" class="special" value="Submit Answer" /></li>
							</ul>
						</div>
					</div>
				</form>
				
			</div>
		</article>
		<footer id="footer">
		<ul class="icons">
			<li><a href="#" class="icon circle fa-twitter"><span class="label">Twitter</span></a></li>
			<li><a href="#" class="icon circle fa-facebook"><span class="label">Facebook</span></a></li>
			<li><a href="#" class="icon circle fa-google-plus"><span class="label">Google+</span></a></li>
			<li><a href="#" class="icon circle fa-github"><span class="label">Github</span></a></li>
			<li><a href="#" class="icon circle fa-dribbble"><span class="label">Dribbble</span></a></li>
		</ul>
	
		<ul class="copyright">
			<li>&copy; Tusiri</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>
	
	</footer>
	</div>
</body>
</html>