package com.cg.ecom.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	

	@Value(value="${message1}")
	private String message1;
	 @ExceptionHandler(value=ItemNotAvailableException.class)
	public ResponseEntity itemNotAvailableException(ItemNotAvailableException ex) {
	return new ResponseEntity(message1,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message2}")
	private String message2;
	
	@ExceptionHandler(value=PaymentNotFoundException.class)
	public ResponseEntity  paymentNotFoundException(PaymentNotFoundException ex) {
		return new ResponseEntity(message2,HttpStatus.NOT_FOUND);
	}
	
	
	@Value(value="${message3}")
	private String message3;
	@ExceptionHandler(value=ProductSupplierNotAvailableException.class)
	public ResponseEntity  productSupplierNotAvailable(ProductSupplierNotAvailableException ex) {
		return new ResponseEntity(message3,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message4}")
	private String message4;
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity  customerNotFoundException(CustomerNotFoundException ex) {
		return new ResponseEntity(message4,HttpStatus.NOT_FOUND);
	}
	

}
