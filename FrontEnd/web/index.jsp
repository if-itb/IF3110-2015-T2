<%-- 
    Document   : index
    Created on : Nov 12, 2015, 2:18:23 AM
    Author     : Asus
--%>
<%@ page import = "FrontEndClient.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method = "post" action = "index.jsp">
            Name : <input type ="text" name = "name"><br>
            Email : <input type ="text" name = "email"><br>
            Password : <input type ="password" name = "password"><br>
            <input type ="submit">
        </form>
        <%-- start web service invocation --%><hr/>
        <%
        try {
            String Name = request.getParameter("name");
            String Email = request.getParameter("email");
            String Password = request.getParameter("password");
            client.ws.RegisterWS_Service service = new client.ws.RegisterWS_Service();
            client.ws.RegisterWS port = service.getRegisterWSPort();
             // TODO initialize WS operation arguments here
            java.lang.String name = Name;
            java.lang.String email = Email;
            java.lang.String password = Password;
            // TODO process result here
            int result = port.register(name, email, password);
            out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
