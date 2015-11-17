package org.tusiri.ws.hello;

import javax.jws.WebService;

@WebService(endpointInterface = "org.tusiri.ws.hello.Hello")

public class HelloImpl implements Hello {
	@Override
	public String sayHello(String name)
	{
		return "Welcome to Tusiri Server, " + name;
		
	}
}