/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import java.sql.DriverManager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createQuestion")
    public int createQuestion(@WebParam(name = "token") String token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) throws ParseException {
        Form form = new Form();
        form.param("token",token);
        Client client = ClientBuilder.newClient();
        String url = "http://localhost:8082/Identity_Service/CheckToken"; 
        String result = client.target(url).request(MediaType.APPLICATION_JSON).
                  post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(result);
        JSONObject jobj = (JSONObject) obj;
        String message = (String) jobj.get("message");
        System.out.println(message);
        int ret = 1;
        if(message.equals("valid")) {
            try {         
                System.out.println("success!!");
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dadakanDB","root","");
                String sql = "INSERT INTO questions(id_user,title,content) VALUES ((select userid from tokens where token='"+token+"'),'"+title+"','"+content+"')";
                java.sql.Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                ret = 1;
            } catch(Exception e) {}   
        }
        else if(message.equals("expired")) {
                System.out.println("expred!");
            ret = 0;
        }
        else if(message.equals("invalid")) {
                System.out.println("invalid!");
            ret = -1;
        }
        return ret;
    }
}
