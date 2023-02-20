package com.cg.ecom.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.ecom.dto.OrdersDTO;
import com.cg.ecom.entity.Orders;
import com.cg.ecom.exceptions.CartIdAlreadyExistsException;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.repository.OrdersRepository;
import com.cg.ecom.service.OrdersService;


@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	public OrdersService ordersService;
	
	@Autowired
	public OrdersRepository ordersRepository;
	
	@PostMapping("/addOrders")
	public ResponseEntity<OrdersDTO> addOrders(@RequestBody OrdersDTO ordersDTO){
		
		Optional<Orders> existingOrder = ordersRepository.findById(ordersDTO.getCartId());
	    if (!existingOrder.isPresent()) 
	    {
		
			OrdersDTO orders = ordersService.addOrders(ordersDTO);
			return ResponseEntity.ok(orders);
		
	}
	    throw new CartIdAlreadyExistsException();
	    }

	@GetMapping("/fetchOrderById/{id}")
	public ResponseEntity<OrdersDTO> getOrderById(@PathVariable int id){
		OrdersDTO ordersDTO=ordersService.getById(id);
		
		if(ordersDTO!=null) 
		{
		return new ResponseEntity<OrdersDTO>(ordersDTO, HttpStatus.FOUND);
	    }
		throw new ItemNotAvailableException();
		}
	
	@PutMapping("/updateOrders")
	public ResponseEntity<OrdersDTO> updateOrders(@RequestBody OrdersDTO ordersDTO){
		return new ResponseEntity<OrdersDTO>(ordersService.updateOrders(ordersDTO), HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteOrdersById/{id}")
	public ResponseEntity<Boolean> deleteOrderById(@PathVariable int id){
		OrdersDTO ordersDTO=ordersService.getById(id);
		if(ordersDTO!=null) {
			ordersService.deleteOrders(ordersDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new ItemNotAvailableException("Orders with id " +id+ "doesnot exists");
	}
	
	@GetMapping("/fetchAllOrders")
	public ResponseEntity<List<OrdersDTO>> getAllOrders(){
		List<OrdersDTO> list=ordersService.findAll();
		return ResponseEntity.ok(list);
	}
}
