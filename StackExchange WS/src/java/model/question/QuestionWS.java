/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import com.sun.istack.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import model.answer.Answer;
import model.answer.AnswerWS;

/**
 *
 * @author visat
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
    private Connection conn = DB.connect();
    
    /**
     * Web service operation
     * @param id
     * @return Question
     */
    @WebMethod(operationName = "getQuestionByID")
    @WebResult(name = "Question")
    public Question getQuestionByID(@WebParam(name = "id") final int id) {
        Question question = null;
        try (Statement statement = conn.createStatement()) {
            String sql ="SELECT * FROM question WHERE id = ?";            
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);            
            dbStatement.setInt(1, id);
                        
            try (ResultSet result = dbStatement.executeQuery(sql)) {
                if (result.next())
                    question = new Question(
                            result.getInt("id"),
                            result.getInt("id_user"),
                            result.getString("topic"),
                            result.getString("content"),
                            result.getInt("votes"),
                            result.getString("date")
                    );
                result.close();
            }
            statement.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(QuestionWS.class).log(Level.SEVERE, null, ex);            
        }
        return question;
    }
       
}
