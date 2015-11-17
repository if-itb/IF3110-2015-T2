<%-- 
    Document   : upvoteQuestion
    Created on : Nov 17, 2015, 8:07:56 PM
    Author     : Luqman A. Siswanto
--%>

<%
  int qid = Integer.parseInt(request.getParameter("id"));
  int type = +1;
  int uid = 1;
  
  QuestionWS.QuestionWS_Service service = new QuestionWS.QuestionWS_Service();
  QuestionWS.QuestionWS port = service.getQuestionWSPort();

  port.voteQuestion(qid, uid, type);
  
  String url = "../view/question.jsp?id=" + qid;
  response.sendRedirect(url);
%>