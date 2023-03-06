package com.cg.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSupplierDTO {

	private int productSupplierId;
	private String productSupplierName;
	private String location;
	private Long contactNo;
	
	private String emailId;



}
