package com.cg.ecom.entity;

import java.time.LocalDate;

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
@Table(name = "order_details")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
//	private LocalDate date;
	private String status;
	private String deliveryAddress;
	private int cartId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductSupplier productSuppliers;




	
}
