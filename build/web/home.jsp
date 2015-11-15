<%-- 
    Document   : home
    Created on : Nov 10, 2015, 2:57:19 PM
    Author     : tama
--%>
<!DOCTYPE html>
<html>
    <head>
        <%@  page import="java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service,WebService.StackWS" %>
        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <% URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        %>
        
        <% StackWS sws = service.getPort(StackWS.class); %>
        <% 
        String sq = request.getParameter("s");
        String R[][] =sws.getAllQuestions();
        int rsize = R.length;
        if (sq!=null && sq!=""){
            R = sws.searchQuestion(sq);
            rsize = R.length;
        }
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stack Exchange</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="head1">            
            <a ><div id="login" >Login</div></a>
            <a ><div id ="reg">Register</div></a>
        </div>
         <a href="home.jsp"><div id="h">Stack <at>Exchange</at></div></a>
        
         <form id="searchbox" method="GET">
             <input id="search" type="text" name="s" placeholder=" Type any keyword here . . . ">
             <input id="submit" type="submit" value="Search">
        </form>
        <p>Cannot find what you are looking for ? <a href="askhere.jsp"><as>Ask here</as></a></p>        
        <div class="raq">Recently Asked Questions </div>
        <div class="separator"></div>       
        <% for (int i=0; i<rsize;i++) { %>        
            <div class ="info">
                <div class ="vote">
                    <div class="vnum"> <% out.println(R[i][3]); %></div>
                    <div class="vname">Votes</div>           
                </div>

                <div class ="answers">
                    <div class="vnum"><% out.println(R[i][7]); %></div>
                    <div class="vname">Answers</div>           
                </div>

                <div class="thread">
                    <a href="open.jsp?id=<%out.println(R[i][0]);%>"><div class="title"><% out.println(R[i][1]); %></div></a>
                    <div class = "content">                     
                        <% if (R[i][2].length() > 150) R[i][2] = R[i][2].substring(0,149) + " . . . ";
                        out.println(R[i][2]); %><br>
                    </div>
                </div>


               </div>
                <div class="utility">
                    <aa>asked by : </aa>
                    <a1> <% out.println(R[i][5]); %></a1>|
                    <a href="askhere.jsp?id=<% out.println(R[i][0]) ; %>"><span class="bb">edit</span></a> |
                    <a onclick ="return confirm('Are you sure to delete this question ?')" href="process.jsp?action=del&id=<% out.println(R[i][0]) ;%>"><span class="cc">delete</span></a>
                </div>
             <div class="uline"></div>       
        <% } %>
        
       
    </body>
</html>
