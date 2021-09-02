package com.retailstore.exception;


public class ApiRequestException extends RuntimeException{
	
	

	private static final long serialVersionUID = -485342244969334188L;

	public ApiRequestException(String message) {
		super(message);
	}

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
