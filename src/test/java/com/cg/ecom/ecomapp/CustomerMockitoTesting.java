//package com.cg.ecom.ecomapp;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cg.ecom.dto.CustomersDTO;
//import com.cg.ecom.entity.Customers;
//import com.cg.ecom.repository.CustomersRepository;
//import com.cg.ecom.serviceimpl.CustomersServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CustomerMockitoTesting {
//
//    @Mock
//    private CustomersRepository customersRepository;
//
//    @InjectMocks
//    private CustomersServiceImpl customersServiceImpl;
//
//    private CustomersDTO customersDto;
//
//    @Before
//    public void setUp() {
//        customersDto = new CustomersDTO();
//        customersDto.setAddress("123 Main St");
//        customersDto.setCustomerId(1);
//        customersDto.setCustomerName("John Doe");
//        customersDto.setEmailId("johndoe@example.com");
//        customersDto.setMobilenumber(1234567890L);
//    }
//
//    @Test
//    public void testAddCustomers() {
//        Customers customers = new Customers();
//        customers.setAddress(customersDto.getAddress());
//        customers.setCustomerId(customersDto.getCustomerId());
//        customers.setCustomerName(customersDto.getCustomerName());
//        customers.setEmailId(customersDto.getEmailId());
//        customers.setMobilenumber(customersDto.getMobilenumber());
//
//        when(customersRepository.save(customers)).thenReturn(customers);
//
//        CustomersDTO result = customersServiceImpl.addCustomers(customersDto);
//
//        assertEquals(customersDto, result);
//    }
//}
