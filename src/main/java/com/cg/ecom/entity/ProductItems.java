package com.cg.ecom.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_items")
public class ProductItems {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;	
	private String ProductName;
	private int price;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "product_supplier_id")
	private ProductSupplier productSuppliers;

	@Transient
	private Cart carts;
	
//	@Transient
//	private Cart carts;
	
	// constructors, getters, and setters omitted
}