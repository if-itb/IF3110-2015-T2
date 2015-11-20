<%-- 
    Document   : update_vote_question
    Created on : Nov 20, 2015, 10:53:19 AM
    Author     : user
--%>

<%@page import="org.wsdl.StackExchangeImplService"%>
<%
    StackExchangeImplService stackExchangeService = new StackExchangeImplService();
    org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
    int id = Integer.parseInt(request.getParameter("id"));
    int vote = Integer.parseInt(request.getParameter("vote"));
    int votes = stackExchange.updateVoteQuestion(id, vote);
    request.setAttribute("votes", votes);
    response.setContentType("text/html;charset=UTF-8");
    out.println(request.getParameter("votes"));
%>