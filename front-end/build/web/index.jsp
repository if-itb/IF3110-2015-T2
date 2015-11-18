<%-- 
    Document   : index
    Created on : Nov 18, 2015, 9:40:20 AM
    Author     : Gerry
--%>
<html lang="en">
  <head>
    <title>Stack Exchange</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  </head>

  <body>
    <nav class="deep-purple darken-2" role="navigation">
      <div class="nav-wrapper container">
        <a id="logo-container" href="#" class="brand-logo">Stack Exchange</a>
        <ul class="right hide-on-med-and-down">
          <li><a href="register.jsp">Register</a></li>
          <li><a href="login.jsp">Login</a></li>
        </ul>
      </div>
    </nav>
    <br><br><br>
    <div class="container">
      <nav class="deep-purple darken-2" role="navigation">
        <div class="nav-wrapper">
          <form>
            <div class="input-field">
              <input id="search" type="search" required>
              <label for="search"><i class="material-icons">search</i></label>
              <i class="material-icons">close</i>
            </div>
          </form>
        </div>
      </nav>
    </div>
    <div class="ask-question">
      <p class="center"><a href="question.jsp"> Ask Your Question Here</a></p>
    </div>
    <br>
    <div class="container">
      <div class="divider"></div>
    </div>
    <!--<div class="parallax-container">
    <div class="parallax"><img src="tokyo-blue-background-4547.jpg"></div>
    <center><h1 class="white-text"> Recently Asked Question </h1></center>
    </div>-->
    <center><h2 class="deep-purple-text"> Recently Asked Question </h2></center>
    <div class="section white">
      <div class="row center">
        <div class="container">
          <div class="card deep-purple darken-2">
            <div class="card-content white-text">
              <span class="card-title"><a href="answer.jsp">Content Topic</a></span>
              <p>I am a very simple card. I am good at containing small bits of information.
                I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a class="left" href="#">Asked by Gerry Kastogi</a>
              <a class="right" href="#">Edit</a>
              <a class="right" href="#">Delete</a>
            </div>
          </div>
        </div>
      </div>
      <div class="row center">
        <div class="container">
          <div class="card deep-purple darken-2">
            <div class="card-content white-text">
              <span class="card-title"><a href="answer.jsp">Content Topic</a></span>
              <p>I am a very simple card. I am good at containing small bits of information.
                I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a class="left" href="#">Asked by Gerry Kastogi</a>
              <a class="right" href="#">Edit</a>
              <a class="right" href="#">Delete</a>
            </div>
          </div>
        </div>
      </div>
      <div class="row center">
        <div class="container">
          <div class="card deep-purple darken-2">
            <div class="card-content white-text">
              <span class="card-title"><a href="answer.jsp">Content Topic</a></span>
              <p>I am a very simple card. I am good at containing small bits of information.
                I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <a class="left" href="#">Asked by Gerry Kastogi</a>
              <a class="right" href="#">Edit</a>
              <a class="right" href="#">Delete</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--<div class="parallax-container">
    <div class="parallax"><img src="tokyo-blue-background-4547.jpg"></div>
    </div>-->

    <footer class="page-footer deep-purple darken-2">
      <div class="footer-copyright">
        <div class="container">
          © 2015 Created by 3xcelsi
        </div>
      </div>
    </footer>

    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.min.js"></script>
    <script src="js/init.js"></script>
  </body>
</html>