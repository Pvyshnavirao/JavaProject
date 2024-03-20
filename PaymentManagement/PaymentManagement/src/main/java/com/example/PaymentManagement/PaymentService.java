package com.example.PaymentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentrepository;
	
	public Payment savePayment(Payment payment) {
		return paymentrepository.save(payment);
	}
	
	
	public List<Payment> getAllPayment(){
		return paymentrepository.findAll();
		
	}
	
	public Payment getById(Integer id) {
		return paymentrepository.findById(id).get();
	}
	
	public Payment ChangeMethod(Integer id ,Payment payment) {
		Payment payment1 = paymentrepository.findById(id).orElseThrow(() -> new RuntimeException("Paymnt details  Not Found"));
	
  
	payment1.setMode(payment.getMode());
	payment1.setStatus(payment.getStatus());
	return paymentrepository.save(payment1);
	
	
	}
	
	public String deleteproduct(Integer id) {
		Payment payment =  paymentrepository.findById(id).get();
		if(payment!=null) {
			paymentrepository.delete(payment);
			return "payment deleted";
		}
		return "something wrong";
	}

	

}
