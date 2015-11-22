<%-- 
    Document   : index
    Created on : Nov 16, 2015, 8:00:36 PM
    Author     : visat
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" flush="true"/>
    <div class="div-search">
        <form class="form-horizontal" action="search" method="get">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="input-group">
                        <input type="search" class="form-control" placeholder="Search for..." name="q" autofocus required>
                        <span class="input-group-btn">
                            <button class="btn btn-search" type="submit">Search</button>
                        </span>
                    </div>
                </div>
            </div>
            <p class="text-center" style="margin-top: 12px">Cannot find what you are looking for? <a href="ask">Ask here</a></p>
        </form>
    </div>
    <br>
    <div class="container">
        <h3>Recently Asked Questions</h3>
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
                        <span><c:out value="${answers[question.id]}"/></span>
                    </div>
                    <div>answers</div>
                </div>
            </div>
            <div class="question-summary">
                <h4 class="topic"><a class="topic" href="question?id=<c:out value="${question.id}"/>" title="<c:out value="${question.topic}"/>"><c:out value="${question.topic}"/></a></h4>
                <p title="<c:out value="${question.content}"/>"><c:out value="${question.content}"/></p><br>
                <div class="timestamp">
                    asked by <a href="mailto:<c:out value="${askers[question.id].email}"/>" target="_blank"><c:out value="${askers[question.id].name}"/></a> at <c:out value="${question.timestamp}"/><c:if test="${not empty user && user.id==question.id_user}"> | <a class="edit" href="ask?id=<c:out value="${question.id}"/>">edit</a> | <a class="delete" href="#" onclick="deleteQuestion(<c:out value="${question.id}"/>)">delete</a></c:if>
                </div>
            </div>
        </div>
        <hr class="item">
        </c:forEach>
    </div>
<jsp:include page="footer.jsp" flush="true"/>