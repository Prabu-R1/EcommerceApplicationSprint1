package com.cg.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

	private int orderId;

	private String status;
	private String deliveryAddress;
	private int customerId;
	private int productSupplierId;
	private int cartId;
	private int productId;
	private int quantity;
	


	

}
