package com.yangnormal.sstackex.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.yangnormal.sstackex.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String printMessage() {
		return "Hello World!";
	}

}
