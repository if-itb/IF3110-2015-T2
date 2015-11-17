/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.*;
import com.mysql.jdbc.Driver;
import database.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
@WebService(serviceName = "answerWS")
public class AnswerWebService {
    /* Atribut */
    private final Database database;
    private final String path = "jdbc:mysql://localhost:3306/stack_exchange";

    /* Constructor */
    public AnswerWebService() {
        database = new Database();
        database.connect(path);
    }
    
    @WebMethod(operationName = "addAnswer")
    @WebResult(name="String")
    public String addAnswer(int qid, String name, String email, String content) {
        String query = "INSERT INTO answer (answer_id, answerer_name, answerer_email, answer_content, answer_vote, question_id)"
                + "VALUES (NULL, '" + name + "', '" + email + "', '"+ content + "', 0, " + qid + ")";
        database.changeData(query);
        return "Success";
    }
    
    @WebMethod(operationName = "incrVote")
    @WebResult(name="String")
    public String incrVote(int id) {
        String result = new String();
        String query = "UPDATE answer SET answer_vote = answer_vote + 1 WHERE answer_id = " + id;
        result = database.changeData(query);
        return result;
    }
    
    @WebMethod(operationName = "decrVote")
    @WebResult(name="String")
    public String decrVote(int id) {
        String result = new String();
        String query = "UPDATE answer SET answer_vote = answer_vote - 1 WHERE answer_id = " + id;
        result = database.changeData(query);
        return result;
    }
    
    @WebMethod(operationName = "getAnswerByQid")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQid(@WebParam(name = "qid") int qid) throws ClassNotFoundException {
        String query = "SELECT * FROM answer WHERE question_id = " + qid;
        ArrayList<Answer> tab = new ArrayList<Answer>();
        ResultSet rs = database.fetchData(query);
        try {
            while(rs.next()) {
                Answer answer = new Answer(rs.getInt("answer_id"), 
                    rs.getString("answerer_name"), 
                    rs.getString("answerer_email"), 
                    rs.getString("answer_content"), 
                    rs.getInt("answer_vote"),
                    rs.getInt("question_id")
                );
                tab.add(answer);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tab;
    }
    
    @WebMethod(operationName = "getCountAnswerByQid")
    @WebResult(name="int")
    public int getCountAnswerByQid(int id) {
        int result = -999;
        String query = "Select count(answer_id) As count From answer Where question_id = " + id;
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            result = rs.getInt("count");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
