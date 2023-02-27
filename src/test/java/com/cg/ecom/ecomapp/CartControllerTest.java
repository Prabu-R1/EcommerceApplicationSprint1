package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.cg.ecom.controller.CartController;
import com.cg.ecom.dto.CartDTO;
import com.cg.ecom.service.CartService;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @Mock
    CartService cartService;

    @InjectMocks
    CartController cartController;

    CartDTO cartDTO;

    @Before
    public void setup() {
        cartDTO = new CartDTO();
        cartDTO.setCartId(1);
        cartDTO.setProductId(1);
        cartDTO.setQuantity(2);
    }

    @Test
    public void testAddToCart() {
        when(cartService.addToCart(cartDTO)).thenReturn(cartDTO);
        ResponseEntity<CartDTO> result = cartController.addToCart(cartDTO);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(cartDTO, result.getBody());
    }
}
