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

import main.entities.ParkingLot;
import main.services.ParkingLotService;


@RestController
public class ParkingLotController {
	
	@Autowired
	private ParkingLotService parkingService;
	
	@GetMapping("parking-lot")
	public Collection<ParkingLot> getParkinglots() {
		return parkingService.getAllParkingLots();
	}
	
	@GetMapping("parking-lot/{id}")
	public ResponseEntity<ParkingLot> getParkinglotById(@PathVariable("id") Integer id) {
		ParkingLot parkingById = new ParkingLot();
		try { 
			parkingById = parkingService.GetParingLotById(id);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(parkingById);
	}
	

	@PostMapping("parking-lot")
	public ResponseEntity<ParkingLot> insertParkinglot(@Valid @RequestBody ParkingLot parkinglot){
		try {
			parkingService.addNewParkingLot(parkinglot);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("parking-lot")
	public ResponseEntity<ParkingLot> updateParkinglot(@Valid @RequestBody ParkingLot parkinglot){
		try {
			parkingService.updateParkingLot(parkinglot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("parking-lot/{id}")
	public ResponseEntity<ParkingLot> deleteParkinglot(@PathVariable("id") Integer id){
		try {
			parkingService.deleteParkingLot(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}