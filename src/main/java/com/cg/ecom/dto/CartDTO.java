package com.cg.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

	private int productSupplierId;
	private int customerId;
	private int cartId;
	private int productId;
	private int quantity;
	private double price;

//	public int getRestaurantId() {
//		return restaurantId;
//	}
//
//	public void setRestaurantId(int restaurantId) {
//		this.restaurantId = restaurantId;
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
//	public int getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(int cartId) {
//		this.cartId = cartId;
//	}
//
//	public int getFoodId() {
//		return foodId;
//	}
//
//	public void setFoodId(int foodId) {
//		this.foodId = foodId;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}

}
