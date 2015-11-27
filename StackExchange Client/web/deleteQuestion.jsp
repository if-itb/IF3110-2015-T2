<%-- 
    Document   : deleteQuestion
    Created on : Nov 26, 2015, 12:00:33 PM
    Author     : William Sentosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  try {
      questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
      questionWS.QuestionWebService port = service.getQuestionWebServicePort();
      String token = request.getParameter("token");
      int id = Integer.parseInt(request.getParameter("id"));
      int qid= Integer.parseInt(request.getParameter("qid"));
      String result = port.deleteQuestion(token, qid, id);
      response.sendRedirect("index.jsp?token=" + token + "&id=" + id);
  } catch (Exception ex) {
      out.println("Gagal");
  }
%>
