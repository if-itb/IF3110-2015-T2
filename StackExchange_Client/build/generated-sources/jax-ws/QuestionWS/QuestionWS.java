
package QuestionWS;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "QuestionWS", targetNamespace = "http://question.model/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface QuestionWS {


    /**
     * 
     * @param q
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "addQuestion", targetNamespace = "http://question.model/", className = "QuestionWS.AddQuestion")
    @Action(input = "http://question.model/QuestionWS/addQuestion")
    public void addQuestion(
        @WebParam(name = "q", targetNamespace = "")
        Question q);

    /**
     * 
     * @return
     *     returns java.util.List<QuestionWS.Question>
     */
    @WebMethod
    @WebResult(name = "Question", targetNamespace = "")
    @RequestWrapper(localName = "getAllQuestions", targetNamespace = "http://question.model/", className = "QuestionWS.GetAllQuestions")
    @ResponseWrapper(localName = "getAllQuestionsResponse", targetNamespace = "http://question.model/", className = "QuestionWS.GetAllQuestionsResponse")
    @Action(input = "http://question.model/QuestionWS/getAllQuestionsRequest", output = "http://question.model/QuestionWS/getAllQuestionsResponse")
    public List<Question> getAllQuestions();

    /**
     * 
     * @param questionId
     * @return
     *     returns QuestionWS.Question
     */
    @WebMethod
    @WebResult(name = "Question", targetNamespace = "")
    @RequestWrapper(localName = "getQuestion", targetNamespace = "http://question.model/", className = "QuestionWS.GetQuestion")
    @ResponseWrapper(localName = "getQuestionResponse", targetNamespace = "http://question.model/", className = "QuestionWS.GetQuestionResponse")
    @Action(input = "http://question.model/QuestionWS/getQuestionRequest", output = "http://question.model/QuestionWS/getQuestionResponse")
    public Question getQuestion(
        @WebParam(name = "question_id", targetNamespace = "")
        int questionId);

}
