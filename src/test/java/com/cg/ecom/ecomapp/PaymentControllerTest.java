package com.cg.ecom.ecomapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.ecom.controller.PaymentController;
import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.exceptions.PaymentNotFoundException;
import com.cg.ecom.service.PaymentService;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

	@Mock
	private PaymentService paymentService;
	
	@InjectMocks
    private PaymentController paymentController;

    private PaymentDTO paymentDTO;

    @Before
    public void setUp() {
        // Initialize test data
        paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentStatus("Success");
        paymentDTO.setProductId(1);
        paymentDTO.setCartId(1);
        paymentDTO.setPaymentId(1);
        paymentDTO.setPaymentDate(LocalDate.now());
        paymentDTO.setPaymentType("credit");
        paymentDTO.setOrderId(1);
    }

    @Test
    public void testAddPayment() {
        when(paymentService.addPayment(paymentDTO)).thenReturn(paymentDTO);

        ResponseEntity<PaymentDTO> result = paymentController.addPayment(paymentDTO);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(paymentDTO, result.getBody());
    }
    @Test
    public void testGetAllPayment() {
        List<PaymentDTO> paymentList = new ArrayList<>();
        paymentList.add(paymentDTO);

        when(paymentService.findAll()).thenReturn(paymentList);

        ResponseEntity<List<PaymentDTO>> responseEntity = paymentController.getAllPayment();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(paymentList, responseEntity.getBody());

        verify(paymentService, times(1)).findAll();
    }
    @Test
    public void testGetPaymentById() throws PaymentNotFoundException {
        int paymentId = 1;
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(paymentId);

        when(paymentService.getById(paymentId)).thenReturn(paymentDTO);

        ResponseEntity<PaymentDTO> response = paymentController.getPaymentById(paymentId);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(paymentDTO, response.getBody());

        verify(paymentService, times(1)).getById(paymentId);
    }
}
