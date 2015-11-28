
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Simple Stack Exchange</title>
    </head>
    <body>
        <center> <h1>Simple Stack Exchange</h1>
        
        <form name="Search" action='login.jsp'>
            <input type="text" name="keyword" size="130">
            <input type="submit" value="Search"><br>
            Can't find what you're looking for? <a href="state"> Ask here</a>
        </form>    
        </center>    
        <h2>Recently Asked Question</h2> 
    <%
    try {
	stackexchange.Question_Service service = new stackexchange.Question_Service();
	stackexchange.QuestionWS port = service.getQuestionWSPort();
	// TODO process result here
	java.util.List<stackexchange.Question> qlist = port.getListQuestion();
	if (!qlist.isEmpty()) {
            for (stackexchange.Question q : qlist) {
                out.println("<hr width='80%'>");
                out.println(q.getIdUser() + " | <a href='answer.jsp?id=" + q.getId() + "'>" +q.getTopic() + "</a> | " + q.getContent()+"<br>");         
            }
        } else {
            out.println("<hr width='80%'>");
            out.println("No recent question asked.<br>");
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
        
    </body>
    
</html>