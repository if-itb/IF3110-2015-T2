
package UserWS;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the UserWS package. 
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

    private final static QName _GetUserbyID_QNAME = new QName("http://UserModel/", "getUserbyID");
    private final static QName _GetUserbyIDResponse_QNAME = new QName("http://UserModel/", "getUserbyIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UserWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserbyID }
     * 
     */
    public GetUserbyID createGetUserbyID() {
        return new GetUserbyID();
    }

    /**
     * Create an instance of {@link GetUserbyIDResponse }
     * 
     */
    public GetUserbyIDResponse createGetUserbyIDResponse() {
        return new GetUserbyIDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserbyID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserModel/", name = "getUserbyID")
    public JAXBElement<GetUserbyID> createGetUserbyID(GetUserbyID value) {
        return new JAXBElement<GetUserbyID>(_GetUserbyID_QNAME, GetUserbyID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserbyIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserModel/", name = "getUserbyIDResponse")
    public JAXBElement<GetUserbyIDResponse> createGetUserbyIDResponse(GetUserbyIDResponse value) {
        return new JAXBElement<GetUserbyIDResponse>(_GetUserbyIDResponse_QNAME, GetUserbyIDResponse.class, null, value);
    }

}
