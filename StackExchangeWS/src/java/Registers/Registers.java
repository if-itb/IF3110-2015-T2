/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registers;

import javax.xml.bind.annotation.*;
//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mochamadtry
 */
@XmlRootElement(name="Register")
public class Registers {
    @XmlElement(name="r_id", required=true)
    private int r_id;
    @XmlElement(name="r_name", required=true)
    private String r_name;
    @XmlElement(name="r_email", required=true)
    private String r_email;
    @XmlElement(name="r_password", required=true)
    private String r_password;
    
        /**
     * Constructor for Register
     */
    public Registers() {
       r_id = 0;
    }
    
    public Registers(int _id, String _name, String _email, String _timestamp) {
        r_id = _id;
        //a_content = _content;
        r_name = _name;
        r_email = _email;
        r_password = _timestamp;
        
    }

    /**
     * @return the r_id
     */
    public int getId() {
        return r_id;
    }

 
    /**
     * @return the r_name
     */
    public String getName() {
        return r_name;
    }

    /**
     * @return the q_email
     */
    public String getEmail() {
        return r_email;
    }
    
     /**
     * @return the q_datetime
     */
    /*public String getDatetime() {
        return a_datetime;
    }

    /**
     * @return the q_vote
     */
    public String getPassword() {
        return r_password;
    }
    
}
