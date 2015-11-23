<%-- 
    Document   : ask
    Created on : 23-Nov-2015, 13:18:54
    Author     : KEVIN
--%>

<html lang="en">
<head> 
	<meta charset="UTF-8">
	<title>Simple StackExchange </title>
	<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
</head>

<body>
	<div id="wrapper">
		<h1 class = "center"> <a href="index.php"> Simple StackExchange </a>
</h1>

<h2 class ="underline"> What's your question? </h2>

<form action="index.php" method="POST" class="block" onsubmit="return validateQuestionForm(this)">

<form action="index.php" method="POST" class="block">
	<input type="text" placeholder="Name" name="name" value="" />
	<input type="text" placeholder="Email" name="email" value="" />
	<input type="text" placeholder="Question Topic" name="topic" value="" />
	<textarea name="content" placeholder="Content"></textarea>
	<input type="submit" value="Post" />
	<input type="hidden" name="type" value="ask" />
	<input type="hidden" name="question_id" value="" />
</form>

	</div>
     <%-- start web service invocation --%><hr/>
    <%
    try {
	questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
	questionWS.QuestionWebService port = service.getQuestionWebServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String arg0 = request.getParameter("name");
	java.lang.String arg1 = request.getParameter("email");
	java.lang.String arg2 = request.getParameter("topic");
	java.lang.String arg3 = request.getParameter("content");
	int arg4 = 0;
	// TODO process result here
	java.lang.String result = port.addQuestion(arg0, arg1, arg2, arg3, arg4);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</body>
 </html>
