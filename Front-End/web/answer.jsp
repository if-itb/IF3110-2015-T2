<%-- 
    Document   : answer.jsp
    Created on : Nov 17, 2015, 3:55:29 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>StackExchange</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="white" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="index.jsp" class="brand-logo">StackExchange</a>
      <ul class="right hide-on-med-and-down">
        <li><a href="">About Us</a></li>
        <li><a href="login.jsp">Log In</a></li>
        <li><a href="register.jsp">Sign Up</a></li>
      </ul>
    </div>
  </nav>

  <div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
      <div class="container">
        <br><br>
        <h1 class="header center white-text">StackExchange</h1>
        <div class="row center">
          <h5 class="header col s12 light">Answer of Question</h5>
        </div>
      </div>
    </div>
    <div class="parallax"><img src="images/background1.jpg" alt="Unsplashed background img 1"></div>
  </div>

  <div class="container">
    <div class="section">
      <div class="row">
        <div class="col s12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">Question Topic</span>
              <p>I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <p class="orange-text text-lighten-1 right">Asked by Vincent Theophilus Ciputra</p>
              <a href="">Edit</a>
              <a href="">Delete</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="divider"></div>
  
  <div class="container">
    <div class="section">
      <h2 class="header center blue-text text-darken-4">Answer 1</h2>
      <div class="row">
        <div class="col s12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <p>Answer... I am a very simple card. I am good at containing small bits of information.
              I am convenient because I require little markup to use effectively.</p>
            </div>
            <div class="card-action">
              <p class="orange-text text-lighten-1 right">Answered by Vincent Theophilus Ciputra</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <div class="divider"></div>
    
  <div class="container">
    <div class="section">
        <h2 class="header center blue-text text-darken-4">Your Answer</h2>
          <div class="row">
            <form class="col s12">
                <div class="row">
                  <form class="col s12">
                      <div class="input-field col s12">
                        <textarea id="content" class="materialize-textarea"></textarea>
                        <label for="content">Content</label>
                      </div>
                  </form>
                </div>
            </form>
          </div>
        <br>
    </div>
  </div>

  <div class="container">
    <div class="section">
        <div class="row right">
          <button class="btn waves-effect waves-light blue darken-4" type="submit" name="action">Post
            <i class="material-icons right">send</i>
          </button>
        </div>
    </div>
  </div>
  <br><br><br><br>

  <footer class="page-footer black">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">About Us</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project for fulfilling Web-Based Development task.</p>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        Made by RestingSOAP Group</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
</html>
