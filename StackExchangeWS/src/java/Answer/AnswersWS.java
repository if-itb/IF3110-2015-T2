/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Answer;

import database.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mochamadtry
 */
@WebService(serviceName = "AnswersWS")
public class AnswersWS {
    Connection conn = DB.getConnection();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "createAnswer")
    //@WebResult
    public int createAnswer(@WebParam(name = "access_token") String access_token, @WebParam(name = "q_id") String q_id, @WebParam(name = "content") String content) {
         try {
            Statement st = conn.createStatement();
            String query = "INSERT INTO answers(a_name, a_email, a_qid, a_content, a_vote) VALUES (?, ?, ?, ?, ?)";
            
            // set the prepared statement by the query and enter the value of where clause
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "null");
            pst.setString(2, "null");
            pst.setString(3, q_id);
            pst.setString(4, content);
            
            pst.setInt(5, 0);
            
            //pst.setString(3, name);
            //pst.setString(4, email);
            
            pst.executeUpdate();
     
            pst.close();
            st.close();
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AnswersWS.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}