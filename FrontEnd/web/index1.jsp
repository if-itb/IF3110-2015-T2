<%-- 
    Document   : index1
    Created on : Nov 14, 2015, 10:43:28 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style.css">
        <title>Simple StackExchange</title>
    </head>
    <body>
        <div class = "maindiv">
            <h1><a href="index.php" id = "title">Simple StackExchange</a></h1>
            <div class = "searchdiv"><form action="index.php" method="GET"><input type = "text" name = "searchq" autofocus> <input type = "submit" value = "Search"></form></div>
            Cannot find what you are looking for? <a href = "ask.jsp" class = "yellow">Ask here</a><br><br>
            <h2 class = "left">Recently Asked Questions</h2>
            <div class="listquestion">
                <%-- start web service invocation --%><hr/>
                <%
                    try {
                        questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
                        questionmodel.QuestionWS port = service.getQuestionWSPort();
                        // TODO process result here
                        java.util.List<questionmodel.Question> result = port.getallQuestions();
                        for (int i = 0; i < result.size(); i++) {
                            out.println("<div class='itemquestion'>");
                            out.println("<div class='columnsmall left2'> <p>"+ result.get(i).getVotes()
                                            +"</p> <p>Votes</p></div>");
                            out.println("<div class='columnsmall left2'> <p>"+ result.get(i).getAnswers()
                                            +"</p> <p>Answers</p></div>");
                            out.println("<div class='columnlarge center2'> <h4>"+ result.get(i).getTopic()
                                            +"</h4> <p>"+ result.get(i).getQuestion() +"</p></div>");
                            out.println("<div class='columnlarge right2'></div>");
                        }
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                %>
                <%-- end web service invocation --%><hr/>
            </div>
    </body>
</html>
