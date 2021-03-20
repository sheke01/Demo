package com.sheke.walking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheke.walking.model.Customers;
import com.sheke.walking.repo.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepo;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public Customers addCustomer(Customers customer) {
		return customerRepo.save(customer);
	} 
	
	public List<Customers> findAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customers updateCustomer(Customers customer) {
		return customerRepo.save(customer);
	} 

}
