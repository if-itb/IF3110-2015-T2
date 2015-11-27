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
    
}
