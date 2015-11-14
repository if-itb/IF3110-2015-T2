<%-- 
    Document   : index
    Created on : Nov 12, 2015, 12:00:30 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.wbd.ans.AnswerWS_Service service = new com.wbd.ans.AnswerWS_Service();
	com.wbd.ans.AnswerWS port = service.getAnswerWSPort();
	 // TODO initialize WS operation arguments here
	int qid = 0;
	// TODO process result here
	java.util.List<com.wbd.ans.Answer> result = port.getAnswerByQID(qid);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.wbd.rgs.RegisterWS_Service service = new com.wbd.rgs.RegisterWS_Service();
	com.wbd.rgs.RegisterWS port = service.getRegisterWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = "";
	java.lang.String email = "";
	java.lang.String password = "";
	// TODO process result here
	int result = port.register(name, email, password);
        if (result == 1){
            out.println("Registration Successful!");
        } else {
            out.println("Registration Failed!");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
