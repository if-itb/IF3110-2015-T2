
package stackexchangews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stackexchangews package. 
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

    private final static QName _InsertAnswer_QNAME = new QName("http://StackExchangeWS/", "insertAnswer");
    private final static QName _UpdateQuestion_QNAME = new QName("http://StackExchangeWS/", "updateQuestion");
    private final static QName _Answer_QNAME = new QName("http://StackExchangeWS/", "Answer");
    private final static QName _RegisterResponse_QNAME = new QName("http://StackExchangeWS/", "registerResponse");
    private final static QName _GetRecentQuestionsResponse_QNAME = new QName("http://StackExchangeWS/", "getRecentQuestionsResponse");
    private final static QName _DeleteQuestion_QNAME = new QName("http://StackExchangeWS/", "deleteQuestion");
    private final static QName _GetAnswer_QNAME = new QName("http://StackExchangeWS/", "getAnswer");
    private final static QName _Question_QNAME = new QName("http://StackExchangeWS/", "Question");
    private final static QName _GetAnswerResponse_QNAME = new QName("http://StackExchangeWS/", "getAnswerResponse");
    private final static QName _Register_QNAME = new QName("http://StackExchangeWS/", "register");
    private final static QName _GetQuestion_QNAME = new QName("http://StackExchangeWS/", "getQuestion");
    private final static QName _GetRecentQuestions_QNAME = new QName("http://StackExchangeWS/", "getRecentQuestions");
    private final static QName _InsertQuestion_QNAME = new QName("http://StackExchangeWS/", "insertQuestion");
    private final static QName _GetQuestionResponse_QNAME = new QName("http://StackExchangeWS/", "getQuestionResponse");
    private final static QName _VoteDownResponse_QNAME = new QName("http://StackExchangeWS/", "voteDownResponse");
    private final static QName _VoteUp_QNAME = new QName("http://StackExchangeWS/", "voteUp");
    private final static QName _VoteUpResponse_QNAME = new QName("http://StackExchangeWS/", "voteUpResponse");
    private final static QName _VoteDown_QNAME = new QName("http://StackExchangeWS/", "voteDown");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stackexchangews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuestion }
     * 
     */
    public GetQuestion createGetQuestion() {
        return new GetQuestion();
    }

    /**
     * Create an instance of {@link GetRecentQuestions }
     * 
     */
    public GetRecentQuestions createGetRecentQuestions() {
        return new GetRecentQuestions();
    }

    /**
     * Create an instance of {@link InsertQuestion }
     * 
     */
    public InsertQuestion createInsertQuestion() {
        return new InsertQuestion();
    }

    /**
     * Create an instance of {@link GetQuestionResponse }
     * 
     */
    public GetQuestionResponse createGetQuestionResponse() {
        return new GetQuestionResponse();
    }

    /**
     * Create an instance of {@link VoteDownResponse }
     * 
     */
    public VoteDownResponse createVoteDownResponse() {
        return new VoteDownResponse();
    }

    /**
     * Create an instance of {@link VoteUp }
     * 
     */
    public VoteUp createVoteUp() {
        return new VoteUp();
    }

    /**
     * Create an instance of {@link VoteDown }
     * 
     */
    public VoteDown createVoteDown() {
        return new VoteDown();
    }

    /**
     * Create an instance of {@link VoteUpResponse }
     * 
     */
    public VoteUpResponse createVoteUpResponse() {
        return new VoteUpResponse();
    }

    /**
     * Create an instance of {@link InsertAnswer }
     * 
     */
    public InsertAnswer createInsertAnswer() {
        return new InsertAnswer();
    }

    /**
     * Create an instance of {@link UpdateQuestion }
     * 
     */
    public UpdateQuestion createUpdateQuestion() {
        return new UpdateQuestion();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link GetRecentQuestionsResponse }
     * 
     */
    public GetRecentQuestionsResponse createGetRecentQuestionsResponse() {
        return new GetRecentQuestionsResponse();
    }

    /**
     * Create an instance of {@link DeleteQuestion }
     * 
     */
    public DeleteQuestion createDeleteQuestion() {
        return new DeleteQuestion();
    }

    /**
     * Create an instance of {@link GetAnswer }
     * 
     */
    public GetAnswer createGetAnswer() {
        return new GetAnswer();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link GetAnswerResponse }
     * 
     */
    public GetAnswerResponse createGetAnswerResponse() {
        return new GetAnswerResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "insertAnswer")
    public JAXBElement<InsertAnswer> createInsertAnswer(InsertAnswer value) {
        return new JAXBElement<InsertAnswer>(_InsertAnswer_QNAME, InsertAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "updateQuestion")
    public JAXBElement<UpdateQuestion> createUpdateQuestion(UpdateQuestion value) {
        return new JAXBElement<UpdateQuestion>(_UpdateQuestion_QNAME, UpdateQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Answer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "Answer")
    public JAXBElement<Answer> createAnswer(Answer value) {
        return new JAXBElement<Answer>(_Answer_QNAME, Answer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentQuestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getRecentQuestionsResponse")
    public JAXBElement<GetRecentQuestionsResponse> createGetRecentQuestionsResponse(GetRecentQuestionsResponse value) {
        return new JAXBElement<GetRecentQuestionsResponse>(_GetRecentQuestionsResponse_QNAME, GetRecentQuestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "deleteQuestion")
    public JAXBElement<DeleteQuestion> createDeleteQuestion(DeleteQuestion value) {
        return new JAXBElement<DeleteQuestion>(_DeleteQuestion_QNAME, DeleteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getAnswer")
    public JAXBElement<GetAnswer> createGetAnswer(GetAnswer value) {
        return new JAXBElement<GetAnswer>(_GetAnswer_QNAME, GetAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "Question")
    public JAXBElement<Question> createQuestion(Question value) {
        return new JAXBElement<Question>(_Question_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getAnswerResponse")
    public JAXBElement<GetAnswerResponse> createGetAnswerResponse(GetAnswerResponse value) {
        return new JAXBElement<GetAnswerResponse>(_GetAnswerResponse_QNAME, GetAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getQuestion")
    public JAXBElement<GetQuestion> createGetQuestion(GetQuestion value) {
        return new JAXBElement<GetQuestion>(_GetQuestion_QNAME, GetQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecentQuestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getRecentQuestions")
    public JAXBElement<GetRecentQuestions> createGetRecentQuestions(GetRecentQuestions value) {
        return new JAXBElement<GetRecentQuestions>(_GetRecentQuestions_QNAME, GetRecentQuestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "insertQuestion")
    public JAXBElement<InsertQuestion> createInsertQuestion(InsertQuestion value) {
        return new JAXBElement<InsertQuestion>(_InsertQuestion_QNAME, InsertQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "getQuestionResponse")
    public JAXBElement<GetQuestionResponse> createGetQuestionResponse(GetQuestionResponse value) {
        return new JAXBElement<GetQuestionResponse>(_GetQuestionResponse_QNAME, GetQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDownResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "voteDownResponse")
    public JAXBElement<VoteDownResponse> createVoteDownResponse(VoteDownResponse value) {
        return new JAXBElement<VoteDownResponse>(_VoteDownResponse_QNAME, VoteDownResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "voteUp")
    public JAXBElement<VoteUp> createVoteUp(VoteUp value) {
        return new JAXBElement<VoteUp>(_VoteUp_QNAME, VoteUp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteUpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "voteUpResponse")
    public JAXBElement<VoteUpResponse> createVoteUpResponse(VoteUpResponse value) {
        return new JAXBElement<VoteUpResponse>(_VoteUpResponse_QNAME, VoteUpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteDown }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StackExchangeWS/", name = "voteDown")
    public JAXBElement<VoteDown> createVoteDown(VoteDown value) {
        return new JAXBElement<VoteDown>(_VoteDown_QNAME, VoteDown.class, null, value);
    }

}
