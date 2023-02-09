package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Payment;
import com.cg.ecom.exceptions.PaymentNotFoundException;
import com.cg.ecom.repository.CartRepository;
import com.cg.ecom.repository.PaymentRepository;
import com.cg.ecom.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {

		Payment payment = new Payment();
		Cart cart = new Cart();
		cart.setCartId(paymentDTO.getPaymentId());
		payment.setCartId(cart);
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentType(paymentDTO.getPaymentType());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());

		Cart cartSave = cartRepository.save(cart);
		Payment paymentsave = paymentRepository.save(payment);
		paymentDTO.setPaymentId(paymentsave.getPaymentId());
		paymentDTO.setCartId(cartSave.getCartId());
		return paymentDTO;

	}

	@Override
	public boolean deletePayment(PaymentDTO paymentDTO) {

		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		paymentRepository.delete(payment);

		return true;
	}

	@Override
	public PaymentDTO getById(int id) {

		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isPresent()) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payment.get(), dto);
			return dto;
		}
		throw new PaymentNotFoundException("Payment not Available at this time");
	}

	@Override
	public List<PaymentDTO> findAll() {

		Iterable<Payment> payment = paymentRepository.findAll();
		List<PaymentDTO> dtos = new ArrayList<>();
		for (Payment payments : payment) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payments, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
