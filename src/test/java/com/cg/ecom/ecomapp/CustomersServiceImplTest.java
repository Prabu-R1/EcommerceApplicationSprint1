package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.repository.CustomersRepository;
import com.cg.ecom.serviceimpl.CustomersServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CustomersServiceImplTest {

    @Mock
    private CustomersRepository customersRepository;

    @InjectMocks
    private CustomersServiceImpl customersServiceImpl;

    @Test
    public void testAddCustomers() {
        // create a mock DTO object
        CustomersDTO mockCustomersDto = new CustomersDTO();
        mockCustomersDto.setCustomerId(1);
        mockCustomersDto.setAddress("123 Main St.");
        mockCustomersDto.setCustomerName("John Smith");
        mockCustomersDto.setEmailId("john.smith@example.com");
        mockCustomersDto.setMobilenumber(1234567890L);

        // create a mock entity object
        Customers mockCustomers = new Customers();
        mockCustomers.setCustomerId(1);
        mockCustomers.setAddress("123 Main St.");
        mockCustomers.setCustomerName("John Smith");
        mockCustomers.setEmailId("john.smith@example.com");
        mockCustomers.setMobilenumber(1234567890L);

        // mock the repository method
        Mockito.when(customersRepository.save(Mockito.any(Customers.class))).thenReturn(mockCustomers);

        // call the service method
        CustomersDTO result = customersServiceImpl.addCustomers(mockCustomersDto);

        // verify the result
        assertEquals(mockCustomersDto.getCustomerId(), result.getCustomerId());
        assertEquals(mockCustomersDto.getAddress(), result.getAddress());
        assertEquals(mockCustomersDto.getCustomerName(), result.getCustomerName());
        assertEquals(mockCustomersDto.getEmailId(), result.getEmailId());
        assertEquals(mockCustomersDto.getMobilenumber(), result.getMobilenumber());

        // verify the repository method is called once
        Mockito.verify(customersRepository, Mockito.times(1)).save(Mockito.any(Customers.class));
    }

    @Test
    public void testUpdateCustomers() {
        // create a mock DTO object
        CustomersDTO mockCustomersDto = new CustomersDTO();
        mockCustomersDto.setCustomerId(1);
        mockCustomersDto.setAddress("123 Main St.");
        mockCustomersDto.setCustomerName("John Smith");
        mockCustomersDto.setEmailId("john.smith@example.com");
        mockCustomersDto.setMobilenumber(1234567890L);

        // create a mock entity object
        Customers mockCustomers = new Customers();
        mockCustomers.setCustomerId(1);
        mockCustomers.setAddress("123 Main St.");
        mockCustomers.setCustomerName("John Smith");
        mockCustomers.setEmailId("john.smith@example.com");
        mockCustomers.setMobilenumber(1234567890L);

        // mock the repository method
        Mockito.when(customersRepository.save(Mockito.any(Customers.class))).thenReturn(mockCustomers);

        // call the service method
        CustomersDTO result = customersServiceImpl.updateCustomers(mockCustomersDto);

        // verify the result
        assertEquals(mockCustomersDto.getCustomerId(), result.getCustomerId());
        assertEquals(mockCustomersDto.getAddress(), result.getAddress());
        assertEquals(mockCustomersDto.getCustomerName(), result.getCustomerName());
        assertEquals(mockCustomersDto.getEmailId(), result.getEmailId());
        assertEquals(mockCustomersDto.getMobilenumber(), result.getMobilenumber());

        // verify the repository method is called once
        Mockito.verify(customersRepository, Mockito.times(1)).save(Mockito.any(Customers.class));
    }}