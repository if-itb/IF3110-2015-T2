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
            registration.RegistrationWS_Service service = new registration.RegistrationWS_Service();
            registration.RegistrationWS port = service.getRegistrationWSPort();
            // TODO initialize WS operation arguments here
            java.lang.String name = request.getParameter("name");
            java.lang.String email = request.getParameter("email");
            java.lang.String password = request.getParameter("password");
            // TODO process result here
            boolean result = port.register(name, email, password);
            if(result)
                out.println("Success!!");
            else {
                out.println("Failed!!");
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
    </body>
</html>
