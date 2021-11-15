package main.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javassist.NotFoundException;
import main.entities.Payment;
import main.interfaces.IPaymentInterface;
import main.repository.PaymentRepository;

@Service
public class PaymentService implements IPaymentInterface{
	@Autowired
	PaymentRepository paymentRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	String vehicleURI = "http://localhost:8082/vehicle";
	String parkingLotURI = "http://localhost:8081/parking-lot";
	String ownerURI = "http://localhost:8082/owner";
	
	
@Override
public List<Payment> getAllPayments()
{
	List<Payment> payments = new ArrayList<Payment>();
	paymentRepository.findAll().forEach(payment -> payments.add(payment));
	return payments;
}
@Override
public Payment getPaymentById(int id) throws Exception
{  
	Payment paymentById = paymentRepository.findById(id).get();
	
	if(paymentById == null)
		throw new NotFoundException("Payment doesn't exist!");
	
	return paymentById;
}  
@Override
public void addNewPayment(Payment payment) throws Exception   
{
	
	ResponseEntity<String> responseVehicle
	  = restTemplate.getForEntity(vehicleURI + "/" + payment.getVehicleId(), String.class);
	ResponseEntity<String> responseOwner
	  = restTemplate.getForEntity(ownerURI + "/" + payment.getOwnerId(), String.class);
	ResponseEntity<String> responseParkingLot
	  = restTemplate.getForEntity(parkingLotURI + "/" + payment.getParkingLot(), String.class);
	
	if(responseVehicle.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Vehicle doesnt exist");
	}
	if(responseOwner.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Owner doesnt exist");
	}
	if(responseParkingLot.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Parking lot doesnt exist");
	}
	
	Payment addPayment = paymentRepository.save(payment);
	
	if(addPayment == null) {
		throw new Exception("Bad request");
	}
}  
@Override
public void deletePayment(int id) throws Exception   
{  
	if(paymentRepository.existsById(id)) {
		paymentRepository.deleteById(id);  
	} else {
		throw new Exception("Bad request");
	}	
}  

@Override
public void updatePayment(Payment payment) throws Exception   
{  
	ResponseEntity<String> responseVehicle
	  = restTemplate.getForEntity(vehicleURI + "/" + payment.getVehicleId(), String.class);
	ResponseEntity<String> responseOwner
	  = restTemplate.getForEntity(ownerURI + "/" + payment.getOwnerId(), String.class);
	ResponseEntity<String> responseParkingLot
	  = restTemplate.getForEntity(parkingLotURI + "/" + payment.getParkingLot(), String.class);
	
	if(responseVehicle.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Vehicle doesnt exist");
	}
	if(responseOwner.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Owner doesnt exist");
	}
	if(responseParkingLot.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Parking lot doesnt exist");
	}
	
	if(paymentRepository.existsById(payment.getId())) {
		paymentRepository.save(payment); 
	} else {
		throw new Exception("Bad request");
	}
}  
}
