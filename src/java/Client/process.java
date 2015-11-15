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
@WebServlet(name = "process", urlPatterns = {"/process"})
public class process extends HttpServlet {

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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("       ");
 URL url = new URL("http://localhost:9998/WebService?wsdl"); 
           QName qname = new QName("http://WebService/", "StackWSImplService");
           Service service = Service.create(url, qname);
           String m1="",m2="";
        
      out.write("\n");
      out.write("         \n");
      out.write("        \n");
      out.write("        ");
 StackWS sws = service.getPort(StackWS.class); 
      out.write("\n");
      out.write("        ");
 String action = request.getParameter("action");
            
           if (action.equals("askhere")) {
               String type = request.getParameter("process");
               String title = request.getParameter("atitle");
               String content = request.getParameter("acontent");
               String qid = request.getParameter("qid");
               if (type.contains("new")) {
                   int stats = sws.addQuestion("asd",title,content);              
                   if (stats!=0) {
                       response.sendRedirect("open?id="+stats);
                   }
                   else {
                       m1 = "You're not currently login. Please login to create new question" ;
                       m2= "home";                       
                   }
               }
               else if (type.contains("edit")){
                   qid=qid.substring(0,qid.length()-2); 
                   int idd = Integer.valueOf(qid);
                   int stats = sws.updateQuestion("asd", idd,title,content);                  
                   if (stats!=0) {
                    response.sendRedirect("open?id="+idd); 
                   }
                   else { 
                       m1 = "You're not the owner of this question." ;
                       m2= "home";  
                   }
               }
               else out.println("|"+type+"|");
           }
           else if (action.contains("del")) {
               String qid = request.getParameter("id");
               int idd = Integer.valueOf(qid);
               int stats = sws.deleteQuestion("asd", idd);
               m2 = "home";
               if (stats!=0) m1 = "The question has been deleted";
               else m1 = "You're not the owner of this question";
           }
           else if (action.contains("answer")) {
               String qid = request.getParameter("q_id");
               qid = qid.substring(0,qid.length()-2);
               int qidd = Integer.valueOf(qid);
               String ida = request.getParameter("id_a");
               ida = ida.substring(0,ida.length()-3);
               int idaa = Integer.valueOf(ida);
               String c = request.getParameter("content");
               int st = sws.addAnswer("asd",qidd,idaa,c);
               if (st!=0) {
                   response.sendRedirect("open?id="+qidd);
               } else {
                   m1 = "You're not currently login. You can't add any answer" ;
                   m2 = "home";
               }
           }
           else if (action.contains("vote")) {
               String idd = request.getParameter("id");
               int id = Integer.valueOf(idd);
               int num=0;
               if (action.contains("up")) num=1;
               else num=-1;
               int qid = id;
               if (qid>=1000) qid = qid/1000;
               String t = request.getParameter("t");
               int st = sws.changeVote("asd", t, id, num);
               m2 = "open?id="+String.valueOf(qid);
               if (st==0) {
                   m1 = "You already vote this one. You can't vote any question or answer more than once";
               }
               else {
                   m1 = "Your vote has been saved";
               }
           }
           else out.println("|"+action+"|");
           
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         \n");
      out.write("           <a href=\"home\"><div id=\"h\">Stack <at>Exchange</at></div></a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("            <div class=\"raq\"> </div>\n");
      out.write("            <div class=\"separator\"></div>\n");
      out.write("            ");
 
                response.setHeader("Refresh", "2;url="+m2); 
               
            
      out.write("\n");
      out.write("            <div class=\"rsuccess\">\n");
      out.write("                ");
out.println(m1) ; 
      out.write("<br>\n");
      out.write("                You'll be redirected to \n");
      out.write("                ");
 if (action.contains("vote")) out.println("previous");
                    else out.println("home"); 
      out.write("\n");
      out.write("                page. If not click <a href=\"");
 out.println(m2); 
      out.write("\"><rr>here</rr></a></div>\n");
      out.write("\n");
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
