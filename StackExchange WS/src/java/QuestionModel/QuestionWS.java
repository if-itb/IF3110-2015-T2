/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Database.DB;
import javax.jws.Oneway;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {

  /* Connecting to Database */
  /* MANDATORY */
  Connection conn = DB.connect();  
  
  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "hello")
  public String hello(@WebParam(name = "name") String txt) {
    int ret = -1;
    try {      
      Statement stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM questions WHERE topic = ?";
      PreparedStatement dbStatement = conn.prepareStatement(sql);
      dbStatement.setString(1, txt);
      
      ResultSet rs = dbStatement.executeQuery();
      
      // Extract data from result set
      while(rs.next()){
        //Retrieve by column name
        int id = rs.getInt("id");
        
        ret = id;   
      }
      
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Yea its:" + ret;
  }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    @Oneway
    public void deleteQuestion(@WebParam(name = "id") int id) {
        try {
            Statement stmt = conn.createStatement();
            String sql;
            
            sql = "DELETE FROM questions WHERE id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, id);
            
            dbStatement.executeUpdate();
            
            stmt.close();
        } catch(SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertQuestion")
    @Oneway
    public void insertQuestion(@WebParam(name = "question") Question question) {
        try {
            Statement stmt = conn.createStatement();
            String sql;
            
            sql = "INSERT INTO questions (id_user, topic, content) VALUES (?, ?, ?)";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setInt(1, question.getIdUser());
            dbStatement.setString(2, question.getTopic());
            dbStatement.setString(3, question.getContent());
            dbStatement.executeUpdate();
            
            stmt.close();
        } catch(SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQuestion")
    @Oneway
    public void updateQuestion(@WebParam(name = "question") Question question) {
        try {
            Statement stmt = conn.createStatement();
            String sql;
            
            sql = "UPDATE questions SET topic = ?, content = ? WHERE id = ?";
            PreparedStatement dbStatement = conn.prepareStatement(sql);
            dbStatement.setString(1, question.getTopic());
            dbStatement.setString(2, question.getContent());
            dbStatement.setInt(3, question.getId());
            
            dbStatement.executeUpdate();
            
            stmt.close();
        } catch(SQLException ex) {
            Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
