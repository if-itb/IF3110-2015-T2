
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Answer_QNAME = new QName("http://webservice/", "answer");
    private final static QName _GetAnswers_QNAME = new QName("http://webservice/", "getAnswers");
    private final static QName _GetAnswersResponse_QNAME = new QName("http://webservice/", "getAnswersResponse");
    private final static QName _GetQuestion_QNAME = new QName("http://webservice/", "getQuestion");
    private final static QName _GetQuestionResponse_QNAME = new QName("http://webservice/", "getQuestionResponse");
    private final static QName _GetUserById_QNAME = new QName("http://webservice/", "getUserById");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://webservice/", "getUserByIdResponse");
    private final static QName _ListQuestion_QNAME = new QName("http://webservice/", "listQuestion");
    private final static QName _ListQuestionResponse_QNAME = new QName("http://webservice/", "listQuestionResponse");
    private final static QName _Question_QNAME = new QName("http://webservice/", "question");
    private final static QName _Registereduser_QNAME = new QName("http://webservice/", "registereduser");
    private final static QName _SearchQuestion_QNAME = new QName("http://webservice/", "searchQuestion");
    private final static QName _SearchQuestionResponse_QNAME = new QName("http://webservice/", "searchQuestionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link GetAnswers }
     * 
     */
    public GetAnswers createGetAnswers() {
        return new GetAnswers();
    }

    /**
     * Create an instance of {@link GetAnswersResponse }
     * 
     */
    public GetAnswersResponse createGetAnswersResponse() {
        return new GetAnswersResponse();
    }

    /**
     * Create an instance of {@link GetQuestion }
     * 
     */
    public GetQuestion createGetQuestion() {
        return new GetQuestion();
    }

    /**
     * Create an instance of {@link GetQuestionResponse }
     * 
     */
    public GetQuestionResponse createGetQuestionResponse() {
        return new GetQuestionResponse();
    }

    /**
     * Create an instance of {@link GetUserById }
     * 
     */
    public GetUserById createGetUserById() {
        return new GetUserById();
    }

    /**
     * Create an instance of {@link GetUserByIdResponse }
     * 
     */
    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    /**
     * Create an instance of {@link ListQuestion }
     * 
     */
    public ListQuestion createListQuestion() {
        return new ListQuestion();
    }

    /**
     * Create an instance of {@link ListQuestionResponse }
     * 
     */
    public ListQuestionResponse createListQuestionResponse() {
        return new ListQuestionResponse();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link Registereduser }
     * 
     */
    public Registereduser createRegistereduser() {
        return new Registereduser();
    }

    /**
     * Create an instance of {@link SearchQuestion }
     * 
     */
    public SearchQuestion createSearchQuestion() {
        return new SearchQuestion();
    }

    /**
     * Create an instance of {@link SearchQuestionResponse }
     * 
     */
    public SearchQuestionResponse createSearchQuestionResponse() {
        return new SearchQuestionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Answer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "answer")
    public JAXBElement<Answer> createAnswer(Answer value) {
        return new JAXBElement<Answer>(_Answer_QNAME, Answer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAnswers")
    public JAXBElement<GetAnswers> createGetAnswers(GetAnswers value) {
        return new JAXBElement<GetAnswers>(_GetAnswers_QNAME, GetAnswers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getAnswersResponse")
    public JAXBElement<GetAnswersResponse> createGetAnswersResponse(GetAnswersResponse value) {
        return new JAXBElement<GetAnswersResponse>(_GetAnswersResponse_QNAME, GetAnswersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getQuestion")
    public JAXBElement<GetQuestion> createGetQuestion(GetQuestion value) {
        return new JAXBElement<GetQuestion>(_GetQuestion_QNAME, GetQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getQuestionResponse")
    public JAXBElement<GetQuestionResponse> createGetQuestionResponse(GetQuestionResponse value) {
        return new JAXBElement<GetQuestionResponse>(_GetQuestionResponse_QNAME, GetQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getUserById")
    public JAXBElement<GetUserById> createGetUserById(GetUserById value) {
        return new JAXBElement<GetUserById>(_GetUserById_QNAME, GetUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getUserByIdResponse")
    public JAXBElement<GetUserByIdResponse> createGetUserByIdResponse(GetUserByIdResponse value) {
        return new JAXBElement<GetUserByIdResponse>(_GetUserByIdResponse_QNAME, GetUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "listQuestion")
    public JAXBElement<ListQuestion> createListQuestion(ListQuestion value) {
        return new JAXBElement<ListQuestion>(_ListQuestion_QNAME, ListQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "listQuestionResponse")
    public JAXBElement<ListQuestionResponse> createListQuestionResponse(ListQuestionResponse value) {
        return new JAXBElement<ListQuestionResponse>(_ListQuestionResponse_QNAME, ListQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "question")
    public JAXBElement<Question> createQuestion(Question value) {
        return new JAXBElement<Question>(_Question_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registereduser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "registereduser")
    public JAXBElement<Registereduser> createRegistereduser(Registereduser value) {
        return new JAXBElement<Registereduser>(_Registereduser_QNAME, Registereduser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "searchQuestion")
    public JAXBElement<SearchQuestion> createSearchQuestion(SearchQuestion value) {
        return new JAXBElement<SearchQuestion>(_SearchQuestion_QNAME, SearchQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "searchQuestionResponse")
    public JAXBElement<SearchQuestionResponse> createSearchQuestionResponse(SearchQuestionResponse value) {
        return new JAXBElement<SearchQuestionResponse>(_SearchQuestionResponse_QNAME, SearchQuestionResponse.class, null, value);
    }

}
