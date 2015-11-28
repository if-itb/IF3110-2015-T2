<%-- 
    Document   : answer
    Created on : Nov 24, 2015, 1:20:01 AM
    Author     : Raihan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
    <center>
    
        <h1>Simple Stack Exchange</h1>
            <%-- start web service invocation --%>
    <%
    try {
	stackexchange.Question_Service service = new stackexchange.Question_Service();
	stackexchange.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	int qid = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	stackexchange.Question question = port.getQuestionByID(qid);
        
        out.println("<h3>"+question.getTopic()+"</h3>");
        out.println("<hr width='80%'>");
        out.println(question.getContent()+"<br>");
        
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
        
        N Votes | Vote UP | Vote Down<br>
        asked by X | Email<br><br><br>
        
        N Answers<br>
        <hr width="80%">
            <%-- start web service invocation --%>
    <%
    try {
	Answer.AnswerWS_Service service = new Answer.AnswerWS_Service();
	Answer.AnswerWS port = service.getAnswerWSPort();
	 // TODO initialize WS operation arguments here
	int qid = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	java.util.List<Answer.Answer> anslist = port.getAnswerByQID(qid);
	
        if (anslist.isEmpty()) {
            out.println("No answer yet.<br>");            
        } else {
            for (Answer.Answer ans : anslist) {
                out.println("Answer by : " + ans.getIdUser() + "<br>");
                out.println(ans.getContent()+"<br>");
                out.println("<hr width='80%'>");
            }
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
        
        <h4>Your Answer</h4>
        <form name='question' action='answer.jsp'>            
            <textarea name='acontent' placeholder="Answer" style="resize:none;width:500px;"></textarea><br><br>
            <input type="submit" value="Submit">
        </form>        
        
        
    </center>
    </body>
</html>
