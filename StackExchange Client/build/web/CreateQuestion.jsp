<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<link rel="stylesheet" type="text/css" href="style.css"/>
	<title>Questions</title>
    </head>
    <body>
	 <div id="big">Simple StackExchange</div>
	 <div class="mediumbaru">
	 <div id="m1">What's your question?</div>
	 <form name="makequestion" method="post" action="checkToken" >
		<input type="text" name="name" placeholder="Name" class="medium">
		<input type="email" name="email" placeholder="Email" class="medium">
		<input type="text" name="question" placeholder="Question Topic" class="medium">
		<textarea name="content" placeholder="Content" class="medium" id="content"></textarea> 
		<input type="submit" value="Post" id="button">
	 </form></div>
         <%
            String email = request.getParameter("email");
            String title = request.getParameter("question");
            String content = request.getParameter("content");
            try {
                if(email!=null && email!="") {
                    questionmodel.QuestionWS_Service service = new questionmodel.QuestionWS_Service();
                    questionmodel.QuestionWS port = service.getQuestionWSPort();
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dadakanDB","root","");
                    String sql = "SELECT token FROM tokens JOIN users WHERE email='" + email + "'";
                    java.sql.PreparedStatement dbs = conn.prepareStatement(sql);
                    ResultSet rs = dbs.executeQuery();
                    String token = "";
                    while(rs.next())
                        token = rs.getString("token");
                    int result = port.createQuestion(token, title, content);
                    if(result>0) 
                        out.println("success!! token valid!!");
                    else if(result<0)
                        out.println("TOKEN INVALID!!");
                    else 
                        out.println("success!! BUT token expired!!");
                }
            } catch (Exception ex) {}
         %>
    </body>
</html>