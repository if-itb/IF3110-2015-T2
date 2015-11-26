<%@page import="java.util.ArrayList"%>
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
            <img class="small-icon" src="img/up.png" name="question-up" onclick="QuestionDetailController?qid=<%= questions.get(i).getIdQuestion()%>&token=<%= request.getParameter("token") %>"/><br>
            <div class="big-number" id="question-1">
                <%= questions.get(i).getVoteNum() %>
            </div>
            <img class="small-icon" src="img/down.png" name="question-down" onclick="QuestionDetailController?qid=<%= questions.get(i).getIdQuestion()%>&token=<%= request.getParameter("token") %>"/><br>
          </div>
          <div class="right-position">
            <div class="answer-question-detail">
              <%= questions.get(i).getContent() %>
            </div>
            <!-- Asked by -->
            <%
            UserWS.User u1 = new UserWS.User();
            if (request.getAttribute("u1") != null) {
              u1 = (UserWS.User)request.getAttribute("u1");
            %>
            asked by
            <%= u1.getName() %>
            at
            <%= questions.get(i).getDatetime() %>
            <%
                if (request.getAttribute("userId") != null) {
                    if (users[i].getIdUser() == (Integer)request.getAttribute("userId")) {
            %>
            |
            <a class="yellow" href="ask-question.jsp">
              edit
            </a>
            |
            <a class="red" href="index.jsp" onclick="return confirm('Do you want to delete this post?')">
              delete
              <%
                        }
                    }
                %>
            </a>
            <%
            }
            %>
            
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
            <%
                if (request.getAttribute("count") != null) {
                  int count = (Integer)request.getAttribute("count");
            %>
            <%= count %> Answer
            <%
                }
            %>
        </div>

        <!-- Answers -->
        <div class="same-height-row border-bottom">
          <%
            List<AnswerWS.Answer> answers = new ArrayList<AnswerWS.Answer>();
            List<UserWS.User> u2 = new ArrayList<UserWS.User>();
            if ((request.getAttribute("answers") != null) && (request.getAttribute("u2") != null)) {
              answers = (ArrayList<AnswerWS.Answer>)request.getAttribute("answers");
              u2 = (ArrayList<UserWS.User>)request.getAttribute("u2");
              if (answers.size() > 0) {
                for (int i = 0; i < answers.size(); i++) {
          %>
          <div class="vote-number">
              <a href = 'VoteController?name=answer-up&qid=<%= questions.get(i).getIdQuestion()%>&aid=<%= answers.get(i).getIdAnswer()%>&token=<%= request.getParameter("token") %>'><img class="small-icon" src="img/up.png" onclick=""/><br></a>
            <div class="big-number" id="answer-1">
                <%= answers.get(i).getVoteNum() %>
            </div>
            <img class="small-icon" src="img/down.png" name="answer-up" onclick="QuestionDetailController?aid=<%= answers.get(i).getIdAnswer()%>&token=<%= request.getParameter("token") %>"/><br>
          </div>
          <!-- Answers Content -->
          <div class="right-position">
            <div class="answer-question-detail">
            
            <%= answers.get(i).getContent() %>
            </div>
            answered by
            <%= u2.get(i).getName() %>
            at
            <%= answers.get(i).getDatetime() %>
          </div>
        </div>
        <%      
            }
          } else { 
        %>
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
      <% if (!"not-valid".equals(request.getParameter("token")) && request.getParameter("token") != null ) {
        
      %>
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
      <% } else { %>
      <div class="same-height-row border-bottom">
          <a href="log-in.jsp">Login</a> or <a href="register.jsp">register</a> to answer this question
      </div>
      <% } %>
    </div>

    <!-- JavaScript -->
    <script src="js/script.js"></script>
  </body>
</html>
