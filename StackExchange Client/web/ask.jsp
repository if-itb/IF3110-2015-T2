<%-- 
    Document   : ask
    Created on : Nov 16, 2015, 11:23:02 PM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <title>Simple StackExchange</title>
    </head>
    <body>
	<div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
	<br>
	<br>
	<br>
	<br>
	<div class="subtitle">What's your question?</div>
	<hr class='line'>

    <%
    try {
        
        String askForm =        
            "<form name='askForm' action='createQuestion.jsp' onsubmit='return validateQuestion()' method='post'>"
                +"<input type='hidden' name='accessToken' value='5'>"
                +"<input type='text' class='form-text' name='topic' placeholder='Question Topic'><br>"
                +"<textarea name='content' class='form-textarea' placeholder='Content'></textarea><br>"
                +"<button class='button-post' type='submit'> Submit </button>"
            +"</form>"
        ;
        out.write(askForm);
    } catch (Exception ex) {
        out.write("exception");
	// TODO handle custom exceptions here
    }
    %>
    
    </body>
</html>



