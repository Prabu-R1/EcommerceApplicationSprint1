package com.cg.ecom.service;

import java.util.List;

import com.cg.ecom.dto.ProductItemsDTO;

public interface ProductItemsService {

	public ProductItemsDTO addProductItems(ProductItemsDTO productItemsDTO);

	public ProductItemsDTO updateProductItems(ProductItemsDTO productItemsDTO);

	public boolean deleteProductItems(ProductItemsDTO productItemsDTO);

	public ProductItemsDTO getById(int id);

	public List<ProductItemsDTO> findAll();
}
