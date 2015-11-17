<%-- 
    Document   : edit_question
    Created on : Nov 17, 2015, 5:38:48 PM
    Author     : zainelwati
--%>
<%@page import="java.io.*, java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple StackExchange - Edit</title>
    </head>
    <body>
        <% String topic = request.getParameter("topic");%>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull/wbd_database"
                           user="root" password=""/>
        <sql:query dataSource="${snapshot}" var="result">
            UPDATE question SET topic= topic ;<!--QUERY nya belum karena variabelnya belum-->
        </sql:query>
    </body>
</html>
