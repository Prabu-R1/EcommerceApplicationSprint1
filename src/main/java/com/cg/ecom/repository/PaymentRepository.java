package com.cg.ecom.repository;


import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{

//	Iterable<Payment> findAll();
	
	 @Query("SELECT SUM(ci.productItems.price * ci.quantity) FROM Cart ci " +
	           "WHERE ci.customers.customerId = :customerId")
	    Long findTotalPriceByCustomerId(int customerId);
	 
//	 @Modifying
//	 @Query("UPDATE ProductItems p SET p.quantity = p.quantity - (SELECT o.quantity FROM Cart c JOIN c.productItems o WHERE c.customers.customerId = :customerId AND o.productId = p.productId)")
//	 void updateProductItemsQuantityByCustomerId(int customerId);



}

//CrudRepository<Payment, Integer>
