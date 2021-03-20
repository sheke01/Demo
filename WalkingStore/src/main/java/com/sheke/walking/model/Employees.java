package com.sheke.walking.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Employees implements Serializable,UserDetails {
	
	public Employees() {super();}
	
	public Employees(String firstName, String lastName, String password,
			int ssn, int phoneNumber, String email,
			int shopNumber, Role empType, Address address) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.shopNumber = shopNumber;
		this.empType = empType;
		this.address = address;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8982585613956937324L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private int empId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean enabled = false;
	private int ssn;
	private int phoneNumber;
	private String email;
	private int shopNumber;
	@Enumerated(EnumType.STRING)
	private Role empType;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Orders> orders;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Expenses> expenses;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(int shopNumber) {
		this.shopNumber = shopNumber;
	}

	public Role getEmpType() {
		return empType;
	}

	public void setEmpType(Role empType) {
		this.empType = empType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Expenses> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expenses> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", shopNumber=" + shopNumber + ", empType="
				+ empType + ", address=" + address + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(empType.name());
        return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
