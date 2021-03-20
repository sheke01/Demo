package com.sheke.walking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sheke.walking.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
	
	public Employees findEmployeeByempId(int empId);
	
	public List<Employees> findEmployeeByshopNumber(int store);
	
	public Optional<Employees> findByEmail(String email);
	
	@Transactional
    @Modifying
    @Query("UPDATE Employees e " +
            "SET e.enabled = TRUE WHERE e.email = ?1")
    int enableEmployeeUser(String email);

}
