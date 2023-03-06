package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.entity.ProductSupplier;
import com.cg.ecom.exceptions.ProductSupplierNotAvailableException;
import com.cg.ecom.repository.ProductSupplierRepository;
import com.cg.ecom.service.ProductSupplierService;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {
	@Autowired
	private ProductSupplierRepository productSupplierRepository;


	
	
	@Override
	public ProductSupplierDTO addProductSupplier(ProductSupplierDTO productSupplierDto) {

		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setProductSupplierName(productSupplierDto.getProductSupplierName());
		productSupplier.setEmailId(productSupplierDto.getEmailId());
		productSupplier.setContactNo(productSupplierDto.getContactNo());
        productSupplier.setLocation(productSupplierDto.getLocation());
		
        ProductSupplier productSupplierave=productSupplierRepository.save(productSupplier);
        productSupplierDto.setProductSupplierId(productSupplierave.getProductSupplierId());
		return productSupplierDto;
	}

	@Override
	public ProductSupplierDTO updateProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();

		productSupplier.setProductSupplierId(productSupplierDTO.getProductSupplierId());
		productSupplier.setProductSupplierName(productSupplierDTO.getProductSupplierName());
		productSupplier.setEmailId(productSupplierDTO.getEmailId());
		productSupplier.setContactNo(productSupplierDTO.getContactNo());
		productSupplier.setLocation(productSupplierDTO.getLocation());
		
		productSupplierRepository.save(productSupplier);
		return productSupplierDTO;
	}

	@Override
	public boolean deleteProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setProductSupplierId(productSupplierDTO.getProductSupplierId());
		productSupplierRepository.delete(productSupplier);
		return true;
	}

	@Override
	public ProductSupplierDTO getById(int id) {

		Optional<ProductSupplier> productSupplier = productSupplierRepository.findById(id);
		if (productSupplier.isPresent()) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(productSupplier.get(), dto);
			return dto;
		}
		throw new ProductSupplierNotAvailableException("ProductSupplierNotAvailable not Available");
	}

	@Override
	public List<ProductSupplierDTO> findAll() {

		List<ProductSupplier> productSupplier = productSupplierRepository.findAll();
		List<ProductSupplierDTO> dtos = new ArrayList<>();
		for (ProductSupplier productSupplier1 : productSupplier) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(productSupplier1, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
