<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><%= request.getParameter("title") %></title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<base href="http://localhost:8080/WebClient/index.jsp"/>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
		
	if((access_token != null) && (access_token.length()>0)){
		//check access_token validity to server
%>

	<script>
	function checkToken(){
		var tokenData = {access_token:"<%= access_token %>"}
		var checkTokenUrl = "http://localhost:8080/REST-WS/rest/token-validity";
		$.ajax({
               url: checkTokenUrl,
               data: tokenData,
               dataType: "json",
               type: "POST",
               success: function(data) {
                   var valid = data.valid;
                   if(valid){
                	   var element = document.getElementById('signin');
                	   element.setAttribute('href','signout.jsp');
                	   var str = $('a#signin').text('Sign Out');
                   }
               }
           });
	}
	$(document).ready(function(){
	    checkToken();
	});
	</script>
	<% } 
	} %>
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
                </button>
                <a class="navbar-brand" href="index.jsp">StackExchange</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a id="signin" href='signin.jsp'>Sign In</a></li>
                    <li>
                        <a href="register.jsp">Register</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
</body>
</html>