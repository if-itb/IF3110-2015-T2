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
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    private static final String CONN_STRING="jdbc:mysql://localhost/dadakanDB";
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQID(@WebParam(name = "qid") int qid) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dadakandb?zeroDateTimeBehavior=convertToNull","root","");
        

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM answers WHERE id_question = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,qid);
            ResultSet result = dbStatement.executeQuery();
            int i = 0;
            while(result.next()) {
                answers.add(new Answer(result.getInt("id"),
                    result.getInt("id_question"),
                    result.getInt("id_user"),
                    result.getString("content"),
                    result.getString("timestamp"),
                    result.getInt("votes")
                ));
                ++i;
            }
            result.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }
    
    @WebMethod(operationName = "createAnswer")
    public int createAnswer(@WebParam(name = "idQuestion") int idQuestion,@WebParam(name = "token") String token, @WebParam(name = "content") String content) throws ParseException {
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
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dadakandb?zeroDateTimeBehavior=convertToNull","root","");
                String sql = "INSERT INTO answers(id_user,id_question,content) VALUES ((select userid from tokens where token='"+token+"'),'"+idQuestion+"','"+content+"')";
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
