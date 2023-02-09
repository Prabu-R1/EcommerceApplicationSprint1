package com.cg.ecom.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

	private int orderId;
//	private LocalDate date;
	private String status;
	private String deliveryAddress;
	private int customerId;
	private int productSupplierId;
	private int cartId;

//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
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
//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//	public int getRestaurantId() {
//		return restaurantId;
//	}
//
//	public void setRestaurantId(int restaurantId) {
//		this.restaurantId = restaurantId;
//	}
//
//	public int getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(int cartId) {
//		this.cartId = cartId;
//	}
//
//	public String getDeliveryAddress() {
//		return deliveryAddress;
//	}
//
//	public void setDeliveryAddress(String deliveryAddress) {
//		this.deliveryAddress = deliveryAddress;
//	}
	

}
