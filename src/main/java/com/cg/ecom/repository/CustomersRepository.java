package com.cg.ecom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Customers;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer>{


	Iterable<Customers> findAll();
}
