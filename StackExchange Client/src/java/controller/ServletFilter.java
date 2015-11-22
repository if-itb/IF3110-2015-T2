/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ISConnector;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.xml.ws.WebServiceRef;
import org.json.simple.JSONObject;
import service.StackExchange_Service;
import service.User;

/**
 *
 * @author visat
 */
public class ServletFilter implements Filter {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/StackExchange_WS/StackExchange.wsdl")
    private StackExchange_Service service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            String auth = null;
            for (Cookie cookie: cookies)
                if (cookie.getName().equals("auth")) {
                    auth = cookie.getValue();
                    break;
                }
            if (auth != null) {
                JSONObject object = ISConnector.requestAuth(auth);
                if (object != null && object.containsKey("id")) {
                    long id = (long)object.get("id");
                    User user = service.getStackExchangePort().getUser((int)id);
                    if (user != null)
                        request.setAttribute("user", user);
                }
            }
        }
        chain.doFilter(request, response);
    }

}
