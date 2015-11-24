<%@page import="java.util.*" %>
<%@page import="java.lang.Exception" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <base href="http://localhost:8082/StackExchange_IS/rest/">
       
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
                var url = "http://localhost:8082/StackExchange_IS/rest/tokenValidate";

                $.ajax({
                    url: url,
                    data: token,
                    dataType: "jsonp",
                    crossDomain: true,
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
            //out.println("Tidak ada cookies");
        }
        %>

        <script>
            $(document).ready(function(){
                var url = "http://localhost:8082/StackExchange_IS/rest/token";
                $('.button-post').click(function(e){
                    e.preventDefault();
                    var data = $('#loginForm').serialize();
                    console.log(data);
                    $.ajax({
                        url: url,
                        data: data,
                        crossDomain: true,
                        dataType: "json",
                        type: "POST",
                        success: function(data){
                            var token = data.access_token;
                            document.cookie = "access_token" + token;
                            //expired = null;
                            if (token == null){
                                //Username password gak sama
                                //window.location.href = "IVanWeteng.jsp"
                            }
                            else{
                                //Berhasil login
                                //window.location.href = "index.jsp";
                            }

                        },
                        error: function(jqxhr,status,errorMsg){
                            out.println("AJAX Error");
                        }
                    });
                });
            });
        </script>


    </body>
</html>
