<%-- 
    Document   : index
    Created on : Nov 12, 2015, 2:18:23 AM
    Author     : Asus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style.css">
        <script src="jquery.min.js"></script>
        <script>
            /*$(document).ready(function(){
                $("#tablogin").click(function(){
                    $("#tablogin").css("background-color", "white");
                    $("#tabreg").css("background-color", "silver");
                });
                $("#tabreg").click(function(){
                    $("#tablogin").css("background-color", "silver");
                    $("#tabreg").css("background-color", "white");
                });
            });*/
        
            function changetab(type) {
                /*var xhttp;
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                    } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhttp.onreadystatechange = function() {
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        document.getElementById("formaccount").innerHTML = xhttp.responseText;
                    }
                }
                if (type == "login")
                    xhttp.open("GET", "login.html", true);
                else
                    xhttp.open("GET", "reg.html", true);
                xhttp.send();*/
                window.open(type+".jsp", "_self");
            }
        </script>
        <title>Simple StackExchange</title>
    </head>
    <body>
        <div style = "width : 40%; margin : auto; text-align: center;">
            <h1><a href="index1.jsp" id = "title">Simple StackExchange</a></h1>
            <div class = "tabbutton" style="background-color : white;" onclick = "changetab('login')">Login</div><div class = "tabbutton" style="background-color : silver;" onclick = "changetab('register')">Create New Account</div>
            <div id ="formaccount">
                <form method = "post" action = "http://localhost:8001/Identity/LoginRSServlet">
                    <br>
                    <table class = "borderless">
                        <tr><td class = "borderless">Email</td><td class = "borderless">:</td><td class = "borderless"><input type ="text" name = "email"></td></tr>
                        <tr><td class = "borderless">Password</td><td class = "borderless">:</td><td class = "borderless"><input type ="password" name = "password"></td></tr>
                    </table>
                    <br>
                    <input type ="hidden" name ="submitted" value ="yes">
                    <input type ="submit" value = "Login">
                </form>
            </div>
        </div>


    </body>
</html>
