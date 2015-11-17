<%-- 
    Document   : ask
    Created on : Nov 16, 2015, 6:09:04 PM
    Author     : Luqman A. Siswanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Ask Question | Overflow48</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
    <link rel="icon" type="image/png" href="../assets/white-icon.jpg">
    
  </head>
  <body>
    <div class="container">
      <h1 class="text-center"><a href="/StackExchangeclient">OVERFLOW48</a></h1>
      <br/>
      <h2>What's your question?</h2>
      <%
        QuestionWS.QuestionWS_Service service = new QuestionWS.QuestionWS_Service();
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        
        QuestionWS.Question q = new QuestionWS.Question();
        String str = request.getParameter("id");
        if(str != null) {
          int id = Integer.parseInt(str);
          q = port.getQuestionByQID(id).get(0);
        }
      %>
      <hr class="line">
      <form id="ask" action="../controller/ask.jsp" method="POST">
        <input name="id" type="hidden" value="<%=q.getId()%>">
        <input id="topic" placeholder="Question Topic" class="form" type="text" name="topic" value="<%=(str != null? q.getTopic() : "")%>">
        <textarea id="content" placeholder="Content" rows="4" class="box" name="content"><%=(str != null? q.getContent() : "")%></textarea>
        <div class="text-right">
            <button class="button" type="submit">Post</button>
        </div>
      </form>
    </div>
    
  </body>
  <footer> <br><br> </footer>
</html>