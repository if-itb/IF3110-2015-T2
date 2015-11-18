<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign Out</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
	<script>
	    $(document).ready(function(){
	    	document.cookie = "access_token =;expires=Thu, 01 Jan 1970 00:00:00 UTC";
	    	window.location.href = "index.jsp";
	    });
	</script>
	
</head>
<body>
 masuk
</body>
</html>