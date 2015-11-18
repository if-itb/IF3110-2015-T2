/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

/**
 *
 * @author Venny
 */

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class User {
    
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="password", required=true)
    private String password;
    @XmlElement(name="token", required=true)
    private String token;
    @XmlElement(name="user_id", required=false)
    private int user_id;
    
    public User(){
        user_id=0;
        name="";
        email="";
        password="";
        token="";
    }
    
    public User(int user_id, String name, String email, String password, String token){
        this.name = name;
        this.email = email;
        this.password = password;
        this.token = token;
        this.user_id = user_id;
    }
}
