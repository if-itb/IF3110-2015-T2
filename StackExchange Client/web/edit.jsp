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
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
        int qid = Integer.parseInt(request.getParameter("id"));
        String question_idLama = "";
        String topicLama = "";
        String contentLama = "";
        if(request.getParameter("id") != null){
            java.util.List<com.wbd.qst.Question> result = port.getQuestionbyID(qid);
            question_idLama = String.valueOf(result.get(0).getIDQ());
            topicLama = result.get(0).getQuestionTopic();
            contentLama = result.get(0).getContent();
        }
        String askForm =        
            "<form name='editForm' action='editpost.php' onsubmit='return validateQuestion()' method='post'>"
                +"<input value='"+question_idLama+"' type='hidden' name='question_id'>"
                +"<input value='"+topicLama+"' type='text' class='form-text' name='topic' placeholder='Question Topic'><br>"
                +"<textarea value='"+contentLama+"'  name='content' class='form-textarea' placeholder='Content'></textarea><br>"
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



