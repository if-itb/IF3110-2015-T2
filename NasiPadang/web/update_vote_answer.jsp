<%-- 
    Document   : update_vote_answer
    Created on : Nov 20, 2015, 10:57:48 AM
    Author     : user
--%>

<%@page import="org.wsdl.StackExchangeImplService"%>
<%
    StackExchangeImplService stackExchangeService = new StackExchangeImplService();
    org.wsdl.StackExchange stackExchange = stackExchangeService.getStackExchangeImplPort();
    int id_answer = Integer.parseInt(request.getParameter("id_answer"));
    int vote = Integer.parseInt(request.getParameter("vote"));
    int votes = stackExchange.updateVoteAnswer(id_answer, vote);
    request.setAttribute("votes", votes);
    response.setContentType("text/html;charset=UTF-8");
    out.println(request.getParameter("votes"));
%>
