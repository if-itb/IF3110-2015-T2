/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

/**
 *
 * @author FiqieUlya
 */
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Auth {
    private final String url = "http://localhost:27300/StackExchangeAuth/validateToken";
    // HTTP POST request
	public Boolean checkToken(String token) {
            Boolean status= false;
            try { 
                String charset = "UTF-8";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("Accept-Charset", charset);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
                
                String query = String.format("token_string=%s",
                        URLEncoder.encode(token, charset));
                try (OutputStream output = con.getOutputStream()) {
                    output.write(query.getBytes(charset));
                }
                InputStream response = con.getInputStream();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (con.getInputStream())));
                
                String output,result="";
                // System.err.println(br.readLine());
                
                while ((output = br.readLine()) != null) {
                    if(isStatus(output)){
                        output = output.substring(8);
                        if(output.startsWith("t")){
                            status=true;
                        }
                    } 
                }
                con.disconnect();   
            } catch (MalformedURLException ex) {
                Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(status);
            return status;
        }
        public static void main (String [] args) throws IOException{
            Auth a = new Auth();
            String abc = "de88a902-df69-474f-8f7a-4fab9b79b815";
            a.checkToken(abc);
        }
        private boolean isStatus(String s) {
            return s.startsWith("<status>");
        }
       
}
