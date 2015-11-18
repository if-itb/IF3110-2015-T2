/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import connection.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
/**
 *
 * @author Venny
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
    
    Connection conn = DB.connect();
   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswersByQid")
    @WebResult(name="Answer")
    public void getAnswersByQid (@WebParam(name = "question_id") int question_id) {
        try{
            Statement stmt = conn.createStatement();
            String sql;
            // INI BELOM SELESAI
        } catch (SQLException ex) {
            Logger.getLogger(AnswerWS.class.getName()).log
            (Level.SEVERE, null, ex);
           }
    }
}
