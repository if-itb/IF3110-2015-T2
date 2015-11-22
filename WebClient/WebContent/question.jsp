<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<% 
		Cookie cookie = null;
		Cookie[] cookies = null;
		String access_token = null;
		
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("access_token")){
					access_token = cookie.getValue();
					break;
				}
			}
		} else {
			//Redirect to signin
		}
		String q_id_string = request.getParameter("q_id");
		if((q_id_string!=null) && (q_id_string.matches("\\d+"))){
		
		int q_id = Integer.parseInt(q_id_string);

		QuestionService qservice = new QuestionService();
		Question qs = qservice.getQuestionPort();
		QuestionItem q = qs.getQuestionInfo(access_token,q_id);
		
		AnswerService aservice = new AnswerService();
		Answer as = aservice.getAnswerPort();
		List<AnswerItem> a = as.getAnswerList(access_token,q_id);
		
	%>
	<% if (q.getIdQuestion() != -1){ %>
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
		<jsp:param name="pageTitle" value="<%= q.getTopic() %>" />
	</jsp:include>
	<script src="assets/js/vote.js"></script>
	<% } %>
</head>
<% if (q.getIdQuestion() != -1){ %>
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
								<div hidden class='up_button user' onclick='VoteUp(true,<%=q_id%>)'><img id='q_up' src='assets/img/up<%=q.getStatus() %>.png' width='30' height='30'></div>
									<div class = 'vote' id='q_vote<%=q_id%>'><%= q.getNumVote() %></div>
								<div hidden class='down_button user' onclick='VoteDown(true,<%=q_id%>)'><img id='q_down' src='assets/img/down<%=q.getStatus() %>.png' width='30' height='30'></div>
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
								<div hidden class='up_button user' onclick='VoteUp(false,<%=a.get(i).getNumAnswer()%>)'><img id='a_up<%=a.get(i).getNumAnswer() %>' src='assets/img/up<%=a.get(i).getStatus()%>.png' width='30' height='30'></div>
									<div class = 'vote' id='vote<%=a.get(i).getNumAnswer()%>'><%= a.get(i).getNumVotes() %></div>
								<div hidden class='down_button user' onclick='VoteDown(false,<%=a.get(i).getNumAnswer()%>)'><img id='a_down<%=a.get(i).getNumAnswer() %>' src='assets/img/down<%=a.get(i).getStatus()%>.png' width='30' height='30'></div>
							</div>
						</div>
						<div class = 'a_mid'>
							<div class = 'a_content'><%= a.get(i).getContent() %></div>
						</div>
						<div class = 'details'>Answered by 
							<span class = 'b_link'><%= a.get(i).getUsername() %> </span>
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
		<%@include file="footer.jsp" %>
	</div>
</body>
	<% 	} else {
			%>
			<jsp:include page="notfound.jsp" flush="true">
				<jsp:param name="onlyBody" value="true" />
			</jsp:include>
		<%}
	} else {
		%>
		<jsp:include page="notfound.jsp" flush="true">
			<jsp:param name="onlyBody" value="true" />
		</jsp:include>
	<%
	} %>
</html>