
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

    private final static QName _GetAllAnswersResponse_QNAME = new QName("http://WebService/", "getAllAnswersResponse");
    private final static QName _AddAnswerResponse_QNAME = new QName("http://WebService/", "addAnswerResponse");
    private final static QName _GetAllQuestionsResponse_QNAME = new QName("http://WebService/", "getAllQuestionsResponse");
    private final static QName _UpdateQuestionResponse_QNAME = new QName("http://WebService/", "updateQuestionResponse");
    private final static QName _GetVote_QNAME = new QName("http://WebService/", "getVote");
    private final static QName _GetQuestions_QNAME = new QName("http://WebService/", "getQuestions");
    private final static QName _SearchQuestion_QNAME = new QName("http://WebService/", "searchQuestion");
    private final static QName _GetAllAnswers_QNAME = new QName("http://WebService/", "getAllAnswers");
    private final static QName _Register_QNAME = new QName("http://WebService/", "register");
    private final static QName _AddAnswer_QNAME = new QName("http://WebService/", "addAnswer");
    private final static QName _CountAnswer_QNAME = new QName("http://WebService/", "countAnswer");
    private final static QName _SearchQuestionResponse_QNAME = new QName("http://WebService/", "searchQuestionResponse");
    private final static QName _Hello_QNAME = new QName("http://WebService/", "hello");
    private final static QName _GetQuestionsResponse_QNAME = new QName("http://WebService/", "getQuestionsResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://WebService/", "helloResponse");
    private final static QName _RegisterResponse_QNAME = new QName("http://WebService/", "registerResponse");
    private final static QName _Answer_QNAME = new QName("http://WebService/", "Answer");
    private final static QName _DeleteQuestionResponse_QNAME = new QName("http://WebService/", "deleteQuestionResponse");
    private final static QName _ChangeVoteResponse_QNAME = new QName("http://WebService/", "changeVoteResponse");
    private final static QName _AddQuestion_QNAME = new QName("http://WebService/", "addQuestion");
    private final static QName _AddQuestionResponse_QNAME = new QName("http://WebService/", "addQuestionResponse");
    private final static QName _Question_QNAME = new QName("http://WebService/", "Question");
    private final static QName _GetVoteResponse_QNAME = new QName("http://WebService/", "getVoteResponse");
    private final static QName _DeleteQuestion_QNAME = new QName("http://WebService/", "deleteQuestion");
    private final static QName _ChangeVote_QNAME = new QName("http://WebService/", "changeVote");
    private final static QName _GetAllQuestions_QNAME = new QName("http://WebService/", "getAllQuestions");
    private final static QName _CountAnswerResponse_QNAME = new QName("http://WebService/", "countAnswerResponse");
    private final static QName _UpdateQuestion_QNAME = new QName("http://WebService/", "updateQuestion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddQuestionResponse }
     * 
     */
    public AddQuestionResponse createAddQuestionResponse() {
        return new AddQuestionResponse();
    }

    /**
     * Create an instance of {@link AddQuestion }
     * 
     */
    public AddQuestion createAddQuestion() {
        return new AddQuestion();
    }

    /**
     * Create an instance of {@link ChangeVoteResponse }
     * 
     */
    public ChangeVoteResponse createChangeVoteResponse() {
        return new ChangeVoteResponse();
    }

    /**
     * Create an instance of {@link DeleteQuestionResponse }
     * 
     */
    public DeleteQuestionResponse createDeleteQuestionResponse() {
        return new DeleteQuestionResponse();
    }

    /**
     * Create an instance of {@link CountAnswerResponse }
     * 
     */
    public CountAnswerResponse createCountAnswerResponse() {
        return new CountAnswerResponse();
    }

    /**
     * Create an instance of {@link UpdateQuestion }
     * 
     */
    public UpdateQuestion createUpdateQuestion() {
        return new UpdateQuestion();
    }

    /**
     * Create an instance of {@link GetAllQuestions }
     * 
     */
    public GetAllQuestions createGetAllQuestions() {
        return new GetAllQuestions();
    }

    /**
     * Create an instance of {@link ChangeVote }
     * 
     */
    public ChangeVote createChangeVote() {
        return new ChangeVote();
    }

    /**
     * Create an instance of {@link DeleteQuestion }
     * 
     */
    public DeleteQuestion createDeleteQuestion() {
        return new DeleteQuestion();
    }

    /**
     * Create an instance of {@link GetVoteResponse }
     * 
     */
    public GetVoteResponse createGetVoteResponse() {
        return new GetVoteResponse();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link GetAllAnswers }
     * 
     */
    public GetAllAnswers createGetAllAnswers() {
        return new GetAllAnswers();
    }

    /**
     * Create an instance of {@link SearchQuestion }
     * 
     */
    public SearchQuestion createSearchQuestion() {
        return new SearchQuestion();
    }

    /**
     * Create an instance of {@link GetQuestions }
     * 
     */
    public GetQuestions createGetQuestions() {
        return new GetQuestions();
    }

    /**
     * Create an instance of {@link GetVote }
     * 
     */
    public GetVote createGetVote() {
        return new GetVote();
    }

    /**
     * Create an instance of {@link UpdateQuestionResponse }
     * 
     */
    public UpdateQuestionResponse createUpdateQuestionResponse() {
        return new UpdateQuestionResponse();
    }

    /**
     * Create an instance of {@link GetAllQuestionsResponse }
     * 
     */
    public GetAllQuestionsResponse createGetAllQuestionsResponse() {
        return new GetAllQuestionsResponse();
    }

    /**
     * Create an instance of {@link AddAnswerResponse }
     * 
     */
    public AddAnswerResponse createAddAnswerResponse() {
        return new AddAnswerResponse();
    }

    /**
     * Create an instance of {@link GetAllAnswersResponse }
     * 
     */
    public GetAllAnswersResponse createGetAllAnswersResponse() {
        return new GetAllAnswersResponse();
    }

    /**
     * Create an instance of {@link Answer }
     * 
     */
    public Answer createAnswer() {
        return new Answer();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link GetQuestionsResponse }
     * 
     */
    public GetQuestionsResponse createGetQuestionsResponse() {
        return new GetQuestionsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link SearchQuestionResponse }
     * 
     */
    public SearchQuestionResponse createSearchQuestionResponse() {
        return new SearchQuestionResponse();
    }

    /**
     * Create an instance of {@link AddAnswer }
     * 
     */
    public AddAnswer createAddAnswer() {
        return new AddAnswer();
    }

    /**
     * Create an instance of {@link CountAnswer }
     * 
     */
    public CountAnswer createCountAnswer() {
        return new CountAnswer();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAnswersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getAllAnswersResponse")
    public JAXBElement<GetAllAnswersResponse> createGetAllAnswersResponse(GetAllAnswersResponse value) {
        return new JAXBElement<GetAllAnswersResponse>(_GetAllAnswersResponse_QNAME, GetAllAnswersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addAnswerResponse")
    public JAXBElement<AddAnswerResponse> createAddAnswerResponse(AddAnswerResponse value) {
        return new JAXBElement<AddAnswerResponse>(_AddAnswerResponse_QNAME, AddAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getAllQuestionsResponse")
    public JAXBElement<GetAllQuestionsResponse> createGetAllQuestionsResponse(GetAllQuestionsResponse value) {
        return new JAXBElement<GetAllQuestionsResponse>(_GetAllQuestionsResponse_QNAME, GetAllQuestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "updateQuestionResponse")
    public JAXBElement<UpdateQuestionResponse> createUpdateQuestionResponse(UpdateQuestionResponse value) {
        return new JAXBElement<UpdateQuestionResponse>(_UpdateQuestionResponse_QNAME, UpdateQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getVote")
    public JAXBElement<GetVote> createGetVote(GetVote value) {
        return new JAXBElement<GetVote>(_GetVote_QNAME, GetVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getQuestions")
    public JAXBElement<GetQuestions> createGetQuestions(GetQuestions value) {
        return new JAXBElement<GetQuestions>(_GetQuestions_QNAME, GetQuestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "searchQuestion")
    public JAXBElement<SearchQuestion> createSearchQuestion(SearchQuestion value) {
        return new JAXBElement<SearchQuestion>(_SearchQuestion_QNAME, SearchQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAnswers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getAllAnswers")
    public JAXBElement<GetAllAnswers> createGetAllAnswers(GetAllAnswers value) {
        return new JAXBElement<GetAllAnswers>(_GetAllAnswers_QNAME, GetAllAnswers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addAnswer")
    public JAXBElement<AddAnswer> createAddAnswer(AddAnswer value) {
        return new JAXBElement<AddAnswer>(_AddAnswer_QNAME, AddAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "countAnswer")
    public JAXBElement<CountAnswer> createCountAnswer(CountAnswer value) {
        return new JAXBElement<CountAnswer>(_CountAnswer_QNAME, CountAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "searchQuestionResponse")
    public JAXBElement<SearchQuestionResponse> createSearchQuestionResponse(SearchQuestionResponse value) {
        return new JAXBElement<SearchQuestionResponse>(_SearchQuestionResponse_QNAME, SearchQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getQuestionsResponse")
    public JAXBElement<GetQuestionsResponse> createGetQuestionsResponse(GetQuestionsResponse value) {
        return new JAXBElement<GetQuestionsResponse>(_GetQuestionsResponse_QNAME, GetQuestionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Answer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "Answer")
    public JAXBElement<Answer> createAnswer(Answer value) {
        return new JAXBElement<Answer>(_Answer_QNAME, Answer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "deleteQuestionResponse")
    public JAXBElement<DeleteQuestionResponse> createDeleteQuestionResponse(DeleteQuestionResponse value) {
        return new JAXBElement<DeleteQuestionResponse>(_DeleteQuestionResponse_QNAME, DeleteQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeVoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "changeVoteResponse")
    public JAXBElement<ChangeVoteResponse> createChangeVoteResponse(ChangeVoteResponse value) {
        return new JAXBElement<ChangeVoteResponse>(_ChangeVoteResponse_QNAME, ChangeVoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addQuestion")
    public JAXBElement<AddQuestion> createAddQuestion(AddQuestion value) {
        return new JAXBElement<AddQuestion>(_AddQuestion_QNAME, AddQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "addQuestionResponse")
    public JAXBElement<AddQuestionResponse> createAddQuestionResponse(AddQuestionResponse value) {
        return new JAXBElement<AddQuestionResponse>(_AddQuestionResponse_QNAME, AddQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Question }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "Question")
    public JAXBElement<Question> createQuestion(Question value) {
        return new JAXBElement<Question>(_Question_QNAME, Question.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getVoteResponse")
    public JAXBElement<GetVoteResponse> createGetVoteResponse(GetVoteResponse value) {
        return new JAXBElement<GetVoteResponse>(_GetVoteResponse_QNAME, GetVoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "deleteQuestion")
    public JAXBElement<DeleteQuestion> createDeleteQuestion(DeleteQuestion value) {
        return new JAXBElement<DeleteQuestion>(_DeleteQuestion_QNAME, DeleteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeVote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "changeVote")
    public JAXBElement<ChangeVote> createChangeVote(ChangeVote value) {
        return new JAXBElement<ChangeVote>(_ChangeVote_QNAME, ChangeVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "getAllQuestions")
    public JAXBElement<GetAllQuestions> createGetAllQuestions(GetAllQuestions value) {
        return new JAXBElement<GetAllQuestions>(_GetAllQuestions_QNAME, GetAllQuestions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "countAnswerResponse")
    public JAXBElement<CountAnswerResponse> createCountAnswerResponse(CountAnswerResponse value) {
        return new JAXBElement<CountAnswerResponse>(_CountAnswerResponse_QNAME, CountAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "updateQuestion")
    public JAXBElement<UpdateQuestion> createUpdateQuestion(UpdateQuestion value) {
        return new JAXBElement<UpdateQuestion>(_UpdateQuestion_QNAME, UpdateQuestion.class, null, value);
    }

}
