<%-- 
    Document   : downQues
    Created on : Nov 22, 2015, 12:35:24 PM
    Author     : yoga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
	questionmodel.QuestionWS port = service.getQuestionWSPort();
	 // TODO initialize WS operation arguments here
	int qid = Integer.parseInt(request.getParameter("id"));
        String token = request.getParameter("token");
	// TODO process result here
	String result = port.downQuestion(qid,token);
	out.println("Result = "+ result);
        if (result.equals("0")){
            out.println("<script>alert('you must login first to vote')</script>");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    
    
    String site = "answer.jsp?id="+Integer.parseInt(request.getParameter("id")) +"&token=" + request.getParameter("token");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    %>
    <%-- end web service invocation --%><hr/>
