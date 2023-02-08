package com.cg.ecom.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ecom.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Iterable<User> findAll();
}
