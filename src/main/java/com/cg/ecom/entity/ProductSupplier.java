package com.cg.ecom.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_suppplier")
public class ProductSupplier {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productSupplierId;
	
	private String productSupplierName;
	private String location;
	private Long contactNo;
	private String emailId;

//	@OneToOne
//	@JoinColumn(name = "userId")
//	private User userId;



}