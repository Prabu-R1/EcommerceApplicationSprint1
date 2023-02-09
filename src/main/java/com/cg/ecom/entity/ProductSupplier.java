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
@Table(name = "product_suppplier")
public class ProductSupplier {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productSupplierId;
	
	private String productSupplierName;
	private String location;
	private Long contactNo;
	private String emailId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User userId;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public Long getContactNo() {
//		return contactNo;
//	}
//
//	public void setContactNo(Long contactNo) {
//		this.contactNo = contactNo;
//	}
//
//	public String getEmailId() {
//		return emailId;
//	}
//
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//	public User getUserId() {
//		return userId;
//	}
//
//	public void setUserId(User userId) {
//		this.userId = userId;
//	}

}