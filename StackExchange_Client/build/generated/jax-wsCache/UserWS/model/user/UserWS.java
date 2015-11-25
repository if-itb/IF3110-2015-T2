
package model.user;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserWS", targetNamespace = "http://user.model/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserWS {


    /**
     * 
     * @param userId
     * @return
     *     returns model.user.User
     */
    @WebMethod
    @WebResult(name = "User", targetNamespace = "")
    @RequestWrapper(localName = "getUserByID", targetNamespace = "http://user.model/", className = "model.user.GetUserByID")
    @ResponseWrapper(localName = "getUserByIDResponse", targetNamespace = "http://user.model/", className = "model.user.GetUserByIDResponse")
    @Action(input = "http://user.model/UserWS/getUserByIDRequest", output = "http://user.model/UserWS/getUserByIDResponse")
    public User getUserByID(
        @WebParam(name = "user_id", targetNamespace = "")
        int userId);

    /**
     * 
     * @param u
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "addUser", targetNamespace = "http://user.model/", className = "model.user.AddUser")
    @Action(input = "http://user.model/UserWS/addUser")
    public void addUser(
        @WebParam(name = "u", targetNamespace = "")
        User u);

    /**
     * 
     * @param email
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(name = "Integer", targetNamespace = "")
    @RequestWrapper(localName = "getIDbyEmail", targetNamespace = "http://user.model/", className = "model.user.GetIDbyEmail")
    @ResponseWrapper(localName = "getIDbyEmailResponse", targetNamespace = "http://user.model/", className = "model.user.GetIDbyEmailResponse")
    @Action(input = "http://user.model/UserWS/getIDbyEmailRequest", output = "http://user.model/UserWS/getIDbyEmailResponse")
    public Integer getIDbyEmail(
        @WebParam(name = "email", targetNamespace = "")
        String email);

}
