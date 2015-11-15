/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import org.data.Question;

/**
 *
 * @author user
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface StackExchange {
    @WebMethod public Question getQuestion(int id);
    @WebMethod public ArrayList getAllQuestion();
    @WebMethod public Boolean addQuestion(String topic, String content);
}