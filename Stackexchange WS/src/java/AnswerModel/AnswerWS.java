/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnswerModel;

import UserModel.User;
import database.Database;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;
import service.TokenHandler;

/**
 *
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
@WebService(serviceName = "AnswerWS")
public class AnswerWS {
  
  private Database db = new Database();
  private TokenHandler _tokenHandler = new TokenHandler();
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
  public boolean addAnswer(@WebParam(name = "qid") int qid, @WebParam(name = "token") String token, @WebParam(name = "content") String content) {
    //TODO write your implementation code here:
    boolean isAdded = false;
    User u;
    try {
      Connection conn = db.connectDatabase();
      
      // Request User ke Identity Service
      String urlString = "http://localhost:8082/Identity_Service/TokenController";
      u = _tokenHandler.getUser(token,urlString);
      if (u != null) {
        String sql;
        sql = "INSERT INTO answer (id_question, id_user, content) VALUES (?,?,?)";
        PreparedStatement dbStatement = conn.prepareStatement(sql);
        dbStatement.setInt(1, qid);
        dbStatement.setInt(2, u.getIdUser());
        dbStatement.setString(3, content);
        dbStatement.executeUpdate();
        isAdded = true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(AnswerWS.class.getName()).log(Level.SEVERE, null, ex);
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
