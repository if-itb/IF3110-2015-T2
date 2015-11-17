/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import javax.xml.bind.annotation.*;

/**
 *
 * @author user
 */
@XmlRootElement(name = "User")
public class User {
    @XmlElement(name="userid", required=true)
    private int userID;
    @XmlElement(name="firstname", required=true)
    private String first_name;
    @XmlElement(name="lastname", required=true)
    private String last_name;
    @XmlElement(name="email", required=true)
    private String email;
    @XmlElement(name="password", required=true)
    private String password;
    
    public User() {
        userID = 0;
    }
    
    public User(int uid, String fname, String lname, String email, String pw) {
        userID = uid;
        first_name = fname;
        last_name = lname;
        this.email = email;
        password = pw;
    }
}
