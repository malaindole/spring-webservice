package com.codereq.springwstwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import com.codereq.mathservice.generated.AddNumberRequest;
import com.codereq.mathservice.generated.AddNumberResponse;

@Endpoint
public class MathServiceEndpoint {

	@Autowired
	MathService mathService;
	
	@SoapAction(value="http://MathModule.cxf.codereq.com/AddNumber")
	public @ResponsePayload AddNumberResponse sum(@RequestPayload AddNumberRequest addNumberRequest) {
		AddNumberResponse response = mathService.add(addNumberRequest);
		return response;
	}
	
}
