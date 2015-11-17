<%-- 
    Document   : question
    Created on : 09-Nov-2015, 17:16:57
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" flush="true"/>
<jsp:useBean id="question" type="QuestionWS.Question" scope="request" /> 
<jsp:useBean id="question_vote_count" type="Integer" scope="request" /> 
<jsp:useBean id="answers" type="java.util.List<AnswerWS.Answer>" scope="request" /> 
<jsp:useBean id="answer_count" type="Integer" scope="request" /> 
<jsp:useBean id="question_asker" type="String" scope="request" /> 

    <form action="" method="GET" id="searchForm">
        <input type="text" placeholder="Search...">
        <input type="submit" value="Search">
    </form>

    <p class="ask-here">Can't find what you are looking for? <a href="${pageContext.request.contextPath}/ask">Ask here</a></p>

    <div class="inner-container">

        <div class="question-header">
            <h1><%= question.getTopic() %></h1>
        </div>

        <div class="question-item">
            <div class="row">

                <div class="question-status col-2">
                    <div class="vote">

                        <div class="vote-up">
                            <a class="vote-link" href="questionvote?id=<%= question.getId() %>&value=1">▲</a>
                        </div>

                        <div class="vote-counts">
                            <span><%= question_vote_count %></span>
                        </div>

                        <div class="vote-down">
                            <a class="vote-link" href="questionvote?id=<%= question.getId() %>&value=-1">▼</a>
                        </div>

                    </div>
                </div> <!-- .question-status -->

                <div class="question-content col-10">
                    <p><%= question.getContent() %></p> 
                </div>

                <div class="question-meta">
                    <span>
                        Asked by
                        <%= question_asker %> |
                        <a href="${pageContext.request.contextPath}/edit.php?id=<%= question.getId() %>" class="question-edit">Edit</a> |
                        <form method="POST" action="deletequestion" id="deleteForm_question<%= question.getId() %>" class="delete-form">
                            <input type="hidden" value="<%= question.getId() %>" name="id_question">
                            <input type="submit" value="Delete" class="form-delete">
                        </form>
                    </span>
                </div>

            </div> <!-- .row -->
        </div> <!-- .question-item -->

    </div> <!-- .inner-container -->

    <div class="row">
        <div class="answer-header col-10 col-push-1">
            <h2><%= answer_count %> Answers</h2>
        </div>
    </div>

    <% for( AnswerWS.Answer answer: answers ) { %>
    <div class="inner-container">
        <div class="answer">
            <div class="row">
                
                <div class="answer-status col-2">
                    <div class="vote">
                        <div class="vote-up">
                            <a class="vote-link" href="">▲</a>
                        </div>

                        <div class="vote-counts">
                            <span>0</span>
                        </div>

                        <div class="vote-down">
                            <a class="vote-link" href="">▼</a>
                        </div>
                    </div>
                </div> <!-- .answer-status -->

                <div class="answer-content col-10">
                    <p><%= answer.getContent() %></p>
                </div>

                <div class="answer-meta">
                    <span>
                        Answered by Name
                    </span>
                </div>

            </div> <!-- .row -->
        </div> <!-- .answes -->
    </div> <!-- .inner-container -->

   <% } %>
    
    <div class="inner-container">
        <div class="row">
            <div class="answer-form col-10 col-push-2">
                
                <h3 class="answer-form-header">Your Answer</h3>

                <form id="answerForm" action="" method="POST">
                    <div class="form-field">
                        <label for="name">Name</label>
                        <input id="name" type="text" placeholder="Name">
                    </div>

                    <div class="form-field">
                        <label for="email">Email</label>
                        <input id="email" type="text" placeholder="Email">
                    </div>

                    <div class="form-field">
                        <label for="content">Answer</label>
                        <textarea placeholder="Your answer goes here"></textarea>
                    </div>
                </form>

            </div> <!-- .answer-form -->
        </div> <!-- .row -->
    </div> <!-- .inner-container -->
<jsp:include page="layout/footer.jsp" flush="true"/>
