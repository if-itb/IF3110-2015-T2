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
@WebService(serviceName = "Questions")
@Stateless()
public class Questions {

    public int id;
    public int id_user;
    public String topic;
    public String content;
    public Timestamp timepost;
  
    public Questions(){
        id=0;
        id_user=0;
        topic=null;
        content=null;
		timepost=null;
    }
    
    public Questions(int _id, int _id_user, String _topic, String _content, Timestamp _timepost){
        id=_id;
        id_user=_id_user;
        topic=_topic;
	content =_content;
        timepost =_timepost;
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "setQuestions")
    public void setQuestions(@WebParam(name = "_id") int _id, @WebParam(name = "_id_user") int _id_user, @WebParam(name = "_topic") String _topic, @WebParam(name = "_content") String _content, @WebParam(name = "_timepost") Timestamp _timepost) {
        id=_id;
        id_user=_id_user;
        topic=_topic;
        content=_content;
	timepost=_timepost;
    }
}
