/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.UUID;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Irene Wiliudarsan - 13513002
 * @author Angela Lynn - 13513032
 * @author Devina Ekawati - 13513088
 */
public class HttpServer {
    public static void main (String[] args) {
      TokenExecutor executor = new TokenExecutor("jenteda@gmail.com", "test");
      Token token = executor.getToken();
      System.out.println(token.getAccessToken() + "\n" + token.getLifetime() + "\n" + executor.getIsValid());
    }
}
