<%-- 
    Document   : editquestion
    Created on : Nov 25, 2015, 5:30:40 PM
    Author     : mochamadtry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style> 
            <%@ include file="style.css"%>
        </style>
        <title>Edit Question</title>
    </head>
    <body>
        <div class="container">
            <c:forEach items="${result}" var="question">
                <div id="header">
                    <a href="index.php"><h1>Simple StackExchange</h1></a>
                </div>
                    <h2>Edit Your Question </h2> 
                <div class="main">
                    <div class="wrapper" id="question-form">
                            <div class="content-header">
                                    <h2>What's your question?</h2>
                            </div>
                            <div class="child-content">
                                    <form action="savequestion" method="POST" id="the-form">

                                            <input type="text" name="topic" placeholder="Question Topic" id="topic" value="${question.getQuestionTopic()} "> <br>
                                            <textarea name="content" id="content" > ${question.getQuestionContent()} </textarea> <br>
                                            <input type="hidden" name="id" value="${question.getQuestionId()}" />
                                            <input type="submit" value="Post" name="post" id="post">
                                    </form>
                            </div>
                    </div>
            </c:forEach>
	</div>
                
        </div>
    </body>
</html>
