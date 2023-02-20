//package com.cg.ecom.ecomapp;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.cg.ecom.controller.OrdersController;
//import com.cg.ecom.dto.OrdersDTO;
//import com.cg.ecom.exceptions.ItemNotAvailableException;
//import com.cg.ecom.service.OrdersService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrderControllerTest {
//
//    @Mock
//    private OrdersService ordersService;
//
//    @InjectMocks
//    private OrdersController ordersController;
//
//    private MockMvc mockMvc;
//    private OrdersDTO ordersDTO;
//    private List<OrdersDTO> ordersDTOList;
//    private ObjectMapper objectMapper;
//
//    @Before
//    public void setUp() {
//        objectMapper = new ObjectMapper();
//        mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();
//        ordersDTO = new OrdersDTO();
//        ordersDTO.setCartId(1);
//        ordersDTO.setCustomerId(1);
//        ordersDTO.setCartId(1);
////        ordersDTO.setQuantity(1);
//        ordersDTOList = new ArrayList<>();
//        ordersDTOList.add(ordersDTO);
//    }
//
//    @Test
//    public void testAddOrders() throws Exception {
//        when(ordersService.addOrders(ordersDTO)).thenReturn(ordersDTO);
//        mockMvc.perform(post("/api/orders/addOrders")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(ordersDTO)))
//                .andExpect(status().isOk());
//    }
//
//} 