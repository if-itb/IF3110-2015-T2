/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

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

/**
 *
 * @author Ahmad Naufal Farhan
 */
@WebService(serviceName = "AnswersWS")
public class AnswersWS {

    Connection conn = DB.getConnection();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswersByQid")
    public List getAnswersByQid(@WebParam(name = "qid") int qid) {
        //TODO write your implementation code here:
        List<Answer> answers = new ArrayList<>();
        
        try (Statement st = conn.createStatement()) {
            
            String query = "SELECT * FROM `answers` WHERE qid = ?";
                
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, qid);
               
            try (ResultSet res = pst.executeQuery()) {
                // get the questions
                while (res.next()) {
                    answers.add(new Answer(res.getInt("id"),
                                            res.getInt("uid"),
                                            res.getInt("qid"),
                                            res.getString("content"),
                                            res.getString("timestamp")));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnswersWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;
    }
}
