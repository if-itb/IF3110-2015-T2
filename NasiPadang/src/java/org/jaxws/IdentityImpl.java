/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

import javax.jws.WebService;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@WebService(endpointInterface = "org.jaxws.Identity")
public class IdentityImpl implements Identity{
    @Override
    public String identityService(String email, String password) {
        String token = "";
        int lifetime = 30;
        JSONObject j = new JSONObject();
        j.put("token", token);
        j.put("lifetime", lifetime);
        return j.toString();
    }
    
}
