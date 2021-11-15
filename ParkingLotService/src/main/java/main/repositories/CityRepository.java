package main.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.City;



public interface CityRepository extends JpaRepository<City,Integer> {

	Collection<City> findByCitynameContainingIgnoreCase(String cityname);

}
