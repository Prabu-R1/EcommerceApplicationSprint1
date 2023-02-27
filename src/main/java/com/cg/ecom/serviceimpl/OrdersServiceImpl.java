package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.OrdersDTO;
import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.entity.Orders;
import com.cg.ecom.entity.ProductItems;
import com.cg.ecom.entity.ProductSupplier;
import com.cg.ecom.exceptions.CartIdAlreadyExistsException;
import com.cg.ecom.exceptions.ItemNotAvailableException;
import com.cg.ecom.exceptions.ProductOutStockException;
import com.cg.ecom.repository.OrdersRepository;
import com.cg.ecom.repository.ProductItemsRepository;
import com.cg.ecom.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ProductItemsRepository productItemsRepository;

	@Override
	public OrdersDTO addOrders(OrdersDTO ordersDTO)  throws CartIdAlreadyExistsException
	{
		
//		// Check if the cart ID already exists
//	    boolean existingOrder = ordersRepository.existsByCartId(ordersDTO.getCartId());
//	    
//	    if (existingOrder) 
//	    {
//	       
//	    	 throw new CartIdAlreadyExistsException();
//	    }
//	    else {
	    	
		Orders orders = new Orders();
		int productId = ordersDTO.getProductId();
		
		ProductItems productItem = productItemsRepository.findById(productId).orElse(null);
		if(ordersDTO.getQuantity() <= productItem.getQuantity()) 
		{
		
		Customers cust = new Customers();
		Cart cart = new Cart();
		cart.setCartId(ordersDTO.getCartId());
		orders.setCart(cart);
		
		cust.setCustomerId(ordersDTO.getCustomerId());
		orders.setCustomerId(cust);
//		orders.setDate(ordersDTO.getDate());
		orders.setDeliveryAddress(ordersDTO.getDeliveryAddress());
//		orders.setStatus(ordersDTO.getStatus());
//		orders.setCartId(ordersDTO.getCartId());

		ProductSupplier rest = new ProductSupplier();
		rest.setProductSupplierId(ordersDTO.getProductSupplierId());
		orders.setProductSuppliers(rest);
//		orders.setDate(ordersDTO.getDate());
		orders.setDeliveryAddress(ordersDTO.getDeliveryAddress());
//		orders.setStatus(ordersDTO.getStatus());
//		orders.setCartId(ordersDTO.getCartId());

		Orders ordersave = ordersRepository.save(orders);
		ordersDTO.setOrderId(ordersave.getOrderId());
		return ordersDTO;

//		Customers customer = customersRepository.findById(ordersDTO.getCustomerId()).get();
		}
		throw new ProductOutStockException();
	    }
//	}
	

	@Override
	public OrdersDTO updateOrders(OrdersDTO ordersDTO) {

		Orders orders = new Orders();
		ProductSupplier rest = new ProductSupplier();
		Customers cust = new Customers();
		rest.setProductSupplierId(ordersDTO.getProductSupplierId());
		cust.setCustomerId(ordersDTO.getCustomerId());
		orders.setProductSuppliers(rest);
		orders.setCustomerId(cust);
		//orders.setDate(ordersDTO.getDate());
		orders.setDeliveryAddress(ordersDTO.getDeliveryAddress());
//		orders.setStatus(ordersDTO.getStatus());
		orders.setOrderId(ordersDTO.getOrderId());
//		orders.setCartId(ordersDTO.getCartId());

		ordersRepository.save(orders);
		return ordersDTO;
	}

	@Override
	public boolean deleteOrders(OrdersDTO ordersDTO) {
		Orders orders = new Orders();
		orders.setOrderId(ordersDTO.getOrderId());
		ordersRepository.delete(orders);
		return true;
	}

	@Override
	public OrdersDTO getById(int id) {

		Optional<Orders> orders = ordersRepository.findById(id);
		if (orders.isPresent()) {
			OrdersDTO dto = new OrdersDTO();
			BeanUtils.copyProperties(orders.get(), dto);
			return dto;
		}
		throw new ItemNotAvailableException("Item not Available at this time");
	}

	@Override
	public List<OrdersDTO> findAll() {

		List<Orders> orders = ordersRepository.findAll();
		List<OrdersDTO> dtos = new ArrayList<>();
		for (Orders order : orders) {
			OrdersDTO dto = new OrdersDTO();
			BeanUtils.copyProperties(order, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
