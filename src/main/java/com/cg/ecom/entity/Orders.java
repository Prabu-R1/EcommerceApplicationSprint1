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
	private LocalDate date;
	private String status;
	private String deliveryAddress;
	private int cartId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductSupplier productSuppliers;



//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public Customers getCustomers() {
//		return customers;
//	}
//
//	public void setCustomers(Customers customers) {
//		this.customers = customers;
//	}
//
//	public Restaurants getRestaurants() {
//		return restaurants;
//	}
//
//	public void setRestaurants(Restaurants restaurants) {
//		this.restaurants = restaurants;
//	}
//
//	public String getDeliveryAddress() {
//		return deliveryAddress;
//	}
//
//	public void setDeliveryAddress(String deliveryAddress) {
//		this.deliveryAddress = deliveryAddress;
//	}
//
//	public int getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(int cartId) {
//		this.cartId = cartId;
//	}



	
}
