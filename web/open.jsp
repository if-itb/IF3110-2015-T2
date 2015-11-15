<%-- 
    Document   : open
    Created on : Nov 11, 2015, 7:48:38 PM
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
        
        <%  String t_id = request.getParameter("id");
            int id = Integer.valueOf(t_id);
           String RR[] = sws.getQuestions(id);
           String A[][] = sws.getAllAnswers(id);
           int asize = A.length ;
           String content = "";
           int ca = Integer.valueOf(RR[7]) ;
           int z = (id*1000) + ca+1;
           String s = request.getParameter("s");
           if (s!=null) response.sendRedirect("home.jsp?s="+s);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title><% out.println(RR[1]) ; %></title>
    </head>
    <body>
        <div id="head1">            
            <a><div id="login" >Login</div></a>
            <a><div id ="reg">Register</div></a>
        </div>
         <a href="home.jsp"><div id="h">Stack <at>Exchange</at></div></a>
         <form id="searchbox" href="home.jsp">
             <input id="search" type="text" name="s" placeholder=" Type any keyword here . . . ">
             <input id="submit" type="submit" value="Search">
        </form>
        <p>Cannot find what you are looking for ? <a href="askhere.jsp"><as>Ask here</as></a></p>     
        <div class="raq"><% out.println(RR[1]) ; %></div>
        <div class="separator"></div>      
        
        <div id="wrap">
            <div id="main">         
               <% out.println(RR[2]) ; %>
            </div>
            <div id="sidebar">
			
                <div id="vnum"><div id="<% out.println(RR[0]);%>"><% out.println(RR[3]) ;%> </div> </div> 
                <div id="vup">
                    <a a href="process.jsp?action=voteup&id=<% out.println(RR[0]) ; %>&t=q">
                    <img src="img/up.png" alt="Vote Up" style="width: 32px;height:32px">
                    </a>
                </div>
                <div id="vdown">
                    <a a href="process.jsp?action=votedown&id=<% out.println(RR[0]) ; %>&t=q">
                    <img src="img/down.png" alt="Vote Down" style="width: 32px;height:32px">
                     </a>
                </div>
            </div>
            <div id="footer"> </div>
            <div id="qinfo">asked by <aa><% out.println(RR[5]) ; %></aa> at<aa><% out.println(RR[4]) ; %></aa> |
            <a href="askhere.jsp?id=<% out.println(RR[0]) ; %>"><span class="bb">edit</span></a> |
            <a onclick ="return confirm('Are you sure to delete this question ?')" href="process.jsp?action=del&id=<% out.println(id) ;%>"><span class="cc">delete</span></a>  
            </div>
        </div>
        <div id ="qans"><% out.println(RR[7]) ; %> Answers</div>
         <div class="separator"></div>
         
        <% for (int i=0;i<asize;i++) { %>
           <div id="wrap">
            <div id="main">         
               <% out.println(A[i][2]) ; %>
            </div>
            <div id="sidebar">         
                <div id="vnum"><div id="<% out.println(A[i][0]) ; %>"> <% out.println(A[i][3]) ; %> </div></div> 
                <div id="vup"><a href="process.jsp?action=voteup&id=<% out.println(A[i][0]) ; %>&t=a">
                        <img src="img/up.png" alt="Vote Up" style="width: 32px;height:32px"></a>
                </div>
                <div id="vdown"><a a href="process.jsp?action=votedown&id=<% out.println(A[i][0]) ; %>&t=a">
                        <img src="img/down.png" alt="Vote Down" style="width: 32px;height:32px"></a>
                    </div>
            </div>
            <div id="footer"> </div>
            <div id="qinfo">answered by <aa><% out.println(A[i][5]) ; %></aa> at<aa> <% out.println(A[i][4]) ; %></aa> 
             </div>
            
        </div>
          <div class="separator2"></div>
         <% } %>
         
         <div id="yans">Your Answer</div>
           
        <form action="process.jsp" method="POST">            
            <textarea id="fcontent" name="content" placeholder="Content : " ><% out.println(content); %></textarea> 
            <input id="fsubmit" type="submit" value="Answer "><br>               
            <input type="hidden" name="bb" value="addans" >              
            <input type="hidden" name="id_a" value="<%out.println(z) ; %>;" >
            <input type="hidden" name="q_id" value="<% out.println(id) ; %>" >
            <input type="hidden" name="action" value="answer">
          </form>
    </body>
</html>

<%--
ret[0] = String.valueOf(aa);
                ret[1] = rs.getString("title");
                ret[2] = rs.getString("content");
                ret[3] = String.valueOf(rs.getInt("vote"));
                ret[4] = rs.getString("date");
                ret[5] = rs.getString("username");
                ret[6] = rs.getString("email"); 
                ret[7] = String.valueOf(countAnswer(aa));
  int aa = rs.getInt("id_a");
                    int bb = rs.getInt("q_id");
                    ret[count][0] = String.valueOf(aa);
                    ret[count][1] = String.valueOf(bb);
                    ret[count][2] = rs.getString("content");
                    ret[count][3] = String.valueOf(rs.getInt("vote"));
                    ret[count][4] = rs.getString("date");
                    ret[count][5] = rs.getString("username");
                    ret[count][6] = rs.getString("email"); 
--%>