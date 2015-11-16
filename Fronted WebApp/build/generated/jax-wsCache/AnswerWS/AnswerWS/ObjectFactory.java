
package AnswerWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the AnswerWS package. 
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

    private final static QName _Answer_QNAME = new QName("http://AnswerModel/", "Answer");
    private final static QName _GetAnswerByQId_QNAME = new QName("http://AnswerModel/", "getAnswerByQId");
    private final static QName _GetAnswerByQIdResponse_QNAME = new QName("http://AnswerModel/", "getAnswerByQIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: AnswerWS
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
     * Create an instance of {@link GetAnswerByQIdResponse }
     * 
     */
    public GetAnswerByQIdResponse createGetAnswerByQIdResponse() {
        return new GetAnswerByQIdResponse();
    }

    /**
     * Create an instance of {@link GetAnswerByQId }
     * 
     */
    public GetAnswerByQId createGetAnswerByQId() {
        return new GetAnswerByQId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Answer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AnswerModel/", name = "Answer")
    public JAXBElement<Answer> createAnswer(Answer value) {
        return new JAXBElement<Answer>(_Answer_QNAME, Answer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerByQId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AnswerModel/", name = "getAnswerByQId")
    public JAXBElement<GetAnswerByQId> createGetAnswerByQId(GetAnswerByQId value) {
        return new JAXBElement<GetAnswerByQId>(_GetAnswerByQId_QNAME, GetAnswerByQId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerByQIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://AnswerModel/", name = "getAnswerByQIdResponse")
    public JAXBElement<GetAnswerByQIdResponse> createGetAnswerByQIdResponse(GetAnswerByQIdResponse value) {
        return new JAXBElement<GetAnswerByQIdResponse>(_GetAnswerByQIdResponse_QNAME, GetAnswerByQIdResponse.class, null, value);
    }

}
