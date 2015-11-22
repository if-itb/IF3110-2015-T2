package model.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import connection.DB;
import java.sql.Connection;
import java.sql.Statement;
import javax.jws.Oneway;
import javax.jws.WebParam;

/**
 *
 * @author Asanilta
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    Connection conn = DB.connect();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllQuestions")
    @WebResult(name="Question")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        
        try {
                
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM question";
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                questions.add(new Question(rs.getInt("question_id"),rs.getString("topic"),rs.getString("content"),rs.getInt("user_id"),rs.getString("create_time"),rs.getInt("vote")));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            //Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questions;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestion")
    @WebResult(name="Question")
    public Question getQuestion(@WebParam(name = "question_id") int question_id) {
        Question question = null;
        try {
                
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM question WHERE question_id="+question_id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                question = new Question(rs.getInt("question_id"),rs.getString("topic"),rs.getString("content"),rs.getInt("user_id"),rs.getString("create_time"),rs.getInt("vote"));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addQuestion")
    @Oneway
    public void addQuestion(@WebParam(name = "q") Question q) {
        try {
                
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO question(topic,content,user_id) VALUES("+
                    q.getTopic() + "," + q.getContent() + "," + q.getUserId() + ")";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
