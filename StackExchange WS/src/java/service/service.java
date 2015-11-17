/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author zainelwati
 */
@WebService(serviceName = "service")
public class service {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "topik")
    public String topik() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "content")
    public String content() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "question_id")
    public String question_id() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "user_id")
    public String user_id() {
        //TODO write your implementation code here:
        return null;
    }
}
