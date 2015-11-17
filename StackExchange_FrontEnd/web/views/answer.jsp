<%--
  Created by IntelliJ IDEA.
  User: elvan_owen
  Date: 11/11/15
  Time: 12:44 PM
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

    <link href="/assets/css/materialize.min.css" rel="stylesheet">
    <link href="/assets/css/answer.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- CSS  -->
    <%--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">--%>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-beta.1/angular.min.js"></script>
</head>
<body ng-app="StackExchangeApp">
<nav class="blue" role="navigation" ng-controller="LoginController">
    <div class="nav-wrapper"><a id="logo-container" href="/" class="brand-logo">Stack Exchange</a>
        <ul class="right hide-on-med-and-down" ng-if="!isLogin">
            <li><a class="waves-effect" href="/register">Register</a></li>
            <li><a class="waves-effect" href="/login">Login</a></li>
        </ul>

        <ul class="right hide-on-med-and-down" ng-if="isLogin">
            <li><a class="waves-effect" href="/register">{{user.name}}</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="#">Navbar Link</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<section id="topic-title">
    <h4 class="blue-text center-align">Question Topic</h4>
    <br/>
</section>

<section id="question-title">
    <h5 class="blue-text">Question</h5>
    <div class="divider"></div>
</section>

<section id="question" ng-controller="QuestionController">
    <div class="row">
        <div class="col s10 offset-s1">
            <div class="card">
                <a class="btn-floating waves-effect red question-close"><i class="material-icons">cancel</i></a>
                <div class="card-content blue-text clearfix">
                    <span class="card-name left"><b>${question.userId}</b></span>
                    <span class="card-date right"><i>${question.createDate}</i></span>
                </div>
                <br/>
                <div class="card-content blue-text">
                    <p class="input-content">${question.content}</p>
                </div>
                <div class="fixed-action-btn horizontal click-to-toggle">
                    <a class="btn-floating btn-large red">
                        <i class="large mdi-navigation-menu"></i>
                    </a>
                    <ul>
                        <li class="thumb-btn-wrapper">
                            <a class="btn-floating waves-effect green">
                                <i class="material-icons">thumb_up</i>
                            </a>
                            <a class="btn-floating green thumbs-num">
                                ${question.vote}
                            </a>
                        </li>
                        <li class="thumb-btn-wrapper">
                            <a class="btn-floating waves-effect red">
                                <i class="material-icons">thumb_down</i>
                            </a>
                            <a class="btn-floating red thumbs-num">
                                ${question.vote}
                            </a>
                        </li>
                        <li><a class="btn-floating waves-effect blue edit-btn"><i class="material-icons">mode_edit</i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="answer-title">
    <h5 class="blue-text">Answers</h5>
    <div class="divider"></div>
    <br/>
</section>

<section id="answer">
    <c:forEach items="${answers}" var="answer">
        <div class="row">
            <div class="col s10 offset-s1">
                <div class="card">
                    <div class="card-content blue-text clearfix">
                        <span class="card-name left"><b>${answer.userId}</b></span>
                        <span class="card-date right"><i>${answer.createDate}</i></span>
                    </div>
                    <br/>
                    <div class="card-content blue-text">
                        <p class="input-content">${answer.content}
                        </p>
                    </div>
                    <div class="fixed-action-btn horizontal click-to-toggle">
                        <a class="btn-floating btn-large red">
                            <i class="large mdi-navigation-menu"></i>
                        </a>
                        <ul>
                            <li class="thumb-btn-wrapper">
                                <a class="btn-floating waves-effect green">
                                    <i class="material-icons">thumb_up</i>
                                </a>
                                <a class="btn-floating green thumbs-num">
                                    ${answer.vote}
                                </a>
                            </li>
                            <li class="thumb-btn-wrapper">
                                <a class="btn-floating waves-effect red">
                                    <i class="material-icons">thumb_down</i>
                                </a>
                                <a class="btn-floating red thumbs-num">
                                    ${answer.vote}
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</section>

<!--  Scripts-->
<script>
    <%@ include file="/assets/js/jquery.min.js"%>
    <%@ include file="/assets/js/materialize.min.js"%>
    <%@ include file="/assets/js/init.js"%>
    <%@ include file="/assets/js/answer.js"%>
</script>

</body>
</html>