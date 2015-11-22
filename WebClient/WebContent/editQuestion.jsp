<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" flush="true">
		<jsp:param name="pageTitle" value="Edit Question" />
	</jsp:include>
</head>
<body class="contact">
	<div id="page-wrapper">
	<!-- Header -->
	<header id="header">
		<h1 id="logo"><a href="index.jsp">Stack Exchange <span>| by Tusiri</span></a></h1>
		<jsp:include page="navigationbar.jsp" flush ="true"/>
	</header>
	<article id="main">
		<header class="special container">
			<span class="icon fa-envelope"></span>
			<strong><h2>Edit Question</h2></strong>
			<p>Fill the form below to edit your question.</p>
		</header>
		<!-- One -->
		<section class="wrapper style4 special container 75%">
		<!-- Content -->
			<div class="content">
				<form name="sentMessage" id="contactForm" action="question_create_post.jsp" METHOD="POST" novalidate>
					<div class="control-group form-group">
						<div class="controls">
							<strong><label class="questionmenu">Topic:</label></strong>
                            <input type="text" class="form-control" name="topic" required data-validation-required-message="Please enter your topic">
                            <p class="help-block"></p>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<strong><label class="questionmenu">Question:</label></strong>
                           	<textarea rows="10" cols="100" class="form-control" name="content" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"> </textarea>
						</div>
					</div>
					
					<div class="row">
						<div class="12u">
							<ul class="buttons">
								<li><input type="submit" class="special" value="Ask Question" /></li>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</section>
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