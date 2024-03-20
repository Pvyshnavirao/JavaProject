package com.example.ProductManagement;







import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
	
	
@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(unique=true)
@NotNull(message = "id cannot be null")
	private Integer id;
@Column
@NotNull(message = "Name cannot be null")
	private String name;
@NotNull(message = "description cannot be null")
@Column
	private String description;
@NotNull(message = "price cannot be null")
@Column
	private Double Price;
@Column
@NotNull(message = "status cannot be null")
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product(){
		
	}
	
	public Product(Integer id, String name, String description, Double price, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Price = price;
		this.status = status;
	}
	
	
	 
}
