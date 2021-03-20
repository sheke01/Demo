package com.sheke.walking;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sheke.walking.model.Address;
import com.sheke.walking.model.Customers;
import com.sheke.walking.model.Employees;
import com.sheke.walking.model.Expenses;
import com.sheke.walking.model.Products;
import com.sheke.walking.repo.CustomerRepository;
import com.sheke.walking.repo.EmployeeRepository;
import com.sheke.walking.repo.ExpenseRepository;
import com.sheke.walking.repo.ProductRepository;

@SpringBootTest
class WalkingStoreApplicationTests {
	
	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	ExpenseRepository expenseRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ProductRepository productRepo;

	@Test
	void contextLoads() {
	}
	
	/*@Test
	void testCreate() {
		Employees emp = new Employees();
		emp.setEmpId(1);
		emp.setFirstName("Vince");
		emp.setLastName("Bould");
		emp.setSsn(123456789);
		emp.setEmail("email@email.com");
		emp.setEmpType("Manager");
		emp.setPhoneNumber(987654321);
		emp.setShopNumber(1);
		
		Address address = new Address();
		address.setStreetAddress("North Lane Dr");
		address.setCity("Lakewood");
		address.setState("OH");
		address.setZipCode("44107");
		address.setCountry("USA");
		
		emp.setAddress(address);
		
		repo.save(emp);
	}
	
	@Test
	void testCreateExpense() {
		Employees emp1 = new Employees();
		emp1.setFirstName("Peter");
		emp1.setLastName("Pan");
		emp1.setSsn(374482223);
		emp1.setEmail("jasg@email.com");
		emp1.setEmpType("Employee");
		emp1.setPhoneNumber(789654321);
		emp1.setShopNumber(1);
		
		Address address = new Address();
		address.setStreetAddress("North Lane Dr");
		address.setCity("Lakewood");
		address.setState("OH");
		address.setZipCode("44107");
		address.setCountry("USA");
		
		emp1.setAddress(address);
		
		List<Expenses> expenses = new ArrayList<Expenses>();
		
		Expenses exp1 = new Expenses();
		exp1.setExpenseDate(new Date());
		exp1.setExpenseTotal(454.30);
		exp1.setDescription("Paid Delivery guy from Jones manufacturing");
		exp1.setEmployee(emp1);
		
		expenses.add(exp1);
		
		emp1.setExpenses(expenses);
		
		repo.save(emp1);
	}
	
	@Test
	void testCreateCustomer() {
		Customers cust1 = new Customers();
		cust1.setFirstName("Taylor");
		cust1.setLastName("Swift");
		cust1.setEmail("swift@email.com");
		cust1.setPhoneNumber(987651234);
		
		Address address = new Address();
		address.setStreetAddress("4 Madison Avenue");
		address.setCity("Los Angeles");
		address.setState("CA");
		address.setZipCode("54107");
		address.setCountry("USA");
		
		cust1.setAddress(address);
		
		customerRepo.save(cust1);
	}*/
	
	@Test
	void testCreateProduct() {
		Products prod2 = new Products();
		prod2.setProductName("IPhone 12");
		prod2.setProductType("Electronics");
		prod2.setProductPrice(999.99);
		prod2.setManufacturerCode("CST443");
		prod2.setInStock(9);
		
		productRepo.save(prod2);
		
	}

}
