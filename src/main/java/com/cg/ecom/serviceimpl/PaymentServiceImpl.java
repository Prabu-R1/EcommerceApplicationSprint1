package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.PaymentDTO;
import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Orders;
import com.cg.ecom.entity.Payment;
import com.cg.ecom.entity.ProductItems;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.exceptions.PaymentNotFoundException;
import com.cg.ecom.repository.CartRepository;
import com.cg.ecom.repository.OrdersRepository;
import com.cg.ecom.repository.PaymentRepository;
import com.cg.ecom.repository.ProductItemsRepository;
import com.cg.ecom.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ProductItemsRepository productItemsRepository;
	
//	@Autowired
	private ProductItems productItems = new ProductItems();
	
//	@Autowired
	private Cart cart = new Cart();

	//////////////////////////////////
//	@Override
//	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
//
//		Payment payment = new Payment();
//		Cart cart = new Cart();
//		cart.setCartId(paymentDTO.getPaymentId());
//		payment.setCartId(cart);
//		payment.setPaymentId(paymentDTO.getPaymentId());
//		payment.setPaymentDate(paymentDTO.getPaymentDate());
//		payment.setPaymentType(paymentDTO.getPaymentType());
//		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
//		
//        if(paymentDTO.getPaymentStatus().equalsIgnoreCase("Success")) 
//        {
//        	productItems.setQuantity(productItems.getQuantity()- cart.getQuantity());
//        	Cart cartSave = cartRepository.save(cart);
//    		Payment paymentsave = paymentRepository.save(payment);
//    		paymentDTO.setPaymentId(paymentsave.getPaymentId());
//    		paymentDTO.setCartId(cartSave.getCartId());
//    		return paymentDTO;
//        }
//        
//        throw new PaymentNotFoundException();
//		
//	}
	
	//////////////////////////////////////////////////////
	
	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
	    Payment payment = new Payment();
	    Cart cart = new Cart();
	    Orders order = new  Orders();
	    
	    order.setOrderId(paymentDTO.getOrderId());
	    payment.setOrderId(order);
	    cart.setCartId(paymentDTO.getCartId());
	    payment.setCartId(cart);
	    payment.setPaymentId(paymentDTO.getPaymentId());
	    payment.setPaymentDate(paymentDTO.getPaymentDate());
	    payment.setPaymentType(paymentDTO.getPaymentType());
	    payment.setPaymentStatus(paymentDTO.getPaymentStatus());

	    if (paymentDTO.getPaymentStatus().equalsIgnoreCase("Success")) {
	        int productId = paymentDTO.getProductId();
	        ProductItems productItem = productItemsRepository.findById(productId).orElse(null);
	        if (productItem != null) {
	            int updatedQuantity = productItem.getQuantity() - cart.getQuantity();
	            productItem.setQuantity(updatedQuantity);
	            productItemsRepository.save(productItem);
	            Cart cartSave = cartRepository.save(cart);
	            Payment paymentSave = paymentRepository.save(payment);
	            Orders orderSave = ordersRepository.save(order);
	            paymentDTO.setPaymentId(paymentSave.getPaymentId());
	            paymentDTO.setCartId(cartSave.getCartId());
	            paymentDTO.setOrderId(orderSave.getCartId());
	            return paymentDTO;
	        } else {
	            throw new ItemNotAvailableException();
	        }
	    } else {
	        throw new PaymentNotFoundException();
	    }
	}

	///////////////////////////////////////////////////

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
