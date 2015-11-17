/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-11-16 07:12:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Sign In</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("        <script src=\"//code.jquery.com/jquery-migrate-1.2.1.min.js\"></script>\r\n");

	Cookie cookie = null;
	Cookie[] cookies = null;
	String access_token = null;
	// Get an array of Cookies associated with this domain
	cookies = request.getCookies();
	if( cookies != null ){
		for (int i = 0; i < cookies.length; i++){
			cookie = cookies[i];
			if(cookie.getName().equals("access_token")){
				access_token = cookie.getValue();
				break;
			}
		}

		if((access_token != null) && (access_token.length()>0)){
			//check access_token validity to server

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tfunction checkToken(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar tokenData = {access_token:\"");
      out.print( access_token );
      out.write("\"}\r\n");
      out.write("\t\t\tvar checkTokenUrl = \"http://localhost:8080/REST-WS/rest/token-validity\";\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("                url: checkTokenUrl,\r\n");
      out.write("                data: tokenData,\r\n");
      out.write("                dataType: \"json\",\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                success: function(data) {\r\n");
      out.write("                    var valid = data.valid;\r\n");
      out.write("                    if(valid)\r\n");
      out.write("                    \twindow.location.href = \"index.jsp\";\r\n");
      out.write("                },\r\n");
      out.write("                error: function(jqxhr, status, errorMsg) {\r\n");
      out.write("                    alert(status + \": \" + errorMsg);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t    checkToken();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

	}
      
  }else{
      out.println("<h2>No cookies founds</h2>");
  }

      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("                var url = \"http://localhost:8080/REST-WS/rest/token\";\r\n");
      out.write("                $(\"#submitBtn\").click(function(e) {\r\n");
      out.write("                    e.preventDefault();\r\n");
      out.write("                    var formData = $(\"#loginForm\").serialize();\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url: url,\r\n");
      out.write("                        data: formData,\r\n");
      out.write("                        dataType: \"json\",\r\n");
      out.write("                        type: \"POST\",\r\n");
      out.write("                        success: function(data) {\r\n");
      out.write("                            var token = data.access_token;\r\n");
      out.write("                            document.cookie=\"access_token=\"+token+\"; expires=\"+data.expire;\r\n");
      out.write("                            if(token == null)\r\n");
      out.write("                            \t$(\".error\").replaceWith( \"Username and password not match\" );\r\n");
      out.write("                            else\r\n");
      out.write("                            \twindow.location.href = \"signin_success.jsp\";\r\n");
      out.write("\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function(jqxhr, status, errorMsg) {\r\n");
      out.write("                            alert(status + \": \" + errorMsg);\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"content\">\r\n");
      out.write("        \t<span class=\"error\"></span>\r\n");
      out.write("            <form id=\"loginForm\">\r\n");
      out.write("                Email: <input type=\"text\" name=\"email\"/><br/>\r\n");
      out.write("                Password : <input type=\"text\" name=\"password\"/><br/>\r\n");
      out.write("                <button id=\"submitBtn\">Submit</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
