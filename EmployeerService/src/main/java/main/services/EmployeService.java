package main.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.Employe;
import main.interfaces.IEmployeInterface;
import main.repository.EmployeRepository;  
@Service  
public class EmployeService implements IEmployeInterface 
{  
@Autowired  
EmployeRepository controllerRepository;  
@Override
public List<Employe> getAllEmployes()   
{  
	List<Employe> controllers = new ArrayList<Employe>();  
	controllerRepository.findAll().forEach(controller -> controllers.add(controller));  
	return controllers;  
}  
 @Override
public Employe getEmployeById(int id)  throws Exception 
{  
	Employe controllerById = controllerRepository.findById(id).get();
	
	if(controllerById.getId() == null)
		throw new NotFoundException("Controller doesn't exist");
	
	return controllerById ;
}  
 @Override
public void addNewEmploye(Employe controller) throws Exception
{  
	 Employe addedController = controllerRepository.save(controller);
	 
	 if(addedController == null)
		 throw new Exception("Bad request");
	 
}  
 @Override
 public void deleteEmploye(int id) throws Exception   
{  
	 if(controllerRepository.existsById(id)) {
		 controllerRepository.deleteById(id); 
		} else {
			throw new Exception("Bad request");
		}
	 
	 
}  
 @Override
public void updateEmploye(Employe controller) throws Exception  
{  
	 if(controllerRepository.existsById(controller.getId())) {
		 controllerRepository.save(controller);
		} else {
		 throw new Exception("Bad request");
	 }
	  
}  
}