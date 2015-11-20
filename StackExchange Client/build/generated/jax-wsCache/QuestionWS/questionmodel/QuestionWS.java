
package questionmodel;

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
@WebService(name = "QuestionWS", targetNamespace = "http://QuestionModel/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface QuestionWS {


    /**
     * 
     * @param title
     * @param content
     * @param token
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createQuestion", targetNamespace = "http://QuestionModel/", className = "questionmodel.CreateQuestion")
    @ResponseWrapper(localName = "createQuestionResponse", targetNamespace = "http://QuestionModel/", className = "questionmodel.CreateQuestionResponse")
    @Action(input = "http://QuestionModel/QuestionWS/createQuestionRequest", output = "http://QuestionModel/QuestionWS/createQuestionResponse")
    public int createQuestion(
        @WebParam(name = "token", targetNamespace = "")
        String token,
        @WebParam(name = "title", targetNamespace = "")
        String title,
        @WebParam(name = "content", targetNamespace = "")
        String content);

}
