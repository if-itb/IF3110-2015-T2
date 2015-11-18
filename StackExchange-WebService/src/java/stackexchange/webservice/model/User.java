/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.webservice.model;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fauzanrifqy
 */
@XmlRootElement(name="User")
public class User {
    @XmlElement(name="id", required=true)
    private int id;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="token", required=true)
    private String token;
    @XmlElement(name="valid", required=true)
    private boolean valid;
    
    public User(){
        id = 0;
    }
    
    public User(int id, String name, String email, String token, boolean valid){
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
        this.valid = valid;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }
}
