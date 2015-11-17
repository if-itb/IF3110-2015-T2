
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>Edit Post</title>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<a class="homelink" href="http://mystackexchange.dev"><h1 id="title">My StackExchange</h1></a>
		<div class="content">
			<h2>Edit Post</h2>
			<hr>
			<form action="editpost.jsp", method="post">
			<input class="textbox" type="text", name="name", id="name" value="'.$rows[0]['name'].'">
			<br>
			<input class="textbox" type="text", name="email", id="email" value="'.$rows[0]['email'].'">
			<br>
			<input class="textbox" type="text", name="topic", id="topic" value="'.$rows[0]['topic'].'">
			<br>
			<textarea class="textarea", name="content", id="content">'.$rows[0]['content'].'</textarea>
			<br>
			<input type="submit" id="post" value="Post">
			</form>
		</div>
		<%@page import= "java.net.URL,javax.xml.namespace.QName,java.lang.String" %>
		<%@page import= "com.yangnormal.sstackex.WebServiceInterface" %>
		<%@page import= "com.yangnormal.sstackex.WebServiceImplService" %>
		<%
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String topic = request.getParameter("topic");
			String content = request.getParameter("content");
			if ((name!= null) && (email!=null) && (topic!=null)&&(content!=null)){
				URL url = new URL ("http://localhost:8082/ws/stackexchange?wsdl");
				QName qname = new QName("http://ws.sstackex.yangnormal.com/","WebServiceImplService");
				WebServiceImplService webService = new WebServiceImplService(url,qname);
				WebServiceInterface ws = webService.getWebServiceImplPort();
				int status = ws.updateQuestion(name,email,topic,content);
				if (status==0){
					response.sendRedirect("registerSuccess.jsp");
				} else {
					response.sendRedirect("registerFail.jsp");
				}
			}
		%>
	</div>
</body>
</html>