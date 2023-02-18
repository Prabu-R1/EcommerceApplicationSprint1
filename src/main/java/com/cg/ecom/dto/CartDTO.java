package com.cg.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

	
	
	private int cartId;
	private int quantity;
//	private double price;
	/////////////////
	private int customerId;
	private int productId;
//	private int productSupplierId;


}
