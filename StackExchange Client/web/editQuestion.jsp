<%-- 
    Document   : editQuestion
    Created on : Nov 26, 2015, 11:37:20 AM
    Author     : William Sentosa
--%>

<%@page import="userWebService.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  try {
      questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
      questionWS.QuestionWebService port = service.getQuestionWebServicePort();
      String token = request.getParameter("token");
      String topic = request.getParameter("topic");
      String content = request.getParameter("content");
      int id = Integer.parseInt(request.getParameter("id"));
      int qid= Integer.parseInt(request.getParameter("qid"));
      userWebService.UserWebService_Service userService = new userWebService.UserWebService_Service();
      userWebService.UserWebService userPort = userService.getUserWebServicePort();
      String result = port.editQuestion(token, qid, topic, content, id);
      response.sendRedirect("index.jsp?token=" + token + "&id=" + id);
  } catch (Exception ex) {
      out.println("Gagal");
  }
%>

