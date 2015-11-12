
package org.tusiri.ws.question;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tusiri.ws.question package. 
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

    private final static QName _Questionitem_QNAME = new QName("http://question.ws.tusiri.org/", "questionitem");
    private final static QName _GetQuestionList_QNAME = new QName("http://question.ws.tusiri.org/", "getQuestionList");
    private final static QName _GetQuestionListResponse_QNAME = new QName("http://question.ws.tusiri.org/", "getQuestionListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tusiri.ws.question
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuestionListResponse }
     * 
     */
    public GetQuestionListResponse createGetQuestionListResponse() {
        return new GetQuestionListResponse();
    }

    /**
     * Create an instance of {@link QuestionItem }
     * 
     */
    public QuestionItem createQuestionItem() {
        return new QuestionItem();
    }

    /**
     * Create an instance of {@link GetQuestionList }
     * 
     */
    public GetQuestionList createGetQuestionList() {
        return new GetQuestionList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.ws.tusiri.org/", name = "questionitem")
    public JAXBElement<QuestionItem> createQuestionitem(QuestionItem value) {
        return new JAXBElement<QuestionItem>(_Questionitem_QNAME, QuestionItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.ws.tusiri.org/", name = "getQuestionList")
    public JAXBElement<GetQuestionList> createGetQuestionList(GetQuestionList value) {
        return new JAXBElement<GetQuestionList>(_GetQuestionList_QNAME, GetQuestionList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://question.ws.tusiri.org/", name = "getQuestionListResponse")
    public JAXBElement<GetQuestionListResponse> createGetQuestionListResponse(GetQuestionListResponse value) {
        return new JAXBElement<GetQuestionListResponse>(_GetQuestionListResponse_QNAME, GetQuestionListResponse.class, null, value);
    }

}
