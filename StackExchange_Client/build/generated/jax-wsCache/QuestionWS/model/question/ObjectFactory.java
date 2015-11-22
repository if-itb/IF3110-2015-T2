
package model.question;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model.question package. 
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

    private final static QName _AddQuestion_QNAME = new QName("http://question.model/", "addQuestion");
    private final static QName _Question_QNAME = new QName("http://question.model/", "Question");
    private final static QName _EditQuestion_QNAME = new QName("http://question.model/", "editQuestion");
    private final static QName _GetAllQuestionsResponse_QNAME = new QName("http://question.model/", "getAllQuestionsResponse");
    private final static QName _GetAllQuestions_QNAME = new QName("http://question.model/", "getAllQuestions");
    private final static QName _GetQuestionByIDResponse_QNAME = new QName("http://question.model/", "getQuestionByIDResponse");
    private final static QName _GetQuestionByID_QNAME = new QName("http://question.model/", "getQuestionByID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model.question
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllQuestions }
     * 
     */
    public GetAllQuestions createGetAllQuestions() {
        return new GetAllQuestions();
    }

    /**
     * Create an instance of {@link GetQuestionByIDResponse }
     * 
     */
    public GetQuestionByIDResponse createGetQuestionByIDResponse() {
        return new GetQuestionByIDResponse();
    }

    /**
     * Create an instance of {@link GetQuestionByID }
     * 
     */
    public GetQuestionByID createGetQuestionByID() {
        return new GetQuestionByID();
    }

    /**
     * Create an instance of {@link AddQuestion }
     * 
     */
    public AddQuestion createAddQuestion() {
        return new AddQuestion();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link EditQuestion }
     * 
     */
    public EditQuestion createEditQuestion() {
        return new EditQuestion();
    }

    /**
     * Create an instance of {@link GetAllQuestionsResponse }
     * 
     */
    public GetAllQuestionsResponse createGetAllQuestionsResponse() {
        return new GetAllQuestionsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "addQuestion")
    public JAXBElement<AddQuestion> createAddQuestion(AddQuestion value) {
        return new JAXBElement<AddQuestion>(_AddQuestion_QNAME, AddQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "Question")
    public JAXBElement<Question> createQuestion(Question value) {
        return new JAXBElement<Question>(_Question_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "editQuestion")
    public JAXBElement<EditQuestion> createEditQuestion(EditQuestion value) {
        return new JAXBElement<EditQuestion>(_EditQuestion_QNAME, EditQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "getAllQuestionsResponse")
    public JAXBElement<GetAllQuestionsResponse> createGetAllQuestionsResponse(GetAllQuestionsResponse value) {
        return new JAXBElement<GetAllQuestionsResponse>(_GetAllQuestionsResponse_QNAME, GetAllQuestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "getAllQuestions")
    public JAXBElement<GetAllQuestions> createGetAllQuestions(GetAllQuestions value) {
        return new JAXBElement<GetAllQuestions>(_GetAllQuestions_QNAME, GetAllQuestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "getQuestionByIDResponse")
    public JAXBElement<GetQuestionByIDResponse> createGetQuestionByIDResponse(GetQuestionByIDResponse value) {
        return new JAXBElement<GetQuestionByIDResponse>(_GetQuestionByIDResponse_QNAME, GetQuestionByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.model/", name = "getQuestionByID")
    public JAXBElement<GetQuestionByID> createGetQuestionByID(GetQuestionByID value) {
        return new JAXBElement<GetQuestionByID>(_GetQuestionByID_QNAME, GetQuestionByID.class, null, value);
    }

}
