<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="question" type="model.question.Question" scope="request"/>
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
            <div class="subq black">Edit your question</div>
            <form class="formsearch createquestion" method="post" onsubmit="return validateQuestionForm()" action="updateQuestion">
                    <input type="hidden" name="question_id" value="<%= question.getQuestionId() %>">
                <input type="text" id="createtopic" name="topic" placeholder="<%= question.getTopic() %>" />
                <textarea rows="5" name="content"><%= question.getContent() %></textarea>
                    <button type="submit" name="submit">Post</button>
            </form>
        </div>
        </div>
    </body>
</html>
