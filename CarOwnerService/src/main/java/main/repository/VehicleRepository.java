package main.repository;

//import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}