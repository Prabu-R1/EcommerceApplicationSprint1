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
	public ResponseEntity<String> itemNotAvailableException(ItemNotAvailableException ex) {
	return new ResponseEntity<String>(message1,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message2}")
	private String message2;
	
	@ExceptionHandler(value=PaymentNotFoundException.class)
	public ResponseEntity<String>  paymentNotFoundException(PaymentNotFoundException ex) {
		return new ResponseEntity<String>(message2,HttpStatus.NOT_FOUND);
	}
	
	
	@Value(value="${message3}")
	private String message3;
	@ExceptionHandler(value=ProductSupplierNotAvailableException.class)
	public ResponseEntity<String>  productSupplierNotAvailable(ProductSupplierNotAvailableException ex) {
		return new ResponseEntity<String>(message3,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message4}")
	private String message4;
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<String>  customerNotFoundException(CustomerNotFoundException ex) {
		return new ResponseEntity<String>(message4,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message5}")
	private String message5;
	@ExceptionHandler(value=ProductOutStockException.class)
	public ResponseEntity<String> ProductOutStockException(ProductOutStockException ex)
	{
		return new ResponseEntity<String>(message5,HttpStatus.NOT_FOUND);
	}
	
	@Value(value="${message6}")
	private String message6;
	@ExceptionHandler(value=CartIdAlreadyExistsException.class)
	public ResponseEntity<String> CartIdAlreadyExistsException(CartIdAlreadyExistsException ex)
	{
		return new ResponseEntity<String>(message6,HttpStatus.IM_USED);
	}
	

}
