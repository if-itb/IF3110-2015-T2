
package questionmodel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the questionmodel package. 
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

    private final static QName _CreateQuestion_QNAME = new QName("http://QuestionModel/", "createQuestion");
    private final static QName _CreateQuestionResponse_QNAME = new QName("http://QuestionModel/", "createQuestionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: questionmodel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateQuestionResponse }
     * 
     */
    public CreateQuestionResponse createCreateQuestionResponse() {
        return new CreateQuestionResponse();
    }

    /**
     * Create an instance of {@link CreateQuestion }
     * 
     */
    public CreateQuestion createCreateQuestion() {
        return new CreateQuestion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://QuestionModel/", name = "createQuestion")
    public JAXBElement<CreateQuestion> createCreateQuestion(CreateQuestion value) {
        return new JAXBElement<CreateQuestion>(_CreateQuestion_QNAME, CreateQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://QuestionModel/", name = "createQuestionResponse")
    public JAXBElement<CreateQuestionResponse> createCreateQuestionResponse(CreateQuestionResponse value) {
        return new JAXBElement<CreateQuestionResponse>(_CreateQuestionResponse_QNAME, CreateQuestionResponse.class, null, value);
    }

}
