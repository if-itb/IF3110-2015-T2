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
      String token = UUID.randomUUID().toString();
      UUID token2 = UUID.randomUUID();
      //System.out.println("Token: " + token2);
      //System.out.println("Time: " + token2.timestamp());
      Date date1 = new Date();
      System.out.println(date1.toString());
      Date dateDetail = new Date(System.currentTimeMillis()+10*60*1000);
      System.out.println(dateDetail.toString());
      Timestamp timeDetail = new Timestamp(dateDetail.getTime());
      System.out.println(timeDetail);
      
      DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
Date dateobj = new Date();
System.out.println(df.format(dateobj));

      String detail = "13513022@std.stei.itb.ac.id123lala" + timeDetail.toString();
      UUID detailToken = UUID.nameUUIDFromBytes(detail.getBytes());
      System.out.println("Token: "+detailToken);
      System.out.println("Time: "+detailToken.toString().matches("[0-9a-fA-F]{8}(?:-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}"));
      System.out.println("Time: "+detailToken.toString().matches("/^[0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{12}$/i"));
      
      //System.out.println(UUID.fromString("lala"));
      //System.out.println(UUID.hashCode())
    }
}
