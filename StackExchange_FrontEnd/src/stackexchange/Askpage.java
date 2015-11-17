package stackexchange;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.xml.*;
import java.util.HashMap;

import util.HttpRequest;
import util.HttpRequest.*;
import util.XmlParser;

/**
 * Created by elvan_owen on 11/17/15.
 */
@WebServlet(name = "Askpage")
public class Askpage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> data = new HashMap<>();

        data.put("access_token", request.getParameter("token"));
        data.put("title", request.getParameter("title"));
        data.put("content", request.getParameter("content"));

        String requestResponse = HttpRequest.executeMethod("createQuestion", data);

        // Get soap response
        boolean isSuccess = XmlParser.isSuccessResponse(requestResponse);

        if (isSuccess){
            response.sendRedirect("/");
            return;
        }

        request.setAttribute("error", "Internal Server Error");

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("views/error.jsp").forward(request, response);
    }
}
