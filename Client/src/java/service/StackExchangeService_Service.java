
package service;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "StackExchangeService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:39358/StackExchangeService/StackExchangeService?wsdl")
public class StackExchangeService_Service
    extends Service
{

    private final static URL STACKEXCHANGESERVICE_WSDL_LOCATION;
    private final static WebServiceException STACKEXCHANGESERVICE_EXCEPTION;
    private final static QName STACKEXCHANGESERVICE_QNAME = new QName("http://service/", "StackExchangeService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:39358/StackExchangeService/StackExchangeService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        STACKEXCHANGESERVICE_WSDL_LOCATION = url;
        STACKEXCHANGESERVICE_EXCEPTION = e;
    }

    public StackExchangeService_Service() {
        super(__getWsdlLocation(), STACKEXCHANGESERVICE_QNAME);
    }

    public StackExchangeService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), STACKEXCHANGESERVICE_QNAME, features);
    }

    public StackExchangeService_Service(URL wsdlLocation) {
        super(wsdlLocation, STACKEXCHANGESERVICE_QNAME);
    }

    public StackExchangeService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, STACKEXCHANGESERVICE_QNAME, features);
    }

    public StackExchangeService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StackExchangeService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns StackExchangeService
     */
    @WebEndpoint(name = "StackExchangeServicePort")
    public StackExchangeService getStackExchangeServicePort() {
        return super.getPort(new QName("http://service/", "StackExchangeServicePort"), StackExchangeService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StackExchangeService
     */
    @WebEndpoint(name = "StackExchangeServicePort")
    public StackExchangeService getStackExchangeServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "StackExchangeServicePort"), StackExchangeService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (STACKEXCHANGESERVICE_EXCEPTION!= null) {
            throw STACKEXCHANGESERVICE_EXCEPTION;
        }
        return STACKEXCHANGESERVICE_WSDL_LOCATION;
    }

}
