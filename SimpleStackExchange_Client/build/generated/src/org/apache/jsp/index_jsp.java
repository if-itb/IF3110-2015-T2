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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\"><head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"icon\" href=\"assets/img/favicon.ico\">\n");
      out.write("\n");
      out.write("    <title>Simple StackExchange</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("     ");

        //allow access only if session exists
        String email = null;
        Boolean isLogin= false;
        if(session.getAttribute("email") != null){
           isLogin= true;
           email = (String) session.getAttribute("email");
        }
        
        String userEmail = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("email")) userEmail = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
        }else{
            sessionID = session.getId();
        }
      
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/navbar.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("isLogin", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(isLogin), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template/userinfo.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("isLogin", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(isLogin), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userEmail", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(userEmail), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <form class=\"form-horizontal\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/search\" method=\"GET\">\n");
      out.write("            <div class=\"col-lg-12\">\n");
      out.write("                <div class=\"input-group\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" placeholder=\"Search for...\">\n");
      out.write("                  <span class=\"input-group-btn\">\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"button\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\"></span></button>\n");
      out.write("                  </span>\n");
      out.write("                </div><!-- /input-group -->\n");
      out.write("            </div><!-- /.col-lg-12 -->\n");
      out.write("          </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-sm-12\">\n");
      out.write("                <h2>\n");
      out.write("                    Recently Asked Questions\n");
      out.write("                </h2>\n");
      out.write("                <hr>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("           \n");
      out.write("            <div class=\"question-item row\">\n");
      out.write("            <div class=\"col-sm-1 \">\n");
      out.write("                <div class=\"text-center well-lg text-lg\">0</div>\n");
      out.write("                <div class=\"text-center\">votes</div>\n");
      out.write("            </div><!-- end of col-sm-1 -->\n");
      out.write("            <div class=\"col-sm-1 \">\n");
      out.write("                <div class=\"text-center well-lg text-lg\">0</div>\n");
      out.write("                <div class=\"text-center\">answers</div>\n");
      out.write("            </div><!-- end of col-sm-1 -->\n");
      out.write("            <div class=\"col-sm-10\">\n");
      out.write("            <div class=\"panel panel-default\">\n");
      out.write("                <!-- Default panel contents -->\n");
      out.write("                <div class=\"panel-heading\"><h4><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/question/?qid=1\">Judul Pertanyaan</a></h4></div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                  \n");
      out.write("                  <span class=\"pull-right\">\n");
      out.write("                      <button type=\"button\" class=\"btn btn-default transparent\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> User\n");
      out.write("                      </button>\n");
      out.write("                      <button type=\"button\" class=\"btn btn-warning \" aria-label=\"Edit\">\n");
      out.write("                        <a class=\"glyphicon glyphicon-pencil white\" aria-hidden=\"true\"></a>\n");
      out.write("                      </button>\n");
      out.write("                      <button type=\"button\" class=\"btn btn-danger\" aria-label=\"Delete\">\n");
      out.write("                        <a class=\"glyphicon glyphicon-trash white\" aria-hidden=\"true\"></a>\n");
      out.write("                      </button>\n");
      out.write("                  </span>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("        </div><!-- end of col-sm-11 -->\n");
      out.write("       \n");
      out.write("      </div><!-- end of question-item -->\n");
      out.write("      <footer>\n");
      out.write("          <p class=\"text-center\">© Simple StackExchage 2015</p>\n");
      out.write("      </footer>\n");
      out.write("    </div> <!-- /container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript\n");
      out.write("    ================================================== -->\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body></html>\n");
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
