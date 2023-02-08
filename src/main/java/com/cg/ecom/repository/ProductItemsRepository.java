package com.cg.ecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.ProductItems;

@Repository
public interface ProductItemsRepository extends CrudRepository<ProductItems, Integer> {

	Iterable<ProductItems> findAll();
}
