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
                <p><a href="index1.jsp">Simple StackExchange</a></p> 
            </div>
        </div>

        <div class="main">
            <div class="container">
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
                    token = request.getParameter("token");
                    out.println(token);
                    int qidFromURL = Integer.parseInt(request.getParameter("id"));
                    //take the first question
                    try {
                        questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
                        questionmodel.QuestionWS port = service.getQuestionWSPort();
                        // TODO process result here
                        java.util.List<questionmodel.Question> result = port.getQuestionbyID(qidFromURL);
                        for (int i = 0; i < result.size(); i++) {
                            out.println("<div>");
                            out.println("<h2>" + result.get(i).getTopic() + "</h2>");
                            out.println("<div class='columnsmall left'>");
                            out.println("<a href='upQues.jsp?id=" + qidFromURL + "&token=" + token + "'>");
                            out.println("<img src='up.png' alt='up' height='42' width='42' >");
                            out.println("</a>");
                            out.println("<p>" + result.get(i).getVotes() + "</p>");
                            out.println("<a href='downQues.jsp?id=" + qidFromURL + "&token=" + token + "'>");
                            out.println("<img src='down.png' alt='up' height='42' width='42' >");
                            out.println("</a>");
                            out.println("</div>");

                            out.println("<div class='columnlargest center'>");
                            out.println("<p class='wrap'>" + result.get(i).getQuestion() + "</p>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("<div class='footer'>");
                            out.println("<p>asked by" + result.get(i).getName() + " at " + result.get(i).getDatetime() + " | <a class='edit' href='question.jsp?id=" + result.get(i).getQuestionID() + "'>edit</a> | <a class='delete' href='delete.jsp?id=" + result.get(i).getQuestionID() + "'>delete</a></p>");
                            out.println("</div>");
                            out.println("<div>");
                            out.println("<h2>" + result.get(i).getAnswers()+" Answers</h2>");
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
                            out.println("<div class='answer'>");

                            out.println("<div class='columnsmall left' >");
                            out.println("<a href='upAns.jsp?id=" + result.get(i).getAnswerID() + "&qid="+qidFromURL + "&token=" + token + "'>");
                            out.println("<img src='up.png' alt='up' height='42' width='42' >");
                            out.println("</a>");
                            out.println("<p>" + result.get(i).getVotes() + "</p>");
                            out.println("<a href='downAns.jsp?id=" + result.get(i).getAnswerID()+ "&qid="+qidFromURL + "&token=" + token + "'>");
                            out.println("<img src='down.png' alt='up' height='42' width='42' >");
                            out.println("</a>");
                            out.println("</div>");

                            out.println("<div class='columnlargest center'>");
                            out.println("<p class='warp'>" + result.get(i).getAnswer() + "</p>");
                            out.println("</div>");

                            out.println("<div class='footer'>");
                            out.println("<p>answered by " + result.get(i).getName() + " at " + result.get(i).getDatetime() + "</p>");
                            out.println("</div>");

                            out.println("</div>");
                        }
                        out.println("</div>");
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }

                %>
                <%-- end web service invocation --%><hr/>
                <div>
                    <h3>Your Answer</h3>
                    <% out.println("<form name='answer' action='insertanswer.jsp?id="+qidFromURL+ "' method='post' class='form'>"); %>
                    <input type="text" maxlength="12" name="name" placeholder="Name"><br>
                    <input type="text" name="email" maxlength="30" placeholder="Email"><br>
                    <textarea name="content" placeholder="Content" maxlength="1500"></textarea>
                    <input type="submit" value="Post">
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
