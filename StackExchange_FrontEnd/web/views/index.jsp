<%--
  Created by IntelliJ IDEA.
  User: elvan_owen
  Date: 11/10/15
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
    <title>StackExchange</title>
    <link href='/assets/css/materialize.min.css' rel="stylesheet">
    <link href="/assets/css/index.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- CSS  -->
    <%--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">--%>
</head>
<body>

<nav class="blue" role="navigation">
    <div class="nav-wrapper"><a id="logo-container" href="#" class="brand-logo">Stack Exchange</a>
        <ul class="right hide-on-med-and-down">
            <li><a class="waves-effect" href="/register">Register</a></li>
            <li><a class="waves-effect" href="/login">Login</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<section id="search">
    <div class="row">
        <div class="offset-s2 col s8">
            <div class="row">
                <form class="col s10">
                    <div class="input-field">
                        <%--<i class="material-icons prefix">search</i>--%>
                        <input id="input-search" type="text" class="validate">
                        <label for="input-search">Search</label>
                    </div>
                </form>
                <div class="col s2" id="search-btn-wrapper">
                    <a class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">search</i></a>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="question-title">
    <h5 class="blue-text">Top Questions</h5>
    <div class="divider"></div>
</section>

<section id="recent-post">
    <c:forEach items="${questions}" var="question">
        <div class="row">
            <div class="col s10 offset-s1">
                <div class="card blue" data-id="5">
                    <div class="card-content white-text">
                        <span class="card-title">${question.title}</span>
                        <div class="divider"></div>
                        <br/>
                        <p>${question.title}</p>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</section>

<!--  Scripts-->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/materialize.min.js"></script>
<script src="/assets/js/init.js"></script>
<script src="/assets/js/index.js"></script>

</body>
</html>