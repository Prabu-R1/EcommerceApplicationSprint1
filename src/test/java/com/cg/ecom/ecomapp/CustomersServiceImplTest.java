package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.repository.CustomersRepository;
import com.cg.ecom.serviceimpl.CustomersServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomersServiceImplTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomersServiceImpl customersServiceImpl;

    private CustomersDTO customersDto;

    @Before
    public void setUp() {
        customersDto = new CustomersDTO();
        customersDto.setAddress("123 Main St");
        customersDto.setCustomerId(1);
        customersDto.setCustomerName("John Doe");
        customersDto.setEmailId("johndoe@example.com");
        customersDto.setMobilenumber(1234567890L);
    }

   
    @Test
    public void testAddCustomer() {
        when(customersRepository.save(Mockito.any(Customers.class)))
                .thenReturn(new Customers());

        CustomersDTO result = customersServiceImpl.addCustomers(customersDto);

        assertEquals(customersDto, result);
    }
}
