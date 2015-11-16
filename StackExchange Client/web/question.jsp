<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Simple StackExchange
        </title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <h1>
            <a href="index.jsp">
                Simple StackExchange
            </a>
        </h1>
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

        <h2>
            Your Answer
        </h2>

        <form name="answerForm" action="" method="post" onsubmit="">
            <input name="qid" type="hidden" value="">
            <input name="name" class="text" type="text" placeholder="Name"><br>
            <input name="email" class="text" type="text" placeholder="Email"><br>
            <textarea name="content" id="question" placeholder="Content"></textarea>
            <input class="button" type="submit" value="Post"><br>
        </form>
    </body>
</html>
