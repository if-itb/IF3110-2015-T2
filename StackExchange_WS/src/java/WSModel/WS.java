/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jessica
 */
@WebService(serviceName = "WS")
public class WS {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByQID")
    public ArrayList getAnswerByQID(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    
    
    
    
    
    
    
    @WebMethod(operationName = "getAllQuestion")
    public ArrayList<WSModule.QuestionClass> getAllQuestion() {
        //TODO write your implementation code here:
        return Question.getAllQuestion();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionByID")
    public Question getQuestionByID(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQuestion")
    public Boolean updateQuestion(@WebParam(name = "questionId") int questionId, @WebParam(name = "questionTitle") String questionTitle, @WebParam(name = "questionContent") String questionContent) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    public Boolean deleteQuestion(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteUpQuestion")
    public Boolean voteUpQuestion(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteDownQuestion")
    public Boolean voteDownQuestion(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteUpAnswer")
    public Boolean voteUpAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "questionId") String questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteDownAnswer")
    public Boolean voteDownAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addQuestion")
    public Boolean addQuestion(@WebParam(name = "questionTitle") String questionTitle, @WebParam(name = "questionContent") String questionContent, @WebParam(name = "voteQuestion") int voteQuestion, @WebParam(name = "questionDate") Date questionDate, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAnswer")
    public Boolean addAnswer(@WebParam(name = "question_id") int question_id, @WebParam(name = "answerContent") String answerContent, @WebParam(name = "answerVote") int answerVote, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Answer.addAnswer(question_id, answerContent, answerVote,userID);
    }
}
