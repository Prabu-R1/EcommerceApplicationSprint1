package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.CartDTO;

public interface CartService {

	public CartDTO addToCart(CartDTO cartDTO);

	public CartDTO updateCart(CartDTO cartDTO);

	public boolean deleteCart(CartDTO cartDTO);

	public CartDTO getById(int id);

	public List<CartDTO> findAll();

}
