<%-- 
    Document   : questionAnswerPage_Q
    Created on : Nov 24, 2015, 9:47:17 AM
    Author     : Marco Orlando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%-- start web service invocation --%><hr/>
    <%
	wsmodel.WS_Service service = new wsmodel.WS_Service();
	wsmodel.WS port = service.getWSPort();
	 // TODO initialize WS operation arguments here
	int questionId = Integer.parseInt(request.getParameter("q_id"));
	// TODO process result here
	wsmodel.QuestionClass questionItem = port.getQuestionByID(questionId);

    %>
    <%-- end web service invocation --%><hr/>

    
    
    <%-- Printing out --%>
     <div class='questionB'>
         <span class='questionAnswerHeader'><% out.println(questionItem.getQuestionTitle()); %></span>
    <div class ='questionAnswerBody'>
        <div class ='questionAnswerVote'>
            <div class='questionAnswerVoteUpArrow' <%--onclick= \voteUpdate('question',$questionId, 'up')\--%>>
                 <img src='icons/upArrow.png' width='30' height='30'>
            </div>
            <div class='questionAnswerVoteNumber' id='voteQuestion'>
                 <% out.println(questionItem.getQuestionVote()); %>
            </div>
            <div class='questionAnswerVoteDownArrow' <%--onclick= \voteUpdate('question',$questionId, 'down')\--%> >
                 <img src='icons/downArrow.png' width='30' height='30'>
            </div>
        </div>
        <div class ='questionAnswerContent'>
            <% out.println(questionItem.getQuestionContent()); %>
        </div>
    </div>
        
         <%-- start web service invocation --%><hr/>
                            <%
                                wsmodel.WS_Service service3 = new wsmodel.WS_Service();
                                wsmodel.WS port3 = service3.getWSPort();
                                 // TODO initialize WS operation arguments here
                                int userID = questionItem.getQuestionUserId();
                                // TODO process result here
                                java.lang.String q_UserName = port3.getQuestionUserName(userID);
                            %>
                            <%-- end web service invocation --%><hr/>
        
        
    <span class='questionAnswerFooter'>asked by <% out.println(q_UserName); %> at <% out.println(questionItem.getQuestionDate()); %>|<a class='editQuestion' href='editQuestion.jsp?id=<%= questionItem.getQuestionId() %>'><font color='green'>edit</font> </a>|<a class='deleteQuestion' href = 'deleteQuestionProcess.jsp?id=<%= questionItem.getQuestionId() %> onclick= \"return confirm('Confirm Delete?');\'><font color='red'>delete</font> </a></span>
 </div>
    
