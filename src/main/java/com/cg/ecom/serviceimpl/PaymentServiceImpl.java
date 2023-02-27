package com.cg.ecom.serviceimpl;
import org.springframework.transaction.annotation.Transactional;
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
	

	private ProductItems productItems = new ProductItems();
	

	private Cart cart = new Cart();

		
	@Override
	@Transactional
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
	    Payment payment = new Payment();
	    Cart cart = new Cart();
	    Orders order = new  Orders();
	    
	    

	    if (paymentDTO.getPaymentStatus().equalsIgnoreCase("Success")) 
	    
	    {
	        int productId = paymentDTO.getProductId();
	        ProductItems productItem = productItemsRepository.findById(productId).orElse(null);
	        
	        
	        Cart cart2 = cartRepository.findById(paymentDTO.getCartId()).orElse(null);
	        
	        if (productItem != null) {
	        	
	        	order.setOrderId(paymentDTO.getOrderId());
	    	    payment.setOrderId(order);
	    	    cart.setCartId(paymentDTO.getCartId());
	    	    payment.setCartId (cart);
	    	    payment.setPaymentId(paymentDTO.getPaymentId());
	    	    payment.setPaymentDate(paymentDTO.getPaymentDate());
	    	    payment.setPaymentType(paymentDTO.getPaymentType());
	    	    payment.setPaymentStatus(paymentDTO.getPaymentStatus());
	        	
	    	 // Get the total price of the order
	    	    ////////////////////
//	            int totalPrice = productItem.getPrice() * cart2.getQuantity();
	            
	            Long totalPrice = paymentRepository.findTotalPriceByCustomerId(paymentDTO.getCustomerId());
	            payment.setTotalPrice(totalPrice);
	            paymentDTO.setTotalPrice(totalPrice);

	            
	            int updatedQuantity = ((productItem.getQuantity())-(cart2.getQuantity()));
	            productItem.setQuantity(updatedQuantity);
	            productItemsRepository.save(productItem);
	            
//	            paymentRepository.updateProductItemsQuantityByCustomerId(paymentDTO.getCustomerId());
	            
	            Payment paymentSave = paymentRepository.save(payment);
	            paymentDTO.setPaymentId(paymentSave.getPaymentId());
	            return paymentDTO;
	            
	        } 
	        
	        else 
	        {
	            throw new ItemNotAvailableException();
	        }
	    } 
	    
	    else
	    {
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

		List<Payment> payment = paymentRepository.findAll();
		List<PaymentDTO> dtos = new ArrayList<>();
		for (Payment payments : payment) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payments, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
