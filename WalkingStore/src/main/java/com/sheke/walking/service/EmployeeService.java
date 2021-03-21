package com.sheke.walking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sheke.walking.model.Employees;
import com.sheke.walking.registration.Token.ConfirmationToken;
import com.sheke.walking.registration.Token.ConfirmationTokenService;
import com.sheke.walking.repo.EmployeeRepository;

@Service
public class EmployeeService implements UserDetailsService{
	
	private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
	
	private EmployeeRepository employeeRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo,BCryptPasswordEncoder bCryptPasswordEncoder,ConfirmationTokenService confirmationTokenService) {
		this.employeeRepo = employeeRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}
	
	public Employees addEmployee(Employees employee) {
		return employeeRepo.save(employee);
	}
	
	public List<Employees> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employees findEmployeeById(int id){
		return employeeRepo.findEmployeeByempId(id);
	}
	
	public List<Employees> findEmployeeByshopNumber(int shopNumber){
		return employeeRepo.findEmployeeByshopNumber(shopNumber);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return employeeRepo.findByEmail(email).orElseThrow(() ->
        new UsernameNotFoundException(
                String.format(USER_NOT_FOUND_MSG, email)));
	}
	
	public String signUpEmployee(Employees employee) {
        boolean userExists = employeeRepo
                .findByEmail(employee.getEmail()).isPresent();

        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(employee.getPassword());

        employee.setPassword(encodedPassword);
        
        employee.setUsername(employee.getEmail());

        employeeRepo.save(employee);

       String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                employee
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

        return token;
    }

	public int enableEmployeeUser(String email) {
        return employeeRepo.enableEmployeeUser(email);
    }
}
