package com.yangnormal.sstackex.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;



@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
		@WebMethod
        String[][] getQuestionList();
	    @WebMethod
		String printMessage();
}
