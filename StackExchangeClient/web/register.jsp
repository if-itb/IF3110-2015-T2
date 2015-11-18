<%-- 
    Document   : register
    Created on : Nov 18, 2015, 8:50:14 AM
    Author     : mochamadtry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        try {
            registers.Register_Service service = new registers.Register_Service();
            registers.Register port = service.getRegisterPort();
             // TODO initialize WS operation arguments here
            java.lang.String name = request.getParameter("name"); //getParameter("username");
            java.lang.String email = request.getParameter("email");
            java.lang.String password = request.getParameter("password");
            // TODO process result here
            int result = port.addRegister(name, email, password);
            out.println("Result = "+result);
            } catch (Exception ex) {
                out.println(ex);
        }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
