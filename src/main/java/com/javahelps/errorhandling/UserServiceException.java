package com.javahelps.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javahelps.restservice.entity.User;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
@ControllerAdvice
public class UserServiceException extends Exception {

	private Exception exception;
	private int code;

	public UserServiceException(String message, int invalidPortConfiguration) {
		super(message);
		this.code = invalidPortConfiguration;    
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}