
	<title><%= request.getParameter("pageTitle") %></title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<base href="http://localhost:8080/WebClient/index.jsp"/>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
    <!-- js -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollgress.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="assets/css/main.css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
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
%>

<script>
function checkToken(){
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
	               	   var element = document.getElementById('signin');
	               	   element.setAttribute('href','signout.jsp');
	               	   var str = $('a#signin').text('Sign Out');
	               	   $('a#register').remove();
	               	   $('.modify_'+id).show();
                  }
                  else{
                	  alert('halo');
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
