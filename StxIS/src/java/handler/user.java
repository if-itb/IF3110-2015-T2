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
    
    private String email;
    private String pass;
    
    public user(){
        email= pass= "";
    }
    
    public user(String _email, String _pass){
        
        email = _email;
        pass =_pass;
    }
    

    public String getEmail(){
        return email;
    } 
    
    public String getPass(){
        return pass;
    }
    
    
    public void setEmail(String _email){
        email=_email;
    }
    
    public void setPass(String _pass){
        pass=_pass;
    }
    
    public boolean isEqual(user A){
        return ( email.equals(A.email) && pass.equals(A.pass));
    }
    
    
}
