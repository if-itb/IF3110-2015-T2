<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*, java.io.*"%>
	<%@ page import = "org.tusiri.ws.question.QuestionService" %>
	<%@ page import = "org.tusiri.ws.question.Question" %>
	<%@ page import = "org.tusiri.ws.question.QuestionItem" %>

	<jsp:include page="Header.jsp">
		<jsp:param name="pageTitle" value="Simple StackExchange" />
		<jsp:param name="isNeedCookieCheck" value="false" />
	</jsp:include>
	
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
	
	<script>
	function checkToken(){
		var tokenData = {access_token:"<%= access_token %>"}
		<%
			String checkTokenUrl = "http://localhost:8080/REST-WS/rest/token-validity/getQuestionAccessValidity";
			if(request.getParameter("validityUrl")!=null){
				checkTokenUrl += request.getParameter("validityUrl");
			}
		%>
		var validityData = {access_token:"<%= access_token %>",id_question:<%= id_question %>}
		var checkTokenUrl = "<%= checkTokenUrl %>";
		$.ajax({
	              url: checkTokenUrl,
	              data: validityData,
	              dataType: "json",
	              type: "POST",
	              success: function(data) {
	                  var valid = data.valid;
	                  if(valid){
	               	   var element = document.getElementById('signin');
	               	   element.setAttribute('href','signout.jsp');
	               	   var str = $('a#signin').text('Sign Out');
	               	   $('a#register').remove();
	                  }
	                  if(!valid){
	        	  		window.location.href = "index.jsp";
	        	  		$('body').remove();
						alert("Anda tidak berhak mengakses");
	                  }
	              }
	          });
	}
	$(document).ready(function(){
	    checkToken();
	});
	</script>
	
</head>

<body>
	<jsp:include page="navigationbar.jsp"/>
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

<% 		}
	}%>