<%-- 
    Document   : index
    Created on : Nov 20, 2015, 10:57:36 PM
    Author     : William Sentosa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="questionWS.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Simple StackExchange</title>
	<link rel="stylesheet" type="text/css" href="css/mainstyle.css">
    </head>
    <body>

	<div id="wrapper">
            <%
            if(request.getParameter("token") != null && request.getParameter("id") != null){
            %>
            <h1 class="center">
                <a href="index.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>">Simple StackExchange</a>
            </h1>
            <%
            } else {
            %>
            <h1 class="center">
                <a href="index.jsp">Simple StackExchange</a>
            </h1>
            <%
            }
            %>
            <div class="row">
                <%
                if(request.getParameter("token") != null && request.getParameter("id") != null){
                %>
                  <%! String name = ""; %>
                  Welcome, 
                  <%
                  try {
                      userWebService.UserWebService_Service service0 = new userWebService.UserWebService_Service();
                      userWebService.UserWebService port0 = service0.getUserWebServicePort();
                      int uid = Integer.parseInt(request.getParameter("id"));
                      userWebService.User result0 = port0.getUser(uid);
                      name = result0.getName();
                      out.println(name);
                  } catch (Exception ex) {
                  }
                  %>
                  !
                  <div class="right">
                      <a href="login.jsp">Logout</a>
                  </div>
                <%
                } //bracket for if
                %>
                
            </div>
            <div id="main-search" class="center">
                    <%
                    if(request.getParameter("token") != null && request.getParameter("id") != null){
                    %>
                        <form action="index.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>" method="POST">
                    <%
                    } else {
                    %>
                        <form action="index.jsp" method="POST">
                    <%
                    }
                    %>
                            <input autofocus="autofocus" type="text" name="search" id="search-bar" placeholder="Search question topic or content here..." value="">
                            <input type="submit" value="Search">
                    </form>
            </div>
            <%
            if(request.getParameter("token") != null && request.getParameter("id") != null){
            %>
                <div class="center">
                    <h3>
                        <a href="ask.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>">Ask a question!</a>
                    </h3>    
                </div>
            <%
            } else {
            %>
                <div class="center">
                    <h3>
                      <a href="login.jsp">Login</a>
                    </h3>    
                </div>
            <%
            }
            %>
            <div id="main-page" onload="function() {document.getElementById('autofocus').focus();}">
                <div class="questions">
                    <h2>Recently Asked Questions</h2>
                    <hr class="border">
                    <% 
                    try {
                        questionWS.QuestionWebService_Service service = new questionWS.QuestionWebService_Service();
                        questionWS.QuestionWebService port = service.getQuestionWebServicePort();
                        List<Question> result = new ArrayList<Question>();
                        if(request.getParameter("search") == null) {
                            result = port.getAllQuestion();
                        } else {
                            result = port.searchQuestion(request.getParameter("search"));
                            if(result.size() == 0) {
                              out.println("No question found");
                            }
                        }
                        for (int i=0 ; i < result.size(); i++){
                            int id = result.get(i).getQuestionId();
                            String s = String.valueOf(id);
                    %>
                            <div class="col title">
                                <a href="question.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>&qid=<%= s %>"><% out.print(result.get(i).getTopic());%></a>
                            </div>
                            <div class="content">
                                <br>
                                <% 
                                String res = result.get(i).getContent();
                                if(res.length() >= 75){
                                  res = res.substring(0, 74);
                                  res += res + "...";
                                }
                                out.println(res);
                                %>
                            </div>
                            <br>
                            <div class="question">
                                <div class="row">
                                    <div class="col vote in-numbers">
                                        <div class="number"><%= result.get(i).getVote() %></div>
                                        <div class="flag">Votes</div>
                                    </div>
                                    <div class="col answers in-numbers">
                                        <div class="number">
                                        <%
                                        try {
                                            answerWebService.AnswerWebService_Service service2 = new answerWebService.AnswerWebService_Service();
                                            answerWebService.AnswerWebService port2 = service2.getAnswerWebServicePort();
                                            int qid = result.get(i).getQuestionId();
                                            int result2 = port2.getCountAnswerByQid(qid);
                                            out.println(result2);
                                        } catch (Exception ex) {
                                        }
                                        %>
                                        </div>
                                        <div class="flag">Answers</div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="controls" align="right">
                                        asked by 
                                        <span class="name"> <% out.print(result.get(i).getAskerName()); %></span>
                                        <% 
                                        if(name.equals(result.get(i).getAskerName())) { 
                                        %>
                                            |
                                            <a href="editForm.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>&qid=<%= result.get(i).getQuestionId()%>"><span class="link edit"> edit </span></a> |
                                            <a onclick="confirm('Are you sure to delete this question ?');" href="deleteQuestion.jsp?token=<%= request.getParameter("token")%>&id=<%=request.getParameter("id")%>&qid=<%= result.get(i).getQuestionId()%>"><span class="link delete"> delete </span></a>
                                        <%
                                        } 
                                        %>
                                    </div>
                                </div>
                            </div>
                        <%
                        } //end for
                        %>
                    <% 
                    } catch (Exception ex) {
 
                    }
                    %>    
                </div>
            </div>
        </div>
    </body>   
</html>
