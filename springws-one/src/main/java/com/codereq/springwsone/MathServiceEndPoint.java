package com.codereq.springwsone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.codereq.mathservice.schemas.MathServiceRequest;
import com.codereq.mathservice.schemas.MathServiceResponse;

@Endpoint
public class MathServiceEndPoint {

	@Autowired
	MathService mathService;
	
	@PayloadRoot(namespace = "http://codereq.com/mathservice/schemas" ,localPart="MathServiceRequest")
    public @ResponsePayload MathServiceResponse handleMathServiceRequest(@RequestPayload MathServiceRequest mathServiceRequest) {
        boolean isEven = getMathService().isEven(mathServiceRequest.getNumber().intValue());
		MathServiceResponse r = new MathServiceResponse();
		r.setIsEven(isEven);
		r.setNumber(mathServiceRequest.getNumber());
		return r;
    }

    public MathService getMathService() {
    	return mathService;
    }

    public void setMathService(MathService mathService) {
    	this.mathService = mathService;
    }
}
