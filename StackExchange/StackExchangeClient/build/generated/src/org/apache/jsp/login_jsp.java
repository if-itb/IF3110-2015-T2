package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>Stack Exchange</title>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n");
      out.write("    <link href=\"css/register-login.css\" type=\"text/css\" rel=\"stylesheet\" media=\"screen,projection\"/>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <nav class=\"deep-purple darken-2\" role=\"navigation\">\r\n");
      out.write("      <div class=\"nav-wrapper container\">\r\n");
      out.write("        <a id=\"logo-container\" href=\"#\" class=\"brand-logo\">Stack Exchange - Login</a>\r\n");
      out.write("        <ul class=\"right hide-on-med-and-down\">\r\n");
      out.write("          <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("          <li><a href=\"register.jsp\">Register</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <br><br><br>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <nav class=\"deep-purple darken-2\" role=\"navigation\">\r\n");
      out.write("        <div class=\"nav-wrapper\">\r\n");
      out.write("          <form>\r\n");
      out.write("            <div class=\"input-field\">\r\n");
      out.write("              <input id=\"search\" type=\"search\" required>\r\n");
      out.write("              <label for=\"search\"><i class=\"material-icons\">search</i></label>\r\n");
      out.write("              <i class=\"material-icons\">close</i>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </nav>\r\n");
      out.write("    </div>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    ");

        try{
            int valid = Integer.parseInt(request.getParameter("valid"));
            if(valid == 0)
                out.println("<div class='center'><br> Login unsuccessful, Incorrect Email or Password ! </div>");
            else{
                String token = request.getParameter("token");
                response.sendRedirect("http://localhost:8081/StackExchangeClient/index.jsp?token="+token);
            }
        }catch(Exception ex){
            
        }
    
      out.write("\r\n");
      out.write("    <div class=\"row container\">\r\n");
      out.write("      <form class=\"col s12 m8\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"input-field\">\r\n");
      out.write("            <input id=\"email\" type=\"text\" name=\"email\" class=\"validate\">\r\n");
      out.write("            <label for=\"email\">Email</label>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"input-field\">\r\n");
      out.write("            <input id=\"password\" type=\"password\" name=\"password\" class=\"validate\">\r\n");
      out.write("            <label for=\"password\">Password</label>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container center\">\r\n");
      out.write("            <button class=\"btn waves-effect waves-light deep-purple darken-2\" type=\"submit\" formmethod=\"POST\" formaction=\"http://localhost:8082/IdentityService/LoginServlet\">Login\r\n");
      out.write("              <i class=\"material-icons right\">send</i>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("        \r\n");
      out.write("    <footer class=\"page-footer deep-purple darken-2\">\r\n");
      out.write("      <div class=\"footer-copyright\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          © 2015 Created by 3xcelsi0r\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/materialize.min.js\"></script>\r\n");
      out.write("    <script src=\"js/init.js\"></script>\r\n");
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
