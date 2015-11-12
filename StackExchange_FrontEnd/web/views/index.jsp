<%--
  Created by IntelliJ IDEA.
  User: elvan_owen
  Date: 11/10/15
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>Simple StackExchange</title>
    <style>
        <%@ include file="/assets/css/index.css"%>
    </style>
</head>
<body>
<header>
    Simple StackExchange
</header>

<section id='search'>
    <input type='text' />
    <a href='#' class='btn'>Search</a>
    <div class='ask-title'>
        Cannot find what you are looking for? <a href='/ask' class='ask'>Ask here</a>
    </div>
</section>

<section id='recent'>
    <table class='question-table'>
        <thead>
        <th colspan='3'>
            Recently Asked Questions
        </th>
        </thead>
        <tbody>

        <%--<c:forEach items="${questions}" var="question">--%>
            <%--<tr data-id="${question.id}">--%>
                <%--<td width='75'>${question.votes}<br>Votes</td>--%>
                <%--<td width='75'>${question.answers}<br>Answers</td>--%>
                <%--<td>--%>
                    <%--<div class='questions-body-wrapper'>--%>
                        <%--<a href='#' class='topic'> ${question.topic} </a>--%>
                        <%--<div class='action'>--%>
                            <%--Asked by <span class='name'>${question.by}</span> at ${question.createTime} | <a href='#' class='edit'>Edit</a> | <a href='#' class='delete'>Delete</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>

        </tbody>
    </table>
</section>
<script>
    <%@ include file="/assets/js/index.js"%>
</script>
</body>
</html>