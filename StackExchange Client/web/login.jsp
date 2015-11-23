<%-- 
    Document   : login
    Created on : 23-Nov-2015, 22:51:05
    Author     : KEVIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
	<link href="mainstyle.css" rel="stylesheet">
 </head>
 <body>
 
 	    <header id="top" class="header">
        <div class="text-vertical-center">


            <h1>Register your mail</h1>
			
	<form method="post" action="">
            
		<div>
			<h2> User Name : <input type ="text" name="username" value=""> </h2>
			<span class="error">* 
		</div>
		<div>
			<h2> Password: <input type ="text" name="password" value=""> </h2>
			<span class="error">* 
		</div>
		<div>		
			<input type="submit" name="submit" value="Submit" class="btn btn-dark btn-lg">
		</div>
        </div>
</header>

	</form>
 </body>
</html>
