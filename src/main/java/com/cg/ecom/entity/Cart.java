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
	private int id;
	private int quantity;
	private double price;
	private int productId;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@OneToOne
	@JoinColumn(name = "id")
	private ProductItems ProductItems;

//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
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
//	public Customers getCustomers() {
//		return customers;
//	}
//
//	public void setCustomers(Customers customers) {
//		this.customers = customers;
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
//	public FoodItems getFoodItems() {
//		return FoodItems;
//	}
//
//	public void setFoodItems(FoodItems foodItems) {
//		FoodItems = foodItems;
//	}


}
