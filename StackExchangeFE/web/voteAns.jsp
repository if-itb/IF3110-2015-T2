
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
<<<<<<< HEAD
        <%String t = "";
            Cookie [] cookieArray = request.getCookies();
            if(cookieArray != null){
                    for (int j=0; j<cookieArray.length;j++){
                        if(cookieArray[j].getName().equals("token")){
                            t = cookieArray[j].getValue();
                        }
                    }
                   }%>
=======
        <% String t = request.getParameter("token");%>
>>>>>>> 4df0728f23fffc49d188659f63c70f6ff0d862ee
        <% String a = request.getParameter("aid");%>
        <% String q = request.getParameter("qid");%>
        <% String v = request.getParameter("value");%>    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>voteAns - TuBes WBD</title>
    </head>
    
    <body>

    <%-- start web service invocation --%><hr/>
    <%
    try {
	answermodel.AnswerWS_Service service = new answermodel.AnswerWS_Service();
	answermodel.AnswerWS port = service.getAnswerWSPort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = t;
	int aId = Integer.valueOf(a);
        int val = 0;
        if (v.equals("plus"))
        {
            val = 1;
        }
        else
        {
            val = -1;
        }
	// TODO process result here
	int result = port.voteAnswer(accessToken, aId, val);
        if (result==1)
        {
<<<<<<< HEAD
            response.sendRedirect("http://localhost:8080/StackExchangeFE/answerlogin.jsp?id="+q);
=======
            response.sendRedirect("http://localhost:8080/StackExchangeFE/answerlogin.jsp?id="+q+"&token="+t);
>>>>>>> 4df0728f23fffc49d188659f63c70f6ff0d862ee
        }
        else
        {
            response.sendRedirect("http://localhost:8082/WBD_IS/login.jsp?msg=sessiontimeout");
        }        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
