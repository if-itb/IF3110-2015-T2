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
@WebServlet(name = "open", urlPatterns = {"/open"})
public class open extends HttpServlet {

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
      out.write("       \n");
      out.write("      ");
  webservice.NewWebService service = new webservice.NewWebService();
	webservice.StackWebSevice sws = service.getStackWebSevicePort();
      
      out.write("\n");
      out.write("          \n");
      out.write(" \n");       
      out.write("\n");
      out.write("        \n");
      out.write("        ");
  String t_id = request.getParameter("id");
            int id = Integer.valueOf(t_id);
           webservice.Question Q = sws.getQuestions(id);
           java.util.List<webservice.Answer> A = sws.getAllAnswers(id);
           int asize = A.size() ;
           String content = "";
           int ca = Integer.valueOf(Q.getTanswer()) ;
           int z = (id*1000) + ca+1;
           String s = request.getParameter("s");
           if (s!=null) response.sendRedirect("Home?s="+s);
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        <title>");
 out.println(Q.getTitle()) ; 
      out.write("</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a href=\"login\"><div id=\"login\" >Login</div></a>\n");
      out.write("            <a href=\"register\"><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("         <a href=\"Home\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("         <form id=\"searchbox\" action=\"Home?s="+s+"\">\n");
      out.write("             <input id=\"search\" type=\"text\" name=\"s\" placeholder=\" Type any keyword here . . . \">\n");
      out.write("             <input id=\"submit\" type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        <p>Cannot find what you are looking for ? <a href=\"askhere\"><as>Ask here</as></a></p>     \n");
      out.write("        <div class=\"raq\">");
 out.println(Q.getTitle()) ; 
      out.write("</div>\n");
      out.write("        <div class=\"separator\"></div>      \n");
      out.write("        \n");
      out.write("        <div id=\"wrap\">\n");
      out.write("            <div id=\"main\">         \n");
      out.write("               ");
 out.println(Q.getContent()) ; 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"sidebar\">\n");
      out.write("\t\t\t\n");
      out.write("                <div id=\"vnum\"><div id=\"");
 out.println(Q.getIdQ());
      out.write('"');
      out.write('>');
 out.println(Q.getVote()) ;
      out.write(" </div> </div> \n");
      out.write("                <div id=\"vup\">\n");
      out.write("                    <a a href=\"process?action=voteup&id=");
 out.println(Q.getIdQ()) ; 
      out.write("&t=q\">\n");
      out.write("                    <img src=\"img/up.png\" alt=\"Vote Up\" style=\"width: 32px;height:32px\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"vdown\">\n");
      out.write("                    <a a href=\"process?action=votedown&id=");
 out.println(Q.getIdQ()) ; 
      out.write("&t=q\">\n");
      out.write("                    <img src=\"img/down.png\" alt=\"Vote Down\" style=\"width: 32px;height:32px\">\n");
      out.write("                     </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\"> </div>\n");
      out.write("            <div id=\"qinfo\">asked by <aa>");
 out.println(Q.getUsername()) ; 
      out.write("</aa> at<aa>");
 out.println(Q.getDate()) ; 
      out.write("</aa> |\n");
      out.write("            <a href=\"askhere?id=");
 out.println(Q.getIdQ()) ; 
      out.write("\"><span class=\"bb\">edit</span></a> |\n");
      out.write("            <a onclick =\"return confirm('Are you sure to delete this question ?')\" href=\"process?action=del&id=");
 out.println(id) ;
      out.write("\"><span class=\"cc\">delete</span></a>  \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id =\"qans\">");
 out.println(Q.getTanswer()) ; 
      out.write(" Answers</div>\n");
      out.write("         <div class=\"separator\"></div>\n");
      out.write("         \n");
      out.write("        ");
 for (int i=0;i<asize;i++) { 
      out.write("\n");
      out.write("           <div id=\"wrap\">\n");
      out.write("            <div id=\"main\">         \n");
      out.write("               ");
 out.println(A.get(i).getContent()) ; 
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"sidebar\">         \n");
      out.write("                <div id=\"vnum\"><div id=\"");
 out.println(A.get(i).getIdA()) ; 
      out.write("\"> ");
 out.println(A.get(i).getVote()) ; 
      out.write(" </div></div> \n");
      out.write("                <div id=\"vup\"><a href=\"process?action=voteup&id=");
out.println(A.get(i).getIdA()) ; 
      out.write("&t=a\">\n");
      out.write("                        <img src=\"img/up.png\" alt=\"Vote Up\" style=\"width: 32px;height:32px\"></a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"vdown\"><a a href=\"process?action=votedown&id=");
 out.println(A.get(i).getIdA()) ; 
      out.write("&t=a\">\n");
      out.write("                        <img src=\"img/down.png\" alt=\"Vote Down\" style=\"width: 32px;height:32px\"></a>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\"> </div>\n");
      out.write("            <div id=\"qinfo\">answered by <aa>");
 out.println(A.get(i).getUsername()) ; 
      out.write("</aa> at<aa> ");
 out.println(A.get(i).getDate()) ; 
      out.write("</aa> \n");
      out.write("             </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("          <div class=\"separator2\"></div>\n");
      out.write("         ");
 } 
      out.write("\n");
      out.write("         \n");
      out.write("         <div id=\"yans\">Your Answer</div>\n");
      out.write("           \n");
      out.write("        <form action=\"process\" method=\"POST\">            \n");
      out.write("            <textarea id=\"fcontent\" name=\"content\" placeholder=\"Content : \" >");
 out.println(content); 
      out.write("</textarea> \n");
      out.write("            <input id=\"fsubmit\" type=\"submit\" value=\"Answer \"><br>               \n");
      out.write("            <input type=\"hidden\" name=\"bb\" value=\"addans\" >              \n");
      out.write("            <input type=\"hidden\" name=\"id_a\" value=\"");
out.println(z) ; 
      out.write(";\" >\n");
      out.write("            <input type=\"hidden\" name=\"q_id\" value=\"");
 out.println(id) ; 
      out.write("\" >\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"answer\">\n");
      out.write("          </form>\n");
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
