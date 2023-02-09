package com.cg.ecom.entity;


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
@Table(name="product_items")
public class ProductItems {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;	
	private String ProductName;
	private int price;
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name="product_supplier_id")
	private ProductSupplier productSuppliers;


//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public Restaurants getRestaurants() {
//		return restaurants;
//	}
//
//
//	public void setRestaurants(Restaurants restaurants) {
//		this.restaurants = restaurants;
//	}
//
//
//	public int getPrice() {
//		return price;
//	}
//
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}


	


	



	
	
}
