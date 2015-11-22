
	<title><%= request.getParameter("pageTitle") %> | StackExchange</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<base href="http://localhost:8080/WebClient/index.jsp"/>
	<script src="assets/js/jquery-1.11.3.min.js"></script>
    <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
    
   
    <%
    if((request.getParameter("isNeedCookieCheck") == null) ||  ((request.getParameter("isNeedCookieCheck") != null) && (request.getParameter("isNeedCookieCheck") == "true"))){
    	Cookie cookie = null;
		Cookie[] cookies = null;
		String access_token = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		if( cookies != null ){
			for (int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				if(cookie.getName().equals("access_token")){
					access_token = cookie.getValue();
					break;
				}
			}
			
			if((access_token != null) && (access_token.length()>0)){
				//check access_token validity to server
				if((request.getParameter("needDeleteQuestion") != null) && (request.getParameter("needDeleteQuestion").equals("true"))){
					%>
					<jsp:include page="question_delete.jsp" flush="true">
						<jsp:param name="pageTitle" value="Simple StackExchange" />
						<jsp:param name="access_token" value="<%= access_token %>" />
					</jsp:include><%
				}
%>

<script>
function checkToken(){
	var user_buttons = document.getElementsByClassName("user");
	console.log(user_buttons.length);
	var tokenData = {access_token:"<%= access_token %>"}
	
	<%
		String checkTokenUrl = "http://localhost:8080/REST-WS/rest/token-validity";
		if(request.getParameter("validityUrl")!=null){
			checkTokenUrl += request.getParameter("validityUrl");
		}
	%>
	var checkTokenUrl = "<%= checkTokenUrl %>";
	$.ajax({
              url: checkTokenUrl,
              data: tokenData,
              dataType: "json",
              type: "POST",
              success: function(data) {
                  var valid = data.valid;
                  var id = data.id_user;
                  if(valid){
                	   for (var i = 0; i < user_buttons.length; i ++) {
                		   user_buttons[i].style.display='block';
                		}
	               	   var element = document.getElementById('signin');
	               	   element.setAttribute('href','signout.jsp');
	               	   var str = $('a#signin').text('Sign Out');
	               	   $('a#register').remove();
	               	   $('.modify_'+id).show();
					   $('#navPanel nav a:nth-child(2)').remove();
					   $('#navPanel nav a:nth-child(2)').text('Sign Out');
					   $('#navPanel nav a:nth-child(2)').attr("href", "signout.jsp");
                  }
                  else{
                	  alert('Welcome to StackExchange');
                  }
                  <% if((request.getParameter("needRedirectWhenNotValid") != null) && (request.getParameter("needRedirectWhenNotValid").equals("true"))){%>
        	  			if(!valid){
        	  				window.location.href = "index.jsp";
	        	  			<% if((request.getParameter("messagetWhenNotValid") != null)){ %>
	        	  				alert("<%= request.getParameter("messagetWhenNotValid") %>");
	        	  			<% } %>
        	  			}
        	   	 <%}%>  
              }
          });
}
$(document).ready(function(){
    checkToken();
});
</script>
	<%	} else {
			if(request.getParameter("errorCookieError") != null){
				String redirectUrl = request.getParameter("redirectUrlAuthorization");
				//redirect
				String site = new String(redirectUrl);
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", site); 
			}
		}
	} else {
		if(request.getParameter("errorCookieEmpty") != null){
			String redirectUrl = request.getParameter("redirectUrlTokenEmpty");
			//redirect
			String site = new String(redirectUrl);
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
	}
}%>
