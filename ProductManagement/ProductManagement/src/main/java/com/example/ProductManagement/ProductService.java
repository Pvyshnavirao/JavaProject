package com.example.ProductManagement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	
	public Product saveProduct(Product product) {
		return productrepository.save(product);
	}
	
	
	public List<Product> getAllProduct(){
		return productrepository.findAll();
		
	}
	
	public Product getById(Integer id) {
		return productrepository.findById(id).get();
	}
	
	public Product ChangeMethod(Integer id ,Product product) {
		Product product1 = productrepository.findById(id).orElseThrow(() -> new RuntimeException("product Not Found"));
	product1.setName(product.getName()
);
	product1.setDescription(product.getDescription());
	product1.setPrice(product.getPrice());
	product1.setStatus(product.getStatus());
	return productrepository.save(product);
	
	
	}
	
	public String deleteproduct(Integer id) {
		Product product =  productrepository.findById(id).get();
		if(product!=null) {
			productrepository.delete(product);
			return "product deleted";
		}
		return "something wrong";
	}

}
