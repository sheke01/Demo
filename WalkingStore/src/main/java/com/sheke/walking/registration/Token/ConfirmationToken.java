package com.sheke.walking.registration.Token;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.sheke.walking.model.Employees;

@Entity
public class ConfirmationToken implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4616817333411031867L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
    private int id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    //@CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    //@CreationTimestamp
    private LocalDateTime expiresAt;

    //@CreationTimestamp
    private LocalDateTime confirmedAt ;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private Employees employee;

    public ConfirmationToken(String token,
    		LocalDateTime createdAt,
    		LocalDateTime expiresAt,
                             Employees employee) {
        this.token = token;
        this.createdAt = createdAt; 
        this.expiresAt = expiresAt;
        this.employee = employee;
    }
    
    public ConfirmationToken() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
}
