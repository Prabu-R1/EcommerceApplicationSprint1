package com.cg.ecom.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_items")
public class ProductItems {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;	
	private String ProductName;
	private int price;
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name="product_supplier_id")
	private ProductSupplier productSuppliers;



}
