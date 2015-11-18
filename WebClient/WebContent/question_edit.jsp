<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int id_question = Integer.parseInt(request.getParameter("id"));
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
<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        
	    <!-- Bootstrap Core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom CSS -->
	    <link href="css/modern-business.css" rel="stylesheet">
	
	    <!-- Custom Fonts -->
	    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<script>
		function checkToken(){
			var validityData = {access_token:"<%= access_token %>",id_question:<%= id_question %>}
			var checkTokenUrl = "http://localhost:8080/REST-WS/rest/token-validity/getQuestionAccessValidity/";
			$.ajax({
                url: checkTokenUrl,
                data: validityData,
                dataType: "json",
                type: "POST",
                success: function(data) {
                    var valid = data.valid;
                    var element = document.getElementById('signin');
              	    element.setAttribute('href','signout.jsp');
              	    var str = $('a#signin').text('Sign Out');
                    if(!valid)
                    	window.location.href = "index.jsp";
                },
                error: function(jqxhr, status, errorMsg) {
                    alert(status + ": " + errorMsg);
                }
            });
		}
		$(document).ready(function(){
		    checkToken();
		});
		
		
		</script>
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
    <%@ page import = "org.tusiri.ws.question.QuestionService" %>
<%@ page import = "org.tusiri.ws.question.Question" %>
<%@ page import = "org.tusiri.ws.question.QuestionItem" %>
    <%
    
    QuestionService qservice = new QuestionService();
    Question q = qservice.getQuestionPort();
    QuestionItem qi = q.getQuestionInfo(id_question);
    
    String judul = qi.getTopic();
    String content = qi.getContent();
    %>
    
    <div class ="container">
    <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">
            <div class="col-md-8">
                <h3>Create A Question</h3>
                <form name="sentMessage" id="contactForm" action="question_create_post.jsp" METHOD="POST" novalidate>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Topic:</label>
                            <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name."
                            value="<%= judul %>">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Question:</label>
                            <textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"><%= content %></textarea>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">Ask Question</button>
                </form>
            </div>

        </div>
        <!-- /.row -->
    </div>
    <hr>
</body>
</html>
<%
		} else {
			%>
			<script>
				alert("Anda tidak berhak mengedit question ini");
			</script>
			<%
			//redirect ke index
			String site = new String("index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
	} else {
		%>
		<script>
			alert("Anda tidak berhak mengedit question ini");
		</script>
		<%
		//redirect ke index
		String site = new String("index.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site); 
	}
%>