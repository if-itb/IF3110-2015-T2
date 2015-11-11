/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackexchange;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "StackExchangeWS")
public class StackExchangeWS {

  /**
   * This is a sample web service operation
   */
  @WebMethod(operationName = "hello")
  public String hello(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "operation")
  public String operation(@WebParam(name = "parameter") String parameter) {
    //TODO write your implementation code here:
    return null;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "getAnswerByQID")
  public ArrayList getAnswerByQID(@WebParam(name = "qid") int qid) {
    //TODO write your implementation code here:
    return null;
  }
}
