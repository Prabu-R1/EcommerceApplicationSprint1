package com.cg.ecom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

	Iterable<Payment> findAll();
}
