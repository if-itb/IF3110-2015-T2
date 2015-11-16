/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.stackx;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.me.stackx.model.QuestionModel;

/**
 *
 * @author natanelia
 */
@WebService(serviceName = "StackxWS")
public class StackxWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createQuestion")
    public boolean createQuestion(@WebParam(name = "access_token") String access_token, @WebParam(name = "title") String title, @WebParam(name = "content") String content) {
        return QuestionModel.create(access_token, title, content);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestions")
    public Question[] getQuestions() {
        //TODO write your implementation code here:
        return QuestionModel.getAll();
    }

    /**
     * Web service operation
     * @param id
     * @return Question with the id
     */
    @WebMethod(operationName = "getQuestionById")
    public Question getQuestionById(@WebParam(name = "id") final int id) {
        return QuestionModel.getById(id);
    }
}
