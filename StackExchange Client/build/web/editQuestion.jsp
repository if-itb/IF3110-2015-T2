<%-- 
    Document   : editQuestion
    Created on : Nov 24, 2015, 4:40:05 AM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css">
  <title>Simple StackExchange</title>
  <script type = "text/javascript" src="validatorInputQuestionAnswer.js"></script>
</head>

<body>
<div id="container">
  <div id="header_addQuestions">
    <span id="Judul">Simple StackExchange</span>
    <span id="what">What's your question?</span>
  </div>
    
        <%-- start web service invocation --%><hr/>
    <%
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	 int questionId = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	wsmodel.QuestionClass result = port.getQuestionByID(questionId);
	
        
        String qTopic = result.getQuestionTitle();
        String qContent = result.getQuestionContent();
    %>
    <%-- end web service invocation --%><hr/>

    
    

  <div id="body">
    <form name="myForm" action="editQuestionProcess.jsp" method="post">
      <input type="text" name="questionTopic" placeholder="Question Topic" value='<%= qTopic %>'><br>
      <textarea name="questionContent" placeholder="Content"> <%= qContent %> </textarea><br>
      <input type="hidden" name="questionId" value='<%= questionId %>'>
      <div id="submitter">
        <input class="submitButton" name= "submitButton" type="submit" value="Update Question">
      </div>
    </form>
  </div>

</div>

</body>
</html>
