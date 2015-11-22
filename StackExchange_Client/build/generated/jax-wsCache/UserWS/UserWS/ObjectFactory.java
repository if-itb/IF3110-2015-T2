
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

    private final static QName _GetUserNameByIDResponse_QNAME = new QName("http://user.model/", "getUserNameByIDResponse");
    private final static QName _GetUserNameByID_QNAME = new QName("http://user.model/", "getUserNameByID");
    private final static QName _AddUser_QNAME = new QName("http://user.model/", "addUser");
    private final static QName _GetUserByIDResponse_QNAME = new QName("http://user.model/", "getUserByIDResponse");
    private final static QName _User_QNAME = new QName("http://user.model/", "User");
    private final static QName _GetUserByID_QNAME = new QName("http://user.model/", "getUserByID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: UserWS
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link GetUserByID }
     * 
     */
    public GetUserByID createGetUserByID() {
        return new GetUserByID();
    }

    /**
     * Create an instance of {@link GetUserNameByIDResponse }
     * 
     */
    public GetUserNameByIDResponse createGetUserNameByIDResponse() {
        return new GetUserNameByIDResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetUserByIDResponse }
     * 
     */
    public GetUserByIDResponse createGetUserByIDResponse() {
        return new GetUserByIDResponse();
    }

    /**
     * Create an instance of {@link GetUserNameByID }
     * 
     */
    public GetUserNameByID createGetUserNameByID() {
        return new GetUserNameByID();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNameByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "getUserNameByIDResponse")
    public JAXBElement<GetUserNameByIDResponse> createGetUserNameByIDResponse(GetUserNameByIDResponse value) {
        return new JAXBElement<GetUserNameByIDResponse>(_GetUserNameByIDResponse_QNAME, GetUserNameByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNameByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "getUserNameByID")
    public JAXBElement<GetUserNameByID> createGetUserNameByID(GetUserNameByID value) {
        return new JAXBElement<GetUserNameByID>(_GetUserNameByID_QNAME, GetUserNameByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "getUserByIDResponse")
    public JAXBElement<GetUserByIDResponse> createGetUserByIDResponse(GetUserByIDResponse value) {
        return new JAXBElement<GetUserByIDResponse>(_GetUserByIDResponse_QNAME, GetUserByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "User")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.model/", name = "getUserByID")
    public JAXBElement<GetUserByID> createGetUserByID(GetUserByID value) {
        return new JAXBElement<GetUserByID>(_GetUserByID_QNAME, GetUserByID.class, null, value);
    }

}
