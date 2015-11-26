<%-- 
    Document   : viewpost
    Created on : Nov 25, 2015, 3:03:06 PM
    Author     : Bimo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Post</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 class="col-md-11 col-md-offset-1">stackexchange?</h1>
            <h1 class="col-md-1 col-md-offset-1"><small><a href"">UP</a></small></h1>
            <h1 class="col-md-1"><small><a href"">DOWN</a></small></h1>
        
        <h1 class="col-md-9"><small>${result.getQuestionTopic()}</small></h1>
        <p class="col-md-4 col-md-offset-3"> ${result.getQuestionContent()}</p>
        <div class="col-md-8">  
            <c:forEach items="${answers}" var="answer">
                ${answer.getAnswerContent()}
                ${answer.getAnswerId()}<br>
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
