package com.example.orderManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderrepository;
	

	
	public Order saveProduct(Order order) {
		return orderrepository.save(order);
	}
	
	
	public List<Order> getAllProduct(){
		return orderrepository.findAll();
		
	}
	
	public Order getById(Integer orderid) {
		return orderrepository.findById(orderid).get();
	}
	
	public Order ChangeMethod(Integer orderid ,Order order) {
		Order order1 = orderrepository.findById(orderid).orElseThrow(() -> new RuntimeException("order Not Found"));
	
     order1.setQuantity(order.getQuantity());
	order1.setCost(order.getCost());
	order1.setStatus(order.getStatus());
	return orderrepository.save(order);
	
	
	}
	
	public String deleteproduct(Integer orderid) {
		Order order =  orderrepository.findById(orderid).get();
		if(order!=null) {
			orderrepository.delete(order);
			return "order deleted";
		}
		return "something wrong";
	}


}
