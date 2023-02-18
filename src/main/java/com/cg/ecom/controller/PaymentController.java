package com.cg.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.exceptions.PaymentNotFoundException;
import com.cg.ecom.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	public PaymentService paymentService;

	@PostMapping("/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO) {

		PaymentDTO addpayment = paymentService.addPayment(paymentDTO);
		
		return ResponseEntity.ok(addpayment);

	}

	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<Boolean> deletePaymentById(@PathVariable int id) {
		PaymentDTO paymentDTO = paymentService.getById(id);
		if (paymentDTO != null) {
			paymentService.deletePayment(paymentDTO);
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		throw new PaymentNotFoundException("Payment with id " + id + "doesnot exists");
	}

	@GetMapping("/fetchPaymentById/{id}")
	public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable int id) {
		PaymentDTO paymentDTO = paymentService.getById(id);
		return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.FOUND);
	}

	@GetMapping("/fetchAllPayments")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() {
		List<PaymentDTO> list = paymentService.findAll();
		return ResponseEntity.ok(list);
	}
}
