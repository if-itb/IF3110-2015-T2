<%-- 
    Document   : index
    Created on : Nov 16, 2015, 11:34:48 AM
    Author     : Luqman A. Siswanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Overflow48</title>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="icon" type="image/png" href="assets/white-icon.jpg">
  </head>
  <body>
    <div class="container">
      <h1 class="text-center"><a href="/StackExchangeclient">OVERFLOW48</a></h1>
      
      <form id="search" action="view/search.jsp" action="GET">
        <table>
        <tr>
          <td width="200%"> <input id="q" placeholder="What are you looking for?" type="text" class="form" name="q"></td>
          <td width="20%"> <button class="button" type="submit">Search</button> </td>
        </tr>
        </table>
      </form>

      <p class="text-center">Cannot find what you are looking for? <a href="view/ask.jsp" class="link">Ask here.</a></p>

      <br/> <h3>Recently Asked Questions</h3>

      <%
        QuestionWS.QuestionWS_Service service = new QuestionWS.QuestionWS_Service();
        QuestionWS.QuestionWS port = service.getQuestionWSPort();
        java.util.List<QuestionWS.Question> result = port.getQuestion();
      %>

      <% for(QuestionWS.Question q : result) { %>
        <div class="question">
          <hr class="line">
          <div class="item">
            <div class="vote">
              <p class="text-center">
                <a href="view/question.jsp?id=<%=q.getId()%>">
                  <%=q.getVote() %>
                </a>
              </p>
              <p class="text-center">
                <a href="view/question.jsp?id=<%=q.getId()%>">
                  Votes
                </a>
              </p>
            </div>
            <div class="answer">
              <p class="text-center">
                <a href="view/question.jsp?id=<%=q.getId()%>">
                  <%=q.getSumAns()%>
                </a>
              </p>
              <p class="text-center">
                <a href="view/question.jsp?id=<%=q.getId()%>">
                  Answers
                </a>
              </p>
            </div>
            <div class="text">
              <p><i><a href="view/question.jsp?id=<%=q.getId()%>"><%=q.getTopic()%></a></i></p>
            </div>
            <div class="text">
              <p><a href="view/question.jsp?id=<%=q.getId()%>"><%=q.getContent()%></a></p>
            </div>
            <div class="text-right">
              <p>asked by <%=q.getName()%> | <a href="view/ask.jsp?id=<%=q.getId()%>" class="link">edit</a> | <a href="controller/delete.jsp?id=<%=q.getId()%>" class="link">delete</a></p>
            </div>
          </div>
        </div>
      <% } %>
    </div>

  </body>
  <footer> <br><br> </footer>
</html>