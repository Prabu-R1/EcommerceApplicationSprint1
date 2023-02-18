package com.cg.ecom.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_details")
public class Payment {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private LocalDate paymentDate;
	private String paymentType;
	private String paymentStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_cart_fk")
	private Cart cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_order_fk")
	private Orders orderId ;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="payment_product_fk")
//	private List<ProductItems> productItems ;
	
	

}
