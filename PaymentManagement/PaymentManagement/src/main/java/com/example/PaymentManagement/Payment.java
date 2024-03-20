package com.example.PaymentManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@Column
	private Integer id;
	@Column
	private String Mode;
	@Column
	private String status;
	
	public Payment(Integer id, String mode, String status) {
		super();
		this.id = id;
		Mode = mode;
		this.status = status;
	}
	
	public Payment() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMode() {
		return Mode;
	}

	public void setMode(String mode) {
		Mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
