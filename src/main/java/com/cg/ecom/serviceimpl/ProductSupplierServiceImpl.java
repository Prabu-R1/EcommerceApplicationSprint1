package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.ProductSupplierDTO;
import com.cg.ecom.entity.ProductSupplier;
import com.cg.ecom.entity.User;
import com.cg.ecom.exceptions.ProductSupplierNotAvailableException;
import com.cg.ecom.repository.ProductSupplierRepository;
import com.cg.ecom.repository.UserRepository;
import com.cg.ecom.service.ProductSupplierService;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {
	@Autowired
	private ProductSupplierRepository productSupplierRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ProductSupplierDTO addProductSupplier(ProductSupplierDTO productSupplierDto) {

		User user=new User();
		user.setPassword(productSupplierDto.getPassword());
		user.setRole("OWNER");
		user.setUsername(productSupplierDto.getUsername());		

		User userSave=userRepository.save(user);
		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setUserId(userSave);
		productSupplier.setName(productSupplierDto.getName());
		productSupplier.setEmailId(productSupplierDto.getEmailId());
		productSupplier.setContactNo(productSupplierDto.getContactNo());
        //productSupplier.setId(productSupplierDto.getId());
        productSupplier.setLocation(productSupplierDto.getLocation());
		
        ProductSupplier productSupplierave=productSupplierRepository.save(productSupplier);
        productSupplierDto.setUserId(userSave.getUserId());
        productSupplierDto.setId(productSupplierave.getId());
		return productSupplierDto;
	}

	@Override
	public ProductSupplierDTO updateProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();
		User user=new User();
		user.setUserId(productSupplierDTO.getUserId());
		productSupplier.setUserId(user);
		productSupplier.setId(productSupplierDTO.getId());
		productSupplier.setName(productSupplierDTO.getName());
		productSupplier.setEmailId(productSupplierDTO.getEmailId());
		productSupplier.setContactNo(productSupplierDTO.getContactNo());
		productSupplier.setLocation(productSupplierDTO.getLocation());
		
		productSupplierRepository.save(productSupplier);
		return productSupplierDTO;
	}

	@Override
	public boolean deleteProductSupplier(ProductSupplierDTO productSupplierDTO) {

		ProductSupplier productSupplier = new ProductSupplier();
		productSupplier.setId(productSupplierDTO.getId());
		productSupplierRepository.delete(productSupplier);
		return true;//write logic
	}

	@Override
	public ProductSupplierDTO getById(int id) {

		Optional<ProductSupplier> productSupplier = productSupplierRepository.findById(id);
		if (productSupplier.isPresent()) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(productSupplier.get(), dto);
			return dto;
		}
		throw new ProductSupplierNotAvailableException("Restaurant not Available");
	}

	@Override
	public List<ProductSupplierDTO> findAll() {

		Iterable<ProductSupplier> productSupplier = productSupplierRepository.findAll();
		List<ProductSupplierDTO> dtos = new ArrayList<>();
		for (ProductSupplier restaurant : productSupplier) {
			ProductSupplierDTO dto = new ProductSupplierDTO();
			BeanUtils.copyProperties(restaurant, dto);
			dtos.add(dto);
		}
		return dtos;
	}

}
