<%-- 
    Document   : downAns
    Created on : Nov 19, 2015, 5:40:17 PM
    Author     : Satria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        answermodel.AnswerWS_Service service = new answermodel.AnswerWS_Service();
        answermodel.AnswerWS port = service.getAnswerWSPort();
        
        int id = Integer.parseInt(request.getParameter("id"));
        // TODO process result here
        port.downAnswer(id);
    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }
    String site = "index1.jsp";
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>