package com.cg.ecom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer>{

	Iterable<Orders> findAll();
	
}
