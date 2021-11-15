package main.services;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import main.entities.City;
import main.interfaces.ICityService;
import main.repositories.CityRepository;

@Service  
public class CityService implements ICityService {  
	
	@Autowired  
	CityRepository cityRepository;  
	
	@Override
	public List<City> getAllCities()   {  
		List<City> cities = new ArrayList<City>();  
		cityRepository.findAll().forEach(city -> cities.add(city));  
		return cities;  
	}  
	 
	@Override
	public City getCityById(int id) throws Exception {  
		City cityById = cityRepository.findById(id).get();
		
		if(cityById == null)
			throw new NotFoundException("City doesn't exist");
		
		return cityById;
	}  
	 
	@Override
	public void addNewCity(City city) throws Exception {  
		City addedCity = cityRepository.save(city); 
		
		if(addedCity == null)
			throw new Exception("Bad request");
	}  
	  
	@Override
	public void deleteCity(int id) throws Exception {  
		if(cityRepository.existsById(id)) {
			cityRepository.deleteById(id);  			
		} else {
			throw new Exception("Bad request");
		}
	}  
	
	@Override
	public void updateCity(City city) throws Exception{  
		if(cityRepository.existsById(city.getId())) { 
			cityRepository.save(city);  
		} else {
			throw new Exception("Bad request");
		}
		
	}  
}  