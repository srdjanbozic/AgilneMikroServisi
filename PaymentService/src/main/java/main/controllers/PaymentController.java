package main.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.entities.*;
import main.services.*;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("payment")
	public Collection<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}
	
	@GetMapping("payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Integer id) {
		Payment paymentById = new Payment();
		try {
			paymentById = paymentService.getPaymentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(paymentById);
	}
	

	@PostMapping("payment")
	public ResponseEntity<Payment> insertPayment(@Valid @RequestBody Payment payment){
		try {
			paymentService.addNewPayment(payment);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@PutMapping("payment")
	public ResponseEntity<Payment> updatePayment(@Valid @RequestBody Payment payment){
		try {
			paymentService.updatePayment(payment);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("payment/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable("id") Integer id){
		try {
			paymentService.deletePayment(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
