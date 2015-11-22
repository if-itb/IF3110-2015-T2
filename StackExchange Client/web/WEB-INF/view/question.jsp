<%-- 
    Document   : question
    Created on : Nov 17, 2015, 6:25:38 PM
    Author     : visat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" flush="true"/>    
    <h3 class="topic"><a class="topic" href="question?id=<c:out value="${question.id}"/>"><c:out value="${question.topic}"/></a></h3>
    <hr class="heading">
        <div class="question-item">
            <div class="vote-panel">
                <div class="vote-up" onclick="vote('question',<c:out value="${question.id}"/>,'up')"></div>
                <div class="vote-count">
                    <span id="question-<c:out value="${question.id}"/>"><c:out value="${question.votes}"/></span>
                </div>
                <div class="vote-down" onclick="vote('question',<c:out value="${question.id}"/>,'down')"></div>
            </div>
            <div class="question-content">
                <p><c:out value="${question.content}"/></p><br>
                <div class="timestamp">
                    asked by <a href="mailto:<c:out value="${asker.email}"/>" target="_blank"><c:out value="${asker.name}"/></a> at <c:out value="${question.timestamp}"/> | <a class="edit" href="ask?id=${question.id}">edit</a> | <a class="delete" href="#" onclick="deleteQuestion(${question.id})">delete</a>
                </div>
            </div>
        </div>
        <br>
        <c:if test="${fn:length(answers) > 0}">
            <h3>${fn:length(answers)} Answer${fn:length(answers) > 1 ? "s" : ""}</h3>
            <hr class="heading">
            <div class="answer-list">
            <c:forEach items="${answers}" var="answer">                
                <div class="answer-item">
                    <div class="vote-panel">
                        <div class="vote-up" onclick="vote('answer',${answer.id},'up')"></div>
                        <div class="vote-count">
                            <span id="answer-${answer.id}">${answer.votes}</span>
                        </div>
                        <div class="vote-down" onclick="vote('answer',${answer.id},'down')"></div>
                    </div>
                    <div class="answer-content">
                        <p><c:out value="${answer.content}" /></p>
                        <div class="timestamp">
                            answered by <a href="mailto:<c:out value="${answerers[answer.id].email}"/>" target="_blank"><c:out value="${answerers[answer.id].name}" /></a> at <c:out value="${answer.timestamp}"/>
                        </div>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </c:if>
        <br>        
        <h3>Your Answer</h3>
        <hr class="heading">
        <form onsubmit="return validate()" action="" method="post">
            <input type="text" name="name" placeholder="Name"></input>
            <input type="text" name="email" placeholder="Email"></input>
            <textarea  name="content" placeholder="Content" rows="7"></textarea>
            <input type="submit" class="btn-default btn-right" value="Post"></input>
            <input type="hidden" name="id" value="${question.id}"></input>
        </form>        
    </div>    
<jsp:include page="footer.jsp" flush="true"/>