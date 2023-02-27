//package com.cg.ecom.ecomapp;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cg.ecom.dto.CartDTO;
//import com.cg.ecom.entity.Cart;
//import com.cg.ecom.entity.Customers;
//import com.cg.ecom.entity.ProductItems;
//import com.cg.ecom.repository.CartRepository;
//import com.cg.ecom.serviceimpl.CartServiceImpl;
//
//
//@SpringBootTest
//public class CartMockitoTesting {
//
//	@InjectMocks
//	private CartServiceImpl cartServiceImpl;
//
//	@Mock
//	private CartRepository cartRepository;
//
//	@Test
//	public void testAddToCart() {
//		// Create a CartDTO object for testing
//		CartDTO cartDTO = new CartDTO();
//		cartDTO.setCartId(1);
//		cartDTO.setCustomerId(1);
//		cartDTO.setProductId(1);
//		cartDTO.setQuantity(2);
//
//		// Create a Cart object for mocking
//		Cart cart = new Cart();
//		Customers cust = new Customers();
//		ProductItems product = new ProductItems();
//		product.setProductId(cartDTO.getProductId());
//		cust.setCustomerId(cartDTO.getCustomerId());
//		cart.setCustomers(cust);
//		cart.setProductItems(product);
//		cart.setCartId(cartDTO.getCartId());
//		cart.setQuantity(cartDTO.getQuantity());
//
//		// Mock the save() method of CartRepository
//		when(cartRepository.save(cart)).thenReturn(cart);
//
//		// Call the addToCart() method of CartServiceImpl
//		CartDTO savedCartDTO = cartServiceImpl.addToCart(cartDTO);
//
//		// Verify that the saved CartDTO object has the correct cartId
//		assertEquals(cartDTO.getCartId(), savedCartDTO.getCartId());
//	}
//}
//
