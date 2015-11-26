/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mfikria
 */
public class Util {
    
     public static Boolean isLogin(HttpServletRequest request) {
        
        ConsumerREST qr = new ConsumerREST();
        
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token") && qr.auth(cookie.getValue())) {
                     return true;
                }
            }
        }
        return false;
    }
     
     public static Boolean isAuthUser(HttpServletRequest request, int theUid) {
        
        ConsumerREST qr = new ConsumerREST(); 
        
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token") && qr.auth(cookie.getValue())) {
                    int uid = qr.getUidByToken(cookie.getValue());
                   
                    if(uid != 0 && uid == theUid) {
                        return true;
                    }
                }
            }
        }
        return false;
     }

    public static Boolean hasVotedQuestion(int qid, int uid) {
        webservice.SimpleStackExchangeWS_Service service = new webservice.SimpleStackExchangeWS_Service();
        webservice.SimpleStackExchangeWS port = service.getSimpleStackExchangeWSPort();
        return port.hasVotedQuestion(qid, uid);
    }
    
    public static Integer getUid(HttpServletRequest request) {
        ConsumerREST qr = new ConsumerREST();
        
         Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token") && qr.auth(cookie.getValue())) {
                     return qr.getUidByToken(cookie.getValue());
                }
            }
        }
        return null;
    }
    
    public static String getTokenCookie(HttpServletRequest request) {
        String token = new String();
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")) token = cookie.getValue();
            }
        }
        return token;
    }
}
