/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import database.Database;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;

/**
 *
 * @author Devina
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
  
  /* Connecting to DB */
  /* DB is other java file where DB settings is there */
  
  
  /**
   * Web service operation
   */
  @WebMethod(operationName = "getAnswerByQId")
  @WebResult(name = "Answer")
  public ArrayList<Answer> getAnswerByQId(@WebParam(name = "qid") int qid) {
    ArrayList<Answer> answers = new ArrayList<Answer>();
    Database db = new Database();
    
    try {
      //TODO write your implementation code here:
      Connection conn = db.connectDatabase();
      Statement stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM answer WHERE id_question = ?";
      PreparedStatement dbStatement = conn.prepareStatement(sql);
      dbStatement.setInt(1, qid);
      ResultSet rs = dbStatement.executeQuery();
            
      while (rs.next()) {
        answers.add(new Answer(rs.getInt("id_answer"),rs.getString("content"), rs.getString("datetime"), rs.getInt("id_user"), rs.getInt("id_question"))); 
      }
      rs.close();
      stmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    return answers;
  }
}
