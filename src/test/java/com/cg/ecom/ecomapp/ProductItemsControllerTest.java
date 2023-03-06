package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.ecom.controller.ProductItemsController;
import com.cg.ecom.dto.ProductItemsDTO;
import com.cg.ecom.service.ProductItemsService;


@RunWith(MockitoJUnitRunner.class)
public class ProductItemsControllerTest {
	
	 @Mock
	    private ProductItemsService ProductItemsService;

	    @InjectMocks
	    private ProductItemsController productItemsController;

	    private ProductItemsDTO productItemsDTO;
	    
	    @Before
	    public void setup() {
	    	productItemsDTO = new ProductItemsDTO();
	    	productItemsDTO.setProductId(1);
	    	productItemsDTO.setProductName("RedMi");
	    	productItemsDTO.setPrice(100);
	    	productItemsDTO.setQuantity(10);

	    }
	    @Test
	    public void testAddProductItems() {
	        when(ProductItemsService.addProductItems(productItemsDTO)).thenReturn(productItemsDTO);

	        ResponseEntity<ProductItemsDTO> result = productItemsController.addProductItems(productItemsDTO);

	        assertEquals(HttpStatus.OK, result.getStatusCode());
	        assertEquals(productItemsDTO, result.getBody());
	    }
	    @Test
	    public void testUpdateProductItems() {
	       
	        when(ProductItemsService.updateProductItems(productItemsDTO)).thenReturn(productItemsDTO);

	        ResponseEntity<ProductItemsDTO> responseEntity = productItemsController.updateProductItems(productItemsDTO);

	        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
	        assertEquals(productItemsDTO, responseEntity.getBody());

	        verify(ProductItemsService).updateProductItems(productItemsDTO);
	    }
	   
	    

	

}
