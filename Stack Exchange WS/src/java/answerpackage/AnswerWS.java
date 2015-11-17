/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package answerpackage;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import database_console.*;
/**
 *
 * @author zulvafachrina
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {

    Connection conn; 

    public AnswerWS() throws SQLException {
        DBConnect db = new DBConnect();
        conn = db.connect();
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerById")
    @WebResult(name="Answer")
    public java.util.ArrayList<Answer> getAnswerById(@WebParam(name = "id") int id) {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        
        try {
            Statement statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Answer WHERE question_id=?";
                    
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1,id);
            
            ResultSet result = dbStatement.executeQuery();
            
           
            while(result.next()) {
               answers.add(new Answer(result.getInt("id"), result.getInt("question_id"), result.getInt("user_id"),
               result.getString("content"), result.getInt("vote"), result.getString("date"))); 
               
            }
            
            result.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
        }
        return answers;
        
    }
}
