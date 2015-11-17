/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL ;
import javax.xml.namespace.QName ;
import javax.xml.ws.Service;

/**
 *
 * @author tama
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("       ");
  webservice.NewWebService service = new webservice.NewWebService();
	webservice.StackWebSevice sws = service.getStackWebSevicePort();     
        
      out.write("\n");
      out.write("         \n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("       \n");
      out.write("        ");
 
            
           String ru = request.getParameter("rusername"); 
           String re = request.getParameter("remail") ;
           String rp = request.getParameter("rpass") ;
           int status = 0;          
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
   if (ru==null||re==null) {status=0;}
            else {            
                if (ru.length()>0||re.length()>0) {                    
                    status = sws.register(ru, re, rp);         
                    if (status==0) {                                  
                        ru="" ;
                        re="";
                        rp="";
                        response.sendRedirect("regsuccess");
                    }
                    else {}
                }
                else status=0;
            }
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>        \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a href=\"login\"><div id=\"login\" >Login</div></a>\n");
      out.write("            <a href=\"register\"><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("         <a href=\"Home\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"raq\">Register Page </div>\n");
      out.write("        <div class=\"separator\"></div>\n");
      out.write("        \n");
      out.write("         <form method=\"post\" >\n");
      out.write("             <input id=\"rname\" type=\"text\" name=\"rusername\" placeholder=\"Name : \"/><br> \n");
      out.write("            <input id=\"remail\" type=\"text\" name=\"remail\" placeholder=\"Email : \" /><br>\n");
      out.write("            <input id=\"rpass\" type=\"password\" name=\"rpass\" placeholder=\"Password : \" /><br> \n");
      out.write("            <div id=\"regerror\">\n");
      out.write("                ");
 if (status!=0) { 
      out.write("\n");
      out.write("                This account has been registered. Click <a href=\"login\"><rr>here</rr></a> to login.\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <input id=\"rsubmit\" type=\"submit\" value=\"Register\"><br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("         </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
