<%-- 
    Document   : sign up
    Created on : Nov 27, 2015, Nov 27, 2015 7:49:31 PM
    Author     : Fikri-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	userWS.UserWS_Service service = new userWS.UserWS_Service();
	userWS.UserWS port = service.getUserWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String nama = request.getParameter("Name");
	java.lang.String email = request.getParameter("Email");
	java.lang.String password = request.getParameter("Password");
	// TODO process result here
	int result = port.createUser(nama, email, password);
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "../index.jsp");
        session.setAttribute("sessionName", nama);
        session.setAttribute("sessionEmail", email);
        session.setAttribute("sessionPass", password);

%>
    <%-- end web service invocation --%><hr/>

