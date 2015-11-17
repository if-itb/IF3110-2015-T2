<%-- 
    Document   : answer
    Created on : Nov 17, 2015, 8:21:10 PM
    Author     : Luqman A. Siswanto
--%>

<%
  int qid = Integer.parseInt(request.getParameter("id"));
  String content = request.getParameter("content");
  int uid = 1;
  
  AnswerWS.AnswerWS_Service aservice = new AnswerWS.AnswerWS_Service();
  AnswerWS.AnswerWS port = aservice.getAnswerWSPort();
  port.insertAnswer(uid, qid, content);
  
  String url = "../view/question.jsp?id=" + qid;
  response.sendRedirect(url);
%>