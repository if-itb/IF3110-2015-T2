/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Ahmad Naufal Farhan
 */
@WebService(serviceName = "QuestionsWS")
public class QuestionsWS {
    
    Connection conn = DB.getConnection();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionById")
    @WebResult(name = "Question")
    public Question getQuestionById(@WebParam(name = "qid") int qid) {
        Question question = null;
        
        try {
            Statement st = conn.createStatement(); 
                String query;
                query = "SELECT * FROM questions WHERE id = ?";
                
                // set the prepared statement by the query and enter the value of where clause
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, qid);
                
                // create a new question object with the result
                ResultSet res = pst.executeQuery();
                    
                    if (res.next())
                        question = new Question(res.getInt("id"),
                                res.getInt("uid"),
                                res.getString("topic"),
                                res.getString("content"),
                                res.getString("timestamp"));
                res.close();
                    st.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAllQuestions")
    @WebResult(name = "Questions")
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        
        try (Statement st = conn.createStatement()) {
            
            String query = "SELECT * FROM `questions`";
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
               
            try (ResultSet res = pst.executeQuery()) {
                // get the questions
                while (res.next()) {
                    questions.add(new Question(res.getInt("id"),
                            res.getInt("uid"),
                            res.getString("topic"),
                            res.getString("content"),
                            res.getString("timestamp")));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questions;
    }
}
