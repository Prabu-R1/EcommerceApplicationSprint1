package com.cg.ecom.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String,Object> objectBody=new LinkedHashMap<>();
		objectBody.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
		objectBody.put("errorCode", status.value());
		List<String> exceptions= ex.getBindingResult().getFieldErrors().stream().map(m->m.getDefaultMessage()).collect(Collectors.toList());
		objectBody.put("errorMessage", exceptions);
		return new ResponseEntity<Object>(objectBody, status);
	}
	
	@ExceptionHandler(ItemNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> handler(ItemNotAvailableException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response=new ResponseEntity<ExceptionResponse>(exception,HttpStatus.BAD_REQUEST);
		return response;
	}
	
	
	@ExceptionHandler(ProductSupplierNotAvailableException.class)
	public ResponseEntity<ExceptionResponse> handler(ProductSupplierNotAvailableException ex){
		ExceptionResponse exception=new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ExceptionResponse> response=new ResponseEntity<ExceptionResponse>(exception,HttpStatus.BAD_REQUEST);
		return response;
	}

}
