package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"assets/img/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <title>Signup Template for Bootstrap</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <form class=\"form-signin\">\r\n");
      out.write("          <h2 class=\"form-signin-heading\">Please sign up</h2>\r\n");
      out.write("          <label for=\"inputEmail\" class=\"sr-only\">Email address</label>\r\n");
      out.write("          <input type=\"email\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Email address\" required=\"\" autofocus=\"\">\r\n");
      out.write("          <label for=\"inputPassword\" class=\"sr-only\">Password</label>\r\n");
      out.write("          <input type=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required=\"\">\r\n");
      out.write("          <div class=\"checkbox\">\r\n");
      out.write("            <label>\r\n");
      out.write("              <input type=\"checkbox\" value=\"remember-me\"> Remember me\r\n");
      out.write("            </label>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Sign in</button>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("      </div> <!-- /container -->\r\n");
      out.write("  </body>\r\n");
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
