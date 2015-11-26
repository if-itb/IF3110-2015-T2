
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
    private final static QName _CheckEmailUser_QNAME = new QName("http://webservice/", "checkEmailUser");
    private final static QName _CheckEmailUserResponse_QNAME = new QName("http://webservice/", "checkEmailUserResponse");
    private final static QName _CreateAnswer_QNAME = new QName("http://webservice/", "createAnswer");
    private final static QName _CreateAnswerResponse_QNAME = new QName("http://webservice/", "createAnswerResponse");
    private final static QName _CreateQuestion_QNAME = new QName("http://webservice/", "createQuestion");
    private final static QName _CreateQuestionResponse_QNAME = new QName("http://webservice/", "createQuestionResponse");
    private final static QName _CreateUser_QNAME = new QName("http://webservice/", "createUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://webservice/", "createUserResponse");
    private final static QName _DeleteAllVoteAnswer_QNAME = new QName("http://webservice/", "deleteAllVoteAnswer");
    private final static QName _DeleteAllVoteAnswerResponse_QNAME = new QName("http://webservice/", "deleteAllVoteAnswerResponse");
    private final static QName _DeleteAllVoteQuestion_QNAME = new QName("http://webservice/", "deleteAllVoteQuestion");
    private final static QName _DeleteAllVoteQuestionResponse_QNAME = new QName("http://webservice/", "deleteAllVoteQuestionResponse");
    private final static QName _DeleteQuestion_QNAME = new QName("http://webservice/", "deleteQuestion");
    private final static QName _DeleteQuestionResponse_QNAME = new QName("http://webservice/", "deleteQuestionResponse");
    private final static QName _GetAnswers_QNAME = new QName("http://webservice/", "getAnswers");
    private final static QName _GetAnswersResponse_QNAME = new QName("http://webservice/", "getAnswersResponse");
    private final static QName _GetCountAnswer_QNAME = new QName("http://webservice/", "getCountAnswer");
    private final static QName _GetCountAnswerResponse_QNAME = new QName("http://webservice/", "getCountAnswerResponse");
    private final static QName _GetQuestion_QNAME = new QName("http://webservice/", "getQuestion");
    private final static QName _GetQuestionResponse_QNAME = new QName("http://webservice/", "getQuestionResponse");
    private final static QName _GetUserById_QNAME = new QName("http://webservice/", "getUserById");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://webservice/", "getUserByIdResponse");
    private final static QName _GetVotesAnswer_QNAME = new QName("http://webservice/", "getVotesAnswer");
    private final static QName _GetVotesAnswerResponse_QNAME = new QName("http://webservice/", "getVotesAnswerResponse");
    private final static QName _GetVotesQuestion_QNAME = new QName("http://webservice/", "getVotesQuestion");
    private final static QName _GetVotesQuestionResponse_QNAME = new QName("http://webservice/", "getVotesQuestionResponse");
    private final static QName _HasVotedAnswer_QNAME = new QName("http://webservice/", "hasVotedAnswer");
    private final static QName _HasVotedAnswerResponse_QNAME = new QName("http://webservice/", "hasVotedAnswerResponse");
    private final static QName _HasVotedQuestion_QNAME = new QName("http://webservice/", "hasVotedQuestion");
    private final static QName _HasVotedQuestionResponse_QNAME = new QName("http://webservice/", "hasVotedQuestionResponse");
    private final static QName _ListQuestion_QNAME = new QName("http://webservice/", "listQuestion");
    private final static QName _ListQuestionResponse_QNAME = new QName("http://webservice/", "listQuestionResponse");
    private final static QName _Question_QNAME = new QName("http://webservice/", "question");
    private final static QName _Registereduser_QNAME = new QName("http://webservice/", "registereduser");
    private final static QName _SearchQuestion_QNAME = new QName("http://webservice/", "searchQuestion");
    private final static QName _SearchQuestionResponse_QNAME = new QName("http://webservice/", "searchQuestionResponse");
    private final static QName _UpdateQuestion_QNAME = new QName("http://webservice/", "updateQuestion");
    private final static QName _UpdateQuestionResponse_QNAME = new QName("http://webservice/", "updateQuestionResponse");
    private final static QName _VoteAnswer_QNAME = new QName("http://webservice/", "voteAnswer");
    private final static QName _VoteAnswerResponse_QNAME = new QName("http://webservice/", "voteAnswerResponse");
    private final static QName _VoteQuestion_QNAME = new QName("http://webservice/", "voteQuestion");
    private final static QName _VoteQuestionResponse_QNAME = new QName("http://webservice/", "voteQuestionResponse");

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
     * Create an instance of {@link CheckEmailUser }
     * 
     */
    public CheckEmailUser createCheckEmailUser() {
        return new CheckEmailUser();
    }

    /**
     * Create an instance of {@link CheckEmailUserResponse }
     * 
     */
    public CheckEmailUserResponse createCheckEmailUserResponse() {
        return new CheckEmailUserResponse();
    }

    /**
     * Create an instance of {@link CreateAnswer }
     * 
     */
    public CreateAnswer createCreateAnswer() {
        return new CreateAnswer();
    }

    /**
     * Create an instance of {@link CreateAnswerResponse }
     * 
     */
    public CreateAnswerResponse createCreateAnswerResponse() {
        return new CreateAnswerResponse();
    }

    /**
     * Create an instance of {@link CreateQuestion }
     * 
     */
    public CreateQuestion createCreateQuestion() {
        return new CreateQuestion();
    }

    /**
     * Create an instance of {@link CreateQuestionResponse }
     * 
     */
    public CreateQuestionResponse createCreateQuestionResponse() {
        return new CreateQuestionResponse();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteAllVoteAnswer }
     * 
     */
    public DeleteAllVoteAnswer createDeleteAllVoteAnswer() {
        return new DeleteAllVoteAnswer();
    }

    /**
     * Create an instance of {@link DeleteAllVoteAnswerResponse }
     * 
     */
    public DeleteAllVoteAnswerResponse createDeleteAllVoteAnswerResponse() {
        return new DeleteAllVoteAnswerResponse();
    }

    /**
     * Create an instance of {@link DeleteAllVoteQuestion }
     * 
     */
    public DeleteAllVoteQuestion createDeleteAllVoteQuestion() {
        return new DeleteAllVoteQuestion();
    }

    /**
     * Create an instance of {@link DeleteAllVoteQuestionResponse }
     * 
     */
    public DeleteAllVoteQuestionResponse createDeleteAllVoteQuestionResponse() {
        return new DeleteAllVoteQuestionResponse();
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
     * Create an instance of {@link GetCountAnswer }
     * 
     */
    public GetCountAnswer createGetCountAnswer() {
        return new GetCountAnswer();
    }

    /**
     * Create an instance of {@link GetCountAnswerResponse }
     * 
     */
    public GetCountAnswerResponse createGetCountAnswerResponse() {
        return new GetCountAnswerResponse();
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
     * Create an instance of {@link GetVotesAnswer }
     * 
     */
    public GetVotesAnswer createGetVotesAnswer() {
        return new GetVotesAnswer();
    }

    /**
     * Create an instance of {@link GetVotesAnswerResponse }
     * 
     */
    public GetVotesAnswerResponse createGetVotesAnswerResponse() {
        return new GetVotesAnswerResponse();
    }

    /**
     * Create an instance of {@link GetVotesQuestion }
     * 
     */
    public GetVotesQuestion createGetVotesQuestion() {
        return new GetVotesQuestion();
    }

    /**
     * Create an instance of {@link GetVotesQuestionResponse }
     * 
     */
    public GetVotesQuestionResponse createGetVotesQuestionResponse() {
        return new GetVotesQuestionResponse();
    }

    /**
     * Create an instance of {@link HasVotedAnswer }
     * 
     */
    public HasVotedAnswer createHasVotedAnswer() {
        return new HasVotedAnswer();
    }

    /**
     * Create an instance of {@link HasVotedAnswerResponse }
     * 
     */
    public HasVotedAnswerResponse createHasVotedAnswerResponse() {
        return new HasVotedAnswerResponse();
    }

    /**
     * Create an instance of {@link HasVotedQuestion }
     * 
     */
    public HasVotedQuestion createHasVotedQuestion() {
        return new HasVotedQuestion();
    }

    /**
     * Create an instance of {@link HasVotedQuestionResponse }
     * 
     */
    public HasVotedQuestionResponse createHasVotedQuestionResponse() {
        return new HasVotedQuestionResponse();
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
     * Create an instance of {@link VoteAnswer }
     * 
     */
    public VoteAnswer createVoteAnswer() {
        return new VoteAnswer();
    }

    /**
     * Create an instance of {@link VoteAnswerResponse }
     * 
     */
    public VoteAnswerResponse createVoteAnswerResponse() {
        return new VoteAnswerResponse();
    }

    /**
     * Create an instance of {@link VoteQuestion }
     * 
     */
    public VoteQuestion createVoteQuestion() {
        return new VoteQuestion();
    }

    /**
     * Create an instance of {@link VoteQuestionResponse }
     * 
     */
    public VoteQuestionResponse createVoteQuestionResponse() {
        return new VoteQuestionResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmailUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "checkEmailUser")
    public JAXBElement<CheckEmailUser> createCheckEmailUser(CheckEmailUser value) {
        return new JAXBElement<CheckEmailUser>(_CheckEmailUser_QNAME, CheckEmailUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckEmailUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "checkEmailUserResponse")
    public JAXBElement<CheckEmailUserResponse> createCheckEmailUserResponse(CheckEmailUserResponse value) {
        return new JAXBElement<CheckEmailUserResponse>(_CheckEmailUserResponse_QNAME, CheckEmailUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createAnswer")
    public JAXBElement<CreateAnswer> createCreateAnswer(CreateAnswer value) {
        return new JAXBElement<CreateAnswer>(_CreateAnswer_QNAME, CreateAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createAnswerResponse")
    public JAXBElement<CreateAnswerResponse> createCreateAnswerResponse(CreateAnswerResponse value) {
        return new JAXBElement<CreateAnswerResponse>(_CreateAnswerResponse_QNAME, CreateAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createQuestion")
    public JAXBElement<CreateQuestion> createCreateQuestion(CreateQuestion value) {
        return new JAXBElement<CreateQuestion>(_CreateQuestion_QNAME, CreateQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createQuestionResponse")
    public JAXBElement<CreateQuestionResponse> createCreateQuestionResponse(CreateQuestionResponse value) {
        return new JAXBElement<CreateQuestionResponse>(_CreateQuestionResponse_QNAME, CreateQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllVoteAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteAllVoteAnswer")
    public JAXBElement<DeleteAllVoteAnswer> createDeleteAllVoteAnswer(DeleteAllVoteAnswer value) {
        return new JAXBElement<DeleteAllVoteAnswer>(_DeleteAllVoteAnswer_QNAME, DeleteAllVoteAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllVoteAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteAllVoteAnswerResponse")
    public JAXBElement<DeleteAllVoteAnswerResponse> createDeleteAllVoteAnswerResponse(DeleteAllVoteAnswerResponse value) {
        return new JAXBElement<DeleteAllVoteAnswerResponse>(_DeleteAllVoteAnswerResponse_QNAME, DeleteAllVoteAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllVoteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteAllVoteQuestion")
    public JAXBElement<DeleteAllVoteQuestion> createDeleteAllVoteQuestion(DeleteAllVoteQuestion value) {
        return new JAXBElement<DeleteAllVoteQuestion>(_DeleteAllVoteQuestion_QNAME, DeleteAllVoteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAllVoteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteAllVoteQuestionResponse")
    public JAXBElement<DeleteAllVoteQuestionResponse> createDeleteAllVoteQuestionResponse(DeleteAllVoteQuestionResponse value) {
        return new JAXBElement<DeleteAllVoteQuestionResponse>(_DeleteAllVoteQuestionResponse_QNAME, DeleteAllVoteQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteQuestion")
    public JAXBElement<DeleteQuestion> createDeleteQuestion(DeleteQuestion value) {
        return new JAXBElement<DeleteQuestion>(_DeleteQuestion_QNAME, DeleteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "deleteQuestionResponse")
    public JAXBElement<DeleteQuestionResponse> createDeleteQuestionResponse(DeleteQuestionResponse value) {
        return new JAXBElement<DeleteQuestionResponse>(_DeleteQuestionResponse_QNAME, DeleteQuestionResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getCountAnswer")
    public JAXBElement<GetCountAnswer> createGetCountAnswer(GetCountAnswer value) {
        return new JAXBElement<GetCountAnswer>(_GetCountAnswer_QNAME, GetCountAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getCountAnswerResponse")
    public JAXBElement<GetCountAnswerResponse> createGetCountAnswerResponse(GetCountAnswerResponse value) {
        return new JAXBElement<GetCountAnswerResponse>(_GetCountAnswerResponse_QNAME, GetCountAnswerResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVotesAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getVotesAnswer")
    public JAXBElement<GetVotesAnswer> createGetVotesAnswer(GetVotesAnswer value) {
        return new JAXBElement<GetVotesAnswer>(_GetVotesAnswer_QNAME, GetVotesAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVotesAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getVotesAnswerResponse")
    public JAXBElement<GetVotesAnswerResponse> createGetVotesAnswerResponse(GetVotesAnswerResponse value) {
        return new JAXBElement<GetVotesAnswerResponse>(_GetVotesAnswerResponse_QNAME, GetVotesAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVotesQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getVotesQuestion")
    public JAXBElement<GetVotesQuestion> createGetVotesQuestion(GetVotesQuestion value) {
        return new JAXBElement<GetVotesQuestion>(_GetVotesQuestion_QNAME, GetVotesQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVotesQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getVotesQuestionResponse")
    public JAXBElement<GetVotesQuestionResponse> createGetVotesQuestionResponse(GetVotesQuestionResponse value) {
        return new JAXBElement<GetVotesQuestionResponse>(_GetVotesQuestionResponse_QNAME, GetVotesQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasVotedAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "hasVotedAnswer")
    public JAXBElement<HasVotedAnswer> createHasVotedAnswer(HasVotedAnswer value) {
        return new JAXBElement<HasVotedAnswer>(_HasVotedAnswer_QNAME, HasVotedAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasVotedAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "hasVotedAnswerResponse")
    public JAXBElement<HasVotedAnswerResponse> createHasVotedAnswerResponse(HasVotedAnswerResponse value) {
        return new JAXBElement<HasVotedAnswerResponse>(_HasVotedAnswerResponse_QNAME, HasVotedAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasVotedQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "hasVotedQuestion")
    public JAXBElement<HasVotedQuestion> createHasVotedQuestion(HasVotedQuestion value) {
        return new JAXBElement<HasVotedQuestion>(_HasVotedQuestion_QNAME, HasVotedQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasVotedQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "hasVotedQuestionResponse")
    public JAXBElement<HasVotedQuestionResponse> createHasVotedQuestionResponse(HasVotedQuestionResponse value) {
        return new JAXBElement<HasVotedQuestionResponse>(_HasVotedQuestionResponse_QNAME, HasVotedQuestionResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "updateQuestion")
    public JAXBElement<UpdateQuestion> createUpdateQuestion(UpdateQuestion value) {
        return new JAXBElement<UpdateQuestion>(_UpdateQuestion_QNAME, UpdateQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "updateQuestionResponse")
    public JAXBElement<UpdateQuestionResponse> createUpdateQuestionResponse(UpdateQuestionResponse value) {
        return new JAXBElement<UpdateQuestionResponse>(_UpdateQuestionResponse_QNAME, UpdateQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteAnswer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "voteAnswer")
    public JAXBElement<VoteAnswer> createVoteAnswer(VoteAnswer value) {
        return new JAXBElement<VoteAnswer>(_VoteAnswer_QNAME, VoteAnswer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteAnswerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "voteAnswerResponse")
    public JAXBElement<VoteAnswerResponse> createVoteAnswerResponse(VoteAnswerResponse value) {
        return new JAXBElement<VoteAnswerResponse>(_VoteAnswerResponse_QNAME, VoteAnswerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "voteQuestion")
    public JAXBElement<VoteQuestion> createVoteQuestion(VoteQuestion value) {
        return new JAXBElement<VoteQuestion>(_VoteQuestion_QNAME, VoteQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VoteQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "voteQuestionResponse")
    public JAXBElement<VoteQuestionResponse> createVoteQuestionResponse(VoteQuestionResponse value) {
        return new JAXBElement<VoteQuestionResponse>(_VoteQuestionResponse_QNAME, VoteQuestionResponse.class, null, value);
    }

}
