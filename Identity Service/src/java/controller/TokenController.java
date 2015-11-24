/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author User
 */
public class TokenController extends HttpServlet {

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
    response.setContentType("text/xml;charset=UTF-8");
    
    BufferedReader in = request.getReader();
    String inputLine;
    StringBuffer stringBuffer = new StringBuffer();
    
    while ((inputLine = in.readLine()) != null) {
      stringBuffer.append(inputLine);
    }
    
    JSONParser parser = new JSONParser();
    try {
      Object object = parser.parse(stringBuffer.toString());
      JSONObject req = (JSONObject) object;
      
      String token = (String)req.get("token");
      
      response.setContentType("application/json; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      JSONObject resp = new JSONObject();
      resp.put("token", "123abc");
      writer.println(resp);
    } catch (ParseException ex) {
      Logger.getLogger(TokenController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //    BufferedReader in = request.getReader();
//    String inputLine;
//    StringBuffer stringBuffer = new StringBuffer();
//    
//    while ((inputLine = in.readLine()) != null) {
//      stringBuffer.append(inputLine);
//    }
//    in.close();
//    
//    ServletOutputStream out = response.getOutputStream();
//    PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
//    writer.write("token diterima");
//    writer.close();
    
//    try {
//      receiveGet(request,response);
//    } catch (Exception ex) {
//      Logger.getLogger(TokenController.class.getName()).log(Level.SEVERE, null, ex);
//    }
    
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
  
//  private void receiveGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//    // Mengatur koneksi
//    URL url = new URL(req.getServletPath());
//    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//    connection.setRequestMethod("GET");
//    
//    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//      // Menerima request
//      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//      String inputLine;
//      StringBuffer request = new StringBuffer();
//      
//      while ((inputLine = in.readLine()) != null) {
//        request.append(inputLine);
//      }
//      in.close();
//      
//      // Mengirim response
//      OutputStreamWriter response = new OutputStreamWriter(connection.getOutputStream());
//      response.write("message=blabla");
//      response.close();
//    }
//  }

}
