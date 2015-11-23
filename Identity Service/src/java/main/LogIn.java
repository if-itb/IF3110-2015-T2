/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
public class LogIn {
  // Atribut
  private String email;
  private String password;
  private Connection connection;
  
  // Konstruktor
  public LogIn(String email, String password) {
    try {
      // Connect database
      Database database = new Database();
      connection = database.connectDatabase();
      int idUser = getIdUser();
      if (idUser != -999999) {
        Token token = new Token(email, password);
        // Masukkan token ke basis data
        addToken(idUser, token);
      } else {
        // Kirim pesan error
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }
  
  // Method
  private int getIdUser() throws SQLException {
    int idUser = -999999;
    Statement statement = connection.createStatement();

    // Menjalankan query
    String query = "SELECT id_user, email, password FROM user WHERE email = ? AND password = ?";
    PreparedStatement databaseStatement = connection.prepareStatement(query);
    databaseStatement.setString(1, email);
    databaseStatement.setString(2, password);
    ResultSet result = databaseStatement.executeQuery(query);
    if (result.next()) {
      // Email and password matched
      idUser = result.getInt("id_user");
    }
    result.close();
    statement.close();
    return idUser;
  }
  private void addToken(int idUser, Token token) throws SQLException {
    Statement statement = connection.createStatement();

    // Menjalankan query
    String query = "UPDATE user SET token = ? AND lifetime = ? WHERE id_user = ?";
    PreparedStatement databaseStatement = connection.prepareStatement(query);
    databaseStatement.setString(1, token.getAccessToken());
    databaseStatement.setTimestamp(2, token.getLifetime());
    databaseStatement.setInt(3, idUser);
    databaseStatement.executeUpdate(query);
    statement.close();
  }
}
