/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import QuestionModel.Question;
import QuestionModel.QuestionWS;
import DatabaseAdapter.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author user
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

    database DB = new database();
    
    Connection conn = DB.connect();
    
    @WebMethod(operationName = "getQuestionByQID")
    @WebResult(name="Question")
    public Question getQuestionByQID(@WebParam(name = "qid") int qid) {
        
        Question question = new Question();
        
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM questions where question_id = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery();
            
            rs.next();
            question = new Question(rs.getInt("question_id"), 
                                    rs.getInt("user_id"),                     
                                    rs.getString("topic"),
                                    rs.getString("content"),
                                    rs.getInt("vote"),
                                    rs.getString("time"),
                                    rs.getInt("answer_count")
                                    );
                
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
           Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }

}
