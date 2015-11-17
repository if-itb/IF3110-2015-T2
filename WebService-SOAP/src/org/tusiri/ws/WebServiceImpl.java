package org.tusiri.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "org.tusiri.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String printMessage() {
		return "Hello from Tusiri Server";
	}

}