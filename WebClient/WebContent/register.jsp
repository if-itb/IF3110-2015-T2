<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Register</title>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <div id="content">
        	<span class="error"></span>
            <form id="registerForm" action="register_post.jsp" METHOD = "POST">
            	Username : <input type="text" name="username"/><br/>
                Email: <input type="text" name="email"/><br/>
                Password : <input type="text" name="password"/><br/>
                Fullname : <input type="text" name="fullname"/><br/>
                <button id="submitBtn">Submit</button>
            </form>
        </div>
    </body>
</html>