package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.ecom.controller.ProductSupplierController;
import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.service.ProductSupplierService;

@RunWith(MockitoJUnitRunner.class)
public class ProductSupplierControllerTest {

    @Mock
    private ProductSupplierService productSupplierService;

    @InjectMocks
    private ProductSupplierController productSupplierController;

    private ProductSupplierDTO productSupplierDTO;

    @Before
    public void setup() {
        productSupplierDTO = new ProductSupplierDTO();
        productSupplierDTO.setProductSupplierId(1);
        productSupplierDTO.setProductSupplierName("chandler");
        productSupplierDTO.setEmailId("abc@123");
    }

    @Test
    public void testAddProductSupplier() {
        when(productSupplierService.addProductSupplier(productSupplierDTO)).thenReturn(productSupplierDTO);

        ResponseEntity<ProductSupplierDTO> result = productSupplierController.addProductSupplier(productSupplierDTO);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(productSupplierDTO, result.getBody());
    }
    @Test
    public void testGetAllProductSuppliers() {
        List<ProductSupplierDTO> productSuppliers = new ArrayList<>();
        productSuppliers.add(new ProductSupplierDTO(1, "Supplier1", "Location1", 1234567890L, "supplier1@test.com"));
        productSuppliers.add(new ProductSupplierDTO(2, "Supplier2", "Location2", 1234567891L, "supplier2@test.com"));
        when(productSupplierService.findAll()).thenReturn(productSuppliers);

        ResponseEntity<List<ProductSupplierDTO>> response = productSupplierController.getAllProductSuppliers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("Supplier1", response.getBody().get(0).getProductSupplierName());
        assertEquals("Supplier2", response.getBody().get(1).getProductSupplierName());
    }
    @Test
    public void testGetProductSupplierById() throws Exception {
        int id = 1;
        when(productSupplierService.getById(id)).thenReturn(productSupplierDTO);

        ResponseEntity<ProductSupplierDTO> response = productSupplierController.getProductSupplierById(id);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(productSupplierDTO, response.getBody());
    }
}
