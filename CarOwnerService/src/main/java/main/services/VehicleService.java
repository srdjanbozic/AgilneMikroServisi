package main.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.Owner;
import main.entities.Vehicle;
import main.interfaces.IVehicleInterface;
import main.repository.VehicleRepository;  

@Service
public class VehicleService implements IVehicleInterface  {
	@Autowired  
	VehicleRepository vehicleRepository;  
	@Override
	public List<Vehicle> getAllVehicles()   
	{  
		List<Vehicle> vehicles = new ArrayList<Vehicle>();  
		vehicleRepository.findAll().forEach(vehicle -> vehicles.add(vehicle));  
		return vehicles;  
	}  
	 
	public Vehicle getVehicleById(int id) throws Exception
	{  
		Vehicle vehicleById = vehicleRepository.findById(id).get();
		
		if (vehicleById.getId() == null)
			throw new NotFoundException("Vehicle doesn't exist");
		
		return vehicleById;  
	}  
	 
	public void addNewVehicle(Vehicle vehicle)   throws Exception
	{  
	Vehicle addedVehicle = vehicleRepository.save(vehicle);
		
		if (addedVehicle == null) 
			throw new Exception ("Bad request");
		}  
	  
	public void deleteVehicle(int id)   throws Exception
	{  
		if(vehicleRepository.existsById(id)) {
			vehicleRepository.deleteById(id); 
		} else {
			throw new Exception ("Bad request");
		}
	}  

	public void updateVehicle(Vehicle vehicle) throws Exception
	{  
		if(vehicleRepository.existsById(vehicle.getId())) {
			vehicleRepository.save(vehicle); 
		} else {
			throw new Exception ("Bad request");
		}
	}  
}
