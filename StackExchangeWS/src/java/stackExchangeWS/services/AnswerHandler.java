/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackExchangeWS.services;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import stackExchangeWS.database.Answer;
import stackExchangeWS.database.DbAnswerManager;

/**
 *
 * @author davidkwan
 */
@WebService(serviceName = "AnswerHandler")
public class AnswerHandler {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "answer")
    public int answer(@WebParam(name = "questionId") int questionId, @WebParam(name = "answererId") int answererId, @WebParam(name = "content") String content) throws SQLException {
        //TODO write your implementation code here:
        Answer answer = new Answer();
        
        answer.setQuestionId(questionId);
        answer.setAnswererId(answererId);
        answer.setContent(content);
        
        DbAnswerManager.answer(questionId, answer);
        
        return 1;
    }

    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "votesUpAnswer")
    public int votesUpAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "answererId") int answererId) throws SQLException {
        //TODO write your implementation code here:
        DbAnswerManager.voteAnswer(answerId, answererId, 1);
        
        return 1;
    }
    
        /**
     * Web service operation
     */
    @WebMethod(operationName = "votesDownAnswer")
    public int votesDownAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "answererId") int answererId) throws SQLException {
        //TODO write your implementation code here:
        DbAnswerManager.voteAnswer(answerId, answererId, -1);
        
        return 1;
    }
    
    
}
