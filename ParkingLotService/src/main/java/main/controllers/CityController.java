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

import main.entities.City;
import main.services.CityService;


@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("city")
	public Collection<City> getCitys() {
		return cityService.getAllCities();
	}
	
	@GetMapping("city/{id}")
	public ResponseEntity<City> GetCityById(@PathVariable("id") Integer id) {
		City cityById = new City();
		try {
			cityById = cityService.getCityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(cityById);
	}
	
	@PostMapping("city")
	public ResponseEntity<City> postCity(@Valid @RequestBody City city){
		try {
			cityService.addNewCity(city);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	

	@PutMapping("city")
	public ResponseEntity<City> putCity(@Valid @RequestBody City city){
		try {
			cityService.updateCity(city);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("city/{id}")
	public ResponseEntity<City> deleteCity(@PathVariable("id") Integer id){
		try {
			cityService.deleteCity(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
