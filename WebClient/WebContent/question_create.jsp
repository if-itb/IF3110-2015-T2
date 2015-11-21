<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" flush="true">
		<jsp:param name="pageTitle" value="Ask A Question" />
	</jsp:include>
</head>
<body>
<body>
	<jsp:include page="navigationbar.jsp" flush ="true"/>
	
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
                            <input type="text" class="form-control" id="name" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Question:</label>
                            <textarea rows="10" cols="100" class="form-control" id="message" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
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