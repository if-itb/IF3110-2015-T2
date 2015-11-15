package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import WebService.StackWS;

public final class open_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("       \n");
      out.write("      ");
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        
      out.write("\n");
      out.write("          \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        \n");
      out.write("        ");
  String t_id = request.getParameter("id");
            int id = Integer.valueOf(t_id);
           String RR[] = sws.getQuestions(id);
           String A[][] = sws.getAllAnswers(id);
           int asize = A.length ;
           String content = "";
           int ca = Integer.valueOf(RR[7]) ;
           int z = (id*1000) + ca+1;
           String s = request.getParameter("s");
           if (s!=null) response.sendRedirect("home.jsp?s="+s);
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <title>");
 out.println(RR[1]) ; 
      out.write("</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a><div id=\"login\" >Login</div></a>\n");
      out.write("            <a><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("         <a href=\"home.jsp\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("         <form id=\"searchbox\" href=\"home.jsp\">\n");
      out.write("             <input id=\"search\" type=\"text\" name=\"s\" placeholder=\" Type any keyword here . . . \">\n");
      out.write("             <input id=\"submit\" type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        <p>Cannot find what you are looking for ? <a href=\"askhere.jsp\"><as>Ask here</as></a></p>     \n");
      out.write("        <div class=\"raq\">");
 out.println(RR[1]) ; 
      out.write("</div>\n");
      out.write("        <div class=\"separator\"></div>      \n");
      out.write("        \n");
      out.write("        <div id=\"wrap\">\n");
      out.write("            <div id=\"main\">         \n");
      out.write("               ");
 out.println(RR[2]) ; 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"sidebar\">\n");
      out.write("\t\t\t\n");
      out.write("                <div id=\"vnum\"><div id=\"");
 out.println(RR[0]);
      out.write('"');
      out.write('>');
 out.println(RR[3]) ;
      out.write(" </div> </div> \n");
      out.write("                <div id=\"vup\">\n");
      out.write("                    <a a href=\"process.jsp?action=voteup&id=");
 out.println(RR[0]) ; 
      out.write("&t=q\">\n");
      out.write("                    <img src=\"img/up.png\" alt=\"Vote Up\" style=\"width: 32px;height:32px\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"vdown\">\n");
      out.write("                    <a a href=\"process.jsp?action=votedown&id=");
 out.println(RR[0]) ; 
      out.write("&t=q\">\n");
      out.write("                    <img src=\"img/down.png\" alt=\"Vote Down\" style=\"width: 32px;height:32px\">\n");
      out.write("                     </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\"> </div>\n");
      out.write("            <div id=\"qinfo\">asked by <aa>");
 out.println(RR[5]) ; 
      out.write("</aa> at<aa>");
 out.println(RR[4]) ; 
      out.write("</aa> |\n");
      out.write("            <a href=\"askhere.jsp?id=");
 out.println(RR[0]) ; 
      out.write("\"><span class=\"bb\">edit</span></a> |\n");
      out.write("            <a onclick =\"return confirm('Are you sure to delete this question ?')\" href=\"process.jsp?action=del&id=");
 out.println(id) ;
      out.write("\"><span class=\"cc\">delete</span></a>  \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id =\"qans\">");
 out.println(RR[7]) ; 
      out.write(" Answers</div>\n");
      out.write("         <div class=\"separator\"></div>\n");
      out.write("         \n");
      out.write("        ");
 for (int i=0;i<asize;i++) { 
      out.write("\n");
      out.write("           <div id=\"wrap\">\n");
      out.write("            <div id=\"main\">         \n");
      out.write("               ");
 out.println(A[i][2]) ; 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"sidebar\">         \n");
      out.write("                <div id=\"vnum\"><div id=\"");
 out.println(A[i][0]) ; 
      out.write("\"> ");
 out.println(A[i][3]) ; 
      out.write(" </div></div> \n");
      out.write("                <div id=\"vup\"><a href=\"process.jsp?action=voteup&id=");
 out.println(A[i][0]) ; 
      out.write("&t=a\">\n");
      out.write("                        <img src=\"img/up.png\" alt=\"Vote Up\" style=\"width: 32px;height:32px\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"vdown\"><a a href=\"process.jsp?action=votedown&id=");
 out.println(A[i][0]) ; 
      out.write("&t=a\">\n");
      out.write("                        <img src=\"img/down.png\" alt=\"Vote Down\" style=\"width: 32px;height:32px\"></a>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\"> </div>\n");
      out.write("            <div id=\"qinfo\">answered by <aa>");
 out.println(A[i][5]) ; 
      out.write("</aa> at<aa> ");
 out.println(A[i][4]) ; 
      out.write("</aa> \n");
      out.write("             </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("          <div class=\"separator2\"></div>\n");
      out.write("         ");
 } 
      out.write("\n");
      out.write("         \n");
      out.write("         <div id=\"yans\">Your Answer</div>\n");
      out.write("           \n");
      out.write("        <form action=\"process.jsp\" method=\"POST\">            \n");
      out.write("            <textarea id=\"fcontent\" name=\"content\" placeholder=\"Content : \" >");
 out.println(content); 
      out.write("</textarea> \n");
      out.write("            <input id=\"fsubmit\" type=\"submit\" value=\"Answer \"><br>               \n");
      out.write("            <input type=\"hidden\" name=\"bb\" value=\"addans\" >              \n");
      out.write("            <input type=\"hidden\" name=\"id_a\" value=\"");
out.println(z) ; 
      out.write(";\" >\n");
      out.write("            <input type=\"hidden\" name=\"q_id\" value=\"");
 out.println(id) ; 
      out.write("\" >\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"answer\">\n");
      out.write("          </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
