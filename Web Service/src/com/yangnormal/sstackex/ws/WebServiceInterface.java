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
    void postQuestion(int uid, String token, String title, String content) throws Exception;
    @WebMethod
    void postAnswer(int qid, int uid, String token, String content) throws Exception;
    @WebMethod
    void deleteQuestion(int uid, int qid, String token) throws Exception;
    @WebMethod
    Question getQuestion(int qid);
    @WebMethod
    String[][] getQuestionList();
    @WebMethod
    String[][] getAnswerList(int qid);
    @WebMethod
    void vote(int type, int id, int direction, int uid, String token) throws Exception;
    @WebMethod
    String[] getQuestionArray(int qid);
    @WebMethod
    void updateQuestion(int qid, int uid, String token, String title, String content) throws Exception;
    @WebMethod
    void updateAnswer(int aid, int qid, int uid, String token, String content) throws Exception;
}
