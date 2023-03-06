package com.cg.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.exceptions.CustomerNotFoundException;
import com.cg.ecom.exceptions.ProductSupplierNotAvailableException;
import com.cg.ecom.service.CustomersService;
import com.cg.ecom.service.ProductSupplierService;

@RestController
@RequestMapping("/api/ProductSuppliers")
public class ProductSupplierController {

	@Autowired
	public ProductSupplierService productSupplierService;

	@Autowired
	public CustomersService customersService;
	

@GetMapping("/fetchCustomersById/{id}")
public ResponseEntity<CustomersDTO> getCustomersById(@PathVariable int id) 
{
	
CustomersDTO customersDTO = customersService.getById(id);
if(customersDTO != null) 
{

return new ResponseEntity<CustomersDTO>(customersDTO, HttpStatus.FOUND);
}
throw new CustomerNotFoundException();
}

@GetMapping("/fetchAllCustomers")
public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
List<CustomersDTO> list = customersService.findAll();
return ResponseEntity.ok(list);
}
	
	@PostMapping("/addProductSuppliers")
	public ResponseEntity<ProductSupplierDTO> addProductSupplier(@RequestBody ProductSupplierDTO productSupplierDTO) {

		ProductSupplierDTO productSuppliers = productSupplierService.addProductSupplier(productSupplierDTO);
		return ResponseEntity.ok(productSuppliers);

	}
	

	@GetMapping("/fetchProductSuppliersById/{id}")
	public ResponseEntity<ProductSupplierDTO> getProductSupplierById(@PathVariable int id) {
		ProductSupplierDTO productSupplierDTO = productSupplierService.getById(id);
		return new ResponseEntity<ProductSupplierDTO>(productSupplierDTO, HttpStatus.FOUND);
	}

	@PutMapping("/updateProductSuppliers")
	public ResponseEntity<ProductSupplierDTO> updateProductSupplier(@RequestBody ProductSupplierDTO productSupplierDTO) {
		return new ResponseEntity<ProductSupplierDTO>(productSupplierService.updateProductSupplier(productSupplierDTO),
				HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteProductSuppliers/{id}")
	public ResponseEntity<Boolean> deleteProductSupplierById(@PathVariable int id) {
		ProductSupplierDTO productSupplierDTO = productSupplierService.getById(id);
		if (productSupplierDTO != null) {
			productSupplierService.deleteProductSupplier(productSupplierDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new ProductSupplierNotAvailableException("ProductSuppliers with id " + id + "doesnot exists");
	}

	@GetMapping("/fetchAllProductSuppliers")
	public ResponseEntity<List<ProductSupplierDTO>> getAllProductSuppliers() {
		List<ProductSupplierDTO> list = productSupplierService.findAll();
		return ResponseEntity.ok(list);
	}
}
