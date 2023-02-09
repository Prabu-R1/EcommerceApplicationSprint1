package com.cg.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemsDTO {

	private int productId;
	private int productSupplierId;
	private String ProductName;
	private int price;
	private int quantity;



	
}
