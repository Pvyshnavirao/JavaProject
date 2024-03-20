package com.example.orderManagement;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column
	private Integer orderid;
	
	@Column
    private Integer quantity;
	@Column
	private Double Cost;
	@Column
	private String status;
	
	
//	 @ManyToOne
//	    @JoinColumn(name = "id", nullable = false)
//	    private Product product;
//	
	
	public Order() {}
	
	public Order(Integer orderid, Integer quantity, Double cost, String status) {
		super();
		this.orderid = orderid;
		this.quantity = quantity;
		Cost = cost;
		this.status = status;
	}
	
	
	public Integer getId() {
		return orderid;
	}
	public void setId(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCost() {
		return Cost;
	}
	public void setCost(Double cost) {
		Cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
