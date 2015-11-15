<%-- 
    Document   : index
    Created on : Nov 14, 2015, 1:47:57 PM
    Author     : user
--%>

<%@page import="org.jaxws.StackExchangeImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.data.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Simple StackExchange</title>
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/delete_question.js"></script>
    <%! 
    StackExchangeImpl impl = new StackExchangeImpl();
    ArrayList a = impl.getAllQuestion();
    %>
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
    <%c:for(Question q :a){%>
        <li>
            <table>
                <tbody>
                    <tr>
                        <td><div class="votes"><% out.print(q.getVote())%><br>Votes</div></td>
                        <td><div class="count"><% out.print(q.getCount())%><br>Answers</div></td>
                        <td>
                                <div class="content"><a href="question.php?id=<% out.print(q.getID())%>"><% out.print(q.getTopic())%></a></div>
                                <div class="credential">asked by <div class="name"><% out.print(q.getName())%></div> | <a class="yellow" href="edit.php?id=<% out.print(q.getID())%>">edit</a> | <a class="delete" href="javascript:confirmDelete(<% out.print(q.getName())%>)">delete</a></div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </li>
    <%! }%>
    </ul>
    </div>
</body>