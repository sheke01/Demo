package com.sheke.walking.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheke.walking.model.Employees;
import com.sheke.walking.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value="person/{id}")
	@Transactional
	public Employees getEmployee(@PathVariable("id") int id) {
		return employeeService.findEmployeeById(id);
	}
	
	@RequestMapping(value="store/{id}")
	@Transactional
	public List<Employees> getEmployeeByStore(@PathVariable("id") int id) {
		return employeeService.findEmployeeByshopNumber(id);
	}

}
