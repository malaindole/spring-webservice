package com.codereq.springwsone;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	public boolean isEven(Integer number) {
		if(number % 2 == 0) {
			return true;
		}
		return false;
	}
	
}
