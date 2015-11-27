<%-- 
    Document   : ask
    Created on : Nov 16, 2015, 11:23:02 PM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">    
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>    <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container">
            <% out.write("<a id='logo-container' href='index.jsp?token="+ request.getParameter("token") +"' class='brand-logo'>Home</a>");%>
            <ul class="right hide-on-med-and-down">
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>

            <ul id="nav-mobile" class="side-nav">
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
            </ul>
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
            </div>
        </nav>   
        <script>
            $(document).ready(function(){

              // Initialize collapse button
              $(".button-collapse").sideNav();
            });
        </script>
        <title>Simple StackExchange</title>
    </head>
    <body>
        <div class="container">
            <br><br>
            <h1 class="header center orange-text">Ask here!</h1>
            <br><br>
        </div>

        <div class="row">
            <%out.write("<form class='col s12' name='loginForm' action='createQuestion.jsp?token="+ request.getParameter("token") +"' onsubmit='' method='POST'>");%>
              <input type="hidden" name="question_id">
              <div class="row">
                <div class="input-field col s12">
                  <input placeholder="The question topic goes here..." name="topic" id="topic" type="text" required>
                  <label for="topic" data-error="wrong" data-success="right">Question Topic</label> 
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input placeholder="The content goes here..." name="content" id="content" type="text" required>
                  <label for="content" data-error="wrong" data-success="right">Content</label> 
                </div>
              </div>
              <button class="btn waves-effect waves-light" type="submit" name="action">ask
                <i class="material-icons right">send</i>
            </button>
            </form>
          </div>
        
    <%
    /*try {
        
        String askForm =        
            "<form name='askForm' action='createQuestion.jsp?token=" + request.getParameter("token") + "'method='post'>"
                +"<input type='hidden' name='accessToken' value='5'>"
                +"<input type='text' class='form-text' name='topic' placeholder='Question Topic' required><br>"
                +"<textarea name='content' class='form-textarea' placeholder='Content' required></textarea><br>"
                +"<button class='button-post' type='submit'> Submit </button>"
            +"</form>"
        ;
        out.write(askForm);
    } catch (Exception ex) {
        out.write("exception");
	// TODO handle custom exceptions here
    }*/
    %>
    
    </body>
</html>



