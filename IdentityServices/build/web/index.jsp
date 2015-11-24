<%-- 
    Document   : index
    Created on : Nov 17, 2015, 8:16:41 PM
    Author     : acel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="Token.*"%>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    
    <form method="POST" action="/IdentityServices/Token">
        Username <input type="text" name="uname"><br>
        Password <input type="password" name="pword"><br>
        <button type="submit">Submit</button>
    </form>
    
    

