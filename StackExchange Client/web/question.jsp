<%-- 
    Document   : question
    Created on : Nov 16, 2015, 11:31:39 PM
    Author     : chairuniaulianusapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href='css/style.css'/>
        <title>Simple StackExchange</title>
</head>

    <body>
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>
        <br>
        <br>
        <br>
        <br>    

        <%
        try {
            com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
            com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
            com.wbd.qst.QuestionWS_Service service2 = new com.wbd.qst.QuestionWS_Service();
            com.wbd.qst.QuestionWS port2 = service2.getQuestionWSPort();
             // TODO initialize WS operation arguments here
            int qid = Integer.parseInt(request.getParameter("id"));
            // TODO process result here
            //out.println("QID : " + qid);
            java.util.List<com.wbd.qst.Question> result = port.getQuestionbyID(qid);
            java.lang.String result2 = port2.getNama(qid);
            for (int i = 0; i < result.size(); i++){
                String question = 
                    "<div class='subtitle'>"
			+result.get(i).getQuestionTopic()
                    +"</div>"
                    +"<hr class='line'>"
                    +"<div class='block-QA'>"
			+"<div class='bQA-vote'>"
                            +"<a href = voteUp.jsp?id=" + request.getParameter("id") + "&token=" + request.getParameter("token") + "><div class='vote-up'>"
                            +"</div></a>"
                            +"<br>"
                            +"<a class='vote-value' id='question_vote" + qid +"'>"
				+result.get(i).getVote()
                            +"</a>"
                            +"<br><br>"
                            +"<a href = voteDown.jsp?id=" + request.getParameter("id") + "&token=" + request.getParameter("token") + "><div class='vote-down'>"
                            +"</div>"
			+"</div>"
			+"<div class='bQA-content'>"
                            +result.get(i).getContent()
                            +"<br><br>"
                        +"</div>"
                        +"<div class='bquestion-identity'>"
                            +"asked by "
                            +"<a id='color-blue'>"
                            +result2
                            +"</a>"
                            +" | "
                            +"<a id='color-orange' href=edit.jsp?id=" + result.get(i).getIDQ() + "&token=" + request.getParameter("token") + ">"
                                +"edit"
                            +"</a>"
                            +" | "
                            +"<a id='color-red' href=delete.jsp?id=" + result.get(i).getIDQ() + ">"
                                +"delete"
                            +"</a>"
	    		+"</div>"
	    	+"</div>"           
                ;
                out.write(question);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        
        <% out.write("<br><br><br><br><br>");%>
        
        <%
        try {
            com.wbd.ans.AnswerWS_Service service = new com.wbd.ans.AnswerWS_Service();
            com.wbd.ans.AnswerWS port = service.getAnswerWSPort();
             // TODO initialize WS operation arguments here
            int qid = Integer.parseInt(request.getParameter("id"));
            // TODO process result here
            java.util.List<com.wbd.ans.Answer> result = port.getAnswerByQID(qid);
            String isManyAnswer;
            if(result.size() > 1){
                isManyAnswer = "Answers";
            }
            else{
                isManyAnswer = "Answer";
            }
            String answerTitle = 
                "<div class='subtitle'>" + result.size() + " " + isManyAnswer + "</div>"
                + "<hr class ='line'>"
            ;
            out.write(answerTitle);
            for(int i = 0; i < result.size() ; i++){
                String answer = 
                    "<div class='block-QA'>"
                        +"<div class='bQA-vote'>"
                            +"<a href = voteUpAns.jsp?id=" + request.getParameter("id") + "&token=" + request.getParameter("token") + "&ansid=" + result.get(i).getIDAns() + "><div class='vote-up'>"
                            +"</div></a>"
                            +"<br>"
                            +"<a class='vote-value' id='answer_vote" + "$row['answer_id']"+  "'>" + result.get(i).getVote()
                            +"</a>"
                            +"<br><br>"
                            +"<a href = voteDownAns.jsp?id=" + request.getParameter("id") + "&token=" + request.getParameter("token") + "&ansid=" + result.get(i).getIDAns() + "><div class='vote-down'>"
                            +"</div>"
			+"</div>"
                        +"<div class='bQA-content'>"
                            +result.get(i).getAnswer()
                            +"<br><br>"
                        +"</div>"
                        +"<div class='bQA-identity'>" 
                            +"answered by "
                            +result.get(i).getNama()
                            +" at "
                            +"$row['time']"
                        +"</div>"
                    +"</div>"
		    +"<hr class='line'>"
                ;
                out.write(answer);
        }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <% out.write("<br><br>"); %>
        <%
        String answerForm =
                "<div class='subtitle'>" + "<a id='color-grey'>" + "Your Answer" + "</a>" + "</div>"
		+"<form name='answerForm' action='anspost.php' onsubmit='return validateAnswer()' method='post'>"
			+"<input type='hidden' name='question_id' value=' " + Integer.parseInt(request.getParameter("id")) + "'>"
			+"<textarea class='form-textarea' name='content' placeholder='Content'></textarea><br>"
			+"<button class='button-post' type='submit'> Post </button>"
		+"</form>";
        ;
        out.write(answerForm);
        %>
    </body>
</html>
