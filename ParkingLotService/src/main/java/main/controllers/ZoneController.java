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

import javassist.NotFoundException;
import main.entities.Zone;
import main.services.ZoneService;

@RestController
public class ZoneController {
	
	@Autowired
	private ZoneService zoneService;
	
	@GetMapping("zone")
	public Collection<Zone> getZones() {
		return zoneService.getAllZOnes();
	}
	
	@GetMapping("zone/{id}")
	public ResponseEntity<Zone> getZoneById(@PathVariable("id") Integer id) {
		Zone zoneById = new Zone();
		try {
			zoneById =  zoneService.GetZoneById(id);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(zoneById);
	}
	

	@PostMapping("zone")
	public ResponseEntity<Zone> insertZone(@Valid @RequestBody Zone zone){
		try {
			zoneService.addNewZone(zone);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("zone")
	public ResponseEntity<Zone> updateZone(@Valid @RequestBody Zone zone){
		try {
			zoneService.updateZone(zone);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("zone/{id}")
	public ResponseEntity<Zone> deleteZone(@PathVariable("id") Integer id){
		try {
			zoneService.deleteZone(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

}
