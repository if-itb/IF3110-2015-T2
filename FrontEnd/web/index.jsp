<%-- 
    Document   : index
    Created on : Nov 12, 2015, 2:18:23 AM
    Author     : Asus
--%>
<%@ page import = "FrontEndClient.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Client a = new Client();
        out.println(a.GetHello());
        %>
    </body>
</html>
