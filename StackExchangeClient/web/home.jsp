<%@ page language ="java" contentType = "text/html ; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Simple StackExchange | Home</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        
</head>
<body>

<div class="containerT">
	<div id="headerT">
		<a href="/StackExchangeClient/home"><h1 class="col-3">Simple StackExchange</h1></a>
	</div>

	<!-- das searchbox -->
	<div>
		<!--div class="wrapper" id="searchbox">-->
                <div>
			<form role="form" action="" method="get">
                            <input class="col-md-6 col-md-offset-3" type="text" id="searchbox" name="searchquery" required>
                            <input class="btn" type="submit" id="searchbutton" value="Search" name="search">
			</form>

                    <div class="col-md"><p>Cannot find what you are looking for? <a href="ask.php?req=new">Ask here</a></p></div>
		</div>
                <div class="col-md-2" id="main3"><h3>Recently Asked Questions</h3></div>
                   
                <div class="col-md-8">
                <c:forEach items="${result}" var="question">
                   <ul class="list-inline">
                       <li>
                           VOTE 
                       </li>
                       <li>
                           ANSWERS 
                       </li>
                       <li><a href="<c:url value="/viewpost?qid=${question.getQuestionId()}"></c:url>"><h4>${question.getQuestionTopic()}</h4></a></li>
                   </ul>
                   ${question.getQuestionContent()}<br>
                </c:forEach> 
                   </div>

        </div> 
        
</div>

</body>
</html>
