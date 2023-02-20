//package com.cg.ecom.ecomapp;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.ecom.dto.CustomersDTO;
//import com.cg.ecom.dto.OrdersDTO;
//import com.cg.ecom.dto.ProductSupplierDTO;
//import com.cg.ecom.service.CustomersService;
//import com.cg.ecom.service.OrdersService;
//import com.cg.ecom.service.ProductSupplierService;
//
//@SpringBootTest
//class ECOMApplicationTests {
//
//	@Autowired
//	private ProductSupplierService productSupplierService;
//
//	@Autowired
//	private CustomersService customersService;
//
//	@Autowired
//	private OrdersService ordersService;
//
////	@Test
////		ProductSupplierDTO c = ProductSupplierService.getById(3);
////		assertEquals("stuv", c.getName());
////		assertEquals("hyd", c.getLocation());
////	}
//
//	@Test
//	void testgetByCustomerId() {
//		CustomersDTO d = customersService.getById(5);
//		assertEquals("abc", d.getCustomerName());
//	}
//
//	@Test
//	void testgetByOrderId() {
//		OrdersDTO o = ordersService.getById(6);
//		assertEquals("delivered", o.getStatus());
//	}
//
//}
