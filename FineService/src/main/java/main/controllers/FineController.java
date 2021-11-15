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
public class FineController {

	@Autowired
	private FineService fineService;
	
	@GetMapping("fine")
	public Collection<Fine> getAllFines() {
		return fineService.getAllFines();
	}
	
	@GetMapping("fine/{id}")
	public ResponseEntity<Fine> getFineById(@PathVariable("id") Integer id) {
		Fine fineById = new Fine();
		try {
			fineById = fineService.getFineById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(fineById);
	}
	

	@PostMapping("fine")
	public ResponseEntity<Fine> insertFine(@Valid @RequestBody Fine fine){
		try {
			fineService.addNewFine(fine);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

	@PutMapping("fine")
	public ResponseEntity<Fine> updateFine(@Valid @RequestBody Fine fine){
		
		try {
			fineService.updateFine(fine);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("fine/{id}")
	public ResponseEntity<Fine> deleteFine(@PathVariable("id") Integer id){
		
		try {
			fineService.deleteFine(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
