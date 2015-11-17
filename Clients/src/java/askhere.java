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
@WebServlet(name = "askhere", urlPatterns = {"/askhere"})
public class askhere extends HttpServlet {

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
      out.write("        ");
           String s = request.getParameter("s");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         ");

            String t_id = request.getParameter("id");
            webservice.Question Q = new webservice.Question() ;
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
      out.write("            <a href=\"login\"><div id=\"login\" >Login</div></a>\n");
      out.write("            <a href=\"register\"><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("        <a href=\"Home\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("         <form id=\"searchbox\" action=\"Home?s="+s+"\">\n");
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
      out.write("        <form action=\"process\" method=\"POST\">\n");
      out.write("            <input id=\"atitle\" type=\"text\" name=\"atitle\" placeholder=\"Title\" value=\"");
 if (id!=0) out.println(Q.getTitle()) ; 
      out.write("\"/><br>             \n");
      out.write("             <textarea id=\"acontent\" name=\"acontent\" placeholder=\"Content\" >");
 if (id!=0) out.println(Q.getContent()) ; 
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
