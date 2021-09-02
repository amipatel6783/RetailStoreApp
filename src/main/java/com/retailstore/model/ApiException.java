package com.retailstore.model;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final String message;
	private final HttpStatus status;
	private final ZonedDateTime timestamp;
	private int error_code;

	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.status = httpStatus;
		//this.error_code = errorCode;
		this.timestamp = timestamp;
	}
	
	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp, int errorCode) {
		super();
		this.message = message;
		this.status = httpStatus;
		this.error_code = errorCode;
		this.timestamp = timestamp;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	
	
	
}
