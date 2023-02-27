package com.cg.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.dto.CustomersDTO;
import com.cg.ecom.entity.Customers;
import com.cg.ecom.repository.CustomersRepository;
import com.cg.ecom.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {
	@Autowired
	private CustomersRepository customerRepository;
	
////	@Autowired
////	private UserRepository userRepository;
//
//	 public void  CustomersDTO() {
//	        for (int i = 100; i <= 200; i++) {
//	        	Customers entity = new Customers();
//	            int counter = 0;
//				entity.setCustomerId(counter++);
//	            // set other fields if necessary
//				customerRepository.save(entity);
//	        }
//	    }

	@Override
	public CustomersDTO addCustomers(CustomersDTO customersDto) {
		

		//logic for user_details
//		User user=new User();
//		user.setPassword(customersDto.getPassword());
//		user.setRole("CUSTOMER");
//		user.setUsername(customersDto.getUsername());

//		User userSave=userRepository.save(user);
		Customers customers = new Customers();
//		customers.setUserId(userSave);
		customers.setAddress(customersDto.getAddress());
		customers.setEmailId(customersDto.getEmailId());
		customers.setMobilenumber(customersDto.getMobilenumber());
		customers.setCustomerName(customersDto.getCustomerName());
		customers.setCustomerId(customersDto.getCustomerId());
		
		Customers customersave =customerRepository.save(customers);
		customersDto.setCustomerId(customersave.getCustomerId());
//		customersDto.setUserId(userSave.getUserId());
		return customersDto;
	}

	@Override
	public CustomersDTO updateCustomers(CustomersDTO customersDTO) {
		
		Customers customers = new Customers();
//		User user=new User();
//		user.setUserId(customersDTO.getUserId());
//		customers.setUserId(user);
		customers.setCustomerId(customersDTO.getCustomerId());
		customers.setAddress(customersDTO.getAddress());
		customers.setEmailId(customersDTO.getEmailId());
		customers.setMobilenumber(customersDTO.getMobilenumber());
		customers.setCustomerName(customersDTO.getCustomerName());
		
		Customers saveId=customerRepository.save(customers);
		customersDTO.setCustomerId(saveId.getCustomerId());
		
		return customersDTO;
	}

	@Override
	public boolean deleteCustomers(CustomersDTO customersDTO) {
		
		Customers customers = new Customers();
		customers.setCustomerId(customersDTO.getCustomerId());
		customerRepository.delete(customers);
		return true;
	}

	@Override
	public List<CustomersDTO> findAll() {
		
		List<Customers> customers = customerRepository.findAll();
		List<CustomersDTO> dtos = new ArrayList<>();
		for (Customers customer : customers) {
			CustomersDTO dto = new CustomersDTO();
			BeanUtils.copyProperties(customer, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public CustomersDTO getById(int id) {
		
		Optional<Customers> customers = customerRepository.findById(id);
		if (customers.isPresent()) {
			CustomersDTO dto = new CustomersDTO();
			BeanUtils.copyProperties(customers.get(), dto);
			return dto;
		}
		return null;

	}

}
