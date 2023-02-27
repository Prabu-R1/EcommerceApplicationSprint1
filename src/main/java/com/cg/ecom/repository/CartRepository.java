package com.cg.ecom.repository;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Customers;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>
{
//	Iterable<Cart> findAll();

    List<Cart> findByCustomersCustomerId(int customerId);
    @Query("SELECT SUM(c.productItems.price * c.quantity) FROM Cart c WHERE c.customers.customerId = :customerId")
    int findTotalPriceByCustomerId(Integer customerId);
	
}

//CrudRepository<Cart, Integer>