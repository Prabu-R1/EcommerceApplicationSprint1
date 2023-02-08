package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.CustomersDTO;

public interface CustomersService {

	public CustomersDTO addCustomers(CustomersDTO customers);

	public CustomersDTO updateCustomers(CustomersDTO customersDTO);

	public boolean deleteCustomers(CustomersDTO customersDTO);

	public CustomersDTO getById(int id);

	public List<CustomersDTO> findAll();
}
