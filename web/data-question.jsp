<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<html>
<head>
    <title></title>
</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*" %>
    <%
        String url= "jdbc:mysql://localhost:9000/db";
        String id= "root";
        String pass = "";
        try{
          Connection connection = null;
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          connection = DriverManager.getConnection(url,id,pass);
          Statement statement = connection.createStatement();
        }catch(ClassNotFoundException cnfex){
          cnfex.printStackTrace();

        }
        String Topic = request.getParameter("Topic");
        String Content = request.getParameter("Content");


        String sql = "Insert into question (Topic,Content,created_at) values ( 'Topic'  ,'Content' , now());";
        statement.executeUpdate(sql);
        response.addHeader("location", "/index.jsp");
    %>

</body>
</html>
