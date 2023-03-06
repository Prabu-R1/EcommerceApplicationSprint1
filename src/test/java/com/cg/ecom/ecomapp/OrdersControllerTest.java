package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.ecom.controller.OrdersController;
import com.cg.ecom.dto.OrdersDTO;
import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.service.OrdersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControllerTest {

    @Mock
    private OrdersService ordersService;

    @InjectMocks
    private OrdersController ordersController;
    
    private OrdersDTO ordersDTO;


    @Before
    public void setUp() {
        ordersDTO = new OrdersDTO();
        ordersDTO.setStatus("success");
        ordersDTO.setDeliveryAddress("chennai");

        ordersDTO.setProductSupplierId(1);
        ordersDTO.setProductId(1);
        ordersDTO.setCartId(1);
        ordersDTO.setCustomerId(1);
        ordersDTO.setCartId(1);
        ordersDTO.setQuantity(1);
    }

    @Test
    public void testGetAllOrders() {
        List<OrdersDTO> ordersList = new ArrayList<>();
        ordersList.add(ordersDTO);

        when(ordersService.findAll()).thenReturn(ordersList);

        ResponseEntity<List<OrdersDTO>> result = ordersController.getAllOrders();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(ordersList, result.getBody());
    }
    @Test
    public void testUpdateOrders() {
       
        when(ordersService.updateOrders(ordersDTO)).thenReturn(ordersDTO);

        ResponseEntity<OrdersDTO> result = ordersController.updateOrders(ordersDTO);

        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
        assertEquals(ordersDTO, result.getBody());
    }

}
