<%-- 
    Document   : index
    Created on : Nov 24, 2015, 17:32:10 PM
    Author     : User
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Simple StackExchange</title>
    </head>

    <body>
        <div class="smalltitle-right"><a id = "color-black" href="login.jsp" >login</a> | <a id = "color-black" href="register.jsp" >register</a></div>
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
        
        <br><br><br><br>
        <div class="smalltitle-left">Search Result</div>
        <hr class='line'>
        
    <%
    try {
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
        com.wbd.ans.AnswerWS_Service service2 = new com.wbd.ans.AnswerWS_Service();
	com.wbd.ans.AnswerWS port2 = service2.getAnswerWSPort();
        com.wbd.qst.QuestionWS_Service service3 = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port3 = service3.getQuestionWSPort();
	// TODO process result here
	java.util.List<com.wbd.qst.Question> result = port.searchQ(request.getParameter("search_key"), request.getParameter("search_key"));       
	for(int i = 0; i < result.size() ; i++){
            String vote;
            java.util.List<com.wbd.ans.Answer> result2 = port2.getAnswerByQID(result.get(i).getIDQ());
            java.lang.String result3 = port3.getNama(result.get(i).getIDQ());
            int count = result2.size();
            if(result.get(i).getVote() > 1 || result.get(i).getVote() < -1){
                vote = "Votes";
            }
            else{
                vote = "Vote";
            }
            String question =
                "<div class='block-question'>"
                    +"<div class='bquestion-vote'>" 
                        +result.get(i).getVote()
                        +"<br>"
	    		+vote
                    +"</div>"
                    +"<div class='bquestion-answer'>" 
		    	+ count
		    	+"<br>"
		    	+"Answer"
		    +"</div>"
		    +"<div class='bquestion-content'>" 
                        +"<a id='color-black' href=question.jsp?id=" + result.get(i).getIDQ() + "&token=" + request.getParameter("token") + ">" + result.get(i).getQuestionTopic() + "</a>"
                        +"<br>"
                        +result.get(i).getContent()
                        +"<br><br>"
                    +"</div>"
                    +"<div class='bquestion-identity'>" 
                        +"asked by "
                        +"<a id='color-blue'>"
                            +result3
                        +"</a>"
                        +" | "
                        +"<a id='color-orange' href=edit.jsp?id=" + result.get(i).getIDQ() +"&token=" + request.getParameter("token")
                            + ">edit"
                        +"</a>"
			+" | "
                        +"<a id='color-red' href=delete.jsp?id=" + result.get(i).getIDQ() +" onclick='deleteconfirm(" + "$row['question_id']" + ")' " + "'>"
                            +"delete"
			+"</a>"
                    +"</div>"
                +"</div>"
                +"<hr class='line'>"
                ;
            out.write(question);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>


    </body>
</html>