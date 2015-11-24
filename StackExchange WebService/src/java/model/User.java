/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jessica
 */
@XmlRootElement(name="User")
public class User {
    @XmlElement(name="u_id", required=true)
    private int uId;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="password", required=true)
    private String password;
    
    public User(){
        
    }
    
    public User(int uId, String name, String email, String password){
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the uId
     */
    public int getUId() {
        return uId;
    }

    /**
     * @param uId the uId to set
     */
    public void setUId(int uId) {
        this.uId = uId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
