<!-- Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web
Membuat website tanya jawab seperti Stack Exchange dengan REST dan SOAP dan arsitektur berorientasi servis.
Author: 
- Irene Wiliudarsan (13513002)
- Angela Lynn       (13513002)
- Devina Ekawati    (13513002) -->
<!-- File: question-detail.jsp  -->

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Question Detail</title>
    <meta charset="utf-8"/>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/main.css"/>

  </head>
  <body>
    <!-- Title -->
    <div class="title">
      <a href="index.jsp">
        StackExchange
      </a>
    </div>

    <div class="content">
      <!-- Question -->
      <div class="stacked">
        <div class="subtitle">
          <%
            List<QuestionWS.Question> questions = new ArrayList<QuestionWS.Question>();
            if (request.getAttribute("questions") != null) {
              questions = (ArrayList<QuestionWS.Question>)request.getAttribute("questions");
              for (int i = 0; i < questions.size(); i++) {
          %>
          <%= questions.get(i).getTopic() %>
          
        </div>
        <!-- Questions Content -->
        <div class="same-height-row border-bottom">
          <div class="vote-number">
            <img class="small-icon" src="img/up.png" onclick=""/><br>
            <div class="big-number" id="question-1">
              5
            </div>
            <img class="small-icon" src="img/down.png" onclick=""/><br>
          </div>
          <div class="right-position">
            <div class="answer-question-detail">
              <%= questions.get(i).getContent() %>
            </div>
            <!-- Asked by -->
            asked by
            Jen Hammington
            at
            jen.hammington@gmail.com
            |
            <a class="yellow" href="ask-question.jsp">
              edit
            </a>
            |
            <a class="red" href="index.jsp" onclick="return confirm('Do you want to delete this post?')">
              delete
            </a>
          </div>
            <%
              }
            }
          %>
        </div>
      </div>
      
      <!-- Answers List -->
      <div class="stacked">
        <div class="subtitle">
          1 Answer
        </div>

        <!-- Answers -->
        <div class="same-height-row border-bottom">
          <div class="vote-number">
            <img class="small-icon" src="img/up.png" onclick=""/><br>
            <div class="big-number" id="answer-1">
              5
            </div>
            <img class="small-icon" src="img/down.png" onclick=""/><br>
          </div>
          <!-- Answers Content -->
          <div class="right-position">
            <div class="answer-question-detail">
            <%
            List<AnswerWS.Answer> answers = new ArrayList<AnswerWS.Answer>();
            if (request.getAttribute("answers") != null) {
              answers = (ArrayList<AnswerWS.Answer>)request.getAttribute("answers");
              if (answers.size() > 0) {
                for (int i = 0; i < answers.size(); i++) {
            %>
            <%= answers.get(i).getContent() %>
            <%
                }
            %>
            </div>
            answered by
            John Kennedy
            at
            2015-10-25 11:24:29
          </div>
        </div>
        <% } else { %>
        <!-- If no answers: -->
        <div class="same-height-row border-bottom">
          Sorry, there are no answers available yet. Know someone who can answer?
        </div>
        <%
              }
            }
        %>
        
      </div>

      <!-- Answer Form -->
      <div class="stacked">
        <div id="answer-form-title">
          Your Answer
        </div>
        <form class="right" id="answer-form" name="answer-form" action="question-detail.jsp" method="post" onsubmit="return questionFormValidation()">
          <input class="full-length" id="answer-name" name="answer-name" type="text" placeholder="Name">
          <input class="full-length" id="answer-email" name="answer-email" type="text" placeholder="Email">
          <textarea class="full-length" id="answer-content" name="answer-content" placeholder="Content" rows="10" cols="50"></textarea>
          <input class="button" name="answer-submit" type="submit" value="Post">
        </form>
      </div>
    </div>

    <!-- JavaScript -->
    <script src="js/script.js"></script>
  </body>
</html>
