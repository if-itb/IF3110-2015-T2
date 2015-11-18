<%-- 
    Document   : register
    Created on : Nov 17, 2015, 12:47:14 PM
    Author     : jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
	<div class="container">
                <center><h2>Register</h2></center>
		<hr>
		<br>
		<div class="center">
                    <!-- TODO: Ask Controller -->
                    <form name="register" class="register" action="Register" method="post">
                        <input type="text" id="username" name="username" placeholder="Username"><br>
			<input type="text" id="name" name="name" placeholder="Name"><br>
			<input type="text" id="email" name="email" placeholder="Email"><br>
			<input type="password" id="pass" name="pass" placeholder="Password"><br>
                        <input type="password" id="passcheck" name="passcheck" placeholder="Type your password again"><br>
                        <div class="div-right-button">
                            <input type="submit" class="right-button" value="Register">
                        </div>
			</form>
		</div>
	</div>
<script src="assets/js/validation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>
