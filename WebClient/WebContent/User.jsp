<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<%@ page import="java.util.*, java.io.*"%>
	<%@ page import = "org.tusiri.ws.user.UserService" %>
	<%@ page import = "org.tusiri.ws.user.User" %>
	<%@ page import = "org.tusiri.ws.user.UserDetail" %>
</head>
<body>
<%
	UserService uservice = new UserService();
	User u = uservice.getUserPort();
	UserDetail D = u.getUser(Integer.parseInt(request.getParameter("id")));
%>
	<p>Here is Your Detail</p>
	Username 	: <%= D.getUsername()%></br>
	Email 		: <%= D.getEmail()%></br>
	Fullname 	: <%= D.getFullname()%></br>
	
</body>
</html>