<%-- 
    Document   : upvoteAnswer
    Created on : Nov 17, 2015, 8:08:16 PM
    Author     : Luqman A. Siswanto
--%>

<%
  int aid = Integer.parseInt(request.getParameter("id"));
  int type = +1;
  int uid = 1;
  
  AnswerWS.AnswerWS_Service aservice = new AnswerWS.AnswerWS_Service();
  AnswerWS.AnswerWS port = aservice.getAnswerWSPort();
  
  int qid = port.getAnswerQID(aid);
  port.voteAnswer(aid, uid, type);
  
  String url = "../view/question.jsp?id=" + qid;
  response.sendRedirect(url);
%>