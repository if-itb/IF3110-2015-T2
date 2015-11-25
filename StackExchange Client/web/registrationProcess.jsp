<%-- 
    Document   : registrationProcess
    Created on : Nov 25, 2015, 1:25:44 PM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registration Process</h1>
        
        
            <%-- start web service invocation --%><hr/>
    <%
    try {
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String userName = request.getParameter("name");
	java.lang.String password = request.getParameter("password");
	java.lang.String email = request.getParameter("email");
	// TODO process result here
	java.lang.Boolean result = port.addUser(userName, password, email);
	
        if ( result){
            out.println("success");
        } else{
            out.println("failed");
        }
        
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    <a href="index.jsp">Back to Homepage</a>
        
        
        
        
    </body>
</html>
