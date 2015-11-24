
package model.answer;

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
@WebService(name = "AnswerWS", targetNamespace = "http://answer.model/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AnswerWS {


    /**
     * 
     * @param a
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "addAnswer", targetNamespace = "http://answer.model/", className = "model.answer.AddAnswer")
    @Action(input = "http://answer.model/AnswerWS/addAnswer")
    public void addAnswer(
        @WebParam(name = "a", targetNamespace = "")
        Answer a);

    /**
     * 
     * @param questionId
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "Answer", targetNamespace = "")
    @RequestWrapper(localName = "getAnswerCount", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswerCount")
    @ResponseWrapper(localName = "getAnswerCountResponse", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswerCountResponse")
    @Action(input = "http://answer.model/AnswerWS/getAnswerCountRequest", output = "http://answer.model/AnswerWS/getAnswerCountResponse")
    public int getAnswerCount(
        @WebParam(name = "question_id", targetNamespace = "")
        int questionId);

    /**
     * 
     * @param questionId
     * @return
     *     returns java.util.List<model.answer.Answer>
     */
    @WebMethod
    @WebResult(name = "Answer", targetNamespace = "")
    @RequestWrapper(localName = "getAnswersByQID", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswersByQID")
    @ResponseWrapper(localName = "getAnswersByQIDResponse", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswersByQIDResponse")
    @Action(input = "http://answer.model/AnswerWS/getAnswersByQIDRequest", output = "http://answer.model/AnswerWS/getAnswersByQIDResponse")
    public List<Answer> getAnswersByQID(
        @WebParam(name = "question_id", targetNamespace = "")
        int questionId);

    /**
     * 
     * @param answerId
     * @return
     *     returns model.answer.Answer
     */
    @WebMethod
    @WebResult(name = "Answer", targetNamespace = "")
    @RequestWrapper(localName = "getAnswerByID", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswerByID")
    @ResponseWrapper(localName = "getAnswerByIDResponse", targetNamespace = "http://answer.model/", className = "model.answer.GetAnswerByIDResponse")
    @Action(input = "http://answer.model/AnswerWS/getAnswerByIDRequest", output = "http://answer.model/AnswerWS/getAnswerByIDResponse")
    public Answer getAnswerByID(
        @WebParam(name = "answer_id", targetNamespace = "")
        int answerId);

}
