package com.picolab.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="El parametro introducido es incorrecto o ya existe.")
public class InvalidParamException extends Exception {

	public InvalidParamException(String msg) {
		super(msg);
	}
	
	public InvalidParamException() {
		super();
	}
}
