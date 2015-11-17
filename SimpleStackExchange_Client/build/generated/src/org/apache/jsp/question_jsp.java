package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class question_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\"><head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"assets/img/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <title>Simple StackExchange</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">Simple <strong>StackExchange</strong></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"navbar\" class=\"navbar-collapse collapse\" aria-expanded=\"false\" style=\"height: 1px;\">\r\n");
      out.write("            <form class=\"navbar-form navbar-right\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/UserAuthentication\" method=\"POST\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <input type=\"text\" name=\"email\" placeholder=\"Email\" class=\"form-control\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <input type=\"password\" name=\"password\" placeholder=\"Password\" class=\"form-control\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-success\">Sign in</button>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div><!--/.navbar-collapse -->\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row jumbotron\">\r\n");
      out.write("            <h2><span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> Hello, Guest!</h2>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <span>\r\n");
      out.write("                <a class=\"btn btn-default btn-sm\" href=\"#\" role=\"button\">Go Signup!</a>\r\n");
      out.write("                </span>\r\n");
      out.write("                <span>\r\n");
      out.write("                    for getting access to all features.\r\n");
      out.write("                </span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <form class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/search\" method=\"GET\">\r\n");
      out.write("            <div class=\"col-lg-12\">\r\n");
      out.write("                <div class=\"input-group\">\r\n");
      out.write("                  <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\">\r\n");
      out.write("                  <span class=\"input-group-btn\">\r\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"button\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span></button>\r\n");
      out.write("                  </span>\r\n");
      out.write("                </div><!-- /input-group -->\r\n");
      out.write("            </div><!-- /.col-lg-12 -->\r\n");
      out.write("          </form>\r\n");
      out.write("            <div class=\"col-sm-12\">\r\n");
      out.write("                <p class=\"text-center\">Cannot find what you are looking for? <strong><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ask\">Ask here</a></strong></p>\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("            \r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-12\">\r\n");
      out.write("                <h2>\r\n");
      out.write("                    Recently Asked Questions\r\n");
      out.write("                </h2>\r\n");
      out.write("                <hr>\r\n");
      out.write("            </div>\r\n");
      out.write("           \r\n");
      out.write("            <div class=\"question-item row\">\r\n");
      out.write("            <div class=\"col-sm-1 \">\r\n");
      out.write("                <div class=\"text-center well-lg text-lg\">0</div>\r\n");
      out.write("                <div class=\"text-center\">votes</div>\r\n");
      out.write("            </div><!-- end of col-sm-1 -->\r\n");
      out.write("            <div class=\"col-sm-1 \">\r\n");
      out.write("                <div class=\"text-center well-lg text-lg\">0</div>\r\n");
      out.write("                <div class=\"text-center\">answers</div>\r\n");
      out.write("            </div><!-- end of col-sm-1 -->\r\n");
      out.write("            <div class=\"col-sm-10\">\r\n");
      out.write("            <div class=\"panel panel-default\">\r\n");
      out.write("                <!-- Default panel contents -->\r\n");
      out.write("                <div class=\"panel-heading\"><h4>Judul Pertanyaan</h4></div>\r\n");
      out.write("                <div class=\"panel-body\">\r\n");
      out.write("                  \r\n");
      out.write("                  <span class=\"pull-right\">\r\n");
      out.write("                      <button type=\"button\" class=\"btn btn-default transparent\">\r\n");
      out.write("                        <span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> User\r\n");
      out.write("                      </button>\r\n");
      out.write("                      <button type=\"button\" class=\"btn btn-warning \" aria-label=\"Edit\">\r\n");
      out.write("                        <a class=\"glyphicon glyphicon-pencil white\" aria-hidden=\"true\"></a>\r\n");
      out.write("                      </button>\r\n");
      out.write("                      <button type=\"button\" class=\"btn btn-danger\" aria-label=\"Delete\">\r\n");
      out.write("                        <a class=\"glyphicon glyphicon-trash white\" aria-hidden=\"true\"></a>\r\n");
      out.write("                      </button>\r\n");
      out.write("                  </span>\r\n");
      out.write("                </div>\r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- end of col-sm-11 -->\r\n");
      out.write("       \r\n");
      out.write("      </div><!-- end of question-item -->\r\n");
      out.write("      <footer>\r\n");
      out.write("          <p class=\"text-center\">© Simple StackExchage 2015</p>\r\n");
      out.write("      </footer>\r\n");
      out.write("    </div> <!-- /container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body></html>\r\n");
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
