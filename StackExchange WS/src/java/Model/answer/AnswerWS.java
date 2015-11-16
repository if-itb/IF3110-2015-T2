/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import com.sun.istack.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Adz
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    /**
     * Connecting to Database
     * DB is another java file where DB settings is there
     */
    Connection conn = DB.connect();

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
    @WebMethod(operationName = "getAnswerByQID")
    @WebResult(name="Answer")
    public List<Answer> getAnswerByQID(@WebParam(name = "qid")
            int qid) {
        ArrayList<Answer> answers = new ArrayList<>();
        
        try{
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM answers WHERE id_quetstion = ?";
            
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, qid);
            
            ResultSet rs = dbStatement.executeQuery(sql);
            
            /* Get every data returned by SQL Query */
            int i = 0;
            while(rs.next()){
                answers.add(new Answer(rs.getInt("id"),
                                        rs.getInt("id_question"),
                                        rs.getInt("id_user"),
                                        rs.getString("content"),
                                        rs.getString("timestamp")
                ));
                i++;
            }
            
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //TODO write your implementation code here:
        return answers;
    }
}
