package com.cg.ecom.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private LocalDate paymentDate;
	private String paymentType;
	private String paymentStatus;

	@OneToOne
	private Cart cartId;

//	public String getPaymentType() {
//		return paymentType;
//	}
//
//	public void setPaymentType(String paymentType) {
//		this.paymentType = paymentType;
//	}
//
//	public int getPaymentId() {
//		return paymentId;
//	}
//
//	public void setPaymentId(int paymentId) {
//		this.paymentId = paymentId;
//	}
//
//	public LocalDate getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(LocalDate paymentDate) {
//		this.paymentDate = paymentDate;
//	}
//
//	public String getPaymentStatus() {
//		return paymentStatus;
//	}
//
//	public void setPaymentStatus(String paymentStatus) {
//		this.paymentStatus = paymentStatus;
//	}
//
//	public Cart getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(Cart cartId) {
//		this.cartId = cartId;
//	}

}
