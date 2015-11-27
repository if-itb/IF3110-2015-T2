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
public class NewClass {

    private static java.util.List<stackexchangews.services.Question> getAllQuestions() throws SQLException_Exception {
        stackexchangews.services.QuestionHandler_Service service = new stackexchangews.services.QuestionHandler_Service();
        stackexchangews.services.QuestionHandler port = service.getQuestionHandlerPort();
        return port.getAllQuestions();
    }

    private static Question getQuestion(int questionId) throws SQLException_Exception {
        stackexchangews.services.QuestionHandler_Service service = new stackexchangews.services.QuestionHandler_Service();
        stackexchangews.services.QuestionHandler port = service.getQuestionHandlerPort();
        return port.getQuestion(questionId);
    }
    
}
