<%-- 
    Document   : index
    Created on : Nov 12, 2015, 12:00:30 PM
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
        <div class="link-normalizer"><a class='title' href="index.jsp">Simple StackExchange</a></div>

        <br><br><br><br>

        <form name='searchForm' action='search.php' method='post'>
            <input class='form-search' type="text" name="search_key" size='120%'>
            <button class='button-search' type='submit'> Search </button>
        </form>

        <div class="smalltitle-center">Cannot find what you are looking for? <a id = "color-orange" href="ask.jsp" >Ask here</a></div>
        <br>
        <div class="smalltitle-center">Not registered yet? <a id = "color-orange" href="register.jsp" >Register here</a></div>
        <br>

        <div class="smalltitle-left"> Recently Asked Questions </div>
        <hr class='line'>
    <%
    try {
	com.wbd.qst.QuestionWS_Service service = new com.wbd.qst.QuestionWS_Service();
	com.wbd.qst.QuestionWS port = service.getQuestionWSPort();
	// TODO process result here
	java.util.List<com.wbd.qst.Question> result = port.retrieveQ();
	for(int i = 0; i < result.size() ; i++){
            String vote;
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
		    	+"$row2['answer_count']"
		    	+"<br>"
		    	+"$answer"
		    +"</div>"
		    +"<div class='bquestion-content'>" 
                        +"<a id='color-black' href= question.jsp?id=" + result.get(i).getIDQ() + ">" + result.get(i).getQuestionTopic() + "</a>"
                        +"<br>"
                        +result.get(i).getContent()
                        +"<br><br>"
                    +"</div>"
                    +"<div class='bquestion-identity'>" 
                        +"asked by "
                        +"<a id='color-blue'>"
                            +"$row['name']"
                        +"</a>"
                        +" | "
                        +"<a id='color-orange' href='ask.jsp?id="+ result.get(i).getIDQ() +"'>"
                            +"edit"
                        +"</a>"
			+" | "
                        +"<a id='color-red' href=# onclick='deleteconfirm(" + "$row['question_id']" + ")' " + "'>"
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