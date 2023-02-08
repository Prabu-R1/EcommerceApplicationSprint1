package com.cg.ecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.ProductSupplier;
import com.cg.ecom.entity.User;

@Repository
public interface ProductSupplierRepository extends CrudRepository<ProductSupplier, Integer>{

	Iterable<ProductSupplier> findAll();

	User save(User user);
}
