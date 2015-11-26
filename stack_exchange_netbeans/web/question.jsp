<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML>
<html>
<head>
    <title>StackExchange</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1 class="center">StackExchange</h1>
    </div>
    <div id="question-page">
        <h2 class="underline"><c:out value="${question.topic}"/></h2>
        <div class="question" id="question-   ">
            <div class="row">
                <div class="col_vote">
                    <a title="Click to Upvote" href="     " onclick="   " id="increase-vote">
                        <img src="assets/img/up.png" width="32" height="32"><br>
                    </a>
                    <span id="question-vote-count-    "><font size = "5" color ="blue"><c:out value="${question.vote}"/></font></span><br>
                    <a title="Click to Downvote" href="    " onclick="   " id="decrease-vote">
                        <img src="assets/img/down.png" width="32" height="32">
                    </a>
                </div>
                <div class="col_content">
                    <p>
                        <c:out value="${question.content}"/>
                    </p>
                </div>
            </div>
            <div class="controls" style="border-bottom:0px" align="right">
                asked by <span class="name"><font color="blue"><c:out value="${question_name}"/></font></span> &lt;<span class="email">TES@GMAIL.COM></span>
                at <span class="create-date"><c:out value="${question.createdAt}"/></span> |
                <span class="link_edit"><a class="link_edit" title="Click here to edit" href="http://localhost:8080/stack_exchange_netbeans/EditQuestionServlet?question_id=<c:out value="${question.id}"/>&token=sssc"">edit</a></span> |
                <span class="link_delete"><a class="link_delete" title="Click here to delete" href="      " onclick="      ">delete</a></span>
            </div>
        </div>
    </div>
    
    <c:set var="count" value="0" scope="page" />
    <c:forEach items="${answer}" var="answers">
        <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
    
    <div class="answers">
        <h2 class="underline"><c:out value="${count}"/> Answer<c:if test="${count > 1}">s</c:if></h2>
            <c:forEach items="${answer}" var="answers">
                
		<div class="answer underline" style="width:100%" id="answer-  ">
                	<div class="row">
                		<div class="col_vote">
        				<a title="Click to Upvote" href="http://localhost:8080/stack_exchange_netbeans/UpVoteAnswer?question_id=<c:out value="${question.id}"/>&answer_id=<c:out value="${answers.id}"/>&token=sssc" id="increase-vote">
					<img src="assets/img/up.png" width="32" height="32"><br>
					</a>
                                    <span id="answer-vote-count-"><font size = "5" color ="blue"><c:out value="${answers.vote}"/></font></span><br>
					<a title="Click to Downvote" href="http://localhost:8080/stack_exchange_netbeans/DownVoteAnswer?question_id=<c:out value="${question.id}"/>&answer_id=<c:out value="${answers.id}"/>&token=sssc" id="decrease-vote">
					<img src="assets/img/down.png" width="32" height="32">
					</a>
				</div>
				<div class="col_content">
                                    <p>
					<c:out value="${answers.content}"/>
                                    </p>
				</div>
			</div>
			<div class="controls" style="border-bottom:0px" align="right">
                            answered by <span class="name"><font color="blue"><c:out value="${fullname}"/></font></span> &lt;<span class="email"><c:out value="${answers.userId}"/>&gt;</span>
                            at <span class="create-date"><c:out value="${answers.createdAt}"/></span>
			</div>
		</div>
	     </c:forEach>
    </div>
        
        
           
       
    </div>


    <div class="answer_form">
        <h2>Your Answer</h2>
        <form method="POST" action="http://localhost:8080/stack_exchange_netbeans/question?question_id=<c:out value="${question.id}"/>&token=<c:out value="${token}"/>">
            <textarea class="form" name="content"  rows="5" placeholder="Content"></textarea>
            <div class="right" style="margin-bottom:50px">
                <input type="submit" value="Post">
            </div>
        </form>
    </div>
</div>
</body>
</html>

