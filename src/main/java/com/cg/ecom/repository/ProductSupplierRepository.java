package com.cg.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.ProductSupplier;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer> {

//	Iterable<ProductSupplier> findAll();
//	CrudRepository<ProductSupplier, Integer>

//	User save(User user);
}
