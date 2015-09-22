package com.codereq.springwstwo;

import com.codereq.mathservice.generated.AddNumberRequest;
import com.codereq.mathservice.generated.AddNumberResponse;

public interface MathService {

	public AddNumberResponse add(AddNumberRequest addNumberRequest);
	
}
