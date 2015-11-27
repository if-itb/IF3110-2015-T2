<%-- 
    Document   : viewpost
    Created on : Nov 25, 2015, 3:03:06 PM
    Author     : Bimo
--%>

<%@ page language ="java" contentType = "text/html ; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Post</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 class="col-md-11 col-md-offset-1">Stack exchange?</h1>
            <h1 class="col-md-1">${questionvote}</h1>
            <h1 class="col-md-1"><small><a href="<c:url value="/votequestion?qid=${result.getQuestionId()}&jlhvote=1"></c:url>">UP</a></small></h1>
            <h1 class="col-md-1"><small><a href="<c:url value="/votequestion?qid=${result.getQuestionId()}&jlhvote=-1"></c:url>">DOWN</a></small></h1>
        
        <h1 class="col-md-9"><small>${result.getQuestionTopic()}</small></h1>
        <p class="col-md-8 col-md-offset-3"> ${result.getQuestionContent()}</p>
        
        <h2 class="col-md-offset-5">${answers.size()} Answers</h2>
        <div class="col-md-8">  
            <c:forEach items="${answers}" var="answer">
                <div class="">
                    
                    <h1 class="col-md-1"><small><a href="<c:url value="/voteanswer?aid=${answer.getAnswerId()}&qid=${result.getQuestionId()}&jlhvote=1"></c:url>">UP</a></small></h1>
                    <h1 class="col-md-1"><small><a href="<c:url value="/voteanswer?aid=${answer.getAnswerId()}&qid=${result.getQuestionId()}&jlhvote=-1"></c:url>">DOWN</a></small></h1>
                    <div class="col-md-6 col-md-offset-3">${answer.getAnswerContent()}</div>
                </div>
                
            </c:forEach>
         </div>
        <div class="col-md-6 col-md-offset-2">
            <form action="addanswer" method="POST">				
                <textarea name="content" placeholder="Content" class="form-control" required> </textarea> <br>
                 <input type="hidden" name="qid" value="${result.getQuestionId()}" />
                  <input type="submit" value="Submit" name="post" class="btn btn-default">
            </form>
        </div>
    </body>
</html>
