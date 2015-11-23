/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answer;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.*;
import database.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
@WebService(serviceName = "AnswerWebService")
public class AnswerWebService {
    /* Atribut */
    private final String path = "jdbc:mysql://localhost:3306/stack_exchange";
    
    @WebMethod(operationName = "addAnswer")
    @WebResult(name="String")
    public String addAnswer(String token, int qid, String name, String email, String content, int userId) {
        String query = "INSERT INTO answer (answer_id, answerer_name, answerer_email, answer_content, answer_vote, question_id, user_id)"
                + "VALUES (NULL, '" + name + "', '" + email + "', '"+ content + "', 0, " + qid + ", " + userId + ")";
        Database database = new Database();
        database.connect(path);
        database.changeData(query);
        database.closeDatabase();
        return "executed";
    }
    
    @WebMethod(operationName = "incrVote")
    @WebResult(name="String")
    public String incrVote(String token, int id) {
        String result;
        String query = "UPDATE answer SET answer_vote = answer_vote + 1 WHERE answer_id = " + id;
        Database database = new Database();
        database.connect(path);
        result = database.changeData(query);
        database.closeDatabase();
        return result;
    }
    
    @WebMethod(operationName = "decrVote")
    @WebResult(name="String")
    public String decrVote(String token, int id) {
        String result = new String();
        String query = "UPDATE answer SET answer_vote = answer_vote - 1 WHERE answer_id = " + id;
        Database database = new Database();
        database.connect(path);
        result = database.changeData(query);
        database.closeDatabase();
        return result;
    }
    
    @WebMethod(operationName = "getAnswerByQid")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQid(@WebParam(name = "qid") int qid) throws ClassNotFoundException {
        String query = "SELECT * FROM answer WHERE question_id = " + qid;
        Database database = new Database();
        database.connect(path);
        ArrayList<Answer> tab = new ArrayList<Answer>();
        ResultSet rs = database.fetchData(query);
        try {
            while(rs.next()) {
                Answer answer = new Answer(rs.getInt("answer_id"), 
                    rs.getString("answerer_name"), 
                    rs.getString("answerer_email"), 
                    rs.getString("answer_content"), 
                    rs.getInt("answer_vote"),
                    rs.getInt("question_id"),
                    rs.getInt("user_id")
                );
                tab.add(answer);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return tab;
    }
    
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name="Answer")
    public Answer getAnswerById(@WebParam(name = "id") int id) {
        String query = "SELECT * FROM answer WHERE answer_id = " + id;
        Database database = new Database();
        database.connect(path);
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            Answer answer = new Answer(rs.getInt("answer_id"), 
                rs.getString("answerer_name"), 
                rs.getString("answerer_email"), 
                rs.getString("answer_content"), 
                rs.getInt("answer_vote"),
                rs.getInt("question_id"),
                rs.getInt("user_id")
            );
            rs.close();
            return answer;
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return null;
    }
    
    @WebMethod(operationName = "getCountAnswerByQid")
    @WebResult(name="int")
    public int getCountAnswerByQid(int id) {
        int result = -999;
        String query = "Select count(answer_id) As count From answer Where question_id = " + id;
        Database database = new Database();
        database.connect(path);
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            result = rs.getInt("count");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeDatabase();
        return result;
    }
    
}
