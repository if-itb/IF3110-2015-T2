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
import org.data.Answer;
import org.data.Question;
import org.json.JSONObject;

/**
 *
 * @author user
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface StackExchange {
    @WebMethod public boolean register(String username, String email, String password);
    @WebMethod public JSONObject login(String email, String password);
    @WebMethod public Question getQuestion(int id);
    @WebMethod public Question[] getAllQuestion();
    @WebMethod public Answer getAnswer(int id_answer);
    @WebMethod public Answer[] getAllAnswer(int id);
    @WebMethod public int addQuestion(String token, String topic, String content);
    @WebMethod public boolean addAnswer(int id, String token, String content);
    @WebMethod public int editQuestion(int id, String token, String topic, String content);
    @WebMethod public boolean deleteQuestion(int id, String token);
    @WebMethod public boolean updateVoteAnswer(int id_answer, int vote);
    @WebMethod public boolean updateVoteQuestion(int id, int vote);
}