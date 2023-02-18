package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.ecom.controller.CustomersController;
import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.service.CustomersService;

@RunWith(MockitoJUnitRunner.class)
public class CustomersControllerTest {

    @Mock
    private CustomersService customersService;

    @InjectMocks
    private CustomersController customersController;

    private CustomersDTO customersDTO;

    @Before
    public void setUp() {
        customersDTO = new CustomersDTO();
        customersDTO.setCustomerId(1);
//        customersDTO.setUsername("John Doe");
        customersDTO.setAddress("123 Main St");
        customersDTO.setMobilenumber(1234567890L);
        customersDTO.setEmailId("johndoe@email.com");
       // customersDTO.setPassword("password");
      //  customersDTO.setUsername("johndoe");
//        customersDTO.setUserId(1);
    }

    @Test
    public void testAddCustomers() {
        when(customersService.addCustomers(customersDTO)).thenReturn(customersDTO);
        ResponseEntity<CustomersDTO> response = customersController.addCustomers(customersDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customersDTO, response.getBody());
    }
}
