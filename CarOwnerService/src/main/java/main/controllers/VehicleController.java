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

import main.entities.Vehicle;
import main.services.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("vehicle")
	public Collection<Vehicle> getVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@GetMapping("vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") Integer id) {
		Vehicle vehicleById = new Vehicle();
		try {
			vehicleById = vehicleService.getVehicleById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(vehicleById);
	}
	

	@PostMapping("vehicle")
	public ResponseEntity<Vehicle> insertVehicle(@Valid @RequestBody Vehicle vehicle){
		try {
			vehicleService.addNewVehicle(vehicle);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@PutMapping("vehicle")
	public ResponseEntity<Vehicle> updateVehicle( @Valid @RequestBody Vehicle vehicle){

		try {
			vehicleService.updateVehicle(vehicle);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("vehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") Integer id){
		try {
			vehicleService.deleteVehicle(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
