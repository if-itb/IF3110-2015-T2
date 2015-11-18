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
    /*
    public void setUser(int uid, String fname, String lname, String email, String pw) {
        userID = uid;
        first_name = fname;
        last_name = lname;
        this.email = email;
        password = pw;
    }
    
    public void setUID(int uid) {
        userID = uid;
    }
    
    public void setFirstName(String fname) {        
        first_name = fname;
    }
    
    public void setLastName(String lname) {
        last_name = lname;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String pw) {
        password = pw;
    }
    
    public int getUID() {
        return userID;
    }
    
    public String getFirstName() {        
        return first_name;
    }
    
    public String getLastName() {
        return last_name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    */
}
