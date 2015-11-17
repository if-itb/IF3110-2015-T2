package stackexchange;

import util.HttpRequest;
import util.XmlParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

/**
 * Created by elvan_owen on 11/17/15.
 */
@WebServlet(name = "Loginpage")
public class Loginpage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, String> requestParams = new HashMap<>();
        ArrayList<String> params = new ArrayList<>();

        requestParams.put("email", request.getParameter("email"));
        requestParams.put("password", request.getParameter("password"));

        String requestResponse = HttpRequest.executePOST("http://localhost:9000/Identity_Service/Request", requestParams);

        JSONObject obj = new JSONObject(response);

        try {
            String token = obj.getString("token");

            if (token != ""){
                response.sendRedirect("/?token=" + obj.getString("token"));
                return;
            }
        } catch(Exception e){}

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }
}
