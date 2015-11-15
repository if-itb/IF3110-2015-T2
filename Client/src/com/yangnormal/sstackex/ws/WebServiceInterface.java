
package com.yangnormal.sstackex.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import net.java.dev.jaxb.array.ObjectFactory;
import net.java.dev.jaxb.array.StringArrayArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceInterface", targetNamespace = "http://ws.sstackex.yangnormal.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceInterface {


    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArrayArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.sstackex.yangnormal.com/WebServiceInterface/getQuestionListRequest", output = "http://ws.sstackex.yangnormal.com/WebServiceInterface/getQuestionListResponse")
    public StringArrayArray getQuestionList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://ws.sstackex.yangnormal.com/WebServiceInterface/printMessageRequest", output = "http://ws.sstackex.yangnormal.com/WebServiceInterface/printMessageResponse")
    public String printMessage();

}
