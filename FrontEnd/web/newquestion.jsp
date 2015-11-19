<%-- 
    Document   : newquestion
    Created on : Nov 18, 2015, 1:56:10 PM
    Author     : yoga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='style2.css'/>
    </head>
    <body>
        <div class="header">
            <div class="container">
                <p><a href="index.php">Simple StackExchange</a></p> 
            </div>
        </div>

        <div class="main">
            <div class="container">
                <form name="search" action="indexsearch.php" method="post" class="search">
                    <input type="text" maxlength="50" name="key">
                    <input type="submit" value="Search">
                </form>
                <h6>Cannot find what you are looking for? <a href="newquestion.jsp">Ask here</a></h6>
                
                <form  name="question" action="insertquestion.jsp" method="post" class="form" >
                    <input type="text" name="name" placeholder="Name" maxlength="12"><br>
                    <input type="text" name="email" placeholder="Email" maxlength="30"><br>
                    <input type="text" name="topic" placeholder="Question Topic" maxlength="30"><br>
                    <textarea name="content" placeholder="Content" maxlength="1500"></textarea>
                    <input type="submit" value="Post" >
                </form>
            </div>
        </div>
    </body>
</html>
