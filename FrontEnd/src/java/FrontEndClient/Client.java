package FrontEndClient;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import Webservice.HelloWorld;

public class Client{
	
    public String GetHello() throws Exception {
	   
	URL url = new URL("http://localhost:9999/ws/hello?wsdl");
	
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://Webservice/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        return(hello.getHelloWorldAsString("Cliff"));

    }

}