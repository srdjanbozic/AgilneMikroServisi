package main.controller;

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

import main.entities.Employe;
import main.services.EmployeService;

@RestController
public class EmployeController {

	@Autowired
	private EmployeService controllerService;
	
	@GetMapping("employe")
	public Collection<Employe> getAllEmployes() {
		return controllerService.getAllEmployes();
	}
	
	@GetMapping("employe/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable("id") Integer id) {
		Employe controllerById= new Employe();
		try {
			controllerById = controllerService.getEmployeById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(controllerById);
	}
	

	@PostMapping("employe")
	public ResponseEntity<Employe> addNewEmploye(@Valid @RequestBody Employe employe){
		try {
			controllerService.addNewEmploye(employe);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

	@PutMapping("employe/")
	public ResponseEntity<Employe> updateEmploye(@Valid @RequestBody Employe employe ){
		
		try {
			controllerService.updateEmploye(employe);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@DeleteMapping("employe/{id}")
	public ResponseEntity<Employe> deleteEmploye(@PathVariable("id") Integer id){
		
		try {
			controllerService.deleteEmploye(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
