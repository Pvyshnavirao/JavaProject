 package com.example.orderManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;

    @Autowired
    private RestTemplate restTemplate;
	

@PostMapping("/saveOrder")

public ResponseEntity<Order>  saveOrder(@RequestBody Order order){
	
return new ResponseEntity<>(orderservice.saveProduct(order),HttpStatus.CREATED);
}

@GetMapping
public ResponseEntity<List<Order>> getAllOrders(){
	return new ResponseEntity<List<Order>>(orderservice.getAllProduct(),HttpStatus.OK);
}

//@GetMapping("/{id}")
//public Order getOrderById(@PathVariable("id") Integer id) {
//    Order order = restTemplate.getForObject("http://localhost:8080/orders/" + id, Order.class);
//    Product product = restTemplate.getForObject("http://localhost:8081/products/" + order.getProductId(), Product.class);
//    order.setProduct(product);
//    return order;
//}
//@GetMapping("/{orderid}")
//public ResponseEntity<Order> getOrderById1(@PathVariable Integer orderid) {
//    Order order = orderservice.getById(orderid);
//
//    // Communicate with ProductController to get Product details for the order
//    Product product = restTemplate.getForObject("http://localhost:8081/product/" + order.getProductId(), Product.class);
//    order.setProduct(product);
//
//    return new ResponseEntity<>(order, HttpStatus.OK);
//}

@GetMapping("/{orderid}")
public ResponseEntity<Order> getOrderById(@PathVariable Integer orderid){
	return new ResponseEntity<Order>(orderservice.getById(orderid),HttpStatus.OK);
}	

	@DeleteMapping("/delete/{orderid}")
	public ResponseEntity<String> deleteorder(@PathVariable Integer orderid){
	return new ResponseEntity<String>(orderservice.deleteproduct(orderid), HttpStatus.OK);
}
	
	@PutMapping("/{orderid}")
	public  Order ChnageMethd(@PathVariable Integer  orderid , @RequestBody Order order) {
		return orderservice.ChangeMethod(orderid , order);
		
	}
	
	

}
