/*
 * Nama File : QuestionWebService.java
 */
package question;

import Auth.Auth;
import answer.AnswerWebService;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author William Sentosa
 */

@WebService(serviceName = "QuestionWebService")
public class QuestionWebService {
    /* Atribut */
    private final String path = "jdbc:mysql://localhost:3306/stack_exchange";
    private final String url = "http://localhost:8082/IdentityServices/IdentityChecker";
    /* Method */
    @WebMethod(operationName = "getAllQuestion")
    @WebResult(name="Question")
    public ArrayList<Question> getAllQuestion() {
        String query = "SELECT * FROM question ";
        ArrayList<Question> tab = new ArrayList<Question>();
        Database database = new Database();
        database.connect(path);
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                Question question = new Question(rs.getInt("question_id"), 
                    rs.getString("asker_name"), 
                    rs.getString("asker_email"),
                    rs.getString("question_topic"), 
                    rs.getString("question_content"), 
                    rs.getInt("question_vote"),
                    rs.getInt("user_id")
                );
                tab.add(question);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return tab;
    }
    
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name="Question")
    public Question getQuestionById(@WebParam(name = "id") int id) {
        Question question;
        String query = "SELECT * FROM question WHERE question_id = " + id;
        Database database = new Database();
        database.connect(path);
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            question = new Question(rs.getInt("question_id"), 
                rs.getString("asker_name"), 
                rs.getString("asker_email"),
                rs.getString("question_topic"), 
                rs.getString("question_content"), 
                rs.getInt("question_vote"),
                rs.getInt("user_id")
            );
            rs.close();
            return question;
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return null;
    }
    
    @WebMethod(operationName = "addQuestion")
    @WebResult(name="String")
    public String addQuestion(String token, String name, String email, String topic, String content, int userId) {
        Auth auth = new Auth(token);
        if(auth.getResponse(url)){
            String query = "INSERT INTO question (question_id, asker_name, asker_email, question_topic, question_content, user_id) "
                    + "VALUES (NULL, '" + name + "', '" + email + "', '" + topic + "', '" + content + "', " + userId + ")";
            Database database = new Database();
            database.connect(path);
            database.changeData(query);
            database.closeDatabase();
            return "executed";
        } else return "not executed";
    }
    
    @WebMethod(operationName = "editQuestion")
    @WebResult(name="String")
    public String editQuestion(String token, int id, String topic, String content) {
        Auth auth = new Auth(token);
        if(auth.getResponse(url)){
            String query = "UPDATE question SET question_topic='" + topic + "', question_content='"
                    + content + "' WHERE question_id = " + id;
            Database database = new Database();
            database.connect(path);
            database.changeData(query);
            database.closeDatabase();
            return "executed";
        } else return "not executed";
    }
    
    @WebMethod(operationName = "deleteQuestion")
    @WebResult(name="String")
    public String deleteQuestion(String token, int id) {
        Auth auth = new Auth(token);
        if(auth.getResponse(url)){
            String query = "DELETE FROM question WHERE question_id = " + id;
            Database database = new Database();
            database.connect(path);
            database.changeData(query);
            database.closeDatabase();
            return "executed";
        } else return "not executed";
    }
    
}
