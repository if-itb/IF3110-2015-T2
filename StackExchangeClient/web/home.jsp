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
		<a href="index.php"><h1>Simple StackExchange</h1></a>
	</div>

	<!-- das searchbox -->
	<div>
		<!--div class="wrapper" id="searchbox">-->
                <div>
			<form role="form" action="homes" method="GET">
				<input type="text" id="searchbox" name="searchquery" required>
				<input type="submit" id="searchbutton" value="Search" name="search">
			

			<p>Cannot find what you are looking for? <a href="ask.php?req=new">Ask here</a></p>
		</div>
                <div class="header2" id="main3"> Recently Asked Questions </div>
                <br> answers
                <c:forEach items="${result}" var="question">
                    <br> answers
                    ${question.topic} 
                    <a href="<c:url value="\viewpost">
                        <c:param name="id" value="${question.id}"/>
                    </c:url>">${question.topic}
                    </a>
                
                </c:forEach> 
                    </form>
        </div> 
        
</div>



</body>
</html>
