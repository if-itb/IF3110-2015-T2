/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

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
import WebService.StackWS ;
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
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);           
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        ");
 
        String sq = request.getParameter("s");
        String R[][] =sws.getAllQuestions();
        int rsize = R.length;
        if (sq!=null && sq!=""){
            R = sws.searchQuestion(sq);
            rsize = R.length;
        }
            
        
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Stack Exchange</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"head1\">            \n");
      out.write("            <a ><div id=\"login\" >Login</div></a>\n");
      out.write("            <a ><div id =\"reg\">Register</div></a>\n");
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
 out.println(R[i][3]); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Votes</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class =\"answers\">\n");
      out.write("                    <div class=\"vnum\">");
 out.println(R[i][7]); 
      out.write("</div>\n");
      out.write("                    <div class=\"vname\">Answers</div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"thread\">\n");
      out.write("                    <a href=\"open?id=");
out.println(R[i][0]);
      out.write("\"><div class=\"title\">");
 out.println(R[i][1]); 
      out.write("</div></a>\n");
      out.write("                    <div class = \"content\">                     \n");
      out.write("                        ");
 if (R[i][2].length() > 150) R[i][2] = R[i][2].substring(0,149) + " . . . ";
                        out.println(R[i][2]); 
      out.write("<br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("               </div>\n");
      out.write("                <div class=\"utility\">\n");
      out.write("                    <aa>asked by : </aa>\n");
      out.write("                    <a1> ");
 out.println(R[i][5]); 
      out.write("</a1>|\n");
      out.write("                    <a href=\"askhere?id=");
 out.println(R[i][0]) ; 
      out.write("\"><span class=\"bb\">edit</span></a> |\n");
      out.write("                    <a onclick =\"return confirm('Are you sure to delete this question ?')\" href=\"process?action=del&id=");
 out.println(R[i][0]) ;
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
