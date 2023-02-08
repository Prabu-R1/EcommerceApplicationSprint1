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

import com.cg.ecom.dto.ProductItemsDTO;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.service.ProductItemsService;

@RestController
@RequestMapping("/api/fooditems")
public class ProductItemsController {

	@Autowired
	public ProductItemsService productItemsService;
	
	@PostMapping("/addFooditems")
	public ResponseEntity<ProductItemsDTO> addFoodItems(@RequestBody ProductItemsDTO productItemsDTO){
		
			ProductItemsDTO fooditems = productItemsService.addProductItems(productItemsDTO);
			return ResponseEntity.ok(fooditems);
		
	}

	@GetMapping("/fetchFoodItemsById/{id}")
	public ResponseEntity<ProductItemsDTO> getfoodItemById(@PathVariable int id){
		ProductItemsDTO productItemsDTO=productItemsService.getById(id);
		return new ResponseEntity<ProductItemsDTO>(productItemsDTO, HttpStatus.FOUND);
	}
	
	@PutMapping("/updateFoodItems")
	public ResponseEntity<ProductItemsDTO> updateFoodItems(@RequestBody ProductItemsDTO productItemsDTO){
		return new ResponseEntity<ProductItemsDTO>(productItemsService.updateProductItems(productItemsDTO), HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteFoodItems/{id}")
	public ResponseEntity<Boolean> deleteFoodItemsById(@PathVariable int id){
		ProductItemsDTO productItemsDTO=productItemsService.getById(id);
		if(productItemsDTO!=null) {
			productItemsService.deleteProductItems(productItemsDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new ItemNotAvailableException("FoodItems with id " +id+ "doesnot exists");
	}
	
	@GetMapping("/fetchAllFoodItems")
	public ResponseEntity<List<ProductItemsDTO>> getAllFoodItems(){
		List<ProductItemsDTO> list=productItemsService.findAll();
		return ResponseEntity.ok(list);
	}
}
