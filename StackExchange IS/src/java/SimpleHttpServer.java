/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alberttriadrian
 */
/**
 * Simplistic Java EE server-side application intended for demonstration of
 * HTTP methods often use in REST-based applications.
 * 
 * @author Dustin
 */
public class SimpleHttpServer extends HttpServlet
{
   /**
    * Servlet method responding to HTTP GET methods calls.
    *
    * @param request HTTP request.
    * @param response HTTP response.
    */
   @Override
   public void doGet( HttpServletRequest request,
                      HttpServletResponse response ) throws IOException
   {
      final PrintWriter out = response.getWriter();
      out.write("GET method (retrieving data) was invoked!");
   }

    /**
    * Servlet method responding to HTTP POST methods calls.
    *
    * @param request HTTP request.
    * @param response HTTP response.
    */
   @Override
   public void doPost( HttpServletRequest request,
                       HttpServletResponse response ) throws IOException
   {
      final PrintWriter out = response.getWriter();
      out.write("POST method (changing data) was invoked!");
   }

   /**
    * Servlet method responding to HTTP PUT methods calls.
    *
    * @param request HTTP request.
    * @param response HTTP response.
    */
   @Override
   public void doPut( HttpServletRequest request,
                      HttpServletResponse response ) throws IOException
   {
      final PrintWriter out = response.getWriter();
      out.write("PUT method (inserting data) was invoked!");
   }

    /**
    * Servlet method responding to HTTP DELETE methods calls.
    *
    * @param request HTTP request.
    * @param response HTTP response.
    */
   @Override
   public void doDelete( HttpServletRequest request,
                         HttpServletResponse response ) throws IOException
   {
      final PrintWriter out = response.getWriter();
      out.write("DELETE method (removing data) was invoked!");
   }

   @Override
   public String getServletInfo()
   {
      return "Server-side application demonstrating HTTP methods.";
   }
}