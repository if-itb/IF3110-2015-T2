<%-- 
    Document   : index
    Created on : Nov 15, 2015, 8:43:46 PM
    Author     : Tifani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/views/header.jsp" flush="true"/>

	<div class="container">
		<div class="center">
			<div id="search">
				<form action="search.jsp" method="GET"> <!-- TODO: search.jsp -->
					<fieldset class="clearfix">
						<input type="search" name="search" value="Type your search-keywords here..." 
                                                       placeholder="Type your search-keywords here...">
						<input type="submit" value="Search" class="button">
					</fieldset>
				</form>
			</div>
			<br>
			Cannot find what you are looking for? <a href="ask.jsp">Ask here</a>
		</div>

		<br>
		<h2>Recently Asked Questions</h2>
                
                
                        
		
			<!-- TODO: <?php showQuestionList()?> -->
                        
                        
		
	</div>
<script src="assets/js/confirmation.js"></script>
<jsp:include page="/views/footer.jsp" flush="true"/>
