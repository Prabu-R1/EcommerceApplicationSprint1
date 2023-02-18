package com.cg.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Customers;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>
{
	Iterable<Cart> findAll();
	
}
