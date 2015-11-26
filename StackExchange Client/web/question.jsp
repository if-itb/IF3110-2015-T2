<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Simple StackExchange
        </title>
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="navbar-up">
            <a href="index.jsp">
                <h1 class="white">Simple StackExchange</h1>
            </a>
        </div>
        <div class="navbar-down">
            <b class="navbar-down">
                <a class="white" href="register.jsp">Register</a> |
                <a class="white" href="login.jsp">Login</a>
            </b>
        </div>
        <div>
            <c:set var="qid" value="${param.qid}" scope="request" />
            <jsp:include page="/QuestionByQIDServlet"/>
            <jsp:include page="/AnswerByQIDServlet"/>
        </div>
        <div class="main">
            <br>
            <h2>
                Topic
            </h2>
            <hr>
            <table>
                <tr>
                    <td class="VotesQA">
                        <a onclick="">
                            <img src="img/vote-up.png">
                        </a>
                        <div id="VotesQ">
                            0
                        </div>
                        <a onclick="">
                            <img src="img/vote-down.png">
                        </a>
                    </td>
                    <td>
                        Content
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td class="Asker">
                        asked by Username at Datetime | 
                        <a class="gold" href="">
                            edit
                        </a> | 
                        <a class="red" href="" onclick="" >
                            delete
                        </a>
                    </td>
                </tr>
            </table>

            <br>
            <h2>
                0 Answers
            </h2>
            <hr>

            <table>
                <tr>
                    <td class="VotesQA">
                        <a onclick="">
                            <img src="img/vote-up.png">
                        </a>
                        <br>
                        <div class="VotesA" id="">
                            0
                        </div>
                        <a onclick="">
                            <img src="img/vote-down.png">
                        </a>
                    </td>
                    <td>
                        Content
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td class="Answerer">
                        answered by Username at Datetime
                    </td>
                </tr>
            </table>
            <hr>
        </div>
        <div class="main">
            <h2>
                Your Answer
            </h2>

            <form name="answerForm" action="" method="post" onsubmit="">
                <input name="qid" type="hidden" value="">
                <textarea name="content" id="question" placeholder="Content"></textarea>
                <input class="button" type="submit" value="Post"><br>
            </form>
        </div>
    </body>
</html>
