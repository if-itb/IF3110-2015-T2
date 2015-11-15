package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import WebService.StackWS;

public final class process_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("       ");
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);
           String m1="",m2="";
        
      out.write("\n");
      out.write("         \n");
      out.write("        \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        ");
 String action = request.getParameter("action");
            
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
           
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("           <a href=\"home.jsp\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("            <div class=\"raq\"> </div>\n");
      out.write("            <div class=\"separator\"></div>\n");
      out.write("            ");
 
                response.setHeader("Refresh", "2;url="+m2); 
               
            
      out.write("\n");
      out.write("            <div class=\"rsuccess\">\n");
      out.write("                ");
out.println(m1) ; 
      out.write("<br>\n");
      out.write("                You'll be redirected to \n");
      out.write("                ");
 if (action.contains("vote")) out.println("previous");
                    else out.println("home"); 
      out.write("\n");
      out.write("                page. If not click <a href=\"");
 out.println(m2); 
      out.write("\"><rr>here</rr></a></div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
