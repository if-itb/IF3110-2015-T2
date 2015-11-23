<%-- 
    Document   : question
    Created on : Nov 17, 2015, 6:25:38 PM
    Author     : visat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" flush="true"/>    
    <h3 class="topic"><a class="topic" href="question?id=${question.id}"><c:out value="${question.topic}"/></a></h3>
    <hr class="heading">
        <div class="question-item">
            <div class="vote-panel">
                <span class="vote-button vote-up glyphicon glyphicon-chevron-up"></span>
                <div class="vote-count">
                    <span id="question-${question.id}">${question.votes}</span>
                </div>
                <span class="vote-button vote-down glyphicon glyphicon-chevron-down"></span>
            </div>
            <div class="question-content">
                <p><c:out value="${question.content}"/></p><br>
                <div class="timestamp">
                    asked by <c:out value="${asker.name}"/></a> at ${question.timestamp}
                    <c:if test="${not empty user && user.id==question.idUser}">
                        <a class="edit" href="ask?id=${question.id}"><span class="glyphicon glyphicon-edit"></span> edit</a>
                        <a class="delete" href="delete?id=${question.id}" onclick="return confirm('Are you sure you want to delete this question?');"><span class="glyphicon glyphicon-remove"></span> delete</a>
                    </c:if>
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
                        <span class="vote-button vote-up glyphicon glyphicon-chevron-up"></span>
                        <div class="vote-count">
                            <span id="answer-${answer.id}">${answer.votes}</span>
                        </div>
                        <span class="vote-button vote-down glyphicon glyphicon-chevron-down"></span>
                    </div>
                    <div class="answer-content">
                        <p><c:out value="${answer.content}"/></p>
                        <div class="timestamp">
                            answered by <c:out value="${answerers[answer.id].name}"/> at ${answer.timestamp}
                        </div>
                    </div>
                </div>
                <hr>
            </c:forEach>
        </c:if>
        <br>        
        <h3>Your Answer</h3>
        <hr class="heading">
        <form method="post">
            <textarea name="content" placeholder="Content" rows="7"></textarea>
            <input type="submit" class="btn-default btn-right" value="Post"></input>
            <input type="hidden" name="id" value="${question.id}"></input>
        </form>        
    </div>    
<jsp:include page="footer.jsp" flush="true"/>