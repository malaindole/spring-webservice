package com.codereq.springwstwo;

import com.codereq.mathservice.generated.AddNumberRequest;
import com.codereq.mathservice.generated.AddNumberResponse;

public class MathServiceImpl implements MathService {

	public AddNumberResponse add(AddNumberRequest addNumberRequest) {
		AddNumberResponse addNumberResponse = new AddNumberResponse();
		addNumberResponse.setCode("00");
		addNumberResponse.setResult(addNumberRequest.getNumber1() + addNumberRequest.getNumber2());
		return addNumberResponse;
	}

	
	
}
