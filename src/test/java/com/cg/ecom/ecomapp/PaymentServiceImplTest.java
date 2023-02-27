//package com.cg.ecom.ecomapp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//import java.sql.Date;
//import java.time.LocalDate;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cg.ecom.dto.PaymentDTO;
//import com.cg.ecom.entity.Cart;
//import com.cg.ecom.entity.Payment;
//import com.cg.ecom.entity.ProductItems;
//import com.cg.ecom.exceptions.ItemNotAvailableException;
//import com.cg.ecom.exceptions.PaymentNotFoundException;
//import com.cg.ecom.repository.CartRepository;
//import com.cg.ecom.repository.OrdersRepository;
//import com.cg.ecom.repository.PaymentRepository;
//import com.cg.ecom.repository.ProductItemsRepository;
//import com.cg.ecom.serviceimpl.PaymentServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PaymentServiceImplTest {
//
//    @Mock
//    private PaymentRepository paymentRepository;
//
//    @Mock
//    private CartRepository cartRepository;
//
//    @Mock
//    private OrdersRepository ordersRepository;
//
//    @Mock
//    private ProductItemsRepository productItemsRepository;
//
//    @InjectMocks
//    private PaymentServiceImpl paymentService;
//
//    @Test
//    public void testAddPaymentSuccess() {
//        // Mock input
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentStatus("Success");
//        paymentDTO.setProductId(1);
//        paymentDTO.setCartId(1);
//        paymentDTO.setPaymentId(1);
//        paymentDTO.setPaymentDate(null);
//        paymentDTO.setPaymentType("credit");
//        paymentDTO.setOrderId(1);
//
//        // Mock repositories
//        ProductItems productItem = new ProductItems();
//        productItem.setPrice(100);
//        productItem.setQuantity(5);
//        when(productItemsRepository.findById(1)).thenReturn(Optional.of(productItem));
//
//        Cart cart = new Cart();
//        cart.setQuantity(2);
//        when(cartRepository.findById(1)).thenReturn(Optional.of(cart));
//
//        // Call method
//        PaymentDTO result = paymentService.addPayment(paymentDTO);
//
//        // Verify results
//        assertNotNull(result);
//        assertEquals(200, result.getTotalPrice());
//
//        // Verify repository interactions
//        verify(productItemsRepository, times(1)).save(productItem);
//        verify(paymentRepository, times(1)).save(any(Payment.class));
//    }
//
//    @Test
//    void testAddPaymentItemNotAvailable() {
//        // Mock input
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentStatus("Success");
//        paymentDTO.setProductId(1);
//        paymentDTO.setCartId(1);
//        paymentDTO.setPaymentId(1);
//        paymentDTO.setPaymentDate(null);
//        paymentDTO.setPaymentType("credit");
//        paymentDTO.setOrderId(1);
//
//        // Mock repositories
//        when(productItemsRepository.findById(1)).thenReturn(Optional.empty());
//
//        // Call method and assert that it throws the expected exception
//        ItemNotAvailableException exception = assertThrows(ItemNotAvailableException.class, () -> {
//            paymentService.addPayment(paymentDTO);
//        });
//        
//        // Assert that the exception message is correct
//        assertEquals("Item is not available", exception.getMessage());
//    }
//
//}
//
