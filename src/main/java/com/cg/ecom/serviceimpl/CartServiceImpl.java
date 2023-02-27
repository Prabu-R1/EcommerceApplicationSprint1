package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.CartDTO;
import com.cg.ecom.entity.Cart;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.entity.ProductItems;
import com.cg.ecom.repository.CartRepository;
import com.cg.ecom.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDTO addToCart(CartDTO cartDTO) {

		Cart cart = new Cart();
		Customers cust = new Customers();
		
		ProductItems product = new ProductItems();
		product.setProductId(cartDTO.getProductId());

		
		cust.setCustomerId(cartDTO.getCustomerId());
		cart.setCustomers(cust);
		
		cart.setProductItems(product);
		cart.setCartId(cartDTO.getCartId());
		

		cart.setQuantity(cartDTO.getQuantity());

		Cart cartsave = cartRepository.save(cart);
		
		cartDTO.setCartId(cartsave.getCartId());
		return cartDTO;


	}

	@Override
	public CartDTO updateCart(CartDTO cartDTO) {
		Cart cart = new Cart();
//		cart.setPrice(cartDTO.getPrice());
		cart.setQuantity(cartDTO.getQuantity());
		cart.setCartId(cartDTO.getCartId());


		cartRepository.save(cart);
		return cartDTO;
	}

	@Override
	public boolean deleteCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cartRepository.delete(cart);
		return true;
	}

	@Override
	public CartDTO getById(int id) {

		Optional<Cart> cart = cartRepository.findById(id);
		if (cart.isPresent()) {
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(cart.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<CartDTO> findAll() {

		List<Cart> cart = cartRepository.findAll();
		List<CartDTO> dtos = new ArrayList<>();
		for (Cart carts : cart) {
			CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(carts, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
