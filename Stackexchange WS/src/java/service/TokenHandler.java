/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import QuestionModel.QuestionWS;
import UserModel.User;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Devina
 */
public class TokenHandler {
  // Konstruktor
  public TokenHandler() {
    
  }
  
  // Method
  public User getUser(String token, String urlString) {
    boolean valid = false;
    User user = null;
    
    try {
      //TODO write your implementation code here:
      
      URL url = new URL(urlString);
      HttpURLConnection connection;
      
      try {
        // Mengubah token ke dalam bentuk JSON
        JSONObject request = new JSONObject();
        try {
          request.put("token", token);
        } catch (JSONException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Setting koneksi
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", Integer.toString(request.toString().getBytes(StandardCharsets.UTF_8).length));
        connection.setUseCaches(false);
        
        // Mengirim token ke Identity Service
        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
        writer.write(request.toString().getBytes(StandardCharsets.UTF_8));
        
        // Menerima response dari Identity Service
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        String response = "";
        
        while ((inputLine = in.readLine()) != null) {
          response += inputLine;
        }
        
        try {
          JSONObject tokenResponse = new JSONObject(response);
          //result = tokenResponse.getString("token");
          valid = tokenResponse.getBoolean("validity");
          if (valid) {
            user = new User(tokenResponse.getInt("idUser"), tokenResponse.getString("name"), tokenResponse.getString("email"));
          }
        } catch (JSONException ex) {
          Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      } catch (IOException ex) {
        Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
      }
      
    } catch (MalformedURLException ex) {
      Logger.getLogger(QuestionWS.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return user;
  }
}
