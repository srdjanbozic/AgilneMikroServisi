package main.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import main.entities.ParkingLot;


public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer> {

	Collection<ParkingLot> findByNameContainingIgnoreCase(String name);

}
