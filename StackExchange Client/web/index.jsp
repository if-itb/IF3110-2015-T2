<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css">
        <title>Simple StackExchange</title>
    </head>
    <body>
        <div class="navbar-up">
            <h1 class="white">Simple StackExchange</h1>
        </div>
        <div class="navbar-down">
            <b class="navbar-down">
                <a class="white" href="register.jsp">Register</a> |
                <a class="white" href="login.jsp">Login</a>
            </b>
        </div>

        <br>
        <div class="main">
            <div class="searchbar">
                <form id="searchform" action="" method="post">
                    <input id="searchbar" type="text" name="name">
                    <input id="searchbutton" type="submit" name="submit" value="Search"><br>
                </form>
                <p id="searchbar">
                    Cannot find what you are looking for?
                    <a class="gold" href="create.jsp">
                        Ask here
                    </a>
                </p>
            </div>

            <p id="RecentlyAsked">
                Recently Asked Questions
            </p>
            <hr>

            <div>
                <jsp:include page="/QuestionListServlet"/>
            </div>
        </div>
    </body>
</html>
