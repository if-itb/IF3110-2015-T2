<%-- 
    Document   : registervalidation
    Created on : 24-Nov-2015, 21:01:18
    Author     : KEVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <%
    try {
        
	userWebService.UserWebService_Service service = new userWebService.UserWebService_Service();

        userWebService.UserWebService port = service.getUserWebServicePort();
	 // TODO initialize WS operation arguments here

        java.lang.String arg0 = request.getParameter("name");

	java.lang.String arg1 = request.getParameter("email");
	java.lang.String arg2 = request.getParameter("password");

	
	 // TODO initialize WS operation arguments here
	
	// TODO process result here
	boolean result = port.isUserExist(arg1);
        out.println("lalala");
        if (!result){ 
            out.println("halo");
            java.lang.String result2 = port.addUser(arg0, arg1, arg2);
        } else {
            response.sendRedirect("register.jsp");
            
        }
    } catch (Exception ex) {
	out.println(ex.getMessage());
// TODO handle custom exceptions here
    }
    %>
</body>
</html>
