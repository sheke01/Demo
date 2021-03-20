package com.sheke.walking.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sheke.walking.model.Customers;
import com.sheke.walking.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@Transactional
	public List<Customers> findAllCustomers(){
		return customerService.findAllCustomers();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@Transactional
	public Customers savePatient(@RequestBody Customers customer) {
		return customerService.updateCustomer(customer);
	}

}
