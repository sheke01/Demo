package com.sheke.walking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Expenses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2817647933665553137L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int expenseId;
	private Date expenseDate;
	@Column(name="descript")
	private String description;
	private Double expenseTotal;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employees employee;
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getExpenseTotal() {
		return expenseTotal;
	}
	public void setExpenseTotal(Double expenseTotal) {
		this.expenseTotal = expenseTotal;
	}
	
	public Employees getEmployee() {
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "Expenses [expenseId=" + expenseId + ", expenseDate=" + expenseDate + ", description=" + description
				+ ", expenseTotal=" + expenseTotal + "]";
	}

}
