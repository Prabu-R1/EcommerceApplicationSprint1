package com.cg.ecom.repository;


import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.dto.CartDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.entity.Orders;
import com.cg.ecom.entity.ProductSupplier;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>
{

//	Iterable<Orders> findAll();
	@Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Orders o WHERE o.cart.cartId = :cartId")
    boolean existsByCartId( int cartId);

//	 Iterable<Orders> findByCustomerId(Customers customerId);
//	 Iterable<Orders> findByProductSuppliers(ProductSupplier productSupplier);
//	 Iterable<Orders> findByCartId(String cartId);
//	 boolean existsById(Integer id);

}
//CrudRepository<Orders, Integer>