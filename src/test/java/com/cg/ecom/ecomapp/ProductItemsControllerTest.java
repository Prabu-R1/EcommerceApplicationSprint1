//package com.cg.ecom.ecomapp;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.ResponseEntity;
//
//import com.cg.ecom.controller.ProductItemsController;
//import com.cg.ecom.dto.ProductItemsDTO;
//import com.cg.ecom.service.ProductItemsService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductItemsControllerTest {
//   
//    @Mock
//    private ProductItemsService productItemsService;
// 
//    @InjectMocks
//    private ProductItemsController productItemsController;
// 
//    @Test
//    public void testAddProductItems() {
//        ProductItemsDTO productItemsDTO = new ProductItemsDTO(1, 1, "item1", 10, 5);
//        when(productItemsService.addProductItems(productItemsDTO)).thenReturn(productItemsDTO);
//        ResponseEntity<ProductItemsDTO> response = productItemsController.addProductItems(productItemsDTO);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(productItemsDTO, response.getBody());
//    }
// 
//    @Test
//    public void testGetProductItemsById() {
//        ProductItemsDTO productItemsDTO = new ProductItemsDTO(1, 1, "item1", 10, 5);
//        when(productItemsService.getById(1)).thenReturn(productItemsDTO);
//        ResponseEntity<ProductItemsDTO> response = productItemsController.getProductItemsById(1);
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(productItemsDTO, response.getBody());
//    }
// 
//    @Test
//    public void testFindAllProductItems() {
//        List<ProductItemsDTO> productItemsList = new ArrayList<>();
//        productItemsList.add(new ProductItemsDTO(1, 1, "item1", 10, 5));
//        productItemsList.add(new ProductItemsDTO(2, 2, "item2", 20, 10));
//        when(productItemsService.findAll()).thenReturn(productItemsList);
//        ResponseEntity<List<ProductItemsDTO>> response = productItemsController.getAllProductItems();
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(productItemsList, response.getBody());
//    }
//}
//
