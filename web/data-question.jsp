<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <title></title>
</head>
<body>

  <sql:setDataSource var="insertQ" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/db"
                   user="root"  password=""/>
  
  <sql:update dataSource="${insertQ}" var="result">
    Insert into question (`Topic`,`Content`,`Date`) values (<%= request.getParameter("Topic")%>,<%= request.getParameter("Content")%>,now());
  </sql:update>

</body>
</html>
