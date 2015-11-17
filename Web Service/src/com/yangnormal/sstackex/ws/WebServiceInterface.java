package com.yangnormal.sstackex.ws;

import com.yangnormal.sstackex.ws.classes.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
    @WebMethod
    int register(String name, String email, String password);
    @WebMethod
    void postQuestion(String token);
    @WebMethod
    void postAnswer(int qid, String token);
    @WebMethod
    void deleteQuestion(int qid, String token);
    @WebMethod
    Question getQuestion(int qid);
    @WebMethod
    String[][] getQuestionList();
    @WebMethod
    String[][] getAnswerList(int qid);
    @WebMethod
    void vote(int qid, int direction);
}
