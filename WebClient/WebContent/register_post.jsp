<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*, java.io.*"%>
<%@ page import = "org.tusiri.ws.user.UserService" %>
<%@ page import = "org.tusiri.ws.user.User" %>
<html>
	<head>
		<title>Using GET and POST Method to Read Form Data</title>
	</head>
	<body>
	<%
		UserService uservice = new UserService();
		User u = uservice.getUserPort();
		String message = "";

		int result = u.createUser(request.getParameter("username"), request.getParameter("password"),request.getParameter("email"),request.getParameter("fullname"));
		if(result>0){//success
			String site = new String("User.jsp?id="+result);
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
		else if(result==-1){//exist redirect into sorry page
			message  = "Email has been registered. Please choose another email";
		}
		else{
			message = "Ooops.. Something went wrong. Please retry in a few moment";
		}
	%>
	<center>
		<ul>
		<li><p><b>First Name:</b>
   			<%= request.getParameter("username")%>
		</p></li>
		<li><p><b>Email:</b>
   			<%= request.getParameter("email")%>
		</p></li>
		<li><p>
   			<%= message %>
		</p></li>
		</ul>
	</body>
</html>