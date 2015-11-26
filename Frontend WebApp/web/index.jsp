<!-- Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web
Membuat website tanya jawab seperti Stack Exchange dengan REST dan SOAP dan arsitektur berorientasi servis.
Author: 
- Irene Wiliudarsan (13513002)
- Angela Lynn       (13513002)
- Devina Ekawati    (13513002) -->
<!-- File: index.jsp -->

<%@page import="java.util.*"%>
<%@page import="UserWS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <meta charset="utf-8"/>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
  </head>
  <body>
    <!-- Navigation Bar -->
    <ul class="nav-bar">
      <li><a href="log-in.jsp">Log in</a></li>
      <li><a href="register.jsp">Register</a></li>
    </ul>
      
    <!-- Title -->
    <div class="title">
      <a href="IndexController?token=123abc">
        StackExchange
      </a>
    </div>

    <div class="content">
      <!-- Search Bar -->
      <div class="stacked" id="search-section">
        <form id="search-form" name="search-form" action="" method="post" onsubmit="return searchFormValidation()">
          <input id="search-key" name="search-key" type="text">
          <input class="button" name="search-submit" type="submit" value="Search">
        </form>
        <br>
        Cannot find what you are looking for? 
        <a class="yellow" href="AskController?token=<%= request.getParameter("token") %>">
          Ask here
        </a>
      </div>

      <!-- Recently Asked Questions -->
      <div class="stacked">
        <div class="subtitle">
          Recently Asked Questions
        </div>
        <div class="questions-list">
          <%
            List<QuestionWS.Question> questions = new ArrayList<QuestionWS.Question>();
            
            if (request.getAttribute("questions") != null) {
              questions = (ArrayList<QuestionWS.Question>)request.getAttribute("questions");
              
              if (questions.size() > 0) {
                  int countAnswers[] = new int [questions.size()];
                  User users[] = new User [questions.size()];
                  
                  countAnswers = (int[])request.getAttribute("countAnswers");
                  users = (User[])request.getAttribute("users");
                  
                for (int i = 0; i < questions.size(); i++) {
          %>
          <div class="same-height-row border-bottom">
            <div class="vote-number">
              3
              <br>
              Votes
            </div>
            <div class="answer-number">
                <%= countAnswers[i] %>
              <br>
              Answers
            </div>
            <div class="right-position">
              <div class="answer-question-detail">
                <!-- Question Topic & Content -->
                <a href="QuestionDetailController?qid=<%= questions.get(i).getIdQuestion() %>">
                  <div class="question-topic">
                    <%= questions.get(i).getTopic() %>
                  </div>
                  <div class="question-content">
                    <%= questions.get(i).getContent() %>
                  </div>
                </a>
              </div>
              asked by
              <span class="blue">
                  <%= users[i].getName() %>
              </span>
              <%
                  if (request.getAttribute("userId") != null) {
                      if (users[i].getIdUser() == (Integer)request.getAttribute("userId")) {
              %>
              |
              <a class="yellow" href="EditController?token=<%= request.getParameter("token") %>&qid<%= questions.get(i).getIdQuestion() %>">
                  edit
              </a>
              |
              <a class="red" href="DeleteController?token=<%= request.getParameter("token") %>&qid<%= questions.get(i).getIdQuestion() %>" onclick="return confirm('Do you want to delete this post?')">
                delete
                <%
                        }
                    }
                %>
              </a>
            </div>
          </div>
          <%
                }
              } else {
          %>
          <!-- If no questions: Sorry, no questions found. -->
          Sorry, no questions found
          <%
              }
            }
          %>
        </div>
      </div>
    </div>

    <!-- JavaScript -->
    <script src="js/script.js"></script>
  </body>
</html>
