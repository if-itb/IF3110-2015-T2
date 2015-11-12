package org.tusiri.ws.question;
import javax.xml.ws.Endpoint;

import org.tusiri.ws.hello.HelloImpl;

public class WSPublisher {
	public static void main(String[] args){
		Endpoint.publish("http://localhost:8080/WS/Greeting",new HelloImpl());
	}
}