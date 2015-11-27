<%-- 
    Document   : create_question
    Created on : Nov 18, 2015, 11:11:58 AM
    Author     : Fitra Rahmamuliani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Simple StackExchange: Create Question</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script src="js/validate.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Play' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Dosis:500' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container">
            <div class="container">
            <div class="title">Simple StackExchange</div>
            <div class="subq black">What's your question?</div>
            <form class="formsearch createquestion" name="createquestion" method="post" onsubmit="return validateQuestionForm()" action="addQuestion">
                <input type="text" id="createtopic" name="topic" placeholder="Question Topic" />
                <textarea placeholder="Content" rows="5" name="content"></textarea>
                    <button type="submit" name="submit">Post</button>
            </form>
        </div>
        </div>
    </body>
</html>
