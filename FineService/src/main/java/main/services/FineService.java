package main.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javassist.NotFoundException;
import main.entities.Fine;
import main.interfaces.IFineInterface;
import main.repository.FineRepository;

@Service
public class FineService implements IFineInterface{
	@Autowired
	FineRepository fineRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	String employeURI = "http://localhost:8083/employe";
	String vehicleURI = "http://localhost:8082/vehicle";
	
@Override
public List<Fine> getAllFines()
{
	List<Fine> fines = new ArrayList<Fine>();
	fineRepository.findAll().forEach(fine -> fines.add(fine));
	return fines;
}
@Override
public Fine getFineById(int id) throws Exception  
{  
	Fine fineById = fineRepository.findById(id).get();
	
	if(fineById == null)
		throw new NotFoundException("Fine doesn't exist!");
	
	return fineById;
	
}  
@Override
public void addNewFine(Fine fine) throws Exception  
{
	ResponseEntity<String> responseEmploye
	  = restTemplate.getForEntity(employeURI + "/" + fine.getEmployeId(), String.class);
	
	ResponseEntity<String> responseVehicle
	  = restTemplate.getForEntity(vehicleURI + "/" + fine.getVehicleId(), String.class);
	
	if(responseEmploye.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Employee doesnt exist");
	}
	
	if(responseVehicle.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Vehicle doesnt exist");
	}
	
	Fine addedFine = fineRepository.save(fine);
	if(addedFine == null) {
		throw new Exception("Bad request");
	}
}  
@Override
public void deleteFine(int id) throws Exception   
{  
	if(fineRepository.existsById(id)) {
		fineRepository.deleteById(id);  
	} else {
		throw new Exception("Bad request");
	}
}  
@Override
public void updateFine(Fine fine) throws Exception   
{  
	ResponseEntity<String> responseEmploye
	  = restTemplate.getForEntity(employeURI + "/" + fine.getEmployeId(), String.class);
	
	ResponseEntity<String> responseVehicle
	  = restTemplate.getForEntity(vehicleURI + "/" + fine.getVehicleId(), String.class);
	
	if(responseEmploye.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Employee doesnt exist");
	}
	
	if(responseVehicle.getStatusCode().equals(HttpStatus.BAD_REQUEST))
	{
		throw new Exception("Vehicle doesnt exist");
	}
	
	if(fineRepository.existsById(fine.getId())) {
		fineRepository.save(fine); 
	} else {
		throw new Exception("Bad request");
	}
}  
}
