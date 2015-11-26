
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
     * @param uid
     * @param qid
     * @param value
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "voteQuestion", targetNamespace = "http://webservice/", className = "webservice.VoteQuestion")
    @ResponseWrapper(localName = "voteQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.VoteQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/voteQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/voteQuestionResponse")
    public Boolean voteQuestion(
        @WebParam(name = "qid", targetNamespace = "")
        int qid,
        @WebParam(name = "uid", targetNamespace = "")
        int uid,
        @WebParam(name = "value", targetNamespace = "")
        String value);

    /**
     * 
     * @param answer
     * @param token
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createAnswer", targetNamespace = "http://webservice/", className = "webservice.CreateAnswer")
    @ResponseWrapper(localName = "createAnswerResponse", targetNamespace = "http://webservice/", className = "webservice.CreateAnswerResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/createAnswerRequest", output = "http://webservice/SimpleStackExchange_WS/createAnswerResponse")
    public Boolean createAnswer(
        @WebParam(name = "token", targetNamespace = "")
        String token,
        @WebParam(name = "answer", targetNamespace = "")
        Answer answer);

    /**
     * 
     * @param question
     * @param token
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createQuestion", targetNamespace = "http://webservice/", className = "webservice.CreateQuestion")
    @ResponseWrapper(localName = "createQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.CreateQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/createQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/createQuestionResponse")
    public Boolean createQuestion(
        @WebParam(name = "token", targetNamespace = "")
        String token,
        @WebParam(name = "question", targetNamespace = "")
        Question question);

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
     * @param aid
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteAllVoteAnswer", targetNamespace = "http://webservice/", className = "webservice.DeleteAllVoteAnswer")
    @ResponseWrapper(localName = "deleteAllVoteAnswerResponse", targetNamespace = "http://webservice/", className = "webservice.DeleteAllVoteAnswerResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/deleteAllVoteAnswerRequest", output = "http://webservice/SimpleStackExchange_WS/deleteAllVoteAnswerResponse")
    public Boolean deleteAllVoteAnswer(
        @WebParam(name = "aid", targetNamespace = "")
        int aid);

    /**
     * 
     * @param qid
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteAllVoteQuestion", targetNamespace = "http://webservice/", className = "webservice.DeleteAllVoteQuestion")
    @ResponseWrapper(localName = "deleteAllVoteQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.DeleteAllVoteQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/deleteAllVoteQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/deleteAllVoteQuestionResponse")
    public Boolean deleteAllVoteQuestion(
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param qid
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVotesQuestion", targetNamespace = "http://webservice/", className = "webservice.GetVotesQuestion")
    @ResponseWrapper(localName = "getVotesQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.GetVotesQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/getVotesQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/getVotesQuestionResponse")
    public Integer getVotesQuestion(
        @WebParam(name = "qid", targetNamespace = "")
        int qid);

    /**
     * 
     * @param aid
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVotesAnswer", targetNamespace = "http://webservice/", className = "webservice.GetVotesAnswer")
    @ResponseWrapper(localName = "getVotesAnswerResponse", targetNamespace = "http://webservice/", className = "webservice.GetVotesAnswerResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/getVotesAnswerRequest", output = "http://webservice/SimpleStackExchange_WS/getVotesAnswerResponse")
    public Integer getVotesAnswer(
        @WebParam(name = "aid", targetNamespace = "")
        int aid);

    /**
     * 
     * @param uid
     * @param aid
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hasVotedAnswer", targetNamespace = "http://webservice/", className = "webservice.HasVotedAnswer")
    @ResponseWrapper(localName = "hasVotedAnswerResponse", targetNamespace = "http://webservice/", className = "webservice.HasVotedAnswerResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/hasVotedAnswerRequest", output = "http://webservice/SimpleStackExchange_WS/hasVotedAnswerResponse")
    public Boolean hasVotedAnswer(
        @WebParam(name = "aid", targetNamespace = "")
        int aid,
        @WebParam(name = "uid", targetNamespace = "")
        int uid);

    /**
     * 
     * @param uid
     * @param qid
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hasVotedQuestion", targetNamespace = "http://webservice/", className = "webservice.HasVotedQuestion")
    @ResponseWrapper(localName = "hasVotedQuestionResponse", targetNamespace = "http://webservice/", className = "webservice.HasVotedQuestionResponse")
    @Action(input = "http://webservice/SimpleStackExchange_WS/hasVotedQuestionRequest", output = "http://webservice/SimpleStackExchange_WS/hasVotedQuestionResponse")
    public Boolean hasVotedQuestion(
        @WebParam(name = "qid", targetNamespace = "")
        int qid,
        @WebParam(name = "uid", targetNamespace = "")
        int uid);

}
