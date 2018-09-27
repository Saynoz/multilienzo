package com.picolab.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Ya no quedan mas lienzos :(")
public class NotFoundException extends Exception {

	public NotFoundException(String msg) {
		super(msg);
	}
	
	public NotFoundException() {
		super();
	}
}
