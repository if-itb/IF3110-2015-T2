<%-- 
    Document   : index
    Created on : Nov 16, 2015, 8:00:36 PM
    Author     : visat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>
    <div class="div-search">
        <form action="search.jsp" method="get">
            <input class="txt-search" type="search" name="q" placeholder="Search..." autofocus required>
            <input class="btn-search" type="submit" value="Search"><br>
            Cannot find what you are looking for? <a href="ask.jsp">Ask here</a>
        </form>
    </div>
    <div class="container">
        <h2>Recently Asked Questions</h2>
        <hr class="heading">        
        <c:forEach items="${questions}" var="question">
            <div class=question-item>
            <div class="stat">
                <div class="vote">
                    <div class="vote-count-mini">
                        <span><c:out value="${question.votes}"/></span>
                    </div>
                    <div>votes</div>
                </div>
                <div class="answer">
                    <div class="answer-count-mini">
                        <span><c:out value="${question.votes}"/></span>
                    </div>
                    <div>answers</div>
                </div>
            </div>
            <div class="question-summary">
                <h3 class="topic"><a class="topic" href="question?id=<c:out value="${question.id}"/>" title="<?= $question_row["topic"] ?>"><?= $question_row["topic"] ?></a></h3>
                <p title="<c:out value="${question.content}"/>"><c:out value="${question.content}"/>></p><br>
                <div class="timestamp">
                    asked by <a href="mailto:" target="_blank"><c:out value="${question.name}"/></a> at <c:out value="${question.timestamp}"/> | <a class="edit" href="ask?id<c:out value="${question.id}"/>">edit</a> | <a class="delete" href="#" onclick="deleteQuestion(<c:out value="${question.id}"/>)">delete</a>
                </div>
            </div>
        </div>
        <hr class="item">
        </c:forEach>
    </div>
<jsp:include page="footer.jsp" flush="true"/>