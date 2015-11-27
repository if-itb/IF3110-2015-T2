package AnswerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dadakanDB","root","");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answers WHERE id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,qid);
            ResultSet rs = dbStatement.executeQuery();
            int i = 0;
            while(rs.next()) {
                answers.add(new Answer(
                                    rs.getInt("id"),
                                    rs.getInt("id_question"),
                                    rs.getInt("id_user"),
                                    rs.getString("content"),
                                    rs.getString("timestamp"),
                                    rs.getInt("vote")
                                )       
                );
                ++i;
            }
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createAnswer")
    public int createAnswer(@WebParam(name = "token") String token, @WebParam(name = "question_id") int question_id, @WebParam(name = "content") String content) throws ParseException {
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
                String sql = "INSERT INTO answers(id_user,id_question,content,vote) VALUES ((select id_user from questions where id="+question_id+"),"+question_id+",'"+content+"',0)";
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
