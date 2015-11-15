<%-- 
    Document   : askhere
    Created on : Nov 10, 2015, 5:26:06 PM
    Author     : tama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@  page import="java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service,WebService.StackWS" %>
       <% URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        %>
         
        <% StackWS sws = service.getPort(StackWS.class); %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%
            String t_id = request.getParameter("id");
            String Q[] = null;
            String prcs = "new";
            int id = 0 ;
            if (t_id !=null) {
                id = Integer.valueOf(t_id);
                Q = sws.getQuestions(id);
                prcs = "edit";
            }
        %>
        <title><% if (id==0) out.println("Create New Questions");
                    else out.println("Edit Question"); %>   
        </title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
       
    </head>
    <body>
       <div id="head1">            
            <a><div id="login" >Login</div></a>
            <a><div id ="reg">Register</div></a>
        </div>
        <a href="home.jsp"><div id="h">Stack <at>Exchange</at></div></a>
         <form id="searchbox">
             <input id="search" type="text" name="s" placeholder=" Type any keyword here . . . ">
             <input id="submit" type="submit" value="Search">
        </form>
        
        <div class="raq"><% if (id==0) out.println("Create New Questions");
                    else out.println("Edit Your Question"); %>   </div>
        <div class="separator"></div>
        
        <form action="process.jsp" method="POST">
            <input id="atitle" type="text" name="atitle" placeholder="Title" value="<% if (id!=0) out.println(Q[1]) ; %>"/><br>             
             <textarea id="acontent" name="acontent" placeholder="Content" ><% if (id!=0) out.println(Q[2]) ; %></textarea> <br>
             <input id="asubmit" type="submit" value="Post this !!"><br>
             <input type="hidden" name="process" value="<% out.println(prcs) ; %>">
             <input type="hidden" name="qid" value="<% out.println(id) ; %>">
             <input type="hidden" name="action" value="askhere">
         </form>
    </body>
</html>
