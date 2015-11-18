<%-- 
    Document   : index
    Created on : Nov 14, 2015, 1:47:57 PM
    Author     : user
--%>

<%@page import="org.wsdl.StackExchangeImplService"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Simple StackExchange</title>
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/delete_question.js"></script>
    <script type="text/javascript">
        var a = JSON.parse(allQuestion);
    </script>
</head>
<body>
    <a href="index.jsp"><h1>Simple StackExchange</h1></a><br>
    <div class="search">
        <form method="post" action="search.php">
            <input class="search_form" type="text" name="keyword">
            <button class="button">Search</button>
        </form><br>
        <div class="search_new">Cannot find what you are looking for? <a class="yellow" href="new.php">Ask here</a><br></div>
    </div>
    <br><br>
    <div class="list">
    <div class="title">Recently Asked Questions</div>
    <ul>
    <c:forEach items="${a}" var="question">
        <li>
            <table>
                <tbody>
                    <tr>
                        <td><div class="votes">${question.vote}<br>Votes</div></td>
                        <td><div class="count">${qestion.count}<br>Answers</div></td>
                        <td>
                                <div class="content"><a href="question.php?id=${question.id}">${question.topic}</a></div>
                                <div class="credential">asked by <div class="name">${question.name}</div> | <a class="yellow" href="edit.php?id=${question.id}">edit</a> | <a class="delete" href="javascript:confirmDelete(${question.id})">delete</a></div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </li>
    </c:forEach>
    </ul>
    </div>
</body>