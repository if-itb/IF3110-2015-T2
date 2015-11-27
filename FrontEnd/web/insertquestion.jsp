<%-- 
    Document   : insertquestion
    Created on : Nov 18, 2015, 2:01:07 PM
    Author     : yoga
--%>

<%@page import="java.sql.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            String token = request.getParameter("token");
            questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
            questionmodel.QuestionWS port = service.getQuestionWSPort();

            try {

                Timestamp result = new Timestamp(port.getExpiredDate(token));
                Timestamp ts = new Timestamp(System.currentTimeMillis());
                out.println(ts);
                out.println(result);

                if (ts.after(result)) {
                    String site = "login.jsp?relog=1";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }

            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
<%
     
   
    try {
	
	 // TODO initialize WS operation arguments here
	java.lang.String topic = request.getParameter("topic");
	java.lang.String content = request.getParameter("content");
	// TODO process result here
	int result = port.insertQuestion(token, topic, content);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }

    String site = "index1.jsp?token="+request.getParameter("token") ;
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
