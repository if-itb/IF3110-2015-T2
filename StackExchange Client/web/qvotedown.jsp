<%-- 
    Document   : qvotedown
    Created on : Nov 26, 2015, 2:44:57 PM
    Author     : acel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
	questionWS.QuestionWebService port = service.getQuestionWebServicePort();
	 // TODO initialize WS operation arguments here	
        java.lang.String arg0 = request.getParameter("token");
	int arg1 = Integer.parseInt(request.getParameter("qid"));
	int arg2 = Integer.parseInt(request.getParameter("id"));
	// TODO process result here
	java.lang.String result = port.decrVote(arg0, arg1, arg2);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
     response.sendRedirect("http://localhost:8080/StackExchange_Client/question.jsp?token=" + request.getParameter("token")
                                        + "&id=" + request.getParameter("id") + "&qid=" + request.getParameter("qid"));
    %>
    <%-- end web service invocation --%><hr/>

