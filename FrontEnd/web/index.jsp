<%-- 
    Document   : index
    Created on : Nov 14, 2015, 10:43:28 PM
    Author     : Asus
--%>


<%@page language="java" import="java.sql.Timestamp"%>
<%@page language="java" import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style2.css">
        <title>Simple StackExchange</title>
    </head>
    <body>
        <%
            String token = request.getParameter("token");
            questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
            questionmodel.QuestionWS port = service.getQuestionWSPort();

            try {

                Timestamp result = new Timestamp(port.getExpiredDate(token));
                Timestamp ts = new Timestamp(System.currentTimeMillis());
                /*out.println(ts);
                out.println(result);*/

                if (ts.after(result) || token == null || port.getEmail(token) == null) {
                    String site = "http://localhost:8001/Identity/LoginRSServlet?token="+request.getParameter("token");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }

            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <div class="header">
            <%
                out.println("<a href=\"http://localhost:8001/Identity/LoginRSServlet?token=" + request.getParameter("token") + "&logout=true\" style=\"margin-left: 72%;\">Logout</a>");
            %>
            <div class="container">

                <%
                    if (token != null) {
                        out.println("<p><a href='index.jsp?token=" + token + "'>Simple StackExchange</a></p> ");
                    } else {
                        out.println("<p><a href='index.jsp'>Simple StackExchange</a></p> ");
                    }

                %>
            </div>
        </div>

        <div class="main">
            <div class="container">

                <%                    if (token != null) {
                        out.println("<form name='search' action='index.jsp?token=" + token + "' method='post' class='search'>");
                    } else {
                        out.println("<form name='search' action='index.jsp' method='post' class='search'>");
                    }

                %>
                    <input type="text" maxlength="50" name="key">
                    <input type="submit" value="Search">
                </form>
                <%                    if (token != null) {
                        out.println("<h6>Cannot find what you are looking for? <a href='newquestion.jsp?token=" + token + "'>Ask here</a></h6>");
                    } else {
                        out.println("<h6>Cannot find what you are looking for? <a href='login.jsp'>Login to ask here</a></h6>");
                    }

                %>
            </div>
            <div class="question">
                <h5>Recently Asked Questions</h5>
                <div class="listquestion">

                    <%                        String search = request.getParameter("key");
                        java.lang.String check = port.getName(token);
                        if (search == null) {
                            try {

                                // TODO process result here
                                java.util.List<questionmodel.Question> result = port.getallQuestions();
                                for (int i = 0; i < result.size(); i++) {
                                    out.println("<div class='itemquestion'>");
                                    out.println("<div class='columnsmall left'> <p>" + result.get(i).getVotes()
                                            + "</p> <p>Votes</p></div>");
                                    out.println("<div class='columnsmall left'> <p>" + result.get(i).getAnswers()
                                            + "</p> <p>Answers</p></div>");

                                    if (token != null) {
                                        if (result.get(i).getQuestion().length() > 30) {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion().substring(0, 30) + ". . .</p></div>");
                                        } else {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion() + "</p></div>");
                                        }
                                    } else {
                                        if (result.get(i).getQuestion().length() > 30) {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion().substring(0, 30) + ". . .</p></div>");
                                        } else {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion() + "</p></div>");
                                        }
                                    }

                                    if (result.get(i).getName().equals(check)) {
                                        out.println("<div class='columnlarge right'>'<p>asked by <span class='name'>"
                                                + result.get(i).getName() + "</span>|<a class='edit' href='question.jsp?id="
                                                + result.get(i).getQuestionID() + "&token=" + token + "'>edit</a> | <a class='delete' href='delete.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'>delete</a></p></div></div>");
                                    } else {
                                        out.println("<div class='columnlarge right'>'<p>asked by <span class='name'>"
                                                + result.get(i).getName() + "</span></p></div></div>");
                                    }
                                }
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }
                        } else {

                            try {

                                
                                // TODO initialize WS operation arguments here
                                // TODO process result here
                                java.util.List<questionmodel.Question> result = port.getQuestionSearch(search);
                                for (int i = 0; i < result.size(); i++) {
                                    out.println("<div class='itemquestion'>");
                                    out.println("<div class='columnsmall left'> <p>" + result.get(i).getVotes()
                                            + "</p> <p>Votes</p></div>");
                                    out.println("<div class='columnsmall left'> <p>" + result.get(i).getAnswers()
                                            + "</p> <p>Answers</p></div>");
                                    if (token != null) {
                                        if (result.get(i).getQuestion().length() > 30) {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion().substring(0, 30) + ". . .</p></div>");
                                        } else {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion() + "</p></div>");
                                        }
                                    } else {
                                        if (result.get(i).getQuestion().length() > 30) {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion().substring(0, 30) + ". . .</p></div>");
                                        } else {
                                            out.println("<div class='columnlarge center'><a href='answer.jsp?id=" + result.get(i).getQuestionID() + "'><h4>" + result.get(i).getTopic() + "</h4></a><p>" + result.get(i).getQuestion() + "</p></div>");
                                        }
                                    }

                                    if (result.get(i).getName().equals(check)) {
                                        out.println("<div class='columnlarge right'>'<p>asked by <span class='name'>"
                                                + result.get(i).getName() + "</span>|<a class='edit' href='question.jsp?id="
                                                + result.get(i).getQuestionID() + "&token=" + token + "'>edit</a> | <a class='delete' href='delete.jsp?id=" + result.get(i).getQuestionID() + "&token=" + token + "'>delete</a></p></div></div>");
                                    } else {
                                        out.println("<div class='columnlarge right'>'<p>asked by <span class='name'>"
                                                + result.get(i).getName() + "</span></p></div></div>");
                                    }
                                }
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }
                        }
                    %>

                </div>
            </div>
        </div>
    </body>
</html>
