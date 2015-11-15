<%-- 
    Document   : process
    Created on : Nov 12, 2015, 4:30:50 PM
    Author     : tama
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="css/style.css">
        <%@  page import="java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service,WebService.StackWS" %>
       <% URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);
           String m1="",m2="";
        %>
         
        
        <% StackWS sws = service.getPort(StackWS.class); %>
        <% String action = request.getParameter("action");
            
           if (action.equals("askhere")) {
               String type = request.getParameter("process");
               String title = request.getParameter("atitle");
               String content = request.getParameter("acontent");
               String qid = request.getParameter("qid");
               if (type.contains("new")) {
                   int stats = sws.addQuestion("asd",title,content);              
                   if (stats!=0) {
                       response.sendRedirect("open.jsp?id="+stats);
                   }
                   else {
                       m1 = "You're not currently login. Please login to create new question" ;
                       m2= "home.jsp";                       
                   }
               }
               else if (type.contains("edit")){
                   qid=qid.substring(0,qid.length()-2); 
                   int idd = Integer.valueOf(qid);
                   int stats = sws.updateQuestion("asd", idd,title,content);                  
                   if (stats!=0) {
                    response.sendRedirect("open.jsp?id="+idd); 
                   }
                   else { 
                       m1 = "You're not the owner of this question." ;
                       m2= "home.jsp";  
                   }
               }
               else out.println("|"+type+"|");
           }
           else if (action.contains("del")) {
               String qid = request.getParameter("id");
               int idd = Integer.valueOf(qid);
               int stats = sws.deleteQuestion("asd", idd);
               m2 = "home.jsp";
               if (stats!=0) m1 = "The question has been deleted";
               else m1 = "You're not the owner of this question";
           }
           else if (action.contains("answer")) {
               String qid = request.getParameter("q_id");
               qid = qid.substring(0,qid.length()-2);
               int qidd = Integer.valueOf(qid);
               String ida = request.getParameter("id_a");
               ida = ida.substring(0,ida.length()-3);
               int idaa = Integer.valueOf(ida);
               String c = request.getParameter("content");
               int st = sws.addAnswer("asd",qidd,idaa,c);
               if (st!=0) {
                   response.sendRedirect("open.jsp?id="+qidd);
               } else {
                   m1 = "You're not currently login. You can't add any answer" ;
                   m2 = "home.jsp";
               }
           }
           else if (action.contains("vote")) {
               String idd = request.getParameter("id");
               int id = Integer.valueOf(idd);
               int num=0;
               if (action.contains("up")) num=1;
               else num=-1;
               int qid = id;
               if (qid>=1000) qid = qid/1000;
               String t = request.getParameter("t");
               int st = sws.changeVote("asd", t, id, num);
               m2 = "open.jsp?id="+String.valueOf(qid);
               if (st==0) {
                   m1 = "You already vote this one. You can't vote any question or answer more than once";
               }
               else {
                   m1 = "Your vote has been saved";
               }
           }
           else out.println("|"+action+"|");
           
        %>
    </head>
    <body>
         
           <a href="home.jsp"><div id="h">Stack <at>Exchange</at></div></a>
        
        
            <div class="raq"> </div>
            <div class="separator"></div>
            <% 
                response.setHeader("Refresh", "2;url="+m2); 
               
            %>
            <div class="rsuccess">
                <%out.println(m1) ; %><br>
                You'll be redirected to 
                <% if (action.contains("vote")) out.println("previous");
                    else out.println("home"); %>
                page. If not click <a href="<% out.println(m2); %>"><rr>here</rr></a></div>

    </body>
</html>
