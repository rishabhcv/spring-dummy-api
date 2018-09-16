package com.esp.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GenericExceptionResponse extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PlayerNotFoundException.class)
	public final ResponseEntity<Object> handleAllNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostFailedException.class)
	public final ResponseEntity<Object> handlePostExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse expResp = new ExceptionResponse(ex.getLocalizedMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
	}

}
