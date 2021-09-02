package com.retailstore.exception;


import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.retailstore.model.ApiException;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
				
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
//		if ( e.getStatusCode() ==  HttpStatus.BAD_REQUEST ) {
//			httpStatus = HttpStatus.BAD_REQUEST;
//		}
//
//		if ( e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR ) {
//			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//		}

		ApiException apiException = new ApiException(e.getMessage(), httpStatus, 
				ZonedDateTime.now(ZoneId.of("UTC")));
		
		return new ResponseEntity<>(apiException, httpStatus);

	}
	
//	@ExceptionHandler(value = ApiRequestDetailedException.class)
//	public ResponseEntity<Object> handleApiRequestDetailedException(ApiRequestDetailedException e){
//				
//		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//		
//		if ( e.getStatusCode() ==  HttpStatus.BAD_REQUEST ) {
//			httpStatus = HttpStatus.BAD_REQUEST;
//		}
//
//		if ( e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR ) {
//			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//
//		ApiException apiException = new ApiException(e.getMessage(), httpStatus, 
//				ZonedDateTime.now(ZoneId.of("UTC")), e.getErrorCode());
//		
//		return new ResponseEntity<>(apiException, httpStatus);
//
//	}

}
