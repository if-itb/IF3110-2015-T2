/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionModel;

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
  // Connect ke database
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
      
      // Mengatur koneksi
//      String urlString = "localhost:8082/TokenController";
//      URL url;
//      try {
//        url = new URL(urlString);
//        HttpURLConnection con;
//        try {
//          con = (HttpURLConnection) url.openConnection();
//          con.setRequestMethod("GET");
//          
//          // Mengirim request
//          OutputStreamWriter request = new OutputStreamWriter(con.getOutputStream());
//          request.write("token=123abc");
//          request.close();
//          
//          if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            
//            while ((inputLine = in.readLine()) != null) {
//              response.append(inputLine);
//            }
//            in.close();
//          }
//        } catch (IOException ex) {
//          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      } catch (MalformedURLException ex) {
//        Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
//      }
      
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
  public boolean addQuestion(@WebParam(name = "topic") String topic, @WebParam(name = "content") String content, @WebParam(name = "id_user") int idUser) {
    //TODO write your implementation code here:
    boolean questionAdded;
    
    try {
      // Connect database
      Connection connection = database.connectDatabase();
      Statement statement = connection.createStatement();
      
      // Menjalankan query
      String query = "INSERT INTO question (topic, content, id_user) VALUES (?, ?, ?)";
      PreparedStatement databaseStatement = connection.prepareStatement(query);
      databaseStatement.setString(1, topic);
      databaseStatement.setString(2, content);
      databaseStatement.setInt(3, idUser);
      databaseStatement.executeUpdate();
      
      statement.close();
      questionAdded = true;
    } catch (SQLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      questionAdded = false;
    }
    
    return questionAdded;
  }
  
  
  @WebMethod(operationName = "testURL")
  public String testURL(@WebParam(name = "token") String token) {
    String result = "a";
    
    try {
      //TODO write your implementation code here:
      String urlString = "http://localhost:8082/Identity_Service/TokenController";
      URL url = new URL(urlString);
      HttpURLConnection connection;
      
      try {
        JSONObject request = new JSONObject();
        try {
          request.put("token", "123abc");
        } catch (JSONException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", Integer.toString(request.toString().getBytes(StandardCharsets.UTF_8).length));
        connection.setUseCaches(false);
        
        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
        writer.write(request.toString().getBytes(StandardCharsets.UTF_8));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        String response = "";
        
        while ((inputLine = in.readLine()) != null) {
          response += inputLine;
        }
        
        try {
          JSONObject tokenResponse = new JSONObject(response);
          result = tokenResponse.getString("token");
        } catch (JSONException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      } catch (IOException ex) {
        Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    } catch (MalformedURLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return result;
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
