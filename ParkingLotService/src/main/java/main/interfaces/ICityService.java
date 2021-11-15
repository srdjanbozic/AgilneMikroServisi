package main.interfaces;

import java.util.List;

import main.entities.City;


public interface ICityService {
	List<City> getAllCities();
	City getCityById(int id) throws Exception;
	void addNewCity(City city) throws Exception;
	void deleteCity(int id) throws Exception;
	void updateCity(City city) throws Exception;
}
