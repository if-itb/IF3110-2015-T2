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
      
      <form id="search" action="search.jsp?id=" action="GET" onsubmit="return validateSearch()">
        <table>
        <tr>
          <td width="200%"> <input id="q" placeholder="What are you looking for?" type="text" class="form" name="q"></td>
          <td width="20%"> <button class="button" type="submit">Search</button> </td>
        </tr>
        </table>
      </form>

      <p class="text-center">Cannot find what you are looking for? <a href="/StackExchangeclient/ask.jsp" class="link">Ask here.</a></p>

      <br/> <h3>Recently Asked Questions</h3>

          <%-- start web service invocation --%>
    <%
    try {
      QuestionWS.QuestionWS_Service service = new QuestionWS.QuestionWS_Service();
      QuestionWS.QuestionWS port = service.getQuestionWSPort();
      java.util.List<QuestionWS.Question> result = port.getQuestion();
      for(QuestionWS.Question question : result){
        //question
        out.println("<div class=\"question\">");
        out.println("<hr class=\"line\">");
        out.println("<div class=\"item\">");
        out.println("<div class=\"vote\">");
        out.println("<p class=\"text-center\">");
        out.println("<a href=#>");
        out.println(question.getVote());
        out.println("</a>");
        out.println("</p>");
        out.println("<p class=\"text-center\">");
        out.println("<a href=\"question jsp = id\">");
        out.println("Votes");
        out.println("</a>");
        out.println("</p>");
        out.println("</div>");
        //answer
        out.println("<div class=\"answer\">");
        out.println("<p class=\"text-center\">");
        out.println("<a href=#>");
        out.println(question.getSumAns());
        out.println("</a>");
        out.println("</p>");
        out.println("<p class=\"text-center\">");
        out.println("<a href=\"question jsp = id\">");
        out.println("Answer");
        out.println("</a>");
        out.println("</p>");
        out.println("</div>");
        out.println("<div class=\"text\">");
        out.println("<p><i><a href=\"idem\">"+question.getTopic()+"</a></i></p>");
        out.println("</div>");
        out.println("<div class=\"text\">");
        out.println("<p><i><a href=\"idem\">"+question.getContent()+"</a></i></p>");
        out.println("</div>");
        out.println(" <div class=\"text-right\">");
        out.println("lalalala");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
      }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>
             
    <script type="text/javascript" src="/assets/js/validation.js"></script>
  </body>
  <footer> <br><br> </footer>
</html>