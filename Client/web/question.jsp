<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import= "java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service" %>
<%@ page import="com.yangnormal.sstackex.*" %>
<%
	URL url = new URL ("http://localhost:8082/ws/stackexchange?wsdl");
	QName qname = new QName("http://ws.sstackex.yangnormal.com/","WebServiceImplService");
	WebServiceImplService webService = new WebServiceImplService(url,qname);
	WebServiceInterface ws = webService.getWebServiceImplPort();
	int id = Integer.parseInt(request.getParameter("id"));
	Question q=ws.getQuestion(1);
	AnswerArray answerList = ws.getAnswerList(1);
%>
<!DOCTYPE HTML>

	<html>
	<head>

		<title><% out.println(q.getTopic());%></title>
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		</head>
		<body>
			<div class="container">
				<a class="homelink" href="http://mystackexchange.dev"><h1 id="title">My StackExchange</h1></a>
				<div class="content">
					<h2><% out.println(q.getTopic());%></h2>
					<hr>
					<div class="stackquestion">
						<div class="votes"><div class="arrow-up" onclick=""></div><div id="votequestion"><% out.println(q.getVote());%></div><div class="arrow-down"  onclick=""></div></div>
						<div class="content"><% out.println(q.getContent());%></div>
						<div class="detail">asked by <% out.println(q.getUser().getName()); %> <a class="linkname"></a> at <% out.println(q.getDate());%> | <a class="linkedit" href="">edit</a> | <a class="linkdelete" onclick="" href="">delete</a></div>
					</div>
					<br>
					<h2><% out.println(answerList.getItem().size());%> Answers</h2>
					<hr>
				<%
					for (Answer answer : answerList.getItem()) {
				%>
					<div class="stackanswer">
						<br>
						<div class="votes"><div class="arrow-up" onclick=""></div><div id="voteanswer"><% out.println(answer.getVote()); %></div><div class="arrow-down" onclick=""></div></div>
						<div class="content"><% out.println(answer.getContent()); %></div>
						<div class="detail">answered by <% out.println(answer.getUser().getName()); %><a class="linkname"></a> at <% out.println(answer.getDate()); %> </div>
					</div>
					<br>
					<hr>
					<% } %>
				</div>
				<div class="content question">
					<h2 class="title2">Your Answer</h2>
					<hr>
					<form action="" method="post" onsubmit="">
					<input class="textbox" type="text", name="name", id="name" placeholder="Name">
					<br>
					<input class="textbox" type="text", name="email", id="email" placeholder="Email">
					<br>
					<textarea class="textarea", name="content", id="content" placeholder="Content" ></textarea>
					<br>
					<input type="submit" id="post" value="Post">
					</form>	
				</div>
			</div>
			<script src="js/script.js"></script>
		</body>
	</html>