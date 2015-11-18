<%-- 
    Document   : login
    Created on : Nov 17, 2015, 1:51:17 PM
    Author     : jessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
	<div class="container">
                <center><h2>Log In</h2></center>
		<hr>
		<br>
		<div class="center">
                    <!-- TODO: Ask Controller -->
                    <form name="register" class="register" action="controllers/ask.controller.php" 
                              onsubmit="return validateAskForm()" method="post">
				<input type="text" id="email" name="email" placeholder="Email"><br>
				<input type="password" id="pass" name="pass" placeholder="Password"><br>
                                <div class="div-right-button">
                                    <input type="submit" class="right-button" value="Log In">
                                </div>
			</form>
		</div>
	</div>
<script src="assets/js/validation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>