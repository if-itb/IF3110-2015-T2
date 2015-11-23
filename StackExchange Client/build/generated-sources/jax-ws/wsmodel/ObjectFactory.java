
package wsmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsmodel package. 
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

    private final static QName _AddAnswer_QNAME = new QName("http://WSModel/", "addAnswer");
    private final static QName _AddAnswerResponse_QNAME = new QName("http://WSModel/", "addAnswerResponse");
    private final static QName _AddQuestion_QNAME = new QName("http://WSModel/", "addQuestion");
    private final static QName _AddQuestionResponse_QNAME = new QName("http://WSModel/", "addQuestionResponse");
    private final static QName _DeleteQuestion_QNAME = new QName("http://WSModel/", "deleteQuestion");
    private final static QName _DeleteQuestionResponse_QNAME = new QName("http://WSModel/", "deleteQuestionResponse");
    private final static QName _GetAllQuestion_QNAME = new QName("http://WSModel/", "getAllQuestion");
    private final static QName _GetAllQuestionResponse_QNAME = new QName("http://WSModel/", "getAllQuestionResponse");
    private final static QName _GetAnswerByQID_QNAME = new QName("http://WSModel/", "getAnswerByQID");
    private final static QName _GetAnswerByQIDResponse_QNAME = new QName("http://WSModel/", "getAnswerByQIDResponse");
    private final static QName _GetQuestionByID_QNAME = new QName("http://WSModel/", "getQuestionByID");
    private final static QName _GetQuestionByIDResponse_QNAME = new QName("http://WSModel/", "getQuestionByIDResponse");
    private final static QName _Questionitem_QNAME = new QName("http://WSModel/", "questionitem");
    private final static QName _UpdateQuestion_QNAME = new QName("http://WSModel/", "updateQuestion");
    private final static QName _UpdateQuestionResponse_QNAME = new QName("http://WSModel/", "updateQuestionResponse");
    private final static QName _VoteDownAnswer_QNAME = new QName("http://WSModel/", "voteDownAnswer");
    private final static QName _VoteDownAnswerResponse_QNAME = new QName("http://WSModel/", "voteDownAnswerResponse");
    private final static QName _VoteDownQuestion_QNAME = new QName("http://WSModel/", "voteDownQuestion");
    private final static QName _VoteDownQuestionResponse_QNAME = new QName("http://WSModel/", "voteDownQuestionResponse");
    private final static QName _VoteUpAnswer_QNAME = new QName("http://WSModel/", "voteUpAnswer");
    private final static QName _VoteUpAnswerResponse_QNAME = new QName("http://WSModel/", "voteUpAnswerResponse");
    private final static QName _VoteUpQuestion_QNAME = new QName("http://WSModel/", "voteUpQuestion");
    private final static QName _VoteUpQuestionResponse_QNAME = new QName("http://WSModel/", "voteUpQuestionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddAnswer }
     * 
     */
    public AddAnswer createAddAnswer() {
        return new AddAnswer();
    }

    /**
     * Create an instance of {@link AddAnswerResponse }
     * 
     */
    public AddAnswerResponse createAddAnswerResponse() {
        return new AddAnswerResponse();
    }

    /**
     * Create an instance of {@link AddQuestion }
     * 
     */
    public AddQuestion createAddQuestion() {
        return new AddQuestion();
    }

    /**
     * Create an instance of {@link AddQuestionResponse }
     * 
     */
    public AddQuestionResponse createAddQuestionResponse() {
        return new AddQuestionResponse();
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
     * Create an instance of {@link GetAllQuestion }
     * 
     */
    public GetAllQuestion createGetAllQuestion() {
        return new GetAllQuestion();
    }

    /**
     * Create an instance of {@link GetAllQuestionResponse }
     * 
     */
    public GetAllQuestionResponse createGetAllQuestionResponse() {
        return new GetAllQuestionResponse();
    }

    /**
     * Create an instance of {@link GetAnswerByQID }
     * 
     */
    public GetAnswerByQID createGetAnswerByQID() {
        return new GetAnswerByQID();
    }

    /**
     * Create an instance of {@link GetAnswerByQIDResponse }
     * 
     */
    public GetAnswerByQIDResponse createGetAnswerByQIDResponse() {
        return new GetAnswerByQIDResponse();
    }

    /**
     * Create an instance of {@link GetQuestionByID }
     * 
     */
    public GetQuestionByID createGetQuestionByID() {
        return new GetQuestionByID();
    }

    /**
     * Create an instance of {@link GetQuestionByIDResponse }
     * 
     */
    public GetQuestionByIDResponse createGetQuestionByIDResponse() {
        return new GetQuestionByIDResponse();
    }

    /**
     * Create an instance of {@link QuestionClass }
     * 
     */
    public QuestionClass createQuestionClass() {
        return new QuestionClass();
    }

    /**
     * Create an instance of {@link UpdateQuestion }
     * 
     */
    public UpdateQuestion createUpdateQuestion() {
        return new UpdateQuestion();
    }

    /**
     * Create an instance of {@link UpdateQuestionResponse }
     * 
     */
    public UpdateQuestionResponse createUpdateQuestionResponse() {
        return new UpdateQuestionResponse();
    }

    /**
     * Create an instance of {@link VoteDownAnswer }
     * 
     */
    public VoteDownAnswer createVoteDownAnswer() {
        return new VoteDownAnswer();
    }

    /**
     * Create an instance of {@link VoteDownAnswerResponse }
     * 
     */
    public VoteDownAnswerResponse createVoteDownAnswerResponse() {
        return new VoteDownAnswerResponse();
    }

    /**
     * Create an instance of {@link VoteDownQuestion }
     * 
     */
    public VoteDownQuestion createVoteDownQuestion() {
        return new VoteDownQuestion();
    }

    /**
     * Create an instance of {@link VoteDownQuestionResponse }
     * 
     */
    public VoteDownQuestionResponse createVoteDownQuestionResponse() {
        return new VoteDownQuestionResponse();
    }

    /**
     * Create an instance of {@link VoteUpAnswer }
     * 
     */
    public VoteUpAnswer createVoteUpAnswer() {
        return new VoteUpAnswer();
    }

    /**
     * Create an instance of {@link VoteUpAnswerResponse }
     * 
     */
    public VoteUpAnswerResponse createVoteUpAnswerResponse() {
        return new VoteUpAnswerResponse();
    }

    /**
     * Create an instance of {@link VoteUpQuestion }
     * 
     */
    public VoteUpQuestion createVoteUpQuestion() {
        return new VoteUpQuestion();
    }

    /**
     * Create an instance of {@link VoteUpQuestionResponse }
     * 
     */
    public VoteUpQuestionResponse createVoteUpQuestionResponse() {
        return new VoteUpQuestionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "addAnswer")
    public JAXBElement<AddAnswer> createAddAnswer(AddAnswer value) {
        return new JAXBElement<AddAnswer>(_AddAnswer_QNAME, AddAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "addAnswerResponse")
    public JAXBElement<AddAnswerResponse> createAddAnswerResponse(AddAnswerResponse value) {
        return new JAXBElement<AddAnswerResponse>(_AddAnswerResponse_QNAME, AddAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "addQuestion")
    public JAXBElement<AddQuestion> createAddQuestion(AddQuestion value) {
        return new JAXBElement<AddQuestion>(_AddQuestion_QNAME, AddQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "addQuestionResponse")
    public JAXBElement<AddQuestionResponse> createAddQuestionResponse(AddQuestionResponse value) {
        return new JAXBElement<AddQuestionResponse>(_AddQuestionResponse_QNAME, AddQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "deleteQuestion")
    public JAXBElement<DeleteQuestion> createDeleteQuestion(DeleteQuestion value) {
        return new JAXBElement<DeleteQuestion>(_DeleteQuestion_QNAME, DeleteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "deleteQuestionResponse")
    public JAXBElement<DeleteQuestionResponse> createDeleteQuestionResponse(DeleteQuestionResponse value) {
        return new JAXBElement<DeleteQuestionResponse>(_DeleteQuestionResponse_QNAME, DeleteQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getAllQuestion")
    public JAXBElement<GetAllQuestion> createGetAllQuestion(GetAllQuestion value) {
        return new JAXBElement<GetAllQuestion>(_GetAllQuestion_QNAME, GetAllQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getAllQuestionResponse")
    public JAXBElement<GetAllQuestionResponse> createGetAllQuestionResponse(GetAllQuestionResponse value) {
        return new JAXBElement<GetAllQuestionResponse>(_GetAllQuestionResponse_QNAME, GetAllQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerByQID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getAnswerByQID")
    public JAXBElement<GetAnswerByQID> createGetAnswerByQID(GetAnswerByQID value) {
        return new JAXBElement<GetAnswerByQID>(_GetAnswerByQID_QNAME, GetAnswerByQID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerByQIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getAnswerByQIDResponse")
    public JAXBElement<GetAnswerByQIDResponse> createGetAnswerByQIDResponse(GetAnswerByQIDResponse value) {
        return new JAXBElement<GetAnswerByQIDResponse>(_GetAnswerByQIDResponse_QNAME, GetAnswerByQIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getQuestionByID")
    public JAXBElement<GetQuestionByID> createGetQuestionByID(GetQuestionByID value) {
        return new JAXBElement<GetQuestionByID>(_GetQuestionByID_QNAME, GetQuestionByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "getQuestionByIDResponse")
    public JAXBElement<GetQuestionByIDResponse> createGetQuestionByIDResponse(GetQuestionByIDResponse value) {
        return new JAXBElement<GetQuestionByIDResponse>(_GetQuestionByIDResponse_QNAME, GetQuestionByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionClass }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "questionitem")
    public JAXBElement<QuestionClass> createQuestionitem(QuestionClass value) {
        return new JAXBElement<QuestionClass>(_Questionitem_QNAME, QuestionClass.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "updateQuestion")
    public JAXBElement<UpdateQuestion> createUpdateQuestion(UpdateQuestion value) {
        return new JAXBElement<UpdateQuestion>(_UpdateQuestion_QNAME, UpdateQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "updateQuestionResponse")
    public JAXBElement<UpdateQuestionResponse> createUpdateQuestionResponse(UpdateQuestionResponse value) {
        return new JAXBElement<UpdateQuestionResponse>(_UpdateQuestionResponse_QNAME, UpdateQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDownAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteDownAnswer")
    public JAXBElement<VoteDownAnswer> createVoteDownAnswer(VoteDownAnswer value) {
        return new JAXBElement<VoteDownAnswer>(_VoteDownAnswer_QNAME, VoteDownAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDownAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteDownAnswerResponse")
    public JAXBElement<VoteDownAnswerResponse> createVoteDownAnswerResponse(VoteDownAnswerResponse value) {
        return new JAXBElement<VoteDownAnswerResponse>(_VoteDownAnswerResponse_QNAME, VoteDownAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDownQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteDownQuestion")
    public JAXBElement<VoteDownQuestion> createVoteDownQuestion(VoteDownQuestion value) {
        return new JAXBElement<VoteDownQuestion>(_VoteDownQuestion_QNAME, VoteDownQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDownQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteDownQuestionResponse")
    public JAXBElement<VoteDownQuestionResponse> createVoteDownQuestionResponse(VoteDownQuestionResponse value) {
        return new JAXBElement<VoteDownQuestionResponse>(_VoteDownQuestionResponse_QNAME, VoteDownQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUpAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteUpAnswer")
    public JAXBElement<VoteUpAnswer> createVoteUpAnswer(VoteUpAnswer value) {
        return new JAXBElement<VoteUpAnswer>(_VoteUpAnswer_QNAME, VoteUpAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUpAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteUpAnswerResponse")
    public JAXBElement<VoteUpAnswerResponse> createVoteUpAnswerResponse(VoteUpAnswerResponse value) {
        return new JAXBElement<VoteUpAnswerResponse>(_VoteUpAnswerResponse_QNAME, VoteUpAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUpQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteUpQuestion")
    public JAXBElement<VoteUpQuestion> createVoteUpQuestion(VoteUpQuestion value) {
        return new JAXBElement<VoteUpQuestion>(_VoteUpQuestion_QNAME, VoteUpQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUpQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WSModel/", name = "voteUpQuestionResponse")
    public JAXBElement<VoteUpQuestionResponse> createVoteUpQuestionResponse(VoteUpQuestionResponse value) {
        return new JAXBElement<VoteUpQuestionResponse>(_VoteUpQuestionResponse_QNAME, VoteUpQuestionResponse.class, null, value);
    }

}
