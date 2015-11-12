package org.stackexchange.identityservice.controller;

import org.stackexchange.identityservice.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("testVariable", "tess");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        if (!userService.emailExist(email)) {
            request.setAttribute("flash", "Email is not registered");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (!userService.emailPasswordValid(email, password)) {
            request.setAttribute("flash", "Invalid password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

        }
    }
}
