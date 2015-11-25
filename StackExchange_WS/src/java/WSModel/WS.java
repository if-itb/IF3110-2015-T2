/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSModel;

import java.sql.Date;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import WSModule.AnswerClass;
import WSModel.Answer;
import WSModule.QuestionClass;
import WSModule.UserClass;
/**
 *
 * @author Jessica
 */
@WebService(serviceName = "WS")
public class WS {
    
    /************************************ Answer Class ****************************************/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAnswer")
    public Boolean addAnswer(@WebParam(name = "question_id") int question_id, @WebParam(name = "answerContent") String answerContent, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Answer.addAnswer(question_id, answerContent, userID);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByID")
    public AnswerClass getAnswerByID(@WebParam(name = "answer_id") int answer_id) {
        //TODO write your implementation code here:
        return Answer.getAnswerByID(answer_id);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerByQID")
    public ArrayList<AnswerClass> getAnswerByQID(@WebParam(name = "question_id") int question_id) {
        //TODO write your implementation code here:
        return Answer.getAnswerByQID(question_id);
    }
    
    /**
     * Web service operation
     */
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSumAnswer")
    public int getSumAnswer(@WebParam(name = "question_id") int question_id) {
        //TODO write your implementation code here:
        return Answer.getSumAnswer(question_id);
    }

     @WebMethod(operationName = "voteUpAnswer")
    public Boolean voteUpAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "questionId") int questionId, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Answer.voteUpAnswer(answerId, questionId, userID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteDownAnswer")
    public Boolean voteDownAnswer(@WebParam(name = "answerId") int answerId, @WebParam(name = "questionId") int questionId, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Answer.voteDownAnswer(answerId, questionId, userID);
    }
    
    /************************************ Question Class ****************************************/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addQuestion")
    public Boolean addQuestion(@WebParam(name = "questionTitle") String questionTitle, @WebParam(name = "questionContent") String questionContent, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Question.addQuestion(questionTitle, questionContent, userID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllQuestion")
    public ArrayList<QuestionClass> getAllQuestion() {
        //TODO write your implementation code here:
        return Question.getAllQuestion();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getQuestionByID")
    public QuestionClass getQuestionByID(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return Question.getQuestionByID(questionId);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateQuestion")
    public Boolean updateQuestion(@WebParam(name = "questionId") int questionId, @WebParam(name = "questionTitle") String questionTitle, @WebParam(name = "questionContent") String questionContent) {
        //TODO write your implementation code here:
        return Question.updateQuestion(questionId, questionTitle, questionContent);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteQuestion")
    public Boolean deleteQuestion(@WebParam(name = "questionId") int questionId) {
        //TODO write your implementation code here:
        return Question.deleteQuestion(questionId);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteUpQuestion")
    public Boolean voteUpQuestion(@WebParam(name = "questionId") int questionId, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Question.voteUpQuestion(questionId, userID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "voteDownQuestion")
    public Boolean voteDownQuestion(@WebParam(name = "questionId") int questionId, @WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return Question.voteDownQuestion(questionId, userID);
    }
    
    /************************************ User Class ****************************************/
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        return User.addUser(userName, password, email);
    }
	
	/**
     * Web service operation
     */
    @WebMethod(operationName = "getAnswerUserName")
    public String getUserName(@WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        return User.getUserName(userID);
    }
    
}