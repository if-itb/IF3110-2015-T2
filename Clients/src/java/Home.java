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
import java.util.ArrayList;
import javax.xml.namespace.QName ;
import javax.xml.ws.Service;
/**
 *
 * @author tama
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
      out.write("        \n");
      out.write("        ");
      
        webservice.NewWebService service = new webservice.NewWebService();
	webservice.StackWebSevice sws = service.getStackWebSevicePort();
	// TODO process result here
	   out.write("\n");
      out.write("        \n");
      out.write("        ");
 
      out.write("\n");
      out.write("        ");
 
        String sq = request.getParameter("s");
        java.util.List<webservice.Question> R = sws.getAllQuestions();
	int rsize =R.size();
        if (sq!=null && sq!=""){
            R = sws.searchQuestion(sq);
            rsize = R.size();
        }
            
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Stack Exchange</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a href=\"login\"><div id=\"login\" >Login</div></a>\n");
      out.write("            <a href=\"register\"><div id =\"reg\">Register</div></a>\n");
      out.write("        </div>\n");
      out.write("         <a href=\"Home\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("        \n");
      out.write("         <form id=\"searchbox\" method=\"GET\">\n");
      out.write("             <input id=\"search\" type=\"text\" name=\"s\" placeholder=\" Type any keyword here . . . \">\n");
      out.write("             <input id=\"submit\" type=\"submit\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("        <p>Cannot find what you are looking for ? <a href=\"askhere\"><as>Ask here</as></a></p>        \n");
      out.write("        <div class=\"raq\">Recently Asked Questions </div>\n");
      out.write("        <div class=\"separator\"></div>       \n");
      out.write("        ");
 for (int i=0; i<rsize;i++) { 
      out.write("        \n");
      out.write("            <div class =\"info\">\n");
      out.write("                <div class =\"vote\">\n");
      out.write("                    <div class=\"vnum\"> ");
 out.println(R.get(i).getVote()); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Votes</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class =\"answers\">\n");
      out.write("                    <div class=\"vnum\">");
 out.println(R.get(i).getTanswer()); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Answers</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"thread\">\n");
      out.write("                    <a href=\"open?id=");
out.println(R.get(i).getIdQ());
      out.write("\"><div class=\"title\">");
 out.println(R.get(i).getTitle()); 
      out.write("</div></a>\n");
      out.write("                    <div class = \"content\">                     \n");
      out.write("                        ");
      int cl = R.get(i).getContent().length();
      String ct = R.get(i).getContent();
 if (cl> 150) ct = ct.substring(0, 149);
                        out.println(ct); 
      out.write("<br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("               </div>\n");
      out.write("                <div class=\"utility\">\n");
      out.write("                    <aa>asked by : </aa>\n");
      out.write("                    <a1> ");
 out.println(R.get(i).getUsername()); 
      out.write("</a1>|\n");
      out.write("                    <a href=\"askhere?id=");
 out.println(R.get(i).getIdQ()) ; 
      out.write("\"><span class=\"bb\">edit</span></a> |\n");
      out.write("                    <a onclick =\"return confirm('Are you sure to delete this question ?')\" href=\"process?action=del&id=");
 out.println(R.get(i).getIdQ()) ;
      out.write("\"><span class=\"cc\">delete</span></a>\n");
      out.write("                </div>\n");
      out.write("             <div class=\"uline\"></div>       \n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("       \n");
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
