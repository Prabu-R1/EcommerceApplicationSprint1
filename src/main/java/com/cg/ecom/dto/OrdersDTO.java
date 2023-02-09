package com.cg.ecom.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

	private int orderId;
//	private LocalDate date;
	private String status;
	private String deliveryAddress;
	private int customerId;
	private int productSupplierId;
	private int cartId;



}
