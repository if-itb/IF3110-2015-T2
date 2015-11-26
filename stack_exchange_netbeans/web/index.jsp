<%@page import="model.Question"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.stackexchange.webservice.service.QuestionWS;" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>StackExchange</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="assets/css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body class="cyan lighten-2">
<nav class="white" role="navigation">
  <div class="nav-wrapper container">
    <a><img src="assets/image/Bicep.jpg" alt="Unsplashed background img 1" width="48" height="48"> </a>
    <a id="logo-container" href="#" class="brand-logo">LEXCLE</a>
    <ul class="right hide-on-med-and-down">
      <li><a href="#">Login</a></li>
      <li><a href="#">Register</a></li>
    </ul>

    <ul id="nav-mobile" class="side-nav">
      <li><a href="#">Navbar Link</a></li>
    </ul>
    <a href="WEB-INF/web.xml"></a>
    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
  </div>
</nav>

<div id="index-banner" class="parallax-container">
  <div class="section no-pad-bot">
    <div class="container">
      <br><br>
      <h1 class="header center white-text text-lighten-2">StackExchange</h1>
      <div class="row center">
         <h5 class="header col s12 light">Cannot find what you are looking for?<a class ="orange-text" href="http://localhost:8080/stack_exchange_netbeans/CheckAddQuestionServlet?token=sssc">Ask Here</a></h5>
       </div>
      <!--
       <div class="row center">
         <a href="http://materializecss.com/getting-started.html" id="download-button" class="btn-large waves-effect waves-light teal lighten-1">Get Started</a>
       </div>
       <br><br>
       -->
    </div>
  </div>
  <div class="parallax"></div>
</div>


<%--<div class="container">--%>
  <%--<div class="section">--%>

    <%--<!--   Icon Section   -->--%>
    <%--<div class="row">--%>
      <%--<div class="col s12 m4">--%>
        <%--<div class="icon-block">--%>
          <%--<h2 class="center brown-text"><i class="material-icons">flash_on</i></h2>--%>
          <%--<h5 class="center">Speeds up development</h5>--%>

          <%--<p class="light">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>--%>
        <%--</div>--%>
      <%--</div>--%>

      <%--<div class="col s12 m4">--%>
        <%--<div class="icon-block">--%>
          <%--<h2 class="center brown-text"><i class="material-icons">group</i></h2>--%>
          <%--<h5 class="center">User Experience Focused</h5>--%>

          <%--<p class="light">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>--%>
        <%--</div>--%>
      <%--</div>--%>

      <%--<div class="col s12 m4">--%>
        <%--<div class="icon-block">--%>
          <%--<h2 class="center brown-text"><i class="material-icons">settings</i></h2>--%>
          <%--<h5 class="center">Easy to work with</h5>--%>

          <%--<p class="light">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>--%>
        <%--</div>--%>
      <%--</div>--%>
    <%--</div>--%>

  <%--</div>--%>
<%--</div>--%>
<!--  
 //retrieve your list from the request, with casting 
//ArrayList<Question> list = (ArrayList<Question>) request.getAttribute("IndexServlet");

 //print the information about every category of the list
//for(Question category : list) {
//    out.println(category.getId());
//    out.println(category.getName());
    //out.println(category.getMainCategoryId());
//}
--> 
<c:forEach items="${QList}" var="question">  
    <div class="row">
      <div class="col s10 offset-s1 l10">
        <div class="card blue-grey darken-1">
          <div class="card-content white-text">
              <span class="card-title"><a href = "http://localhost:8080/stack_exchange_netbeans/question?question_id=<c:out value="${question.id}"/>&token=sssc&from=question">${question.topic}</a></span>
              <div class="right">
                <p style="font-size: 35px;margin:20px 28px 0 0">${question.vote}</p>
              </div>
            <p>${question.content}</p>
              <div class="right-align">
                <p>Asked by ${question.userId}</p>
              </div>
          </div>
          <div class="card-action">
            <div class="left">
                <a href="http://localhost:8080/stack_exchange_netbeans/UpVoteQuestionServlet?question_id=<c:out value="${question.id}"/>&token=sssc&from=index"><img src="assets/image/up.png" alt="Unsplashed background img 1" width="25" height="25"></a>
                <a href="http://localhost:8080/stack_exchange_netbeans/DownVoteQuestionServlet?question_id=<c:out value="${question.id}"/>&token=sssc&from=index"><img src="assets/image/down.png" alt="Unsplashed background img 1" width="25" height="25"></a>
            </div>
            <div class="right-align">
                <a href="http://localhost:8080/stack_exchange_netbeans/EditQuestionServlet?question_id=<c:out value="${question.id}"/>&token=sssc">Edit</a>
                <a href="http://localhost:8080/stack_exchange_netbeans/DeleteQuestionServlet?question_id=<c:out value="${question.id}"/>&token=sssc">Delete</a>
            </div> 
          </div>
        </div>
      </div>
    </div>
</c:forEach>

<footer class="page-footer teal">
  <div class="container">
    <div class="row">
      <div class="col l6 s12">
        <h5 class="white-text">Company Bio</h5>
        <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Settings</h5>
        <ul>
          <li><a class="white-text" href="#!">Link 1</a></li>
          <li><a class="white-text" href="#!">Link 2</a></li>
          <li><a class="white-text" href="#!">Link 3</a></li>
          <li><a class="white-text" href="#!">Link 4</a></li>
        </ul>
      </div>
      <div class="col l3 s12">
        <h5 class="white-text">Connect</h5>
        <ul>
          <li><a class="white-text" href="#!">Link 1</a></li>
          <li><a class="white-text" href="#!">Link 2</a></li>
          <li><a class="white-text" href="#!">Link 3</a></li>
          <li><a class="white-text" href="#!">Link 4</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="container">
      Made by <a class="brown-text text-lighten-3" href="http://materializecss.com">Materialize</a>
    </div>
  </div>
</footer>


<!--  Scripts-->
<script src="assets/js/jquery-2.1.1.min.js"></script>
<script src="assets/js/materialize.js"></script>
<script src="assets/js/init.js"></script>

</body>
</html>
