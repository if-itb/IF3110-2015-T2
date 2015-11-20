/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.jws.WebService;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@WebService(endpointInterface = "org.jaxws.Identity")
public class IdentityImpl implements Identity{
    private Connection connection;
    private ArrayList<JSONObject> array;
    public IdentityImpl(){
         array = new ArrayList<>();
    }
    private JSONObject getJSON(String token){
        JSONObject json = null;
        for(JSONObject j : array){
            if(j.get("token").equals(token)){
                json = j;
            }
        }
        return json;
    }
    private boolean isExpired(JSONObject j){
        Date ds = new Date();
        long d0 = (long) j.get("time_start");
        long diff = ds.getTime() - d0;
        return diff/18000000 <= 0;
    }
    private String generateToken(){
        UUID token = UUID.randomUUID();
        return token.toString();
    }
    @Override
    public String createToken(int id) {
        String token = generateToken();
        JSONObject j = new JSONObject();
        Date d = new Date();
        j.put("token", token);
        j.put("id_user", id);
        j.put("time_start", d.getTime());
        j.put("lifetime", 30); // in minutes
        array.add(j);
        return token;
    }
    @Override
    public String whoIs(String token){
        JSONObject answer = new JSONObject();
        JSONObject json = getJSON(token);
        if(json != null){
            if(isExpired(json)){
                array.remove(json);
                answer.put("status", "expired");
            }
            else{
                answer.put("status", "ok");
                answer.put("id_user", json.get("id_user"));
            }
        }
        else{
            answer.put("status", "invalid");
        }
        return answer.toString();
    }
    
}
