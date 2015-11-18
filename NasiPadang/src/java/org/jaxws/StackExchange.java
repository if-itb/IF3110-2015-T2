/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jaxws;

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
    @WebMethod public String getQuestion(int id);
    @WebMethod public String getAllQuestion();
    @WebMethod public String getAllAnswer(int id);
    @WebMethod public boolean addQuestion(String token, String topic, String content);
    @WebMethod public boolean addAnswer(int id, String token, String content);
    @WebMethod public boolean editQuestion(int id, String token, String topic, String content);
    @WebMethod public boolean updateVoteAnswer(int id_answer, int vote);
    @WebMethod public boolean updateVoteQuestion(int id, int vote);
}