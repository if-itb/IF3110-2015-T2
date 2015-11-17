<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.*, java.io.*"%>
<%@ page import = "org.tusiri.ws.question.QuestionService" %>
<%@ page import = "org.tusiri.ws.question.Question" %>
<%@ page import = "org.tusiri.ws.question.QuestionItem" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
QuestionService qservice = new QuestionService();
Question q = qservice.getQuestionPort();
List<QuestionItem> questionList = q.getQuestionList();
int n = questionList.size();
%>
Total jumlah pertanyaan: <%= n %></br>

Pada contoh ini, hanya pertanyaan pertama yang diprint
<p>
Question Pertama Isinya</br>
Id Question: <%= questionList.get(0).getIdQuestion() %></br>
Id User: <%= questionList.get(0).getIdUser() %></br>
Topic: <%= questionList.get(0).getTopic() %></br>
Content: <%= questionList.get(0).getContent() %></br>

</p>
</body>
</html>