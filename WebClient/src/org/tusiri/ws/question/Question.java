
package org.tusiri.ws.question;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Question", targetNamespace = "http://question.ws.tusiri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Question {


    /**
     * 
     * @return
     *     returns java.util.List<org.tusiri.ws.question.QuestionItem>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getQuestionList", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.GetQuestionList")
    @ResponseWrapper(localName = "getQuestionListResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.GetQuestionListResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/getQuestionListRequest", output = "http://question.ws.tusiri.org/Question/getQuestionListResponse")
    public List<QuestionItem> getQuestionList();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws ParseException_Exception
     * @throws IOException_Exception
     * @throws ClientProtocolException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editQuestion", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.EditQuestion")
    @ResponseWrapper(localName = "editQuestionResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.EditQuestionResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/editQuestionRequest", output = "http://question.ws.tusiri.org/Question/editQuestionResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/editQuestion/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/editQuestion/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/editQuestion/Fault/ParseException")
    })
    public int editQuestion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws ParseException_Exception
     * @throws ClientProtocolException_Exception
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createQuestion", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.CreateQuestion")
    @ResponseWrapper(localName = "createQuestionResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.CreateQuestionResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/createQuestionRequest", output = "http://question.ws.tusiri.org/Question/createQuestionResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/createQuestion/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/createQuestion/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/createQuestion/Fault/ParseException")
    })
    public int createQuestion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws ParseException_Exception
     * @throws IOException_Exception
     * @throws ClientProtocolException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteQuestion", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.DeleteQuestion")
    @ResponseWrapper(localName = "deleteQuestionResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.DeleteQuestionResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/deleteQuestionRequest", output = "http://question.ws.tusiri.org/Question/deleteQuestionResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/deleteQuestion/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/deleteQuestion/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/deleteQuestion/Fault/ParseException")
    })
    public int deleteQuestion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.tusiri.ws.question.QuestionItem
     * @throws ParseException_Exception
     * @throws ClientProtocolException_Exception
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getQuestionInfo", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.GetQuestionInfo")
    @ResponseWrapper(localName = "getQuestionInfoResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.GetQuestionInfoResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/getQuestionInfoRequest", output = "http://question.ws.tusiri.org/Question/getQuestionInfoResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/getQuestionInfo/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/getQuestionInfo/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/getQuestionInfo/Fault/ParseException")
    })
    public QuestionItem getQuestionInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws ParseException_Exception
     * @throws ClientProtocolException_Exception
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "QuestionVoteUp")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "QuestionVoteUp", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.QuestionVoteUp")
    @ResponseWrapper(localName = "QuestionVoteUpResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.QuestionVoteUpResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/QuestionVoteUpRequest", output = "http://question.ws.tusiri.org/Question/QuestionVoteUpResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteUp/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteUp/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteUp/Fault/ParseException")
    })
    public int questionVoteUp(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws ParseException_Exception
     * @throws IOException_Exception
     * @throws ClientProtocolException_Exception
     */
    @WebMethod(operationName = "QuestionVoteDown")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "QuestionVoteDown", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.QuestionVoteDown")
    @ResponseWrapper(localName = "QuestionVoteDownResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.QuestionVoteDownResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/QuestionVoteDownRequest", output = "http://question.ws.tusiri.org/Question/QuestionVoteDownResponse", fault = {
        @FaultAction(className = ClientProtocolException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteDown/Fault/ClientProtocolException"),
        @FaultAction(className = IOException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteDown/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://question.ws.tusiri.org/Question/QuestionVoteDown/Fault/ParseException")
    })
    public int questionVoteDown(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws ClientProtocolException_Exception, IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.tusiri.ws.question.QuestionItem>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchQuestion", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.SearchQuestion")
    @ResponseWrapper(localName = "searchQuestionResponse", targetNamespace = "http://question.ws.tusiri.org/", className = "org.tusiri.ws.question.SearchQuestionResponse")
    @Action(input = "http://question.ws.tusiri.org/Question/searchQuestionRequest", output = "http://question.ws.tusiri.org/Question/searchQuestionResponse")
    public List<QuestionItem> searchQuestion(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
