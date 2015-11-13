/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import database.DB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;

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
    @WebResult(name="Question")
    public Question getQuestionById(@WebParam(name = "id") int id) {
        Question question = null;
        
        try {
            Statement st = conn.createStatement();
            String query;
            query = "SELECT * FROM questions WHERE q_id = ?";
            
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            
            ResultSet res = pst.executeQuery();
            
            if (res.next())
                question = new Question(res.getInt("q_id"),
                                        res.getString("q_topic"),
                                        res.getString("q_content"),
                                        res.getString("q_name"),
                                        res.getString("q_datetime"),
                                        res.getInt("q_vote"));
            
            res.close();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return question;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createQuestion")
    @WebResult(name="Success")
    public int createQuestion(@WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "name") String name, @WebParam(name = "email") String email) {
        
        try {
            Statement st = conn.createStatement();
            String query = "INSERT INTO `questions` VALUES (?, ?, ?, ?)";
            
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, topic);
            pst.setString(2, content);
            pst.setString(3, name);
            pst.setString(4, email);
            
            pst.executeQuery();
     
            pst.close();
            st.close();
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }
}
