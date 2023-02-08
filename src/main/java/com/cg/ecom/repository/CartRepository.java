package com.cg.ecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{

	
}
