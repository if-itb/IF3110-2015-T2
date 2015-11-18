package validation;

import java.util.Calendar;
import java.util.Random;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.json.simple.JSONObject;


@WebServlet(name="createToken" , urlPatterns = {"/createToken"})
public class createToken extends HttpServlet {
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
        String obj = "";
        JSONObject jobj = null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            if(exist(email,password)) 
                jobj = tokenize(email);
            else {
                jobj = new JSONObject();
                jobj.put("message","error");
            }
            out.println(jobj.toString());
            out.close();
        }
        catch(Exception e) {}
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

    private boolean exist(java.lang.String email, java.lang.String password) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Connection conn = null;        
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dadakanDB","root","");
            String sql = "SELECT email,password FROM users WHERE email = '" + email + "' and password = '" + password + "'";
            PreparedStatement dbs = conn.prepareStatement(sql);
            ResultSet rs = dbs.executeQuery();
            return rs.next();
        } catch (Exception e) {} 
        return false;
    }
    
    private JSONObject tokenize(String email) {
        JSONObject jobj = new JSONObject();
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dadakanDB","root","");
            String sql = "SELECT * FROM users WHERE email='" + email + "'";
            PreparedStatement dbs = conn.prepareStatement(sql);
            ResultSet rs = dbs.executeQuery();
            int userid = 0;
            String username = "";
            while(rs.next()) {
                userid = rs.getInt("id");
                username = rs.getString("name");
            }
            Random rn = new Random(); 
            String elf = "" + rn.nextInt(100);
            String token = username + elf;
            sql = "INSERT INTO tokens(userid,token) VALUES ('"+userid+"','"+token+"')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            //make json
            DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
            Calendar calobj = Calendar.getInstance();
            jobj.put("message","valid");
            jobj.put("token",token);
            jobj.put("produced",df.format(calobj.getTime()));
            return jobj;
        }
        catch(Exception e) {}
        jobj.put("message","error");
        return jobj;
    }
}
