
	<title><%= request.getParameter("pageTitle") %></title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<base href="http://localhost:8080/WebClient/index.jsp"/>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <%
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
		var checkTokenUrl = "http://localhost:8080/REST-WS/rest/token-validity";
		$.ajax({
               url: checkTokenUrl,
               data: tokenData,
               dataType: "json",
               type: "POST",
               success: function(data) {
                   var valid = data.valid;
                   if(valid){
                	   var element = document.getElementById('signin');
                	   element.setAttribute('href','signout.jsp');
                	   var str = $('a#signin').text('Sign Out');
                	   $('a#register').remove();
                   }
               }
           });
	}
	$(document).ready(function(){
	    checkToken();
	});
	</script>
	<% } 
	} %>
