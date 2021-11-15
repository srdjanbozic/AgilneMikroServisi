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

import main.entities.Owner;
import main.services.OwnerService;

@RestController
public class OwnerRestController {
	@Autowired
	private OwnerService ownerService;

	@GetMapping("/owner")
	public Collection<Owner> getowneri() {
		return ownerService.getAllOwners();
	}

	@GetMapping("/owner/{id}")
	public ResponseEntity<Owner> getOneById(@PathVariable("id") Integer id) {
		Owner ownerById = new Owner();
		try {
			ownerById = ownerService.getOwnerById(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(ownerById);
	}

	@PostMapping("/owner")
	public ResponseEntity<Owner> insertownerjac(@Valid @RequestBody Owner owner) {
		try {
			ownerService.addNewOwner(owner);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/owner")
	public ResponseEntity<Owner> updateowner(@Valid @RequestBody Owner owner) 
	{
		try {
			ownerService.updateOwner(owner);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("owner/{id}")
	public ResponseEntity<Owner> deleteowner(@PathVariable("id") Integer id) {
		try {
			ownerService.deleteOwner(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
