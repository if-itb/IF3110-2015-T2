
package webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NewWebService", targetNamespace = "http://WebService/", wsdlLocation = "http://localhost:8080/WebService/NewWebService?wsdl")
public class NewWebService
    extends Service
{

    private final static URL NEWWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException NEWWEBSERVICE_EXCEPTION;
    private final static QName NEWWEBSERVICE_QNAME = new QName("http://WebService/", "NewWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebService/NewWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NEWWEBSERVICE_WSDL_LOCATION = url;
        NEWWEBSERVICE_EXCEPTION = e;
    }

    public NewWebService() {
        super(__getWsdlLocation(), NEWWEBSERVICE_QNAME);
    }

    public NewWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NEWWEBSERVICE_QNAME, features);
    }

    public NewWebService(URL wsdlLocation) {
        super(wsdlLocation, NEWWEBSERVICE_QNAME);
    }

    public NewWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NEWWEBSERVICE_QNAME, features);
    }

    public NewWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NewWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StackWebSevice
     */
    @WebEndpoint(name = "StackWebSevicePort")
    public StackWebSevice getStackWebSevicePort() {
        return super.getPort(new QName("http://WebService/", "StackWebSevicePort"), StackWebSevice.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StackWebSevice
     */
    @WebEndpoint(name = "StackWebSevicePort")
    public StackWebSevice getStackWebSevicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebService/", "StackWebSevicePort"), StackWebSevice.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NEWWEBSERVICE_EXCEPTION!= null) {
            throw NEWWEBSERVICE_EXCEPTION;
        }
        return NEWWEBSERVICE_WSDL_LOCATION;
    }

}
