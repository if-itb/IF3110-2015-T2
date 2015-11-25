/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

/**
 *
 * @author Aidin
 */
public class user {
    private String name;
    private String email;
    private String pass;
    
    public user(){
     name = email= pass= "";
    }
    
    public String getName(){
       return name;
    }
    
    public String getEmail(){
        return email;
    } 
    
    public String getPass(){
        return pass;
    }
    
    public boolean isEqual(user A){
        
    }
}
