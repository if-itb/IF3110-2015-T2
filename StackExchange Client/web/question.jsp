<%-- 
    Document   : question
    Created on : Nov 16, 2015, 11:31:39 PM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <title>Simple StackExchange</title>
</head>

    <body>
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
        <br>
        <br>
        <br>
        <br>
        <div class='subtitle'> Question Topic Goes Here</div>
        
        <hr class='line'>
        <div class='block-QA'>
            <div class='bQA-vote'>
                <div class='vote-up' onclick='addQuestionVote("$row['question_id']")''>
                </div>
		<br>
                <a class='vote-value' id='question_vote$row['question_id']'>
                    Vote Goes Here
		</a>
		<br><br>
		<div class='vote-down' onclick='subtractQuestionVote("$row['question_id']")''>
                </div>
            </div>"
            <div class='bQA-content'>
                Content Goes Here
                <br><br>
            </div>
            <div class='bQA-identity'>
                asked by
                email
                at
                time
                |
                <a id='color-orange' href=# onclick='editconfirm("question_id")'>
                    edit
                </a>
                |
                <a id='color-red' href=# onclick='deteleconfirm("question_id")'>
                    delete
                </a>
            </div>
        </div>

    </body>
</html>
