package com.yangnormal.sstackex.ws;

import com.yangnormal.sstackex.ws.classes.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;


@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
    @WebMethod
    int register(String name, String email, String password);
    @WebMethod
    int postQuestion(int uid, String token, String title, String content) throws Exception;
    @WebMethod
    int postAnswer(int qid, int uid, String token, String content) throws Exception;
    @WebMethod
    int deleteQuestion(int uid, int qid, String token) throws Exception;
    @WebMethod
    Question getQuestion(int qid);
    @WebMethod
    Question[] getQuestionList();
    @WebMethod
    Answer[] getAnswerList(int qid);
    @WebMethod
    String[][] getQuestionListArray();
    @WebMethod
    String[][] getAnswerListArray(int qid);
    @WebMethod
    int vote(int type, int id, int direction, int uid, String token) throws Exception;
    @WebMethod
    String[] getQuestionArray(int qid);
    @WebMethod
    int updateQuestion(int qid, int uid, String token, String title, String content) throws Exception;
    @WebMethod
    int updateAnswer(int aid, int qid, int uid, String token, String content) throws Exception;
}
