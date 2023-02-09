package com.cg.ecom.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentDTO {

	private int paymentId;
	private LocalDate paymentDate;
	private String paymentType;
	private String paymentStatus;
	private int cartId;



}
