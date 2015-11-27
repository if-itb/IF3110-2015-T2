<%-- 
    Document   : displayQuestion.jsp
    Author     : moel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple StackExcahange | Question</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        
        <a href="index.jsp"><h1>Simple StackExchange</h1></a>
        <h2>Topic</h2>
        <div class="garis"></div>
        
        <%
        QuestionModule.QuestionWS_Service service = new QuestionModule.QuestionWS_Service();
        QuestionModule.QuestionWS port = service.getQuestionWSPort();
        
        QuestionModule.Question q = new QuestionModule.Question();
        String str = request.getParameter("id");
        int id=0;
        if(str != null) {
           id= Integer.parseInt(str);
          q = port.getQuestionByID(id);
        }
        
        Answer.AnswerWS_Service as = new Answer.AnswerWS_Service();
        Answer.AnswerWS ap = as.getAnswerWSPort();
        java.util.List<Answer.Answer> ans = ap.getAllAnswer(id);
        
        int na = ans.size();
        %>
        
        <table class="question">
            <tr>
                    <td class="vote">
                    <a href="voteQuestion.jsp?id=<%=q.getQid()%>+up=true">
                        <img src="image/Up.png" width="30" hight="30">
                    </a>

                    <h3>
                        <%= q.getQvote() %>
                    </h3>
                    <a href="voteQuestion.jsp?id=<%=q.getQid()%>+up=false">
                        <img src="image/down.png"  width="30" hight="30">
                    </a>
                    </td>
                    <td>
                    </td>
                    <td class="Topic">
                        <a href="displayQuestion.jsp?id=<%=q.getQid()%>">
                            <%= q.getQtopic() %>
                        </a>
                    </td>
                    <td class="Date">
                            <%= q.getQtimestamp() %>
                    </td>
            </tr>
            <tr>
                    <td class="Text">
                            Votes
                    </td>
                    <td class="Text">
                            Answers
                    </td>
                    <td></td>
                    <td class="Content">
                            <%= q.getQcontent() %>
                    </td>
                    <td class="Detail">
                            Asked by
                            <span class="name">
                                    <%= q.getUemail() %>
                            </span>
                            | 
                            <a href="ask.jsp?id=<%=q.getQid()%>"><span class="edit">
                            edit
                            </span></a>
                            |
                            <a href="delete.jsp?id=<%=q.getQid()%>"><Span class="delete">
                            delete
                            </span></a>
                    </td>
            </tr>
    </table>
        
        <h2><%= na %> Answer</h2>
        <div class="garis"></div>
        <% for(Answer.Answer a : ans) { %>
        <table >
            <tr>
                <td class="vote">
                    <a href="voteAnswer.jsp?id=<%=q.getQid()%>+aid=<%=a.getAid()%>+up=true">
                        <img src="image/Up.png" width="30" hight="30">
                    </a>

                    <h3>
                        <%= a.getAvote() %>
                    </h3>
                    <a href="voteAnswer.jsp?id=<%=q.getQid()%>+aid=<%=a.getAid()%>+up=false">
                        <img src="image/down.png"  width="30" hight="30">
                    </a>
                </td>
                <td class="dContent">
                    <%= a.getAcontent()%>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td class="Detail">
                    Asked by
                    <span class="name">
                        <%= a.getAauthorname() %>
                    </span>
                    at
                    <%= a.getAtimestamp() %>
                </td>
            </tr>
        </table>
        <div class="garis"></div>
        <% } %>
        <h2 style="color:#A0A0A0">Your Answer</h2>
        <form action="addAnswer.jsp" method="post" name="ask-ans">
            <textarea name="Content" placeholder="Content" class="form-textarea" ></textarea>
            <br>
            <div align="right">
                    <input type="submit" value="Post" onclick="return validateAns()" action="addAnswer.jsp">
            </div>
            <input name="id" type="hidden" value=<%=q.getQid()%>>
        </form>

    </body>
</html>
