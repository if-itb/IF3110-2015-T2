<%-- 
    Document   : index
    Created on : Nov 14, 2015, 1:47:57 PM
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.data.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Simple StackExchange</title>
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/delete_question.js"></script>
    <?php include('backend/all_questions.php');?>
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
    <%! ArrayList<Question> question = %>
        <li>
            <table>
                <tbody>
                    <tr>
                        <td><div class="votes"><?php echo $row['votes'];?><br>Votes</div></td>
                        <td><div class="count"><?php echo $row['count'];?><br>Answers</div></td>
                        <td>
                                <div class="content"><?php echo '<a href="question.php?id='.$row['id'].'">'.$row['topic'].'</a>';?></div>
                                <div class="credential">asked by <div class="name"><?php echo $row['name'];?></div> | <?php echo '<a class="yellow" href="edit.php?id='.$row['id'].'">edit</a> | <a class="delete" href="javascript:confirmDelete('.$row['id'].')">delete</a>';?></div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </li>
    <?php 
    };?>
    </ul>
    </div>
</body>