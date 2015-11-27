/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackexchange.client;

import stackexchangews.services.Question;
import stackexchangews.services.SQLException_Exception;

/**
 *
 * @author davidkwan
 */
public class Testing {

    private static int votesUpAnswer(int answerId, int answererId) throws SQLException_Exception {
        stackexchangews.services.AnswerHandler_Service service = new stackexchangews.services.AnswerHandler_Service();
        stackexchangews.services.AnswerHandler port = service.getAnswerHandlerPort();
        return port.votesUpAnswer(answerId, answererId);
    }

    private static int getQuestionId(int answerId) {
        stackexchangews.services.AnswerHandler_Service service = new stackexchangews.services.AnswerHandler_Service();
        stackexchangews.services.AnswerHandler port = service.getAnswerHandlerPort();
        return port.getQuestionId(answerId);
    }

    private static Question getQuestion(int questionId) throws SQLException_Exception {
        stackexchangews.services.QuestionHandler_Service service = new stackexchangews.services.QuestionHandler_Service();
        stackexchangews.services.QuestionHandler port = service.getQuestionHandlerPort();
        return port.getQuestion(questionId);
    }

    private static int editQuestion(int questionId, String topic, String content) throws SQLException_Exception {
        stackexchangews.services.QuestionHandler_Service service = new stackexchangews.services.QuestionHandler_Service();
        stackexchangews.services.QuestionHandler port = service.getQuestionHandlerPort();
        return port.editQuestion(questionId, topic, content);
    }

    private static int answerQuestion(int questionId, int answererId, java.lang.String content) throws SQLException_Exception {
        stackexchangews.services.AnswerHandler_Service service = new stackexchangews.services.AnswerHandler_Service();
        stackexchangews.services.AnswerHandler port = service.getAnswerHandlerPort();
        return port.answerQuestion(questionId, answererId, content);
    }

    private static int registerUser(java.lang.String email, java.lang.String password) throws SQLException_Exception {
        stackexchangews.services.UserHandler_Service service = new stackexchangews.services.UserHandler_Service();
        stackexchangews.services.UserHandler port = service.getUserHandlerPort();
        return port.registerUser(email, password);
    }
    
}
