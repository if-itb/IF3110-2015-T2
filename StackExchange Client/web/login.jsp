<%@page import="java.util.*" %>
<%@page import="java.lang.Exception" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        
        <title>Simple StackExchange</title>
    </head>

    <body>
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
        <br>
        <br>
        <br>
        <br>
        <div class="subtitle">Login</div>
        <hr class='line'>
        <form id = "loginForm" name="loginForm" action="" onsubmit="" method="POST">
            <input type="hidden" name="question_id">
            <input type="text" class='form-text' name="email" placeholder="Email" required><br>
            <input type="password" class='form-text' name="password" placeholder="Password" required><br>
            <button class='button-post' type='submit'> Login </button>
        </form>
        <% 
            Cookie cookie = null;
            Cookie[] cookies = null;
            String access_token = null;
            
            if (cookies != null){
                for (int i=0; i< cookies.length; i++){
                   if (cookies[i].getName().equals("access_token")){
                        access_token = cookie.getValue();
                        break;
                    }
                }

                if (access_token != null && access_token.length() > 0){
                    //check access_token validity to server    
        %>

        <script>
            //Fungsi java script untuk pengecekan Validitas Token 

            //Java script, JQuery, and AJAX Initialization
            function checkTokenValidity(){
                var token = {access_token: "<%= access_token %>" };
                var url = "http://localhost:8080/REST-WS/rest/token-validity";

                $.ajax({
                    url: url,
                    data: token,
                    dataType: "json",
                    type: "POST",
                    success: function(data){
                        var valid = data.valid;
                        if (valid == 1){
                            window.location.href = "index.jsp";
                        }
                        else if (valid == 0){
                            //regenerate Token and move to index.jsp

                        }
                    },
                    error: function(jqxhr,status,errorMsg){
                        alert(status + " : " + errorMsg);
                    }
                });
            }

            //Document ready function, java script function
            $(document).ready(function(){
                checkTokenValidity();
            });
        </script>
            
        <%
            }
        }
        else{
            out.println("Tidak ada cookies");
        }
        %>

        <script>
            $(document).ready(function(){
                var url = "http://localhost:8080/REST-WS/rest/token";
                $('.button-post').click(function(e){
                    e.preventDefault();
                    var data = $('#loginForm').serialize();
                    $.ajax({
                        url: url,
                        data: data,
                        dataType: "json",
                        type: "POST",
                        success: function(data){
                            var token = data.access_token;
                            document.cookie = "access_token" + token;
                            //expired = null;
                            if (token = null){
                                //Username password gak sama
                            }
                            else{
                                //Berhasil login
                                window.location.href = "index.jsp";
                            }

                        },
                        error: function(jqxhr,status,errorMsg){
                            //
                        }
                    });
                });
            });
        </script>


    </body>
</html>
