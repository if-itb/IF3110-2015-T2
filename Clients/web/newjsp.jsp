<%-- 
    Document   : newjsp
    Created on : Nov 16, 2015, 5:51:17 AM
    Author     : tama
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
    </body>    <%-- start web service invocation --%><hr/>
       <%-- start web service invocation --%><hr/>
    <%
    try {
	webservice.NewWebService service = new webservice.NewWebService();
	webservice.StackWebSevice port = service.getStackWebSevicePort();
	// TODO process result here
	java.util.List<webservice.Question> result = port.getAllQuestions();
	
        out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    <%-- end web service invocation --%><hr/>

</html>
