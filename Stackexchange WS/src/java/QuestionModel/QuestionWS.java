/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

import UserModel.User;
import UserModel.UserWS;
import database.Database;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
@WebService(serviceName = "QuestionWS")
public class QuestionWS {
  // Atribut
  private Database database = new Database();

  /**
   * Web service operation
   */
  @WebMethod(operationName = "getQuestions")
  @WebResult(name="Question")
  public ArrayList<Question> getQuestions() {
    //TODO write your implementation code here:
    ArrayList<Question> questions = new ArrayList<Question>();
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "SELECT * FROM question ORDER BY datetime DESC";
      PreparedStatement databaseStatement = connection.prepareStatement(query);
      ResultSet result = databaseStatement.executeQuery();
      
      // Mengambil semua data hasil eksekusi query
      while (result.next()) {
        questions.add(new Question( result.getInt("id_question"),
                                    result.getString("topic"),
                                    result.getString("content"),
                                    result.getString("datetime"),
                                    result.getInt("id_user")));
      }
      
      result.close();
      statement.close();
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return questions;
  }
  
  @WebMethod(operationName = "addQuestion")
  public boolean addQuestion(@WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "token") String token) {
    //TODO write your implementation code here:
    boolean questionAdded = false;
    int userId = 0;
    UserWS user = new UserWS();
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Request User ke Identity Service dengan token
      userId = user.getUserIdByToken(token, "http://localhost:8082/Identity_Service/TokenController");
      
      if (userId > 0) {
        // Menjalankan query
        String query = "INSERT INTO question (topic, content, id_user) VALUES (?, ?, ?)";
        PreparedStatement databaseStatement = connection.prepareStatement(query);
        databaseStatement.setString(1, topic);
        databaseStatement.setString(2, content);
        databaseStatement.setInt(3, userId);
        databaseStatement.executeUpdate();

        statement.close();
        questionAdded = true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      questionAdded = false;
    }
    
    return questionAdded;
  }
  
  @WebMethod(operationName = "editQuestion")
  public boolean editQuestion(@WebParam(name = "id_question") int idQuestion, @WebParam(name = "topic") String topic, @WebParam(name = "content") String content) {
    //TODO write your implementation code here:
    boolean questionEdited;
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "UPDATE question SET topic = ?, content = ? WHERE id_question = ?";
      PreparedStatement databaseStatement = connection.prepareStatement(query);
      databaseStatement.setString(1, topic);
      databaseStatement.setString(2, content);
      databaseStatement.setInt(3, idQuestion);
      databaseStatement.executeUpdate();
      
      statement.close();
      questionEdited = true;
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      questionEdited = false;
    }
    
    return questionEdited;
  }
  
  @WebMethod(operationName = "deleteQuestion")
  public boolean deleteQuestion(@WebParam(name = "id_question") int idQuestion) {
    //TODO write your implementation code here:
    boolean questionDeleted;
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query1 = "DELETE FROM question WHERE id_question = ?";
      String query2 = "DELETE FROM answer WHERE id_question = ?";
      PreparedStatement databaseStatement1 = connection.prepareStatement(query1);
      PreparedStatement databaseStatement2 = connection.prepareStatement(query2);
      databaseStatement1.setInt(1, idQuestion);
      databaseStatement2.setInt(1, idQuestion);
      databaseStatement1.executeUpdate();
      databaseStatement2.executeUpdate();
      
      statement.close();
      questionDeleted = true;
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      questionDeleted = false;
    }
    
    return questionDeleted;
  }
  
  @WebMethod(operationName = "getQuestion")
  public ArrayList<Question> getQuestion(@WebParam(name = "id_question") int idQuestion) {
    //TODO write your implementation code here:
    ArrayList<Question> question = new ArrayList<Question>();
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "SELECT * FROM question WHERE id_question = ?";
      PreparedStatement databaseStatement = connection.prepareStatement(query);
      databaseStatement.setInt(1, idQuestion);
      ResultSet result = databaseStatement.executeQuery();
      
      // Mengambil data hasil eksekusi query
      while (result.next()) {
        question.add(new Question( result.getInt("id_question"),
                                    result.getString("topic"),
                                    result.getString("content"),
                                    result.getString("datetime"),
                                    result.getInt("id_user")));
      }
      
      result.close();
      statement.close();
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return question;
  }
}
