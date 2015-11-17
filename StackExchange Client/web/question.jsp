<%-- 
    Document   : question
    Created on : Nov 16, 2015, 1:47:03 AM
    Author     : vanyadeasysafrina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>
	<div class="container">
        <!--TODO : SHOW QUESTION AND ANSWER -->
        <!--
        int id = (int)request.getParameter("q_id");
	
		showQuestion(id);
		showAnswers(id); */
	-->
		<br><br>
		<div class="center">
			<form class="basic-grey" name= "answer" action="controllers/answer.controller.php" onsubmit="return validateAnswerForm()" method="post">
				<input type="hidden" name="q_id" value="<?php echo $id ?>">
				<input type="text" id="name" name="name" placeholder="Name"><br>
				<input type="text" id="email" name="email" placeholder="Email"><br>
				<textarea id="content" name="content" placeholder="Content" ></textarea><br>
				<div class="div-right-button">
					<input type="submit" class="right-button" value="Post">
				</div>
			</form>
		</div>
	</div>

<script src="assets/js/confirmation.js"></script>
<script src="assets/js/validation.js"></script>
<script src="assets/js/script.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>