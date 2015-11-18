package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html lang=\"en\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Stack Exchange</title>\r\n");
      out.write("\t\t<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("\t\t <link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n");
      out.write("  \t<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n");
      out.write("\t<head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<nav class=\"deep-purple darken-2\" role=\"navigation\">\r\n");
      out.write("\t\t\t<div class=\"nav-wrapper container\">\r\n");
      out.write("\t\t\t\t<a id=\"logo-container\" href=\"#\" class=\"brand-logo\">Stack Exchange</a>\r\n");
      out.write("\t\t\t\t<ul class=\"right hide-on-med-and-down\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"register.jsp\">Register</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"question.jsp\">Question</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"answer.jsp\">Answer</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<br><br><br>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t  <nav class=\"deep-purple darken-2\" role=\"navigation\">\r\n");
      out.write("\t\t    <div class=\"nav-wrapper\">\r\n");
      out.write("\t\t      <form>\r\n");
      out.write("\t\t        <div class=\"input-field\">\r\n");
      out.write("\t\t          <input id=\"search\" type=\"search\" required>\r\n");
      out.write("\t\t          <label for=\"search\"><i class=\"material-icons\">search</i></label>\r\n");
      out.write("\t\t          <i class=\"material-icons\">close</i>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t      </form>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </nav>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"divider\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--<div class=\"parallax-container\">\r\n");
      out.write("    \t<div class=\"parallax\"><img src=\"tokyo-blue-background-4547.jpg\"></div>\r\n");
      out.write("    \t<center><h1 class=\"white-text\"> Recently Asked Question </h1></center>\r\n");
      out.write("  \t</div>-->\r\n");
      out.write("  \t<center><h1 class=\"black-text\"> Recently Asked Question </h1></center>\r\n");
      out.write("  \t<div class=\"section white\">\r\n");
      out.write("    \t<div class=\"row center\">\r\n");
      out.write("      \t<div class=\"container\">\r\n");
      out.write("        \t<div class=\"card blue-grey darken-1\">\r\n");
      out.write("          \t<div class=\"card-content white-text\">\r\n");
      out.write("            \t<span class=\"card-title\">Topic Content</span>\r\n");
      out.write("            \t<p>I am a very simple card. I am good at containing small bits of information.\r\n");
      out.write("            \tI am convenient because I require little markup to use effectively.</p>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          \t<div class=\"card-action\">\r\n");
      out.write("          \t\t<a class=\"left\" href=\"#\">Asked by Gerry Kastogi</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Edit</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Delete</a>\r\n");
      out.write("          \t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("      \t</div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div class=\"row center\">\r\n");
      out.write("      \t<div class=\"container\">\r\n");
      out.write("        \t<div class=\"card blue-grey darken-1\">\r\n");
      out.write("          \t<div class=\"card-content white-text\">\r\n");
      out.write("            \t<span class=\"card-title\">Topic Content</span>\r\n");
      out.write("            \t<p>I am a very simple card. I am good at containing small bits of information.\r\n");
      out.write("            \tI am convenient because I require little markup to use effectively.</p>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          \t<div class=\"card-action\">\r\n");
      out.write("          \t\t<a class=\"left\" href=\"#\">Asked by Gerry Kastogi</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Edit</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Delete</a>\r\n");
      out.write("          \t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("      \t</div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div class=\"row center\">\r\n");
      out.write("      \t<div class=\"container\">\r\n");
      out.write("        \t<div class=\"card blue-grey darken-1\">\r\n");
      out.write("          \t<div class=\"card-content white-text\">\r\n");
      out.write("            \t<span class=\"card-title\">Topic Content</span>\r\n");
      out.write("            \t<p>I am a very simple card. I am good at containing small bits of information.\r\n");
      out.write("            \tI am convenient because I require little markup to use effectively.</p>\r\n");
      out.write("          \t</div>\r\n");
      out.write("          \t<div class=\"card-action\">\r\n");
      out.write("          \t\t<a class=\"left\" href=\"#\">Asked by Gerry Kastogi</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Edit</a>\r\n");
      out.write("            \t<a class=\"right\" href=\"#\">Delete</a>\r\n");
      out.write("          \t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("      \t</div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<!--<div class=\"parallax-container\">\r\n");
      out.write("    \t<div class=\"parallax\"><img src=\"tokyo-blue-background-4547.jpg\"></div>\r\n");
      out.write("  \t</div>-->\r\n");
      out.write("\r\n");
      out.write(" \t\t<footer class=\"page-footer deep-purple darken-2\">\r\n");
      out.write("      <div class=\"footer-copyright\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("        \tÂ© 2015 Created by 3xcelsi\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script src=\"js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/materialize.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"js/init.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
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
