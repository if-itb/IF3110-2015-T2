
package webservice;

import java.util.List;
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
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SimpleStackExchange_WS", targetNamespace = "http://webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SimpleStackExchangeWS {


    /**
     * 
     * @return
     *     returns java.util.List<webservice.Question>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listQuestion", targetNamespace = "http://webservice/", className = "webservice.ListQuestion")
    @ResponseWrapper(localName = "listQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.ListQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/listQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/listQuestionResponse")
    public List<Question> listQuestion();

    /**
     * 
     * @param keyword
     * @return
     *     returns java.util.List<webservice.Question>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchQuestion", targetNamespace = "http://webservice/", className = "webservice.SearchQuestion")
    @ResponseWrapper(localName = "searchQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.SearchQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/searchQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/searchQuestionResponse")
    public List<Question> searchQuestion(
        @WebParam(name = "keyword", targetNamespace = "")
        String keyword);

    /**
     * 
     * @param question
     * @param token
     */
    @WebMethod
    @RequestWrapper(localName = "createQuestion", targetNamespace = "http://webservice/", className = "webservice.CreateQuestion")
    @ResponseWrapper(localName = "createQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.CreateQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/createQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/createQuestionResponse")
    public void createQuestion(
        @WebParam(name = "token", targetNamespace = "")
        String token,
        @WebParam(name = "question", targetNamespace = "")
        Question question);

    /**
     * 
     * @param uid
     * @return
     *     returns webservice.Registereduser
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://webservice/", className = "webservice.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://webservice/", className = "webservice.GetUserByIdResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/getUserByIdRequest", output = "http://webservice/SimpleStackExchange_WS/getUserByIdResponse")
    public Registereduser getUserById(
        @WebParam(name = "uid", targetNamespace = "")
        int uid);

    /**
     * 
     * @param email
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkEmailUser", targetNamespace = "http://webservice/", className = "webservice.CheckEmailUser")
    @ResponseWrapper(localName = "checkEmailUserResponse", targetNamespace = "http://webservice/", className = "webservice.CheckEmailUserResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/checkEmailUserRequest", output = "http://webservice/SimpleStackExchange_WS/checkEmailUserResponse")
    public Boolean checkEmailUser(
        @WebParam(name = "email", targetNamespace = "")
        String email);

    /**
     * 
     * @param qid
     * @return
     *     returns webservice.Question
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getQuestion", targetNamespace = "http://webservice/", className = "webservice.GetQuestion")
    @ResponseWrapper(localName = "getQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.GetQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/getQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/getQuestionResponse")
    public Question getQuestion(
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param qid
     * @return
     *     returns java.util.List<webservice.Answer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAnswers", targetNamespace = "http://webservice/", className = "webservice.GetAnswers")
    @ResponseWrapper(localName = "getAnswersResponse", targetNamespace = "http://webservice/", className = "webservice.GetAnswersResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/getAnswersRequest", output = "http://webservice/SimpleStackExchange_WS/getAnswersResponse")
    public List<Answer> getAnswers(
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param user
     */
    @WebMethod
    @RequestWrapper(localName = "createUser", targetNamespace = "http://webservice/", className = "webservice.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://webservice/", className = "webservice.CreateUserResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/createUserRequest", output = "http://webservice/SimpleStackExchange_WS/createUserResponse")
    public void createUser(
        @WebParam(name = "user", targetNamespace = "")
        Registereduser user);

}
