<%--
  Created by IntelliJ IDEA.
  User: elvan_owen
  Date: 11/11/15
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>Simple StackExchange</title>
    <style>
        <%@ include file="/assets/css/answer.css"%>
    </style>
</head>
<body>
<header>
    Simple StackExchange
</header>
<section id='question'>
    <table>
        <thead>
        <th colspan='2'>
            LOREM IPSUM
        </th>
        </thead>
        <tbody>
        <tr id='question-id'>
            <td width='50'>
                <div class='question-arrow-up'></div>
                <div class='votes'>
                    LOREM IPSUM
                </div>
                <div class='question-arrow-down'></div>
            </td>
            <td>
                <div>
                    LOREM IPSUM

                    <div class='action'>
                        Asked by <span>LOREM IPSUM</span> at <span>LOREM IPSUM</span> | <a href='#' class='edit'>Edit</a> | <a href='#' class='delete'>Delete</a>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</section>

<section id='answer'>
    <table>
        <thead>
        <th colspan='2'>
            <span> LOREM IPSUM </span> Answer
        </th>
        </thead>
        <tbody>


        <tr>
            <td width='50'>
                <div class='answer-arrow-up'></div>
                <div class='votes'>LOREM IPSUM</div>
                <div class='answer-arrow-down'></div>
                </td>
            <td>
                <div> answer.content
                    <div class='action'>
                        Answered by <span class='name'> LOREM IPSUM </span> at <span>LOREM IPSUM</span>
                        </div>
                    </div>
                </td>
            </tr>

        </tbody>
    </table>
</section>
<section id='your-answer'>
    <div class='title'>
        Your Answer
    </div>
    <form id='answer-form'>
        <div>
            <input id='name' type='text' placeholder='Name'>
        </div>
        <div>
            <input id='email' type='email' placeholder='Email'>
        </div>
        <div>
            <textarea id='content' placeholder='Content' rows='10'></textarea>
        </div>
        <div>
            <div>
                <a href='#' class='btn post-btn'>Post</a>
            </div>
        </div>
    </form>
</section>
<script>
    <%@ include file="/assets/js/answer.js"%>
</script>
</body>
</html>