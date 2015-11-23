
package com.dazzlesquad.question_package;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dazzlesquad.question_package package. 
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

    private final static QName _DeleteQuestion_QNAME = new QName("http://question_package.dazzlesquad.com/", "deleteQuestion");
    private final static QName _Answer_QNAME = new QName("http://question_package.dazzlesquad.com/", "Answer");
    private final static QName _DeleteQuestionResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "deleteQuestionResponse");
    private final static QName _GetQuestionById_QNAME = new QName("http://question_package.dazzlesquad.com/", "getQuestionById");
    private final static QName _InsertQuestion_QNAME = new QName("http://question_package.dazzlesquad.com/", "insertQuestion");
    private final static QName _InsertQuestionResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "insertQuestionResponse");
    private final static QName _EditQuestion_QNAME = new QName("http://question_package.dazzlesquad.com/", "editQuestion");
    private final static QName _EditQuestionResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "editQuestionResponse");
    private final static QName _ShowAllQuestion_QNAME = new QName("http://question_package.dazzlesquad.com/", "showAllQuestion");
    private final static QName _Hello_QNAME = new QName("http://question_package.dazzlesquad.com/", "hello");
    private final static QName _GetQuestionByIdResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "getQuestionByIdResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "helloResponse");
    private final static QName _ShowAllQuestionResponse_QNAME = new QName("http://question_package.dazzlesquad.com/", "showAllQuestionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dazzlesquad.question_package
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteQuestion }
     * 
     */
    public DeleteQuestion createDeleteQuestion() {
        return new DeleteQuestion();
    }

    /**
     * Create an instance of {@link DeleteQuestionResponse }
     * 
     */
    public DeleteQuestionResponse createDeleteQuestionResponse() {
        return new DeleteQuestionResponse();
    }

    /**
     * Create an instance of {@link GetQuestionById }
     * 
     */
    public GetQuestionById createGetQuestionById() {
        return new GetQuestionById();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link InsertQuestion }
     * 
     */
    public InsertQuestion createInsertQuestion() {
        return new InsertQuestion();
    }

    /**
     * Create an instance of {@link InsertQuestionResponse }
     * 
     */
    public InsertQuestionResponse createInsertQuestionResponse() {
        return new InsertQuestionResponse();
    }

    /**
     * Create an instance of {@link EditQuestion }
     * 
     */
    public EditQuestion createEditQuestion() {
        return new EditQuestion();
    }

    /**
     * Create an instance of {@link EditQuestionResponse }
     * 
     */
    public EditQuestionResponse createEditQuestionResponse() {
        return new EditQuestionResponse();
    }

    /**
     * Create an instance of {@link ShowAllQuestion }
     * 
     */
    public ShowAllQuestion createShowAllQuestion() {
        return new ShowAllQuestion();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link GetQuestionByIdResponse }
     * 
     */
    public GetQuestionByIdResponse createGetQuestionByIdResponse() {
        return new GetQuestionByIdResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link ShowAllQuestionResponse }
     * 
     */
    public ShowAllQuestionResponse createShowAllQuestionResponse() {
        return new ShowAllQuestionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "deleteQuestion")
    public JAXBElement<DeleteQuestion> createDeleteQuestion(DeleteQuestion value) {
        return new JAXBElement<DeleteQuestion>(_DeleteQuestion_QNAME, DeleteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "Answer")
    public JAXBElement<Question> createAnswer(Question value) {
        return new JAXBElement<Question>(_Answer_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "deleteQuestionResponse")
    public JAXBElement<DeleteQuestionResponse> createDeleteQuestionResponse(DeleteQuestionResponse value) {
        return new JAXBElement<DeleteQuestionResponse>(_DeleteQuestionResponse_QNAME, DeleteQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "getQuestionById")
    public JAXBElement<GetQuestionById> createGetQuestionById(GetQuestionById value) {
        return new JAXBElement<GetQuestionById>(_GetQuestionById_QNAME, GetQuestionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "insertQuestion")
    public JAXBElement<InsertQuestion> createInsertQuestion(InsertQuestion value) {
        return new JAXBElement<InsertQuestion>(_InsertQuestion_QNAME, InsertQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "insertQuestionResponse")
    public JAXBElement<InsertQuestionResponse> createInsertQuestionResponse(InsertQuestionResponse value) {
        return new JAXBElement<InsertQuestionResponse>(_InsertQuestionResponse_QNAME, InsertQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "editQuestion")
    public JAXBElement<EditQuestion> createEditQuestion(EditQuestion value) {
        return new JAXBElement<EditQuestion>(_EditQuestion_QNAME, EditQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "editQuestionResponse")
    public JAXBElement<EditQuestionResponse> createEditQuestionResponse(EditQuestionResponse value) {
        return new JAXBElement<EditQuestionResponse>(_EditQuestionResponse_QNAME, EditQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "showAllQuestion")
    public JAXBElement<ShowAllQuestion> createShowAllQuestion(ShowAllQuestion value) {
        return new JAXBElement<ShowAllQuestion>(_ShowAllQuestion_QNAME, ShowAllQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "getQuestionByIdResponse")
    public JAXBElement<GetQuestionByIdResponse> createGetQuestionByIdResponse(GetQuestionByIdResponse value) {
        return new JAXBElement<GetQuestionByIdResponse>(_GetQuestionByIdResponse_QNAME, GetQuestionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question_package.dazzlesquad.com/", name = "showAllQuestionResponse")
    public JAXBElement<ShowAllQuestionResponse> createShowAllQuestionResponse(ShowAllQuestionResponse value) {
        return new JAXBElement<ShowAllQuestionResponse>(_ShowAllQuestionResponse_QNAME, ShowAllQuestionResponse.class, null, value);
    }

}
