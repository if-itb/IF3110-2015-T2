package org.stackexchange.identityservice.controller;

import org.stackexchange.identityservice.dao.TokenDao;
import org.stackexchange.identityservice.dao.UserDao;
import org.stackexchange.identityservice.model.User;
import org.stackexchange.identityservice.services.IdentityService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TokenCheckApiServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getParameter("token");
        response.setContentType("application/json");

        IdentityService identityService = new IdentityService();
        boolean valid = identityService.tokenValid(token);

        try {
            PrintWriter out = response.getWriter();
            out.print(String.valueOf(valid));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
