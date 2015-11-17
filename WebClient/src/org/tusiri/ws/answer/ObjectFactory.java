
package org.tusiri.ws.answer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tusiri.ws.answer package. 
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

    private final static QName _GetAnswerListResponse_QNAME = new QName("http://answer.ws.tusiri.org/", "getAnswerListResponse");
    private final static QName _GetAnswerList_QNAME = new QName("http://answer.ws.tusiri.org/", "getAnswerList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tusiri.ws.answer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAnswerList }
     * 
     */
    public GetAnswerList createGetAnswerList() {
        return new GetAnswerList();
    }

    /**
     * Create an instance of {@link GetAnswerListResponse }
     * 
     */
    public GetAnswerListResponse createGetAnswerListResponse() {
        return new GetAnswerListResponse();
    }

    /**
     * Create an instance of {@link AnswerItem }
     * 
     */
    public AnswerItem createAnswerItem() {
        return new AnswerItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://answer.ws.tusiri.org/", name = "getAnswerListResponse")
    public JAXBElement<GetAnswerListResponse> createGetAnswerListResponse(GetAnswerListResponse value) {
        return new JAXBElement<GetAnswerListResponse>(_GetAnswerListResponse_QNAME, GetAnswerListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAnswerList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://answer.ws.tusiri.org/", name = "getAnswerList")
    public JAXBElement<GetAnswerList> createGetAnswerList(GetAnswerList value) {
        return new JAXBElement<GetAnswerList>(_GetAnswerList_QNAME, GetAnswerList.class, null, value);
    }

}
