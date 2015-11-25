<%-- 
    Document   : upAns
    Created on : Nov 18, 2015, 5:06:59 PM
    Author     : Satria
--%>

<%-- 
    Document   : updateanswer
    Created on : Nov 18, 2015, 2:45:30 PM
    Author     : Satria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	answermodel.AnswerWS_Service service = new answermodel.AnswerWS_Service();
	answermodel.AnswerWS port = service.getAnswerWSPort();
	 // TODO initialize WS operation arguments here
	int ansId = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	int result = port.upAnswer(ansId);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    String site = "answer.jsp?id="+Integer.parseInt(request.getParameter("qid"));
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    %>
    <%-- end web service invocation --%><hr/>
