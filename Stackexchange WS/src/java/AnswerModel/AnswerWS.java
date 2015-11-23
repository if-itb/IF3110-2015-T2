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
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
  
  /* Connecting to DB */
  /* DB is other java file where DB settings is there */
  private Database db = new Database();
  
  /**
   * Web service operation
   */
  @WebMethod(operationName = "getAnswerByQId")
  @WebResult(name = "Answer")
  public ArrayList<Answer> getAnswerByQId(@WebParam(name = "qid") int qid) {
    ArrayList<Answer> answers = new ArrayList<Answer>();
    
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
  
  @WebMethod(operationName = "addAnswer")
  public boolean addAnswer(@WebParam(name = "qid") int qid, @WebParam(name = "uid") int uid, @WebParam(name = "content") String content) {
    //TODO write your implementation code here:
    boolean isAdded;
    try {
      Connection conn = db.connectDatabase();
      String sql;
      sql = "INSERT INTO answer (id_question, id_user, content) VALUES (?,?,?)";
      PreparedStatement dbStatement = conn.prepareStatement(sql);
      dbStatement.setInt(1, qid);
      dbStatement.setInt(2, uid);
      dbStatement.setString(3, content);
      dbStatement.executeUpdate();
      isAdded = true;
    } catch (SQLException ex) {
      Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
      isAdded = false;
    }  
    return isAdded;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "getCountAnswerByQId")
  public int getCountAnswerByQId(@WebParam(name = "qid") int qid) {
    int count = 0;
    try {
      
      Connection conn = db.connectDatabase();
      Statement stmt = conn.createStatement();
      String sql;
      sql = "SELECT count(*) FROM answer WHERE id_question = ?";
      PreparedStatement dbStatement = conn.prepareStatement(sql);
      dbStatement.setInt(1, qid);
      ResultSet rs = dbStatement.executeQuery();
      
      while (rs.next()) {
        count = rs.getInt("count(*)");
      }
      
      rs.close();
      stmt.close();
      
    } catch (SQLException ex) {
      Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    return count;
  }

  
  
  
}
