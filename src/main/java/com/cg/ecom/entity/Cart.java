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
@Table(name = "cart_details")
public class Cart {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int quantity;

	@OneToOne
	@JoinColumn(name = "customer_cart_fk")
	private Customers customers;
	
	@OneToOne
	@JoinColumn(name = "cart_product_fk")
	private ProductItems productItems;

}
	
//	@Transient	
//	private List<ProductItems> productItems;
	
//	@OneToMany
//	@JoinColumn(name = "cart_product_fk")
//	private List<ProductItems> productItems;
	
	