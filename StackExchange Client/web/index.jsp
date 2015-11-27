<%-- 
    Document   : index
    Created on : Nov 12, 2015, 12:00:30 PM
    Author     : User
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
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
        <%
            /*if(request.getParameter("token") != null ){
                if(!request.getParameter("token").equals("null")){
                    try {
                        com.wbd.rgs.RegisterWS_Service service = new com.wbd.rgs.RegisterWS_Service();
                        com.wbd.rgs.RegisterWS port = service.getRegisterWSPort();
                         // TODO initialize WS operation arguments here
                        java.lang.String accessToken = request.getParameter("token");
                        // TODO process result here
                        java.lang.String result = port.getUsername(accessToken);
                        out.println("<div class='smalltitle-right'>Welcome " + result + "</div>");
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                }else{
                    out.println("<div class='smalltitle-right'><a id = 'color-black' href='login.jsp' >login</a> | <a id = 'color-black' href='register.jsp' >register</a></div>");
                }
            }
            else{   
                out.println("<div class='smalltitle-right'><a id = 'color-black' href='login.jsp' >login</a> | <a id = 'color-black' href='register.jsp' >register</a></div>");
            }
            out.println("<div class='link-normalizer'><a class='title' href='index.jsp?token=" + request.getParameter("token") + "'>Simple StackExchange</a></div>");
        */
        %>
        
        <div class="container">
            <h1 class="header center orange-text">Simple Stack Exchange</h1>
            <div class="row center">
                <h5 class="header col s12 light">Cannot find what you're looking for?</h5>
            </div>
            <div class="row center">
                <% out.write("<a href='ask.jsp?token="+ request.getParameter("token") +"' id='download-button' class='btn-large waves-effect waves-light orange'>Ask Here</a>");%>
            </div>
            <br><br>
        </div>
  
        <div class="row">
            <div class="orange col s8 push-s2">
                <% out.write("<form name='searchForm' action='index.jsp?token="+request.getParameter("token") +"' method='POST'>");%>
                    <div class="input-field">
                        <input name="search_key" id="search" type="search" required>
                        <i class="material-icons">close</i>
                    </div>
               </form>
            </div>       
        </div>
        <br><br>
   

        <h4 class="header center-align orange-text"> Recently Asked Questions </h2>
        <%
    try {
        
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
        com.wbd.ans.AnswerWS_Service service2 = new com.wbd.ans.AnswerWS_Service();
	com.wbd.ans.AnswerWS port2 = service2.getAnswerWSPort();
        com.wbd.qst.QuestionWS_Service service3 = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port3 = service3.getQuestionWSPort();
	// TODO process result here
        java.util.List<com.wbd.qst.Question> result;
        if(request.getParameter("search_key") != null){
            result = port.searchQ(request.getParameter("search_key"), request.getParameter("search_key"));        
        }
        else{
            result = port.retrieveQ();
        }
    out.write("<ul class='collection'>");
    for(int i = 0; i < result.size() ; i++){
            String vote;
            java.util.List<com.wbd.ans.Answer> result2 = port2.getAnswerByQID(result.get(i).getIDQ());
            java.lang.String result3 = port3.getNama(result.get(i).getIDQ());
            int count = result2.size();
            if(result.get(i).getVote() > 1 || result.get(i).getVote() < -1){
                vote = "Votes";
            }
            else{
                vote = "Vote";
            }
            
            String question ="<div class='bquestion-vote'>" 
                        +result.get(i).getVote()
                        +"<br>"
                +vote
                    +"</div>"
                    +"<div class='bquestion-answer'>" 
                + count
                +"<br>"
                +"Answer"
            +"</div>"
            +"<div class='bquestion-content'>" 
                        +"<a id='color-black' href=question.jsp?id=" + result.get(i).getIDQ() + "&token=" + request.getParameter("token") + ">" + result.get(i).getQuestionTopic() + "</a>"
                        +"<br>"
                        +result.get(i).getContent()
                        +"<br><br>"
                    +"</div>"
                    +"<div class='bquestion-identity'>" 
                        +"asked by "
                        +"<a id='color-blue'>"
                            +result3
                        +"</a>"
                        +" | "
                        +"<a id='color-orange' href=edit.jsp?id=" + result.get(i).getIDQ() +"&token=" + request.getParameter("token")
                            + ">edit"
                        +"</a>"
            +" | "
                        +"<a id='color-red' href=delete.jsp?id=" + result.get(i).getIDQ() +"&token=" + request.getParameter("token") +">"
                            +"delete"
            +"</a>"+"</div>";


        String start = "<li class='collection-item avatar'><i class='material-icons circle'>folder</i>";
        String end = "<br><br><br><a href='' class='secondary-content'><i class='material-icons'>grade</i></a></li>";

            out.write(start + question + end);
        }
        out.write("</ul>");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>


    </body>
</html>