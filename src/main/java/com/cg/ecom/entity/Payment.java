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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int paymentId;
	private LocalDate paymentDate;
	private String paymentType;
	private String paymentStatus;
    private long totalPrice;
	@OneToOne
	@JoinColumn(name="payment_cart_fk")
	private Cart cartId;
	
	@OneToOne
	@JoinColumn(name="payment_order_fk")
	private Orders orderId ;
	

	
	

}
