<%-- 
    Document   : question
    Created on : 23-Nov-2015, 13:20:51
    Author     : KEVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head> 
	<meta charset="UTF-8">
	<title>Simple StackExchange</title>
	<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
</head>

<body>
    <div id="wrapper">
        <h1 class="center">
            <a href="index.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>">Simple StackExchange</a>
        </h1>
        <div id= "question_page">
            <div class="section">
                <h2 class="underlined">  </h2>
                <div class="question" id="question-">
                    <h2>
                    <%
                    try {
                        questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
                        questionWS.QuestionWebService port = service.getQuestionWebServicePort();
                        int id = Integer.parseInt(request.getParameter("qid"));
                        questionWS.Question result = port.getQuestionById(id);
                        out.println(result.getTopic());
                    %>
                    </h2>
                    <hr>
                    <div class="row">
                        <div class= "vote col">
                            <img src="img/upvote.png" width ="30" height="30"><br>
                            <span id="question-vote-count-"><%= result.getVote() %></span><br>
                            <img src="img/downvote.png" width="30" height="30">
                        </div>
                        <div class = "col-content">
                            <p>
                                <%= result.getContent() %>
                            </p>
                        </div>
                    </div>
                    <div class="row-info">
                        asked by <span class="name"><%= result.getAskerName()%></span>
                    </div>
                    <hr>
                    <br>
                        <%
                        } catch (Exception ex) {
                        }
                        %>
                    <h2>Answers</h2>
                    <div class="answer">
                        <%
                        try {
                            answerWebService.AnswerWebService_Service service = new answerWebService.AnswerWebService_Service();
                            answerWebService.AnswerWebService port = service.getAnswerWebServicePort();
                            int qid = Integer.parseInt(request.getParameter("qid"));
                            java.util.List<answerWebService.Answer> result = port.getAnswerByQid(qid);
                            for(int i=0; i<result.size(); i++ ){
                        %>
                                <hr>
                                <div class="section" id="answers">
                                    <div class="answer underline" id="answer-">
                                        <div class="row">
                                            <div class="col vote">
                                                <img src="img/upvote.png" width="35" height="35">
                                                <br>
                                                <span id="answer-vote-count-<%= result.get(i).getAnswerId() %>">
                                                    <%= result.get(i).getVote() %>
                                                </span>
                                                <br>
                                                <img src="img/downvote.png" width="35" height="35">
                                            </div>
                                            <div class="col content">
                                                <p>
                                                    <%= result.get(i).getContent() %>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="row info">
                                            answered by <span class="name"><%= result.get(i).getAnswererName() %></span>
                                            <span class="email">&lt;<%=result.get(i).getEmail()%>&gt;</span>
                                        </div>
                                    </div>
                                </div>
                            <% 
                            } //end for
                            %>
                            <hr>
                        <%
                        } catch (Exception ex) {
                        }
                        %>		
                        <div class="section" id="form-answer">
                            <h2>Your Answer</h2>
                            <form class="block" action="question.php?id=" method="POST" onsubmit="return validateAnswerForm(this);">
                                <input type="text" placeholder="Name" name="name">
                                <input type="text" placeholder="Email" name="email">
                                <textarea name="content" placeholder="Content"></textarea>
                                <input type="submit" value="Post">
                                <input type="hidden" name="type" value="answer">
                                <input type="hidden" name="question_id" value="">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
 </body>
 </html>
