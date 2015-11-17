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
    
    @WebMethod(operationName = "test")
    @WebResult(name="String")
    public String getData (int id) {
        ResultSet rs = database.execute("Select * from answer where question_id = " + id);
        try {
            rs.next();
            return rs.getString("answer_content");
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "gagal";
    }
    
    @WebMethod(operationName = "getAnswerByQid")
    @WebResult(name="Answer")
    public ArrayList<Answer> getAnswerByQid(@WebParam(name = "qid") int qid) throws ClassNotFoundException {
        String query = "Select * from answer where question_id = " + qid;
        ArrayList<Answer> tab = new ArrayList<Answer>();
        ResultSet rs = database.execute(query);
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
    
    
}
