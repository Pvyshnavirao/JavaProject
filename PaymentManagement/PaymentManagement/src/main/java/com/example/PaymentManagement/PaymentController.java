package com.example.PaymentManagement;

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


@RestController
@RequestMapping("/")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentservice;


@PostMapping("/saveProduct")

public ResponseEntity<Payment>  savePayment(@RequestBody Payment payment){
	
return new ResponseEntity<>(paymentservice.savePayment(payment),HttpStatus.CREATED);
}

@GetMapping
public ResponseEntity<List<Payment>> getAllPayments(){
	return new ResponseEntity<List<Payment>>(paymentservice.getAllPayment(),HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Payment> getOrderById(@PathVariable Integer id){
	return new ResponseEntity<Payment>(paymentservice.getById(id),HttpStatus.OK);
}	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteorder(@PathVariable Integer id){
	return new ResponseEntity<String>(paymentservice.deleteproduct(id), HttpStatus.OK);
}
	
	@PutMapping("/{id}")
	public  Payment ChnageMethd(@PathVariable Integer  id , @RequestBody Payment payment) {
		return paymentservice.ChangeMethod(id , payment);
		
	}
	

}
