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
@Table(name = "cart_details")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId; //id
	private int quantity;
	private double price;
	private int productId;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@OneToOne
	@JoinColumn(name = "id")
	private ProductItems ProductItems;




}
