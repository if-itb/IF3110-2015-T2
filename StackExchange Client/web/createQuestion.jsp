<%-- 
    Document   : createQuestion
    Created on : Nov 25, 2015, 9:26:47 AM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- start web service invocation --%>
        <%
        try {
            com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
            com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
             // TODO initialize WS operation arguments here
            java.lang.String accessToken = request.getParameter("accessToken");
            java.lang.String title = request.getParameter("topic");
            java.lang.String content = request.getParameter("content");
            // TODO process result here
            int result = port.createQ(accessToken, title, content);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%>
        <%
            String site = "index.jsp";
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        %>
    </body>
</html>
