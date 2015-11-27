/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackExchange;

import java.sql.Timestamp;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author adar
 */
@WebService(serviceName = "Answers")
@Stateless()
public class Answers {

    public int id;
    public int id_question;
    public int id_user;
    public String content;
    public Timestamp timepost;
    
    public Answers(int _id, int _id_question,  int _id_user, String _content, Timestamp _timepost){
        id=_id;
        id_question=_id_question;
        id_user=_id_user;
        content=_content;
        timepost=_timepost;
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getID")
    public int getID(@WebParam(name = "_id") int _id) {
        return id;
    }
    
    @WebMethod(operationName = "getIDQuestion")
    public int getIDQuestion() {
        return id_question;
    }
    
    @WebMethod(operationName = "getIDUser")
    public int getIDUser() {
        return id_user;
    }
    
    @WebMethod(operationName = "getContent")
    public String getContent() {
        return content;
    }
    
    @WebMethod(operationName = "getTimePost")
    public Timestamp getTimePost() {
        return timepost;
    }
    
    @WebMethod(operationName = "setID")
    public void setID(@WebParam(name = "_id") int _id) {
        id = _id;
    }
    
    @WebMethod(operationName = "setIDQuestion")
    public void setIDQuestion(@WebParam(name = "_id_question") int _id_question) {
        id_question = _id_question;
    }
    
    @WebMethod(operationName = "setIDUser")
    public void setIDUser(@WebParam(name = "_id_user") int _id_user) {
        id_user = _id_user;
    }
    
    @WebMethod(operationName = "setContent")
    public void setContent(@WebParam(name = "_content") String _content) {
        content = _content;
    }
    
    @WebMethod(operationName = "setTimepost")
    public void setTimepost(@WebParam(name = "_timepost") Timestamp _timepost) {
        timepost = _timepost;
    }
}
