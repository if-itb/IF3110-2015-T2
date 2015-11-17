<%-- 
    Document   : ask.jsp
    Created on : Nov 17, 2015, 7:47:33 PM
    Author     : Luqman A. Siswanto
--%>

<%
  String str = request.getParameter("id");
  int qid = Integer.parseInt(str);
  String topic = request.getParameter("topic");
  String content = request.getParameter("content");
  int uid = 1;
  
  QuestionWS.QuestionWS_Service qservice = new QuestionWS.QuestionWS_Service();
  QuestionWS.QuestionWS port = qservice.getQuestionWSPort();
  if(qid != 0) {     // update question (id question ada)
    port.updateQuestion(qid, topic, content);
  } else {
    port.insertQuestion(uid, topic, content);
  }
  
  String url = "/StackExchangeclient";
  response.sendRedirect(url);
%>