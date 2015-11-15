package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import WebService.StackWS;

public final class askhere_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("       ");
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        
      out.write("\n");
      out.write("         \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         ");

            String t_id = request.getParameter("id");
            String Q[] = null;
            String prcs = "new";
            int id = 0 ;
            if (t_id !=null) {
                id = Integer.valueOf(t_id);
                Q = sws.getQuestions(id);
                prcs = "edit";
            }
        
      out.write("\n");
      out.write("        <title>");
 if (id==0) out.println("Create New Questions");
                    else out.println("Edit Question"); 
      out.write("   \n");
      out.write("        </title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <div id=\"head1\">            \n");
      out.write("            <a><div id=\"login\" >Login</div></a>\n");
      out.write("            <a><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("        <a href=\"home.jsp\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("         <form id=\"searchbox\">\n");
      out.write("             <input id=\"search\" type=\"text\" name=\"s\" placeholder=\" Type any keyword here . . . \">\n");
      out.write("             <input id=\"submit\" type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <div class=\"raq\">");
 if (id==0) out.println("Create New Questions");
                    else out.println("Edit Your Question"); 
      out.write("   </div>\n");
      out.write("        <div class=\"separator\"></div>\n");
      out.write("        \n");
      out.write("        <form action=\"process.jsp\" method=\"POST\">\n");
      out.write("            <input id=\"atitle\" type=\"text\" name=\"atitle\" placeholder=\"Title\" value=\"");
 if (id!=0) out.println(Q[1]) ; 
      out.write("\"/><br>             \n");
      out.write("             <textarea id=\"acontent\" name=\"acontent\" placeholder=\"Content\" >");
 if (id!=0) out.println(Q[2]) ; 
      out.write("</textarea> <br>\n");
      out.write("             <input id=\"asubmit\" type=\"submit\" value=\"Post this !!\"><br>\n");
      out.write("             <input type=\"hidden\" name=\"process\" value=\"");
 out.println(prcs) ; 
      out.write("\">\n");
      out.write("             <input type=\"hidden\" name=\"qid\" value=\"");
 out.println(id) ; 
      out.write("\">\n");
      out.write("             <input type=\"hidden\" name=\"action\" value=\"askhere\">\n");
      out.write("         </form>\n");
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
