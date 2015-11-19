<%-- 
    Document   : answer
    Created on : Nov 18, 2015, 4:01:31 PM
    Author     : Satria
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style2.css">
        <title>Simple StackExchange</title>
    </head>
    <body>
        <div class="header">
            <div class="container">
                <p><a href="index.php">Simple StackExchange</a></p> 
            </div>
        </div>

        <div class="main">
            <div class="container">
                <form name="search" action="indexsearch.php" method="post" class="search">
                    <input type="text" maxlength="50" name="key">
                    <input type="submit" value="Search">
                </form>
                <h6>Cannot find what you are looking for? <a href="newquestion.jsp">Ask here</a></h6>
            </div>
            <div class="question">
                <h5>Recently Asked Questions</h5>
                <div class="listquestion">
                    <%-- start web service invocation --%><hr/>
                    <%
                        String token = null;
                        /*Cookie cookies[] = request.getCookies();
                        if (cookies != null) {
                            out.println(cookies.length);
                            for (int i=0;i<cookies.length;i++) {
                                if (cookies[i].getName().equals("access_token")) {
                                    token = cookies[i].getValue();
                                    out.println(cookies[i].getName() + " " + token); 
                                    break;
                                }
                            }
                        }*/
                        token = request.getParameter("access_token");
                        out.println(token);
                        int qidFromURL = Integer.valueOf(request.getParameter("id"));
                        
                        //take the first question
                        
                        try {
                            questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
                            questionmodel.QuestionWS port = service.getQuestionWSPort();
                            // TODO process result here
                            java.util.List<questionmodel.Question> result = port.getQuestionbyID(qidFromURL);
                            for (int i = 0; i < result.size(); i++) {
                                out.println("<div class='itemquestion'>");
                                out.println("<div class='columnsmall left'> <p>" + result.get(i).getVotes()
                                        + "</p> <p>Votes</p></div>");
                                out.println("<div class='columnsmall left'> <p><a href='upAns.jsp?id=" + qidFromURL
                                        + "'> up </a></p> <p><a href='downAns.jsp?id=" + qidFromURL
                                        + "'> down </a></p></div>");
                                if (result.get(i).getQuestion().length() > 30) {
                                    out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion().substring(0,30) + ". . .</p></div>");
                                } else {
                                    out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion() + "</p></div>");
                                }
                                out.println("<div class='columnlarge right'>'<p>asked by <span class='name'>" 
                                        + result.get(i).getName() + "</span>|<a class='edit' href='question.jsp?id=" + 
                                        result.get(i).getQuestionID() + "'>edit</a> | <a class='delete' href='delete.jsp?id="+result.get(i).getQuestionID()+"'>delete</a></p></div></div>");
                            }
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                        
                        //take all answer
                        
                        try {
                            answermodel.AnswerWS_Service service = new answermodel.AnswerWS_Service();
                            answermodel.AnswerWS port = service.getAnswerWSPort();
                            // TODO process result here
                            java.util.List<answermodel.Answer> result = port.getAnswerbyQID(qidFromURL);
                            for (int i = 0; i < result.size(); i++) {
                                out.println("<div class='itemquestion'>");
                                out.println("<div class='columnsmall left'> <p>" + result.get(i).getVotes()
                                        + "</p> <p>Votes</p></div>");
                                out.println("<div class='columnsmall left'> <p><a href='upAns.jsp?id=" + result.get(i).getAnswerID()
                                        + "'> up </a></p> <p><a href='downAns.jsp?id=" + result.get(i).getAnswerID()
                                        + "'> down </a></p></div>");
                                if (result.get(i).getAnswer().length() > 30) {
                                    out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getAnswerID() + "'>" + "</a><p>" + result.get(i).getAnswer().substring(0,30) + ". . .</p></div>");
                                } else {
                                    out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getAnswerID() + "'>" + "</a><p>" + result.get(i).getAnswer() + "</p></div>");
                                }
                            }
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }
                    %>
                    <%-- end web service invocation --%><hr/>

                </div>
            </div>
        </div>
    </body>
</html>
