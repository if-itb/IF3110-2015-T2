<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>New User Profile</title>
	<%@ page import="java.util.*, java.io.*"%>
	<%@ page import = "org.tusiri.ws.user.UserService" %>
	<%@ page import = "org.tusiri.ws.user.User" %>
	<%@ page import = "org.tusiri.ws.user.UserDetail" %>
	
	<!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">
    
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    
    <!-- Javascript -->
    <script src="assets/js/jquery-1.11.1.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.backstretch.min.js"></script>
    <script src="assets/js/scripts.js"></script>
</head>
<body>
	<%
		UserService uservice = new UserService();
		User u = uservice.getUserPort();
		UserDetail D = u.getUser(Integer.parseInt(request.getParameter("id")));
	%>
	<!-- Top content -->
    <div class="top-content">
	    <div class="inner-bg">
	        <div class="container">
	            <div class="row">
	                <div class="col-sm-8 col-sm-offset-2 text">
	                    <h1>
	                    	<strong>Hello</strong> <%= D.getUsername()%> !
	                    </h1>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-sm-4 col-sm-offset-4 text">
	
	                    <div class="card hovercard">
	                        <div class="cardheader">
	
	                        </div>
	                        <div class="avatar">
	                            <img alt="" src="assets/img/default_user.png">
	                        </div>
	                        <div class="info">
	                            <div class="title">
	                                <a target="_blank" href="http://scripteden.com/"><%= D.getUsername()%></a>
	                            </div>
	                            <div class="desc"><%= D.getFullname()%></div>
	                            <div class="desc"><%= D.getEmail()%></div>
	                        </div>
	                        <div class="bottom">
	                            <a class="btn btn-primary btn-twitter btn-sm" href="#">
	                                <i class="fa fa-twitter"></i>
	                            </a>
	                            <a class="btn btn-danger btn-sm" rel="publisher"
	                               href="#">
	                                <i class="fa fa-google-plus"></i>
	                            </a>
	                            <a class="btn btn-primary btn-sm" rel="publisher"
	                               href="#">
	                                <i class="fa fa-facebook"></i>
	                            </a>
	                            <a class="btn btn-warning btn-sm" rel="publisher" href="#">
	                                <i class="fa fa-behance"></i>
	                            </a>
	                            
	                        </div>
	                        <div class="bottom">
	                        	<a href="signin.jsp">
			                       <button id="submitBtn" type="submit" class=btn-success>Get Started!</button>
			                    </a>
			                </div>
	                    </div>   
	                </div>
	            </div>
	
	        </div>
	
	    </div>
	</div>
</body>
</html>