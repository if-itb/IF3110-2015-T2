package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import WebService.StackWS;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        ");
 
        String sq = request.getParameter("s");
        String R[][] =sws.getAllQuestions();
        int rsize = R.length;
        if (sq!=null && sq!=""){
            R = sws.searchQuestion(sq);
            rsize = R.length;
        }
            
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Stack Exchange</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a ><div id=\"login\" >Login</div></a>\n");
      out.write("            <a ><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("         <a href=\"home.jsp\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("        \n");
      out.write("         <form id=\"searchbox\" method=\"GET\">\n");
      out.write("             <input id=\"search\" type=\"text\" name=\"s\" placeholder=\" Type any keyword here . . . \">\n");
      out.write("             <input id=\"submit\" type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        <p>Cannot find what you are looking for ? <a href=\"askhere.jsp\"><as>Ask here</as></a></p>        \n");
      out.write("        <div class=\"raq\">Recently Asked Questions </div>\n");
      out.write("        <div class=\"separator\"></div>       \n");
      out.write("        ");
 for (int i=0; i<rsize;i++) { 
      out.write("        \n");
      out.write("            <div class =\"info\">\n");
      out.write("                <div class =\"vote\">\n");
      out.write("                    <div class=\"vnum\"> ");
 out.println(R[i][3]); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Votes</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class =\"answers\">\n");
      out.write("                    <div class=\"vnum\">");
 out.println(R[i][7]); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Answers</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"thread\">\n");
      out.write("                    <a href=\"open.jsp?id=");
out.println(R[i][0]);
      out.write("\"><div class=\"title\">");
 out.println(R[i][1]); 
      out.write("</div></a>\n");
      out.write("                    <div class = \"content\">                     \n");
      out.write("                        ");
 if (R[i][2].length() > 150) R[i][2] = R[i][2].substring(0,149) + " . . . ";
                        out.println(R[i][2]); 
      out.write("<br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("               </div>\n");
      out.write("                <div class=\"utility\">\n");
      out.write("                    <aa>asked by : </aa>\n");
      out.write("                    <a1> ");
 out.println(R[i][5]); 
      out.write("</a1>|\n");
      out.write("                    <a href=\"askhere.jsp?id=");
 out.println(R[i][0]) ; 
      out.write("\"><span class=\"bb\">edit</span></a> |\n");
      out.write("                    <a onclick =\"return confirm('Are you sure to delete this question ?')\" href=\"process.jsp?action=del&id=");
 out.println(R[i][0]) ;
      out.write("\"><span class=\"cc\">delete</span></a>\n");
      out.write("                </div>\n");
      out.write("             <div class=\"uline\"></div>       \n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("       \n");
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
